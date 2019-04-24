var AnonymousCredentials = /** @class */ (function () {
    function AnonymousCredentials() {
    }
    AnonymousCredentials.prototype.signRequest = function (webResource) {
        // We don't do anything here
        return Promise.resolve(webResource);
    };
    return AnonymousCredentials;
}());
export { AnonymousCredentials };
//# sourceMappingURL=anonymous.js.map