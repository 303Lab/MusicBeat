/**
 *
 * @author windawings
 * @create.time 2017/02/15 16:08
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.routes")
    .config(["$stateProvider", "appConst", adminRouter]);

function adminRouter($stateProvider, appConst) {
    $stateProvider
        .state("admin.home", {
            url: "/admin",
            views: {
                "content@admin":{
                    templateUrl: fnBasePath("adminHome.html")
                }
            }
        })
    ;

    function fnBasePath(uri) {
        return appConst.htmlLoc + uri + "?ver=" + appConst.version;
    }
}