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
                "":{
                    templateUrl: fnBasePath("index.html"),
                    controller: "indexController"
                },
                "authWrapper":{
                    templateUrl: fnBasePath("authWrapper.html"),
                    controller: "authWrapperController"
                },
                "content":{
                    templateUrl: fnBasePath("home.html"),
                    controller: "homeController"
                }
            }
        })
        .state("app.music", {
            url: "music",
            views: {
                "content@":{
                    templateUrl: fnBasePath("music.html")
                }
            }
        })
        .state("app.blog", {
            url: "blog",
            views: {
                "content@":{
                    templateUrl: fnBasePath("blog.html"),
                    controller: "blogController"
                }
            }
        })
        .state("app.singer", {
            url: "singer",
            views: {
                "content@":{
                    templateUrl: fnBasePath("singer.html")
                }
            }
        })
        .state("app.categorySinger", {
            url: "category/singer",
            views: {
                "content@":{
                    templateUrl: fnBasePath("singer-cart.html")
                }
            }
        })
        .state("admin", {
            url: "/admin",
            templateUrl: fnBasePath("admin.html"),
            controller: "adminController"
        })
        .state("user", {
            url: "/user",
            templateUrl: fnBasePath("user.html")
        })
    ;

    function fnBasePath(uri) {
        return appConst.htmlLoc + uri + "?ver=" + appConst.version;
    }
}