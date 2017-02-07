/**
 * 顶部导航条
 * @author windawings
 * @time.creation 2017/02/05 17:48
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("navHomeController", ["$scope", navHomeController]);

function navHomeController($scope) {
    $scope.name = "navHomeController";
    console.log($scope.name);
}