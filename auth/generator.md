# Client for Auth API

> see https://aka.ms/autorest

## Generation Config:

```yaml
input-file: http://auth.n5o.red/swagger.json # full Unicode support

use:
  - "@microsoft.azure/autorest.typescript@2.4.0"

go:
  add-credentials: true
  output-folder: go

csharp: 
  add-credentials: true
  namespace: Naveego.Auth #override the namespace
  output-folder : csharp # relative to the global value.

typescript:
  output-folder: node
  add-credentials: true
  override-client-name: AuthAPI
  generate-metadata: true
  package-name: "@naveego/client-auth"
  package-version: "1.0.2-beta.4"
  author: "Naveego"

java:
  add-credentials: true
  output-folder: java
  namespace: com.naveego.auth
```
