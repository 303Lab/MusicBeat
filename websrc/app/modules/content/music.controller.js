/**
 *
 * @author windawings
 * @create.time 2017/02/25 16:17
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("musicController", [
        "$scope",
        "$stateParams",
        "toastr",
        "toastrProvider",
        "appEvent",
        "musicService",
        musicController
    ]);

function musicController($scope, $stateParams, toastr, toastrProvider, appEvent, musicService) {

    // request musics list
    musicService
        .findMusicByLabel(decodeURIComponent($stateParams.name))
        .then(
            function (data) {
                if (!jQuery.isEmptyObject(data) && data.length > 0) {
                    $scope.musics.splice(0, $scope.musics.length - 1);
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
            function (reason) {
                if (typeof(reason.message) !== "undefined" && reason.message !== null) {
                    toastr.error(toastrProvider.textCenter(reason.message));
                } else {
                    toastr.error(toastrProvider.textCenter(appEvent.error));
                }

                console.log(reason);
            }
        );

    $scope.getMusicByLabel = function ($event) {

        musicService
            .findMusicByLabel($event.target.innerHTML)
            .then(
                function (data) {
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

}