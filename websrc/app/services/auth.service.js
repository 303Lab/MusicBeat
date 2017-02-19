/**
 * 认证服务
 * @author windawings
 * @time.creation 2017/02/06 17:04
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.services")
    .factory("authService", [
        "$http",
        "$q",
        "appConst",
        "authEvent",
        "$sessionStorage",
        "hashProvider",
        "urlParamsProvider",
        authService
    ]);

function authService($http, $q, appConst, authEvent, $sessionStorage, hashProvider, urlParamsProvider) {

    var serviceBaseApi = appConst.apiUrl;
    var loginApi = serviceBaseApi + "/login";
    var logoutApi = serviceBaseApi + "/logout";
    var registerApi = serviceBaseApi + "/register";
    var retrieveApi = serviceBaseApi + "/retrieve";
    var changeApi = "retrieveChange";

    var defaultSession = {
        isAuthed: false, //是否已经过认证
        roleName: "", //当前用户角色
        currentUser: null, //当前用户
    };

    $sessionStorage.$default(defaultSession);

    function logOut() {
        var deferred = $q.defer();
        $http.get(logoutApi)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                }
            )
            .catch(
                function (err) {
                    deferred.reject(err.data);
                }
            );

        $sessionStorage.$reset(defaultSession);
        return deferred.promise;
    }

    function login(credentials) {

        var data = {
            username: encodeURIComponent(credentials.userId.trim()),
            password: encodeURIComponent(hashProvider.sha256(credentials.password.trim()))
        };

        var deferred = $q.defer();

        var header = {
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        };

        $http.post(loginApi, angular.toJson(data), header)
            .then(
                function (response) {
                    $sessionStorage.currentUser = response.data.userData;
                    $sessionStorage.isAuthed = response.data.status === authEvent.ok;
                    if (response.data.roleName) {
                        $sessionStorage.roleName = response.data.roleName;
                    }

                    deferred.resolve(response.data);
                }
            )
            .catch(
                function (err) {
                    $sessionStorage.currentUser = null;
                    $sessionStorage.accessToken = "";
                    $sessionStorage.isAuthed = false;
                    $sessionStorage.roleName = "";
                    deferred.reject(err.data);
                }
            );

        return deferred.promise;
    }

    function register(registerMsg) {
        if (registerMsg.username === undefined || registerMsg.username === null) {
            registerMsg.username = "";
        }

        var data = {
            username: encodeURIComponent(registerMsg.username.trim()),
            email: encodeURIComponent(registerMsg.email.trim())
        };

        var deferred = $q.defer();

        var header = {
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        };

        $http.post(registerApi, angular.toJson(data), header)
            .then(
                function (response) {
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

    function forget(retrieve) {
        var data = {
            email: encodeURIComponent(retrieve.email.trim())
        };

        var deferred = $q.defer();

        var header = {
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        };

        $http.post(retrieveApi, angular.toJson(data), header)
            .then(
                function (response) {
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

    function change(changeModel) {
        var data = {
            password: encodeURIComponent(hashProvider.sha256(changeModel.password.trim()))
        };

        var deferred = $q.defer();

        var header = {
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        };

        var requestUrl = changeApi + "?u=" + urlParamsProvider.getParam("u") + "&" + "c=" + urlParamsProvider.getParam("c");

        $http.post(requestUrl, angular.toJson(data), header)
            .then(
                function (response) {
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
        login: login,

        logout: logOut,

        register: register,

        forget: forget,

        change: change,

        session: $sessionStorage
    };
}