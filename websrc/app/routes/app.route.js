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
                "content@": {
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
        .state("admin", {
            url: "/admin",
            abstract: true,
            views: {
                "": {
                    templateUrl: fnBasePath("admin.html"),
                    controller: "adminController"
                },
                "header": {
                    templateUrl: fnBasePath("adminHeader.html")
                },
                "content@":{
                    templateUrl: fnBasePath("adminSinger.html")
                }
            }

        })
        .state("admin.singer", {
            url: "/singer",
            views: {
                "content@":{
                    templateUrl: fnBasePath("adminSinger.html")
                }
            }
        })
        .state("admin.data", {
            url: "/data",
            views: {
                "content@":{
                    templateUrl: fnBasePath("adminData.html")
                }
            }
        })
        .state("admin.label", {
            url: "/label",
            views: {
                "content@":{
                    templateUrl: fnBasePath("adminLabel.html")
                }
            }
        })
        .state("admin.song", {
            url: "/song",
            views: {
                "content@":{
                    templateUrl: fnBasePath("adminSong.html")
                }
            }
        })
    ;

    function fnBasePath(uri) {
        return appConst.htmlLoc + uri + "?ver=" + appConst.version;
    }
}