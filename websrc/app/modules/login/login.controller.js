/*!登陆控制器*/
/**
 * @author windawings
 * @time.creation 2017/02/02 19:28
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("loginController", ["$scope", "authService", loginController]);

function loginController($scope, authService){

    // 监听文本
    $scope.inputChange = function () {
        if ($scope.credentials.userId.trim() !== "" || $scope.credentials.password.trim() !== ""){
            $scope.message.text = "";
        }
    };

    $scope.login = function() {
        if (!$scope.credentials.userId.trim() || !$scope.credentials.password.trim()) return;
        authService
            .login($scope.credentials)
            .then(
                function (data) { // 返回了response.data信息体
                    $scope.credentials.userId = "";
                    $scope.credentials.password = "";

                    // 关闭各种Panel
                    jQuery(document).click();
                },
                function (reason) {
                    $scope.credentials.userId = "";
                    $scope.credentials.password = "";
                    if (reason.message !== null && reason.message !== undefined) {
                        $scope.message.text = reason.message;
                    } else {
                        $scope.message.text = "Internal Error (500)";
                    }
                }
            );
    };

    /*==========  Validate Email  ==========*/
    $scope.validateEmail = function ($validate_email) {
        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        return emailReg.test($validate_email);
    };
}