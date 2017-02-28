/**
 *
 * @author windawings
 * @create.time 2017/02/15 15:41
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("userController", [
        "$scope",
        "$state",
        "toastr",
        "toastrProvider",
        "$sessionStorage",
        "appEvent",
        "userService",
        userController]);

function userController($scope, $state, toastr, toastrProvider, $sessionStorage, appEvent, userService) {

    if($sessionStorage.isAuthed === false || typeof($sessionStorage.isAuthed) === "undefined" || $sessionStorage.roleName !== "user"){
        $state.go("app.home");
    }

    $scope.user = {
        mobile: "",
        qq: "",
        city: "",
        email: "",
        sex: null,
        username: "",
        newpass: "",
        password: "",
        pic: "",
    };

    if (!jQuery.isEmptyObject($sessionStorage.currentUser)) {
        $scope.user.mobile = typeof($sessionStorage.currentUser.phone) === "undefined" ? "" : $sessionStorage.currentUser.phone;
        $scope.user.qq = typeof($sessionStorage.currentUser.qq) === "undefined" ? "" : $sessionStorage.currentUser.qq;
        $scope.user.city = typeof($sessionStorage.currentUser.city) === "undefined" ? "" : $sessionStorage.currentUser.city;
        $scope.user.sex = typeof($sessionStorage.currentUser.gender) === "undefined" ? "" : $sessionStorage.currentUser.gender;
        $scope.user.email = typeof($sessionStorage.currentUser.email) === "undefined" ? "" : $sessionStorage.currentUser.email;
        $scope.user.username = typeof($sessionStorage.currentUser.username) === "undefined" ? "" : $sessionStorage.currentUser.username;
        $scope.user.pic = typeof($sessionStorage.currentUser.picture) === "undefined" ? "" : $sessionStorage.currentUser.picture;
    }

    
    $scope.submitBasic = function () {

        if (checkMobile() && checkQQ() && checkBasic()) {

            userService
                .updateBasic($scope.user)
                .then(
                    function (data) {
                        if (data.status === appEvent.ok) {

                            toastr.success(toastrProvider.textCenter(appEvent.updateOk));
                        } else {
                            toastr.error(toastrProvider.textCenter(appEvent.notOk));
                        }
                    },

                    function (reason) {
                        if (typeof(reason.message) !== "undefined" && reason.message !== null) {
                            toastr.error(toastrProvider.textCenter(reason.message));
                        } else {
                            toastr.error(toastrProvider.textCenter(appEvent.error));
                        }

                        console.log(reason);
                    }
                );
        }
        else {
            toastr.warning(toastrProvider.textCenter(appEvent.updateNone));
        }
    };

    $scope.submitUserName = function () {
        if (checkUserName()) {
            userService
                .updateUserName($scope.user)
                .then(
                    function (data) {
                        if (data.status === appEvent.ok) {
                            toastr.success(toastrProvider.textCenter(appEvent.updateOk));
                        } else {
                            toastr.error(toastrProvider.textCenter(appEvent.notOk));
                        }
                    },

                    function (reason) {
                        if (typeof(reason.message) !== "undefined" && reason.message !== null) {
                            toastr.error(toastrProvider.textCenter(reason.message));
                        } else {
                            toastr.error(toastrProvider.textCenter(appEvent.error));
                        }

                        console.log(reason);
                    }
                );
        } else {
            toastr.warning(toastrProvider.textCenter(appEvent.usernameDuplicate));
        }
    };

    $scope.submitPassword = function () {
        userService
            .updatePassword($scope.user)
            .then(
                function (data) {
                    if (data === appEvent.passwordDuplicate) {
                        toastr.warning(toastrProvider.textCenter(appEvent.passwordDuplicate));
                        return;
                    }

                    if (data.status === appEvent.ok) {
                        toastr.success(toastrProvider.textCenter(appEvent.updateOk));
                    } else {
                        toastr.error(toastrProvider.textCenter(appEvent.notOk));
                    }
                },

                function (reason) {
                    if (typeof(reason.message) !== "undefined" && reason.message !== null) {
                        toastr.error(toastrProvider.textCenter(reason.message));
                    } else {
                        toastr.error(toastrProvider.textCenter(appEvent.error));
                    }

                    console.log(reason);
                }
            );
    };

    var regPhone = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,2,3,5-9]))\\d{8}$/;
    var regQQ = /^\d{5,10}$/;

    function checkMobile() {
        if ($scope.user.mobile.trim() !== "") {
            if ($scope.user.mobile.trim().length  !== 11) {
                toastr.warning(toastrProvider.textCenter(appEvent.mobileNotValid));
                return false;
            } else if (!regPhone.test($scope.user.mobile.trim())){
                toastr.warning(toastrProvider.textCenter(appEvent.mobileNotValid));
                return false;
            }
        }

        return true;
    }

    function checkQQ() {
        if ($scope.user.qq.trim() !== "") {
            if (!regQQ.test($scope.user.qq.trim())){
                toastr.warning(toastrProvider.textCenter(appEvent.qqNotValid));
                return false;
            }
        }

        return true;
    }

    function checkBasic() {
        return !($scope.user.email === (typeof($sessionStorage.currentUser.email) === "undefined" ? "" : $sessionStorage.currentUser.email)
                 && $scope.user.sex === (typeof($sessionStorage.currentUser.gender) === "undefined" ? "" : $sessionStorage.currentUser.gender)
                 && $scope.user.mobile === (typeof($sessionStorage.currentUser.phone) === "undefined" ? "" : $sessionStorage.currentUser.phone)
                 && $scope.user.qq === (typeof($sessionStorage.currentUser.qq) === "undefined" ? "" : $sessionStorage.currentUser.qq)
                 && $scope.user.city === (typeof($sessionStorage.currentUser.city) === "undefined" ? "" : $sessionStorage.currentUser.city));
    }

    function checkUserName() {
        return !($scope.user.username === $sessionStorage.currentUser.username);
    }
}
