/**
 * 主页控制器
 * @author windawings
 * @time.creation 2017/02/06 19:17
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("indexController", ["$scope", "$state", "authService", indexController]);

function indexController($scope, $state, authService) {
    $state.go("app.home");
    $scope.session = authService.session;
    $scope.credentials = {userId: "", password: ""};
    $scope.registerMsg = {name: "", email: "", message: "A password will be e-mailed to you.", color: {"color": "#FFFFFF"}};
    $scope.retrieve = {email: ""};
    $scope.message = {text: ""};
}