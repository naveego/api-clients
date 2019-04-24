/*
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */
import * as tslib_1 from "tslib";
import * as msRest from "@azure/ms-rest-js";
import * as Models from "./models";
import * as Mappers from "./models/mappers";
import * as Parameters from "./models/parameters";
import { AuthAPIContext } from "./authAPIContext";
var AuthAPI = /** @class */ (function (_super) {
    tslib_1.__extends(AuthAPI, _super);
    /**
     * Initializes a new instance of the AuthAPI class.
     * @param credentials Subscription credentials which uniquely identify client subscription.
     * @param [options] The parameter options
     */
    function AuthAPI(credentials, options) {
        return _super.call(this, credentials, options) || this;
    }
    AuthAPI.prototype.getConfiguration = function (tenantId, options, callback) {
        return this.sendOperationRequest({
            tenantId: tenantId,
            options: options
        }, getConfigurationOperationSpec, callback);
    };
    AuthAPI.prototype.discoverKeys = function (options, callback) {
        return this.sendOperationRequest({
            options: options
        }, discoverKeysOperationSpec, callback);
    };
    AuthAPI.prototype.authorize = function (options, callback) {
        return this.sendOperationRequest({
            options: options
        }, authorizeOperationSpec, callback);
    };
    AuthAPI.prototype.token = function (grantType, options, callback) {
        return this.sendOperationRequest({
            grantType: grantType,
            options: options
        }, tokenOperationSpec, callback);
    };
    AuthAPI.prototype.generateRequest = function (tid, sAMLResponse, relayState, options, callback) {
        return this.sendOperationRequest({
            tid: tid,
            sAMLResponse: sAMLResponse,
            relayState: relayState,
            options: options
        }, generateRequestOperationSpec, callback);
    };
    AuthAPI.prototype.generateRequest1 = function (tid, clientId, options, callback) {
        return this.sendOperationRequest({
            tid: tid,
            clientId: clientId,
            options: options
        }, generateRequest1OperationSpec, callback);
    };
    AuthAPI.prototype.getSAMLSettings = function (tid, options, callback) {
        return this.sendOperationRequest({
            tid: tid,
            options: options
        }, getSAMLSettingsOperationSpec, callback);
    };
    AuthAPI.prototype.create = function (body, options, callback) {
        return this.sendOperationRequest({
            body: body,
            options: options
        }, createOperationSpec, callback);
    };
    AuthAPI.prototype.get = function (userId, options, callback) {
        return this.sendOperationRequest({
            userId: userId,
            options: options
        }, getOperationSpec, callback);
    };
    AuthAPI.prototype.update = function (userId, body, options, callback) {
        return this.sendOperationRequest({
            userId: userId,
            body: body,
            options: options
        }, updateOperationSpec, callback);
    };
    AuthAPI.prototype.update1 = function (userId, options, callback) {
        return this.sendOperationRequest({
            userId: userId,
            options: options
        }, update1OperationSpec, callback);
    };
    AuthAPI.prototype.generateAuthCode = function (userId, options, callback) {
        return this.sendOperationRequest({
            userId: userId,
            options: options
        }, generateAuthCodeOperationSpec, callback);
    };
    return AuthAPI;
}(AuthAPIContext));
// Operation Specifications
var serializer = new msRest.Serializer(Mappers);
var getConfigurationOperationSpec = {
    httpMethod: "GET",
    path: "configuration/{tenantId}",
    urlParameters: [
        Parameters.tenantId
    ],
    responses: {
        200: {
            bodyMapper: Mappers.TenantConfiguration
        },
        default: {
            bodyMapper: Mappers.TenantConfiguration
        }
    },
    serializer: serializer
};
var discoverKeysOperationSpec = {
    httpMethod: "GET",
    path: "discovery/keys",
    responses: {
        200: {
            bodyMapper: Mappers.DiscoveryKeys
        },
        default: {
            bodyMapper: Mappers.DiscoveryKeys
        }
    },
    serializer: serializer
};
var authorizeOperationSpec = {
    httpMethod: "GET",
    path: "oauth2/authorize",
    responses: {
        302: {},
        default: {}
    },
    serializer: serializer
};
var tokenOperationSpec = {
    httpMethod: "POST",
    path: "oauth2/token",
    formDataParameters: [
        Parameters.grantType,
        Parameters.username,
        Parameters.password,
        Parameters.code,
        Parameters.refreshToken
    ],
    contentType: "application/x-www-form-urlencoded",
    responses: {
        200: {
            bodyMapper: Mappers.OauthToken
        },
        400: {},
        403: {},
        500: {},
        default: {
            bodyMapper: Mappers.OauthToken
        }
    },
    serializer: serializer
};
var generateRequestOperationSpec = {
    httpMethod: "POST",
    path: "saml/access",
    queryParameters: [
        Parameters.tid
    ],
    formDataParameters: [
        Parameters.sAMLResponse,
        Parameters.relayState
    ],
    contentType: "application/x-www-form-urlencoded",
    responses: {
        302: {},
        default: {}
    },
    serializer: serializer
};
var generateRequest1OperationSpec = {
    httpMethod: "POST",
    path: "saml/request",
    queryParameters: [
        Parameters.tid
    ],
    formDataParameters: [
        Parameters.clientId
    ],
    contentType: "application/x-www-form-urlencoded",
    responses: {
        200: {
            bodyMapper: Mappers.SamlGenerateRequestResponse
        },
        default: {
            bodyMapper: Mappers.SamlGenerateRequestResponse
        }
    },
    serializer: serializer
};
var getSAMLSettingsOperationSpec = {
    httpMethod: "GET",
    path: "saml/settings",
    queryParameters: [
        Parameters.tid
    ],
    responses: {
        200: {
            bodyMapper: Mappers.SamlSAMLSettings
        },
        default: {
            bodyMapper: Mappers.SamlSAMLSettings
        }
    },
    serializer: serializer
};
var createOperationSpec = {
    httpMethod: "POST",
    path: "users",
    requestBody: {
        parameterPath: "body",
        mapper: tslib_1.__assign({}, Mappers.UserCreateUser, { required: true })
    },
    responses: {
        202: {
            bodyMapper: Mappers.UserUser
        },
        default: {}
    },
    serializer: serializer
};
var getOperationSpec = {
    httpMethod: "GET",
    path: "users/{userId}",
    urlParameters: [
        Parameters.userId
    ],
    responses: {
        200: {
            bodyMapper: Mappers.UserUser
        },
        default: {
            bodyMapper: Mappers.UserUser
        }
    },
    serializer: serializer
};
var updateOperationSpec = {
    httpMethod: "PUT",
    path: "users/{userId}",
    urlParameters: [
        Parameters.userId
    ],
    requestBody: {
        parameterPath: "body",
        mapper: tslib_1.__assign({}, Mappers.UserUser, { required: true })
    },
    responses: {
        200: {
            bodyMapper: Mappers.UserUser
        },
        default: {
            bodyMapper: Mappers.UserUser
        }
    },
    serializer: serializer
};
var update1OperationSpec = {
    httpMethod: "DELETE",
    path: "users/{userId}",
    urlParameters: [
        Parameters.userId
    ],
    responses: {
        200: {},
        default: {}
    },
    serializer: serializer
};
var generateAuthCodeOperationSpec = {
    httpMethod: "GET",
    path: "users/{userId}/authcode",
    urlParameters: [
        Parameters.userId
    ],
    responses: {
        200: {
            bodyMapper: Mappers.UserAuthCodeResponse
        },
        default: {
            bodyMapper: Mappers.UserAuthCodeResponse
        }
    },
    serializer: serializer
};
export { AuthAPI, AuthAPIContext, Models as AuthAPIModels, Mappers as AuthAPIMappers };
//# sourceMappingURL=authAPI.js.map