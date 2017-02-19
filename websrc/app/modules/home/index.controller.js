/**
 * 主页控制器
 * @author windawings
 * @time.creation 2017/02/06 19:17
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("indexController", ["$scope", "$state", "authService", "authEvent", indexController]);

function indexController($scope, $state, authService, authEvent) {
    $state.go("app.home");
    $scope.session = authService.session;
    $scope.credentials = {userId: "", password: ""};
    $scope.registerMsg = {name: "", email: "", message: authEvent.registerDefault, color: {"color": "#FFFFFF"}};
    $scope.retrieve = {email: "", message: authEvent.retrieveDefault, color: {"color": "#FFFFFF"}};
    $scope.message = {text: ""};
}