/**
 * 基础路由
 * @author windawings
 * @time.creation 2017/02/03 19:48
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.routes")
    .config(["$stateProvider", "$urlRouterProvider", "appConst", baseRouter]);

function baseRouter($stateProvider, $urlRouterProvider, appConst) {

    $urlRouterProvider.otherwise("/");

    $stateProvider
        .state("app", {
            abstract: true,
            views: {
                "": {
                    templateUrl: fnBasePath("index.html"),
                    controller: "indexController"
                },
                "header": {
                    templateUrl: fnBasePath("header.html"),
                    controller: "headerController"
                }
            }
        })
        .state("admin", {
            url: "/admin",
            abstract: true,
            views: {
                "header@": {
                    templateUrl: fnBasePath("admin.header.html")
                },
                "content@":{
                    templateUrl: fnBasePath("admin.singer.html")
                }
            }
        })
    ;

    function fnBasePath(uri) {
        return appConst.htmlLoc + uri + "?ver=" + appConst.version;
    }
}