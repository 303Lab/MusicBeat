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
        // app
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
            url: "/music?search&p&label",
            reloadOnSearch: false,
            views: {
                "content@":{
                    templateUrl: fnBasePath("music.html"),
                    controller: "musicController"
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
        .state("app.blog.category", {
            url: "/category/{name}",
            views: {
                "content@":{
                    templateUrl: fnBasePath("blog.cart.html"),
                    controller: "blogCategoryController"
                }
            }
        })
        .state("app.singer", {
            url: "/singer?type&p&search",
            reloadOnSearch: false,
            views: {
                "content@":{
                    templateUrl: fnBasePath("singer.html"),
                    controller: "singerController"
                }
            }
        })
        .state("app.singer.category", {
            url: "/category/{sid:int}",
            views: {
                "content@":{
                    templateUrl: fnBasePath("singer.cart.html"),
                    controller: "singerCategoryController"
                }
            }
        })

        // user
        .state("app.user", {
            url: "/user",
            abstract: true,
            views: {
                "header@": {
                    templateUrl: fnBasePath("user.header.html")
                },
                "content@": {
                    templateUrl: fnBasePath("user.home.html"),
                    controller: "userController"
                },
                "userContent": {
                    templateUrl: fnBasePath("user.detail.html"),
                }
            }
        })
        .state("app.user.detail", {
            url: "/detail",
            views: {
                "userContent@app.user": {
                    templateUrl: fnBasePath("user.detail.html")
                }
            }
        })
        .state("app.user.security", {
            url: "/security",
            views: {
                "userContent@app.user": {
                    templateUrl: fnBasePath("user.security.html")
                }
            }
        })

        // admin
        .state("admin.singer", {
            url: "/singer?p&search",
            reloadOnSearch: false,
            views: {
                "content@":{
                    templateUrl: fnBasePath("admin.singer.html"),
                    controller: "adminSingerController"
                }
            }
        })
        .state("admin.album", {
            url: "/album",
            views: {
                "content@":{
                    templateUrl: fnBasePath("admin.album.html")
                }
            }
        })
        .state("admin.label", {
            url: "/label",
            views: {
                "content@":{
                    templateUrl: fnBasePath("admin.label.html")
                }
            }
        })
        .state("admin.song", {
            url: "/song?p&search",
            reloadOnSearch: false,
            views: {
                "content@":{
                    templateUrl: fnBasePath("admin.song.html"),
                    controller: "adminSongController"
                }
            }
        })
    ;

    function fnBasePath(uri) {
        return appConst.htmlLoc + uri + "?ver=" + appConst.version;
    }
}