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

    $provide.provider("urlParamsProvider", function () {
        this.$get = function () {
            var service={};
            service.getParam = function (name) {
                var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
                var r = window.location.search.substr(1).match(reg);
                if(r!==null)return  unescape(r[2]); return null;
            };

            return service;
        };
    });
}