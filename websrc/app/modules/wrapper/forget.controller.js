/**
 *
 * @author windawings
 * @create.time 2017/02/18 23:02
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("retrieveController", [
        "$scope",
        "authService",
        "appEvent",
        "toastr",
        "toastrProvider",
        retrieveController
    ]);

function retrieveController($scope, authService, appEvent, toastr, toastrProvider) {
    // 监听文本
    $scope.inputChange = function () {
        if ($scope.retrieve.email !== undefined && $scope.retrieve.email.trim() !== ""){
            $scope.retrieve.message = appEvent.retrieveDefault;
            $scope.retrieve.color = {"color": "#FFFFFF"};
        }
    };

    $scope.forget = function () {
        if (!$scope.retrieve.email.trim()) return;

        $scope.retrieve.message = appEvent.registerWait;
        $scope.retrieve.color = {"color": "#5d8730"};

        authService
            .forget($scope.retrieve)
            .then(
                function (data) {
                    $scope.retrieve.email = "";
                    var result = data.status === appEvent.ok;
                    $scope.retrieve.message = result ? appEvent.retrieveOk : appEvent.notOk;
                    var text = toastrProvider.textCenter($scope.retrieve.message);

                    if (jQuery(".forget-wrapper").hasClass("open")) {
                        if (result) {
                            $scope.retrieve.color = {"color": "#5d8730"};
                        } else {
                            $scope.retrieve.color = {"color": "#EE3D3D"};
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
                    if (jQuery(".forget-wrapper").hasClass("open")) {
                        if (reason.message !== null && reason.message !== undefined) {
                            $scope.retrieve.message = reason.message;
                        } else {
                            $scope.retrieve.message = "Server Internal Error";
                        }
                        $scope.retrieve.color = {"color": "#EE3D3D"};
                    } else {
                        var text = toastrProvider.textCenter(reason.message);
                        toastr.error(text);
                    }

                    console.log(reason);
                }
            );
    };
}