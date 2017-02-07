(function() {
    "use strict";
    /**
     * APP模块
     * @author windawings
     * @time.creation 2017/02/06 17:03
     * @version 1.0.0
     * @since 1.0.0
     */

    angular
        .module("musicbeat", [
            "app.configs",
            "app.routes",
            "app.services",
            "app.filters",
            "app.ctrls"
        ])
        .run(["$rootScope", "$state", "$stateParams",
            function($rootScope, $state, $stateParams) {
                $rootScope.$state = $state;
                $rootScope.$stateParams = $stateParams;
            }
        ]);

    /**
     * 配置模块
     * @author windawings
     * @time.creation 2017/02/06 15:34
     * @version 1.0.0
     * @since 1.0.0
     */

    angular
        .module("app.configs", []);
    /**
     * 过滤模块
     * @author windawings
     * @create.time 2017/02/07 23:08
     * @version 1.0.0
     * @since 1.0.0
     */

    angular
        .module("app.filters", []);

    /**
     * 控制模块
     * @author windawings
     * @version 1.0.0
     * @since 2017/02/05 17:55
     */

    angular
        .module("app.ctrls", ["app.services", "ngDialog", "ngSanitize", "ngStorage"]);
    /**
     * 路由模块
     * @author windawings
     * @time.creation 2017/02/05 17:56
     * @version 1.0.0
     * @since 1.0.0
     */

    angular
        .module("app.routes", ["app.configs", "ui.router"]);
    /**
     * DDL模块
     * @author windawings
     * @time.creation 2017/02/06 17:03
     * @version 1.0.0
     * @since 1.0.0
     */

    angular
        .module("app.services", ["app.configs", "ngStorage"]);

    /**
     * APP常量
     * @author windawings
     * @time.creation 2017/02/06 15:31
     * @version 1.0.0
     * @since 1.0.0
     */

    angular
        .module("app.configs")
        .constant("appConst", {
            version: "1.0.0",
            htmlLoc: "tpls/",
            apiUrl: "api",
        });
    /**
     * 认证业务常量
     * @author windawings
     * @time.creation 2017/02/06 17:29
     * @version 1.0.0
     * @since 1.0.0
     */

    angular.module("app.configs")
        .constant("authEvent", {
            success: "success",
            failed: "failed",
        });
    /**
     * 欢迎信息过滤
     * @author windawings
     * @create.time 2017/02/07 23:07
     * @version 1.0.0
     * @since 1.0.0
     */

    angular
        .module("app.filters")
        .filter("welcomeFilter", welcomeFilter)
        .filter("ngDialogFilter", ngDialogFilter);

    function welcomeFilter() {
        return function(data) {
            if (data === null || data === undefined) return "";
            return data.username;
        };
    }

    function ngDialogFilter() {
        return function(data) {
            if (data === null || data === undefined) return "";
            return angular.toJson(data, true);
        };
    }
    /**
     * 基础路由
     * @author windawings
     * @time.creation 2017/02/03 19:48
     * @version 1.0.0
     * @since 1.0.0
     */

    angular
        .module("app.routes")
        .config(["$stateProvider", "$urlRouterProvider", "appConst", baseRouter]);

    function baseRouter($stateProvider, $urlRouterProvider, appConst) {

        $urlRouterProvider.otherwise("/");

        $stateProvider
            .state("app", {
                url: "/",
                views: {
                    "": {
                        templateUrl: fnBasePath("home.html")
                    },
                    "navHome@": {
                        controller: "navHomeController",
                        templateUrl: fnBasePath("navHome.html")
                    }
                }
            })
            .state("app.login", {
                url: "login",
                views: {
                    "viewContent@": {
                        controller: "loginController",
                        templateUrl: fnBasePath("login.html")
                    }
                }
            })
            .state("app.user", {
                url: "user",
                views: {
                    "viewContent@": {
                        templateUrl: fnBasePath("user.html")
                    }
                }
            })
            .state("app.security", {
                url: "changePassword",
                views: {
                    "viewContent@": {
                        templateUrl: fnBasePath("userChgPwd.html")
                    }
                }
            });

        function fnBasePath(uri) {
            return appConst.htmlLoc + uri + "?ver=" + appConst.version;
        }
    }
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
            accessToken: "" //
        };

        $sessionStorage.$default(defaultSession);

        function fnLogOut() {
            $sessionStorage.$reset(defaultSession);
        }

        return {
            login: function(credentials) {

                var data = "username=" + encodeURIComponent(credentials.userId.trim()) + "&password=" + encodeURIComponent(credentials.password.trim());

                var deferred = $q.defer();

                var postHeader = {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                };

                $http.post(serviceApi, data, postHeader)
                    .then(
                        function(response) {
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
                        function(err, status) {
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
    /**
     * 主页控制器
     * @author windawings
     * @time.creation 2017/02/06 19:17
     * @version 1.0.0
     * @since 1.0.0
     */

    angular
        .module("app.ctrls")
        .controller("homeController", ["$scope", "authService", "$localStorage", homeController]);

    function homeController($scope, authService, $localStorage) {
        $scope.session = authService.session;
        $scope.$storage = $localStorage;
    }
    /*!登陆控制器*/
    /**
     * @author windawings
     * @time.creation 2017/02/02 19:28
     * @version 1.0.0
     * @since 1.0.0
     */

    angular
        .module("app.ctrls")
        .controller("loginController", ["$scope", "authService", "ngDialog", loginController]);

    function loginController($scope, authService, ngDialog) {

        $scope.getFormData = function() {
            console.log($scope.credentials);
        };

        $scope.setFormData = function() {
            $scope.credentials = {
                userId: "13088888888",
                password: "233",
                autoLogin: false
            };
        };

        $scope.restForm = function() {
            $scope.credentials = {
                userId: "windawings@foxmail.com",
                password: "123",
                autoLogin: true
            };
        };

        var emptyCredentials = {
            userId: "",
            password: "",
            autoLogin: false
        };
        $scope.credentials = angular.copy(emptyCredentials);
        $scope.message = "";

        $scope.login = function() {
            if (!$scope.credentials.userId.trim() || !$scope.credentials.password.trim()) return;
            authService
                .login($scope.credentials)
                .then(
                    function(data) { // 返回了response.data信息体
                        $scope.credentials = angular.copy(emptyCredentials);
                        ngDialog.open({
                            template: "firstDialogId", //use template id defined in HTML
                            className: "ngdialog-theme-default",
                            scope: $scope
                        });
                    },
                    function(reason) {
                        ngDialog.open({
                            template: reason.message, //use template id defined in HTML
                            className: "ngdialog-theme-default",
                            plain: true
                        });
                    }
                );
        };

        $scope.closeLoginPanel = function() {
            angular.copy(emptyCredentials, $scope.credentials);
            authService.session.isShowPanel = false;
        };
    }
    /**
     * 顶部导航条
     * @author windawings
     * @time.creation 2017/02/05 17:48
     * @version 1.0.0
     * @since 1.0.0
     */

    angular
        .module("app.ctrls")
        .controller("navHomeController", ["$scope", navHomeController]);

    function navHomeController($scope) {
        $scope.name = "navHomeController";
        console.log($scope.name);
    }
})();