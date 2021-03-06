/**
 * 注册控制器
 * @author windawings
 * @create.time 2017/02/16 9:26
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("signupController", [
        "$scope",
        "toastr",
        "toastrProvider",
        "authService",
        "appEvent",
        signupController
    ]);

function signupController($scope, toastr, toastrProvider, authService, appEvent) {

    // 监听文本
    $scope.inputChange = function () {
        if (($scope.registerMsg.name !== undefined && $scope.registerMsg.name.trim() !== "") || ($scope.registerMsg.email !== undefined && $scope.registerMsg.email.trim() !== "")){
            $scope.registerMsg.message = appEvent.registerDefault;
            $scope.registerMsg.color = {"color": "#FFFFFF"};
        }
    };

    $scope.signup = function () {
        if (!$scope.registerMsg.email.trim()) return;

        $scope.registerMsg.message = appEvent.registerWait;
        $scope.registerMsg.color = {"color": "#5d8730"};

        authService
            .register($scope.registerMsg)
            .then(
                function (data) {
                    $scope.registerMsg.name = "";
                    $scope.registerMsg.email = "";
                    var result = data.status === appEvent.ok;
                    $scope.registerMsg.message = result ? appEvent.registerOk : appEvent.notOk;
                    var text = toastrProvider.textCenter($scope.registerMsg.message);

                    if (jQuery(".signup-wrapper").hasClass("open")) {
                        if (result) {
                            $scope.registerMsg.color = {"color": "#5d8730"};
                        } else {
                            $scope.registerMsg.color = {"color": "#EE3D3D"};
                        }
                    } else {
                        if (result) {
                            toastr.success(text);
                        } else {
                            toastr.error(text);
                        }
                    }
                },
                function (reason) {
                    if (jQuery(".signup-wrapper").hasClass("open")) {
                        if (typeof(reason.message) !== "undefined" && reason.message !== null) {
                            $scope.registerMsg.message = reason.message;
                        } else {
                            $scope.registerMsg.message = appEvent.error;
                        }
                        $scope.registerMsg.color = {"color": "#EE3D3D"};
                    } else {
                        var text = toastrProvider.textCenter(reason.message);
                        toastr.error(text);
                    }

                    console.log(reason);
                }
            );
    };
}