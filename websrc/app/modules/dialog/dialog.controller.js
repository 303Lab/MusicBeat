/**
 *
 * @author windawings
 * @create.time 2017/02/14 15:13
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("dialogController", ["$scope", "ngDialog", dialogController]);

function dialogController($scope) {
    $scope.closeDialog = function () {
        ngDialog.close();
    };
}