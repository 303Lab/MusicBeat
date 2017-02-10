/*!登陆控制器*/
/**
 * @author windawings
 * @time.creation 2017/02/02 19:28
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("loginController", ["$scope", "authService", "ngDialog", loginController]);

function loginController($scope, authService, ngDialog){

    $scope.getFormData = function () {
        console.log($scope.credentials);
    };

    $scope.setFormData = function () {
        $scope.credentials = {
            userId: "13088888888",
            password: "233",
            autoLogin: false
        };
    };

    $scope.restForm = function () {
        $scope.credentials={
            userId: "windawings@foxmail.com",
            password: "123",
            autoLogin: true
        };
    };

    var emptyCredentials = {userId: "", password: "", autoLogin: false};
    $scope.credentials = angular.copy(emptyCredentials);
    $scope.message = "";

    $scope.login = function() {
        if (!$scope.credentials.userId.trim() || !$scope.credentials.password.trim()) return;
        authService
            .login($scope.credentials)
            .then(
                function (data) { // 返回了response.data信息体
                    $scope.credentials = angular.copy(emptyCredentials);
                    $scope.message = angular.toJson(data.userData, true);
                    ngDialog.open({
                        template: "loginNgDialog",
                        className: "ngdialog-theme-default",
                        scope: $scope
                    });
                },
                function (reason) {
                    $scope.message = reason.message;
                    ngDialog.open({
                          template: "loginNgDialog",
                          className: "ngdialog-theme-default",
                          scope: $scope
                      });
                }
            );
    };

    $scope.closeLoginPanel = function () {
        angular.copy(emptyCredentials, $scope.credentials);
        authService.session.isShowPanel = false;
    };
}