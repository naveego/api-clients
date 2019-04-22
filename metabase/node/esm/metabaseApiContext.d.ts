import * as msRest from "@azure/ms-rest-js";
import * as Models from "./models";
export declare class MetabaseApiContext extends msRest.ServiceClient {
    credentials: msRest.ServiceClientCredentials;
    /**
     * Initializes a new instance of the MetabaseApiContext class.
     * @param credentials Subscription credentials which uniquely identify client subscription.
     * @param [options] The parameter options
     */
    constructor(credentials: msRest.ServiceClientCredentials, options?: Models.MetabaseApiOptions);
}
//# sourceMappingURL=metabaseApiContext.d.ts.map