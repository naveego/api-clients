This is the Vault client for use in scala.

## Publishing

It is distributed via S3, in the maven.n5o.black bucket.

To publish an updated version, increment the version in build.sbt. Then, in the sbt console:

- `compile`
- `publish`


## Testing

For all tests to pass, you must have a minikube environment running with vault available.

The tests expect vault to be at http://vault.n5o.red, and for a root token of `"root"` to work.
