/**
 * 主页控制器
 * @author windawings
 * @time.creation 2017/02/06 19:17
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("homeController", ["$scope", "authService", "$localStorage", homeController]);

function homeController($scope, authService, $localStorage) {
    $scope.session = authService.session;
    $scope.$storage = $localStorage;
}