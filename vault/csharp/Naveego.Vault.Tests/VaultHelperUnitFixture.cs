using System;
using System.Collections.Generic;
using System.Threading;
using System.Threading.Tasks;
using FluentAssertions;
using Metabase.Api.Vault;
using Microsoft.Extensions.Logging;
using Moq;
using Xunit;
using Xunit.Abstractions;

namespace Naveego.Vault.Tests
{
    public class VaultHelperUnitFixture
    {
        private readonly ITestOutputHelper _testOutputHelper;
        public VaultHelperConfig Config { get; set; } 

        public VaultHelperUnitFixture(ITestOutputHelper testOutputHelper)
        {
            _testOutputHelper = testOutputHelper;
            Config = new VaultHelperConfig()
            {
                Address = "https://vault.n5o.black",
                Logger = new TestLogger(testOutputHelper),
            }.UsingTokenLogin("root");

        }
        
        
        [Fact]
        public async Task RenewableSecretsAreRenewed()
        {
            var (mockClient, sut) = GetMocks();
            
            const string leaseId = "lease-id";
            
            mockClient.Setup(m => m.WriteAsync<NoData>("sys/lease/renew", It.Is<Dictionary<string, string>>(x => x["lease_id"] == leaseId), It.IsAny<CancellationToken>()))
                .Returns(Task.FromResult(new Secret<NoData>()))
                .Verifiable();        

            var secret = await sut.GetLiveSecretAsync("TestMocks", (api, token) => Task.FromResult(new Secret<string>()
            {
                Data = "test-data",
                Renewable = true,
                LeaseDuration = 1,
                LeaseId = leaseId
            }));

            secret.Value.Should().Be("test-data");
            await Task.Delay(TimeSpan.FromSeconds(1));
            
            mockClient.Verify();
        }     
        
        [Fact]
        public async Task NonRenewableSecretsWithLeaseTimeoutsAreRegenerated()
        {
            var (mockClient, sut) = GetMocks();
            
            var getterCallCount = 0;

            Func<IVaultApi, CancellationToken, Task<Secret<string>>> getter = (api, token) =>
            {
                getterCallCount++;
                return Task.FromResult(new Secret<string>()
                {
                    Data = "test-data",
                    Renewable = false,
                    LeaseDuration = 1,
                });
            };

            var secret = await sut.GetLiveSecretAsync("TestMocks", getter);

            secret.Value.Should().Be("test-data");
            await Task.Delay(TimeSpan.FromSeconds(1));

            getterCallCount.Should().BeGreaterOrEqualTo(2, "the getter should have been invoked at least twice");

        }        
        
        [Fact]
        public async Task NonRenewableSecretsWithoutLeaseTimeoutsAreOnlyAcquiredOnce()
        {
            var (mockClient, sut) = GetMocks();
            
            var getterCallCount = 0;

            Func<IVaultApi, CancellationToken, Task<Secret<string>>> getter = (api, token) =>
            {
                getterCallCount++;
                return Task.FromResult(new Secret<string>()
                {
                    Data = "test-data",
                    Renewable = false,
                    LeaseDuration = 0,
                });
            };
            
            var secret = await sut.GetLiveSecretAsync("TestMocks", getter);

            secret.Value.Should().Be("test-data");
            await Task.Delay(TimeSpan.FromSeconds(1));

            getterCallCount.Should().Be(1, "no renewal should be happening");

        }

        public (Mock<IVaultApi>, IVaultHelper) GetMocks()
        {
            var mockClient = new Mock<IVaultApi>(MockBehavior.Strict);
            var mockLoginStrategy = new Mock<ILoginStrategy>(MockBehavior.Strict);
            mockLoginStrategy.Setup(m => m.LoginAsync(It.IsAny<string>(), It.IsAny<ILogger>(), It.IsAny<CancellationToken>()))
                .Returns(Task.FromResult(new LoginResult()
                {
                    Client = mockClient.Object,
                    SecretAuth = new SecretAuth()
                    {
                        LeaseDuration = 0
                    }
                }));
            
            Config.LoginStrategies = new List<ILoginStrategy>(){mockLoginStrategy.Object};
            
            var sut = VaultHelper.CreateAsync(Config).Result;

            return (mockClient, sut);

        }       
        
    }
}