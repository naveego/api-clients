using System;
using System.Text.RegularExpressions;
using Microsoft.Extensions.Logging;
using Vault;
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
}