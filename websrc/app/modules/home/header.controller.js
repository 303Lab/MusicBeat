/**
 *
 * @author windawings
 * @create.time 2017/02/15 10:22
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("headerController", ["$scope", "$state", "authService", "authEvent", headerController]);

function headerController($scope, $state, authService, authEvent) {

    // 注销
    $scope.logout = function () {
        authService
            .logout()
            .then(
                function (data) {
                    if($state.current.name === "app.user") {
                        $state.go("app.home");
                    }
                    console.log(angular.toJson(data));
                },
                function (reason) {
                    console.log(angular.toJson(reason));
                }
            )
        ;
    };

    // 点击登陆按钮清除旧认证数据
    $scope.clearMessage = function () {
        $scope.credentials.userId = "";
        $scope.credentials.password = "";
        $scope.registerMsg.name = "";
        $scope.registerMsg.email = "";
        $scope.registerMsg.message = authEvent.registerDefault;
        $scope.registerMsg.color = {"color": "#FFFFFF"};
        $scope.retrieve.email = "";
        $scope.retrieve.message = authEvent.retrieveDefault;
        $scope.retrieve.color = {"color": "#FFFFFF"};
        $scope.message.text = "";
    };
}