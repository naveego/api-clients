# Client for Auth API

> see https://aka.ms/autorest

## Generation Config:

```yaml
input-file: http://auth.n5o.red/swagger.json # full Unicode support

use:
  - "@microsoft.azure/autorest.typescript@2.0.437"

typescript:
  output-folder: lib 
  add-credentials: true
  override-client-name: Auth
  # generate-metadata: true
  # package-name: "@naveego/client-auth"
  # package-version: "1.0.0"
```
