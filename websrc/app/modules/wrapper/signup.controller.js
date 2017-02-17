/**
 * 注册控制器
 * @author windawings
 * @create.time 2017/02/16 9:26
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("signupController", ["$scope", "authService", "authEvent", signupController]);

function signupController($scope, authService, authEvent) {

    // 监听文本
    $scope.inputChange = function () {
        if ($scope.registerMsg.name.trim() !== "" || $scope.registerMsg.email.trim() !== ""){
            $scope.registerMsg.message = "A password will be e-mailed to you.";
            $scope.registerMsg.color = {"color": "#FFFFFF"};
        }
    };

    $scope.signup = function () {
        if (!$scope.registerMsg.email.trim()) return;

        $scope.registerMsg.message = authEvent.registerWait;
        $scope.registerMsg.color = {"color": "#5d8730"};

        authService
            .register($scope.registerMsg)
            .then(
                function (data) {
                    $scope.registerMsg.name = "";
                    $scope.registerMsg.email = "";
                    $scope.registerMsg.message = data.status === authEvent.ok ? authEvent.registerOk : authEvent.notOk;
                    if (data.status === authEvent.ok) {
                        $scope.registerMsg.color = {"color": "#5d8730"};
                    } else {
                        $scope.registerMsg.color = {"color": "#EE3D3D"};
                    }
                },
                function (reason) {
                    if (reason.message !== null && reason.message !== undefined) {
                        $scope.registerMsg.message = reason.message;
                    } else {
                        $scope.registerMsg.message = "Server Internal Error";
                    }
                    $scope.registerMsg.color = {"color": "#EE3D3D"};
                    console.log(reason);
                }
            );
    };
}