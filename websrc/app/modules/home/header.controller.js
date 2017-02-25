/**
 *
 * @author windawings
 * @create.time 2017/02/15 10:22
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("headerController", [
        "$scope",
        "$state",
        "authService",
        "appEvent",
        "baseConst",
        headerController
    ]);

function headerController($scope, $state, authService, appEvent, baseConst) {

    // singer category
    $scope.menu = baseConst.menu;

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
        $scope.registerMsg.message = appEvent.registerDefault;
        $scope.registerMsg.color = {"color": "#FFFFFF"};
        $scope.retrieve.email = "";
        $scope.retrieve.message = appEvent.retrieveDefault;
        $scope.retrieve.color = {"color": "#FFFFFF"};
        $scope.message.text = "";
    };

    $scope.getMusicByLabel = function ($event) {

        musicService
            .findMusicByLabel($event.target.innerHTML)
            .then(
                function (data)
                {
                    if (!jQuery.isEmptyObject(data) && data.length > 0) {
                        $scope.current.musics.splice(0, $scope.musics.length - 1);
                        for (var i = 0; i < data.length; i++) {
                            var music = {};
                            music.id = data[i].id;
                            music.title = data[i].name;
                            music.author = data[i].author;
                            music.url = data[i].link;
                            music.pic = data[i].picture;
                            music.album = data[i].album;
                            music.lrc = data[i].lyrics;

                            $scope.current.musics.splice(i, 0, music);
                        }
                    } else {
                        toastr.error(toastrProvider.textCenter(appEvent.noneMusic));
                    }
                },

                // 错误处理
                function (reason)
                {
                    if (typeof(reason.message) !== "undefined" && reason.message !== null) {
                        toastr.error(toastrProvider.textCenter(reason.message));
                    } else {
                        toastr.error(toastrProvider.textCenter(appEvent.error));
                    }

                    console.log(reason);
                }
            );
    };
}
