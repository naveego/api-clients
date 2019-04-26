using System;
using System.Threading;
using System.Threading.Tasks;

namespace Metabase.Api.Vault
{
    public class LiveSecret<T> : IDisposable
    {
        private readonly CancellationTokenSource _cts;
        private Exception _error;
        private T _value;

        public LiveSecret(string label, T initialValue, CancellationToken token, TimeSpan interval, Func<CancellationToken, Task<T>> factory)
        {
            _value = initialValue;
            _cts = CancellationTokenSource.CreateLinkedTokenSource(token);
            Task.Factory.StartNew(async () =>
            {
                try
                {
                    while (true)
                    {
                        await Task.Delay(interval, _cts.Token);
                        _value = await factory(_cts.Token);
                    }
                }
                catch (TaskCanceledException)
                {
                    _error = new Exception($"Renewing secret '{label}' was disposed at {DateTime.UtcNow}.");
                    return Task.FromCanceled(token);
                }
                catch (Exception ex)
                {
                    _error = new Exception($"Factory '{label}' threw error at {DateTime.UtcNow}.", ex);
                    return Task.FromException(ex);
                }
            });
        }

        /// <summary>
        ///     Create a renewing secret that doesn't actually do any renewing.
        /// </summary>
        /// <param name="initialValue"></param>
        public LiveSecret(T initialValue)
        {
            _value = initialValue;
        }

        public T Value => _error == null ? _value : throw _error;

        public void Dispose()
        {
            _cts?.Cancel();
            _cts?.Dispose();
        }
    }
}