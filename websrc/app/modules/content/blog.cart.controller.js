/**
 *
 * @author windawings
 * @create.time 2017/02/26 20:34
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("blogCategoryController", [
        "$scope",
        "$stateParams",
        "toastr",
        "toastrProvider",
        "appEvent",
        "musicService",
        "billboardService",
       blogCategoryController
    ]);

function blogCategoryController($scope, $stateParams, toastr, toastrProvider, appEvent, musicService, billboardService) {

    $scope.billboard = {
        time: "",
        musics: [],
    };

    queryBillboard();

    $scope.addMusic = function (id) {

        for (var i = 0; i < $scope.billboard.musics.length; i++) {
            if ($scope.billboard.musics[i].id === id) {
                $scope.player.addPlayMusic($scope.billboard.musics[i]);
                break;
            }
        }

    };

    $scope.downMusic = function (id) {
        for (var i = 0; i < $scope.billboard.musics.length; i++) {
            if (id === $scope.billboard.musics[i].id) {
                var path = document.location.origin + document.location.pathname + $scope.billboard.musics[i].url;
                downloadMusic(path, $scope.billboard.musics[i].title + ' - ' + $scope.billboard.musics[i].author);
                break;
            }
        }
    };

    function queryBillboard() {

        var billboardName = decodeURIComponent($stateParams.name);

        $scope.billboard.musics.splice(0, $scope.billboard.musics.length);

        switch (billboardName) {
            case "新歌潮流榜": queryMusicByLatest(); break;
            case "经典热歌榜": queryMusicByPlayAmount(); break;
            case "心随乐动榜": queryMusicByDownAmount(); break;
            default: toastr.error(toastrProvider.textCenter(appEvent.noneMusic)); break;
        }
    }

    function queryMusicByLatest() {
        billboardService
            .findMusicByLatest()
            .then(
                function (data) {

                    var newDate = new Date();
                    newDate.setTime(data.time);
                    $scope.billboard.time = newDate.toLocaleDateString();

                    if (!jQuery.isEmptyObject(data.musics) && data.musics.length > 0) {
                        for (var i = 0; i < data.musics.length; i++) {
                            var music = {};
                            music.id = data.musics[i].id;
                            music.title = data.musics[i].name;
                            music.author = data.musics[i].sName;
                            music.url = data.musics[i].link;
                            music.pic = data.musics[i].aPicture;
                            music.album = data.musics[i].aName;
                            music.lrc = data.musics[i].lyrics;

                            $scope.billboard.musics.splice(i, 0, music);
                        }

                    } else {
                        toastr.warning(toastrProvider.textCenter(appEvent.noneMusic));
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

    function queryMusicByPlayAmount() {
        billboardService
            .findMusicByPlayAmount()
            .then(
                function (data) {

                    var newDate = new Date();
                    newDate.setTime(data.time);
                    $scope.billboard.time = newDate.toLocaleDateString();

                    if (!jQuery.isEmptyObject(data.musics) && data.musics.length > 0) {
                        for (var i = 0; i < data.musics.length; i++) {
                            var music = {};
                            music.id = data.musics[i].id;
                            music.title = data.musics[i].name;
                            music.author = data.musics[i].sName;
                            music.url = data.musics[i].link;
                            music.pic = data.musics[i].aPicture;
                            music.album = data.musics[i].aName;
                            music.lrc = data.musics[i].lyrics;

                            $scope.billboard.musics.splice(i, 0, music);
                        }

                    } else {
                        toastr.warning(toastrProvider.textCenter(appEvent.noneMusic));
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

    function queryMusicByDownAmount() {
        billboardService
            .findMusicByDownAmount()
            .then(
                function (data) {

                    var newDate = new Date();
                    newDate.setTime(data.time);
                    $scope.billboard.time = newDate.toLocaleDateString();

                    if (!jQuery.isEmptyObject(data.musics) && data.musics.length > 0) {
                        for (var i = 0; i < data.musics.length; i++) {
                            var music = {};
                            music.id = data.musics[i].id;
                            music.title = data.musics[i].name;
                            music.author = data.musics[i].sName;
                            music.url = data.musics[i].link;
                            music.pic = data.musics[i].aPicture;
                            music.album = data.musics[i].aName;
                            music.lrc = data.musics[i].lyrics;

                            $scope.billboard.musics.splice(i, 0, music);
                        }

                    } else {
                        toastr.warning(toastrProvider.textCenter(appEvent.noneMusic));
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