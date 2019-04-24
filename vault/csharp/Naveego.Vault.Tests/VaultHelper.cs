using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using FluentAssertions;
using Metabase.Api.Vault;
using Microsoft.Extensions.Logging;
using Xunit;
using Xunit.Abstractions;

namespace Naveego.Vault.Tests
{
    public class TestLogger : ILogger, IDisposable
    {
        private readonly ITestOutputHelper _helper;

        public TestLogger(ITestOutputHelper helper)
        {
            _helper = helper;
        }

        public void Log<TState>(LogLevel logLevel, EventId eventId, TState state, Exception exception, Func<TState, Exception, string> formatter)
        {
            _helper.WriteLine($"{logLevel} [{eventId}]: {formatter(state, exception)}");
        }

        public bool IsEnabled(LogLevel logLevel)
        {
            return true;
        }

        public IDisposable BeginScope<TState>(TState state)
        {
            return this;
        }

        public void Dispose()
        {
        }
    }
    
    public class VaultHelperFixture
    {
        private readonly ITestOutputHelper _testOutputHelper;

        public VaultHelperFixture(ITestOutputHelper testOutputHelper)
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
        public void CanStartClient()
        {
            try
            {
                var sut = VaultHelper.CreateAsync(Config).Result;
                _testOutputHelper.WriteLine("Got result.");
                sut.Should().NotBeNull();
            }
            catch (Exception ex)
            {
                throw;
            }
        }

        

        [Fact]
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
    }
}