/**
 *
 * @author windawings
 * @create.time 2017/02/15 16:07
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.routes")
    .config(["$stateProvider", "appConst", appRouter]);

function appRouter($stateProvider, appConst) {
    $stateProvider
        .state("app.home", {
            url: "/",
            views: {
                "content@":{
                    templateUrl: fnBasePath("home.html"),
                    controller: "homeController"
                }
            }
        })
        .state("app.music", {
            url: "/music",
            views: {
                "content@":{
                    templateUrl: fnBasePath("music.html")
                }
            }
        })
        .state("app.blog", {
            url: "/blog",
            views: {
                "content@":{
                    templateUrl: fnBasePath("blog.html"),
                    controller: "blogController"
                }
            }
        })
        .state("app.singer", {
            url: "/singer",
            views: {
                "content@":{
                    templateUrl: fnBasePath("singer.html")
                }
            }
        })
        .state("app.categorySinger", {
            url: "/category/singer",
            views: {
                "content@":{
                    templateUrl: fnBasePath("singer-cart.html")
                }
            }
        })
        .state("app.user", {
            url: "/user",
            views: {
                "content@":{
                    templateUrl: fnBasePath("user.html"),
                    controller: "userController"
                }
            }
        })
    ;

    function fnBasePath(uri) {
        return appConst.htmlLoc + uri + "?ver=" + appConst.version;
    }
}