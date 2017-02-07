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
    var serviceApi = serviceBaseApi + "/login";

    var defaultSession = {
        isShowPanel: false, //是否展开loginPanel
        isAuthed: false, //是否已经过认证
        roleName: "", //当前用户角色
        currentUser: null, //当前用户
        accessToken: ""     //
    };

    $sessionStorage.$default(defaultSession);

    function fnLogOut() {
        $sessionStorage.$reset(defaultSession);
    }

    return {
        login: function(credentials) {

            var data = "username=" + encodeURIComponent(credentials.userId.trim()) + "&password=" + encodeURIComponent(credentials.password.trim());

            var deferred = $q.defer();

            var postHeader = { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } };

            $http.post(serviceApi, data, postHeader)
                .then(
                    function (response) {
                        if (credentials.autoLogin) {
                            $localStorage.accessToken = response.data.accessToken;
                        } else {
                            $localStorage.$reset();
                        }
                        $sessionStorage.currentUser = response.data.userData;
                        $sessionStorage.accessToken = response.data.accessToken;
                        $sessionStorage.isAuthed = (response.data.status === authEvent.success);
                        if (response.data.roleName) {
                            $sessionStorage.roleName = response.data.roleName;
                        }

                        deferred.resolve(response.data);
                    }
                )
                .catch(
                    function (err, status) {
                        console.log(err + "\n" + status);
                        deferred.reject(err);
                    }
                );

            return deferred.promise;
        },

        logout: fnLogOut,

        session: $sessionStorage
    };
}