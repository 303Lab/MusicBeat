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
            url: "/",
            views: {
                "": {
                    templateUrl: fnBasePath("home.html"),
                    controller: "homeController"
                },
                "navHome@": {
                    controller: "navHomeController",
                    templateUrl: fnBasePath("navHome.html")
                }
            }
        })
        .state("app.login", {
            url: "login",
            views: {
                "viewContent@":{
                    controller: "loginController" ,
                    templateUrl: fnBasePath("login.html")
                }
            }
        })
        .state("app.user", {
            url: "user",
            views: {
                "viewContent@":{
                    templateUrl: fnBasePath("user.html")
                }
            }
        })
        .state("app.security", {
            url: "changePassword",
            views: {
                "viewContent@":{
                    templateUrl: fnBasePath("userChgPwd.html")
                }
            }
        })
    ;

    function fnBasePath(uri) {
        return appConst.htmlLoc + uri + "?ver=" + appConst.version;
    }
}