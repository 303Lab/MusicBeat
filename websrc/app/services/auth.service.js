/**
 * 认证服务
 * @author windawings
 * @time.creation 2017/02/06 17:04
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.services")
    .factory("authService", ["$http", "$q", "appConst", "authEvent", "$localStorage", "$sessionStorage", authService]);

function authService($http, $q, appConst, authEvent, $localStorage, $sessionStorage) {

    var serviceBaseApi = appConst.apiUrl;
    var loginApi = serviceBaseApi + "/login";
    var logoutApi = serviceBaseApi + "/logout";

    var defaultSession = {
        isAuthed: false, //是否已经过认证
        roleName: "", //当前用户角色
        currentUser: null, //当前用户
    };

    $sessionStorage.$default(defaultSession);

    function fnLogOut() {
        var deferred = $q.defer();
        $http.get(logoutApi)
            .then(
                function (response) {
                    var logString = {
                        status: response.data.status,
                        message: response.data.message
                    };

                    console.log(angular.toJson(logString));
                    deferred.resolve(response.data);
                }
            )
            .catch(
                function (err) {
                    deferred.reject(err.data);
                }
            );
        $sessionStorage.$reset(defaultSession);
    }

    function fnLogin(credentials) {
        var data = {
            username: encodeURIComponent(credentials.userId.trim()),
            password: encodeURIComponent(credentials.password.trim())
        };

        var deferred = $q.defer();

        var postHeader = {
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        };

        $http.post(loginApi, angular.toJson(data), postHeader)
            .then(
                function (response) {
                    $sessionStorage.currentUser = response.data.userData;
                    $sessionStorage.isAuthed = response.data.status === authEvent.success;
                    if (response.data.roleName) {
                        $sessionStorage.roleName = response.data.roleName;
                    }

                    $localStorage.playlist = [
                        {mid:1, name:"千里之外"},
                        {mid:2, name:"干物女喂喂"}
                    ];

                    deferred.resolve(response.data);
                }
            )
            .catch(
                function (err) {
                    $localStorage.$reset();
                    $sessionStorage.currentUser = null;
                    $sessionStorage.accessToken = "";
                    $sessionStorage.isAuthed = false;
                    $sessionStorage.roleName = "";
                    deferred.reject(err.data);
                }
            );

        return deferred.promise;
    }

    return {
        login: fnLogin,

        logout: fnLogOut,

        session: $sessionStorage
    };
}