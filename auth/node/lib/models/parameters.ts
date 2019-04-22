/*
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

import * as msRest from "@azure/ms-rest-js";

export const clientId: msRest.OperationParameter = {
  parameterPath: "clientId",
  mapper: {
    required: true,
    serializedName: "client_id",
    type: {
      name: "String"
    }
  }
};
export const code: msRest.OperationParameter = {
  parameterPath: [
    "options",
    "code"
  ],
  mapper: {
    serializedName: "code",
    type: {
      name: "String"
    }
  }
};
export const grantType: msRest.OperationParameter = {
  parameterPath: "grantType",
  mapper: {
    required: true,
    serializedName: "grant_type",
    type: {
      name: "String"
    }
  }
};
export const password: msRest.OperationParameter = {
  parameterPath: [
    "options",
    "password"
  ],
  mapper: {
    serializedName: "password",
    type: {
      name: "String"
    }
  }
};
export const refreshToken: msRest.OperationParameter = {
  parameterPath: [
    "options",
    "refreshToken"
  ],
  mapper: {
    serializedName: "refresh_token",
    type: {
      name: "String"
    }
  }
};
export const relayState: msRest.OperationParameter = {
  parameterPath: "relayState",
  mapper: {
    required: true,
    serializedName: "RelayState",
    type: {
      name: "String"
    }
  }
};
export const sAMLResponse: msRest.OperationParameter = {
  parameterPath: "sAMLResponse",
  mapper: {
    required: true,
    serializedName: "SAMLResponse",
    type: {
      name: "String"
    }
  }
};
export const tenantId: msRest.OperationURLParameter = {
  parameterPath: "tenantId",
  mapper: {
    required: true,
    serializedName: "tenantId",
    type: {
      name: "String"
    }
  }
};
export const tid: msRest.OperationQueryParameter = {
  parameterPath: "tid",
  mapper: {
    required: true,
    serializedName: "tid",
    type: {
      name: "String"
    }
  }
};
export const userId: msRest.OperationURLParameter = {
  parameterPath: "userId",
  mapper: {
    required: true,
    serializedName: "userId",
    type: {
      name: "String"
    }
  }
};
export const username: msRest.OperationParameter = {
  parameterPath: [
    "options",
    "username"
  ],
  mapper: {
    serializedName: "username",
    type: {
      name: "String"
    }
  }
};
