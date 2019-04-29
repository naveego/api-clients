using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using FluentAssertions;
using Metabase.Api.Vault;
using Xunit;
using Xunit.Abstractions;

namespace Naveego.Vault.Tests
{
    public class VaultHelperIntegrationFixture
    {
        private readonly ITestOutputHelper _testOutputHelper;

        public VaultHelperIntegrationFixture(ITestOutputHelper testOutputHelper)
        {
            _testOutputHelper = testOutputHelper;
            Config = new VaultHelperConfig()
            {
                Address = "https://vault.n5o.black",
                Logger = new TestLogger(testOutputHelper),
            }.UsingTokenLogin("root");

        }
        
        public VaultHelperConfig Config { get; set; } 
        
        [Fact]
        public async Task CanStartClient()
        {
            var sut = await VaultHelper.CreateAsync(Config);
            _testOutputHelper.WriteLine("Got result.");
            sut.Should().NotBeNull();
        }
        
        [Fact]
        public async Task ClientRenewsOwnToken()
        {
            var helperWithOriginalToken = await VaultHelper.CreateAsync(Config);

            var secret = await helperWithOriginalToken.WriteAsync<NoData>("auth/token/create", new Dictionary<string, string>()
            {
                ["ttl"] = "1s",
                ["explicit_max_ttl"] = "1m",
                ["renewable"] = "true"
            });

            Exception ex = null;
            Action<Exception> errorHandler = (e) => ex = e;
            
            var sut = await VaultHelper.CreateAsync(new VaultHelperConfig(Config.Address)
                .UsingTokenLogin(secret.Auth.ClientToken)
                .WithErrorHandler(errorHandler));

            await Task.Delay(TimeSpan.FromSeconds(1));

            ex.Should().BeNull("the renewal should not have errored");
        }
       
        [Fact]
        [Trait("Category","Integration")]
        public async Task CanReadAndWriteThroughClient()
        {
            var sut = await VaultHelper.CreateAsync(Config);

            var input = new Dictionary<string, object>
            {
                ["a"] = "A",
                ["b"] = "B"
            };

            var path = "secret/data/test-secret";

            await sut.WriteAsync<Dictionary<string, string>>(path, input);

            var readActual = await sut.ReadAsync<Dictionary<string, string>>(path);
            readActual.Data.Should().BeEquivalentTo(input);
        }
        
        [Fact]
        [Trait("Category","Integration")]
        public async Task CanGetJwt()
        {
            var sut = await VaultHelper.CreateAsync(Config);

            var secret = await sut.GetLiveSecretAsync("JWT", SecretGetters.MakeJwtGetter("auth", TimeSpan.FromSeconds(1), "vandelay", "tester"));

            var firstValue = secret.Value;
            
            firstValue.Should().NotBeEmpty();

            await Task.Delay(TimeSpan.FromSeconds(1));

            var secondValue = secret.Value;
            secondValue.Should().NotBeEmpty();

            secondValue.Should().NotBe(firstValue, "the token should have been refreshed");
            
            secret.Dispose();
            
            await Task.Delay(TimeSpan.FromSeconds(1));

            Func<string> lateGet = () => secret.Value;
            lateGet.Should().Throw<Exception>("the secret value cannot be read after it is disposed");
        }     
        
        
        [Fact]
        [Trait("Category","Integration")]
        public async Task CanGetMongoCreds()
        {
            var sut = await VaultHelper.CreateAsync(Config);

            var secret = await sut.GetLiveSecretAsync("MongoDB", SecretGetters.MakeSecretTemplateGetter("mongodb://(vault://database/creds/mongodb-admin?template={{.username}}:{{.password}})@mongodb:27017/go-between?readPreference=primary"));

            var firstValue = secret.Value;
            
            firstValue.Should().NotBeEmpty();
            firstValue.Should().MatchRegex(@"mongodb:\/\/[^:]+[^@]+@", "the username and password should be mapped in" );
        }
        
    }
}