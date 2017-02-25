/**
 *
 * @author windawings
 * @create.time 2017/02/19 19:32
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("changeController", [
        "$scope",
        "$timeout",
        "toastr",
        "toastrProvider",
        "authService",
        "appEvent",
        changeController
    ]);

function changeController($scope, $timeout, toastr, toastrProvider, authService, appEvent) {

    $scope.changeModel = {
        password: "",
        confirm: "",
        message: appEvent.changeDefault,
        color: {"color": "#FFFFFF"},
        buttonColor: {"border": "0px"}
    };

    // 监听文本
    $scope.inputChange = function () {
        if (($scope.changeModel.password !== undefined && $scope.changeModel.password.trim() !== "") || ($scope.changeModel.confirm !== undefined && $scope.changeModel.confirm.trim() !== "")){
            $scope.changeModel.message = appEvent.changeDefault;
            $scope.changeModel.color = {"color": "#FFFFFF"};
        }
    };

    $scope.check = function () {
        if ($scope.changeModel.password.trim() !== $scope.changeModel.confirm.trim()) {
            $scope.changeModel.buttonColor = {"border": "2px solid #EE3D3D"};
        } else {
            $scope.changeModel.buttonColor = {"border": "0px"};
        }
    };

    $scope.change = function () {
        if (!$scope.changeModel.password.trim() || !$scope.changeModel.confirm.trim()) return;
        if ($scope.changeModel.password.trim() !== $scope.changeModel.confirm.trim()) {
            $scope.changeModel.message = appEvent.changeCheckFailed;
            $scope.changeModel.color = {"color": "#EE3D3D"};
            return;
        }

        $scope.changeModel.message = appEvent.changeDefault;
        $scope.changeModel.color = {"color": "#5d8730"};

        authService
            .change($scope.changeModel)
            .then(
                function (data) {
                    $scope.changeModel.password = "";
                    $scope.changeModel.confirm = "";
                    var result = data.status === appEvent.ok;
                    $scope.changeModel.message = result ? appEvent.changeOk : appEvent.notOk;
                    var text = toastrProvider.textCenter($scope.changeModel.message);

                    if (result) {
                        toastr.success(text);
                        $scope.changeModel.color = {"color": "#5d8730"};
                    } else {
                        toastr.error(text);
                        $scope.changeModel.color = {"color": "#EE3D3D"};
                    }

                    $timeout(function () {window.location.href = window.location.protocol + "//" + window.location.host + "/" + "musicbeat";}, 2000, true);
                },

                function (reason) {
                    if (typeof(reason.message) !== "undefined" && reason.message !== null) {
                        $scope.registerMsg.message = reason.message;
                    } else {
                        $scope.registerMsg.message = appEvent.error;
                    }
                    $scope.registerMsg.color = {"color": "#EE3D3D"};
                    var text = toastrProvider.textCenter(reason.message);
                    toastr.error(text);

                    console.log(reason);
                }
            );
    };
}