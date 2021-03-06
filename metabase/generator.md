# Client for Auth API

> see https://aka.ms/autorest

## Generation Config:

```yaml
input-file: http://metabase.n5o.red/swagger/v1/swagger.json # full Unicode support

use:
  - "@microsoft.azure/autorest.typescript@2.4.0"

go:
  add-credentials: true
  output-folder: go

csharp: 
  add-credentials: true
  namespace: Naveego.Metabase #override the namespace
  output-folder : csharp # relative to the global value.

typescript:
  output-folder: node
  add-credentials: true
  override-client-name: MetabaseApi
  generate-metadata: true
  package-name: "@naveego/client-metabase"
  package-version: "1.0.0-beta.1"
  author: "Naveego"

java:
  add-credentials: true
  output-folder: java
  namespace: com.naveego.metabase
```
