/**
 * 主页控制器
 * @author windawings
 * @time.creation 2017/02/06 19:17
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("indexController", [
        "$scope",
        "$state",
        "$document",
        "authService",
        "appEvent",
        indexController
    ]);

function indexController($scope, $state, $document, authService, appEvent) {
    $state.go("app.home");
    $scope.session = authService.session;
    $scope.credentials = {userId: "", password: ""};
    $scope.registerMsg = {name: "", email: "", message: appEvent.registerDefault, color: {"color": "#FFFFFF"}};
    $scope.retrieve = {email: "", message: appEvent.retrieveDefault, color: {"color": "#FFFFFF"}};
    $scope.message = {text: ""};

    // APlayer
    $scope.musics = {
        element: $document[0].getElementsByClassName("aplayer")[0],
        narrow: false,
        autoplay: false,
        showlrc: 3,
        mutex: true,
        theme: "#b7daff",
        mode: "circulation",
        listmaxheight: "379.5px",
    };
    $scope.player = new APlayer($scope.musics);

    // 判断是否为数组
    $scope.isArray = function (object){
        return object && typeof object === 'object' && Array == object.constructor;
    };
}
