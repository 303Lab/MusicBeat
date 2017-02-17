/**
 *
 * @author windawings
 * @create.time 2017/02/15 15:41
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("userController", ["$scope", "$state", "$sessionStorage", userController]);

function userController($scope, $state, $sessionStorage) {
    if($sessionStorage.isAuthed === false || $sessionStorage.isAuthed === undefined || $sessionStorage.roleName !== "user"){
        $state.go("app.home");
    }
}