/**
 *
 * @author windawings
 * @create.time 2017/02/26 19:09
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("singerCategoryController", [
        "$scope",
        "$stateParams",
        "$location",
        "toastr",
        "toastrProvider",
        "baseConst",
        "appEvent",
        "singerService",
        "musicService",
        singerCategoryController
    ]);

function singerCategoryController($scope, $stateParams, $location, toastr, toastrProvider, baseConst, appEvent, singerService, musicService) {

    querySingersById();

    $scope.singer = {};

    $scope.addMusic = function (id) {
        musicService
            .findMusicById(id)
            .then(
                function (data) {

                    data = data.MusicByMusicId;

                    if (!jQuery.isEmptyObject(data)) {
                        var music = {};
                        music.id = data.id;
                        music.title = data.name;
                        music.author = data.sName;
                        music.url = data.link;
                        music.pic = data.aPicture;
                        music.album = data.aName;
                        music.lrc = data.lyrics;

                        $scope.player.addPlayMusic(music);

                    } else {
                        toastr.error(toastrProvider.textCenter(appEvent.noneSinger));
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

    function querySingersById() {
        singerService
            .getSingerById($stateParams.sid)
            .then(
                function (data) {

                    data = data.MusicsBySingerId;

                    if (!jQuery.isEmptyObject(data)) {
                        $scope.singer.id = data[0].id;
                        $scope.singer.name = data[0].name;
                        $scope.singer.musics = data[0].musics;
                        $scope.singer.gender = data[0].gender;
                        $scope.singer.intro = data[0].introduction;
                        $scope.singer.pic = data[0].picture;
                    } else {
                        toastr.warning(toastrProvider.textCenter(appEvent.noneSinger));
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
}