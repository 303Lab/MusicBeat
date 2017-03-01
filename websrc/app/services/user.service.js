/**
 * 用户界面控制器
 * @author windawings
 * @create.time 2017/02/27 15:32
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.services")
    .factory("userService", [
        "$http",
        "$q",
        "appConst",
        "$sessionStorage",
        "hashProvider",
        userService
    ]);

function userService($http, $q, appConst, $sessionStorage, hashProvider) {
    var serviceBaseApi = appConst.apiUrl;
    var updateBasicApi = serviceBaseApi + "/user/updateBasic";
    var updateUserNameApi = serviceBaseApi + "/user/updateUserName";
    var updatePasswordApi = serviceBaseApi + "/user/updatePassword";

    function updateBasic(user) {
        var data = {
            qq: encodeURIComponent(user.qq.trim()),
            sex: encodeURIComponent(user.sex),
            city: encodeURIComponent(user.city.trim()),
            email: encodeURIComponent(user.email.trim()),

        };

        var deferred = $q.defer();

        var header = {
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        };

        $http.post(updateBasicApi, angular.toJson(data), header)
            .then(
                function (response) {
                    $sessionStorage.currentUser = response.data.userData;
                    if (response.data.roleName) {
                        $sessionStorage.roleName = response.data.roleName;
                    }
                    deferred.resolve(response.data);
                }
            )
            .catch(
                function (err) {
                    deferred.reject(err.data);
                }
            );

        return deferred.promise;
    }

    function updateUserName(user) {
        var data = {
            username: encodeURIComponent(user.username.trim()),
        };

        var deferred = $q.defer();

        var header = {
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        };

        $http.post(updateUserNameApi, angular.toJson(data), header)
            .then(
                function (response) {
                    $sessionStorage.currentUser.username = response.data.username;
                    deferred.resolve(response.data);
                }
            )
            .catch(
                function (err) {
                    deferred.reject(err.data);
                }
            );

        return deferred.promise;
    }

    function updatePassword(user) {

        var password = hashProvider.sha256(user.password.trim());
        var newpass = hashProvider.sha256(user.newpass.trim());

        var data = {
            password: encodeURIComponent(password),
            newpass: encodeURIComponent(newpass),

        };

        var deferred = $q.defer();

        var header = {
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        };

        $http.post(updatePasswordApi, angular.toJson(data), header)
            .then(
                function (response) {
                    $sessionStorage.currentUser.password = response.data.newpass;
                    deferred.resolve(response.data);
                }
            )
            .catch(
                function (err) {
                    deferred.reject(err.data);
                }
            );

        return deferred.promise;
    }

    return {

        updateBasic: updateBasic,

        updateUserName: updateUserName,

        updatePassword: updatePassword,
    };
}