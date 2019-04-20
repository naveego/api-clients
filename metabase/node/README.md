# An isomorphic javascript sdk for - MetabaseApi
This project provides an isomorphic javascript package. Right now it supports:
- node.js version 6.x.x or higher
- browser javascript

## How to Install

- nodejs
```
npm install
```
- browser
```html
<script type="text/javascript" src="/metabaseApiBundle.js"></script>
```

## How to use

### nodejs - Authentication, client creation and getPagedStatusesForBatch  as an example written in TypeScript.

```javascript
import * as msRest from "ms-rest-js";
import { MetabaseApi, MetabaseApiModels, MetabaseApiMappers } from "";
const subscriptionId = process.env["AZURE_SUBSCRIPTION_ID"];

const token = "<access_token>";
const creds = new msRest.TokenCredentials(token);
const client = new MetabaseApi(creds, subscriptionId);
const id = "testid";
const page = 1;
const pageSize = 1;
client.getPagedStatusesForBatch(id, page, pageSize).then((result) => {
  console.log("The result is:");
  console.log(result);
}).catch((err) => {
  console.log('An error ocurred:');
  console.dir(err, {depth: null, colors: true});
});
```

### browser - Authentication, client creation and getPagedStatusesForBatch  as an example written in javascript.

- index.html
```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>My Todos</title>
    <script type="text/javascript" src="https://raw.githubusercontent.com/Azure/ms-rest-js/master/msRestBundle.js"></script>
    <script type="text/javascript" src="./metabaseApiBundle.js"></script>
    <script type="text/javascript">
      document.write('hello world');
      const subscriptionId = "<Subscription_Id>";
      const token = "<access_token>";
      const creds = new msRest.TokenCredentials(token);
      const client = new MetabaseApi(creds, subscriptionId);
      const id = "testid";
      const page = 1;
      const pageSize = 1;
      client.getPagedStatusesForBatch(id, page, pageSize).then((result) => {
        console.log("The result is:");
        console.log(result);
      }).catch((err) => {
        console.log('An error ocurred:');
        console.dir(err, { depth: null, colors: true});
      });
    </script>
  </head>
  <body>
  </body>
</html>
```

# Related projects
 - [Microsoft Azure SDK for Javascript](https://github.com/Azure/azure-sdk-for-js)
