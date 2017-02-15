/**
 *
 * @author windawings
 * @create.time 2017/02/15 10:22
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("headerController", ["$scope", "authService", headerController]);

function headerController($scope, authService) {
    $scope.logout = function () {
        authService.logout();
    };
}