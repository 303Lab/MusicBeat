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
        "toastr",
        "toastrProvider",
        "appEvent",
        "singerService",
        "musicService",
        singerCategoryController
    ]);

function singerCategoryController($scope, $stateParams, toastr, toastrProvider, appEvent, singerService, musicService) {

    querySingersById();

    $scope.singer = {};

    $scope.addMusic = function (id) {

        musicService
            .findMusicById(id)
            .then(
                function (data) {

                    data = data.MusicByMusicId;

                    var music = {};

                    if (!jQuery.isEmptyObject(data)) {
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

    $scope.downMusic = function (id) {

        musicService
            .findMusicById(id)
            .then(
                function (data) {

                    data = data.MusicByMusicId;

                    if (!jQuery.isEmptyObject(data)) {
                        var path = document.location.origin + document.location.pathname + data.link;
                        toastr.success(toastrProvider.textCenter(appEvent.downMusic));
                        downloadMusic(path, data.name + " - " + data.sName);

                    } else {
                        toastr.error(toastrProvider.textCenter(appEvent.noneSinger));
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

    function downloadMusic(url, name) {
        jQuery('<a href="' + url + '" download="' + name + '">Download</a>')[0].click();
    }
}