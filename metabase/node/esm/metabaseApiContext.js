/*
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */
import * as tslib_1 from "tslib";
import * as msRest from "@azure/ms-rest-js";
var packageName = "@naveego/client-metabase";
var packageVersion = "1.0.0-beta.1";
var MetabaseApiContext = /** @class */ (function (_super) {
    tslib_1.__extends(MetabaseApiContext, _super);
    /**
     * Initializes a new instance of the MetabaseApiContext class.
     * @param credentials Subscription credentials which uniquely identify client subscription.
     * @param [options] The parameter options
     */
    function MetabaseApiContext(credentials, options) {
        var _this = this;
        if (credentials === null || credentials === undefined) {
            throw new Error('\'credentials\' cannot be null.');
        }
        if (!options) {
            options = {};
        }
        if (!options.userAgent) {
            var defaultUserAgent = msRest.getDefaultUserAgentValue();
            options.userAgent = packageName + "/" + packageVersion + " " + defaultUserAgent;
        }
        _this = _super.call(this, credentials, options) || this;
        _this.baseUri = options.baseUri || _this.baseUri || "http://metabase.n5o.red";
        _this.requestContentType = "application/json; charset=utf-8";
        _this.credentials = credentials;
        return _this;
    }
    return MetabaseApiContext;
}(msRest.ServiceClient));
export { MetabaseApiContext };
//# sourceMappingURL=metabaseApiContext.js.map