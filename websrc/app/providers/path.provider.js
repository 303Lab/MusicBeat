/**
 *
 * @author windawings
 * @create.time 2017/02/15 16:43
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.providers")
    .config(["$provide", "appConst", pathProvider]);

function pathProvider($provide, appConst) {
    $provide.provider("basePathProvider", function () {
        this.$get = function () {
            var service={};
            service.basePath = function (uri) {
                return appConst.htmlLoc + uri + "?ver=" + appConst.version;
            };

            return service;
        };
    });
}