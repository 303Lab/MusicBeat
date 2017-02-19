/*!登陆控制器*/
/**
 * @author windawings
 * @time.creation 2017/02/02 19:28
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("loginController", [
        "$scope",
        "toastr",
        "toastrProvider",
        "authService",
        "authEvent",
        loginController
    ]);

function loginController($scope, toastr, toastrProvider, authService, authEvent){

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
                // 返回了response.data信息体
                function (data) {
                    $scope.credentials.userId = "";
                    $scope.credentials.password = "";
                    // 关闭各种Panel
                    jQuery(document).click();

                    if (!jQuery(".login-wrapper").hasClass("open")) {
                        var text =  toastrProvider.textCenter("Welcome " + data.userData.username + " !");
                        toastr.success(text);
                    }
                },

                // 错误处理
                function (reason) {
                    if (reason.message !== null && reason.message !== undefined) {
                        $scope.message.text = reason.message;
                    } else {
                        $scope.message.text = "Server Internal Error";
                    }

                    if (!jQuery(".login-wrapper").hasClass("open")) {
                        var text = toastrProvider.textCenter($scope.message.text);
                        toastr.error(text);
                    }

                    console.log(reason);
                }
            );
    };
}