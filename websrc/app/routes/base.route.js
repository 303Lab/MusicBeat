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
    ;

    function fnBasePath(uri) {
        return appConst.htmlLoc + uri + "?ver=" + appConst.version;
    }
}