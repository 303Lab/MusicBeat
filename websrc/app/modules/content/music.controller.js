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
        "$location",
        "$stateParams",
        "toastr",
        "toastrProvider",
        "appEvent",
        "musicService",
        musicController
    ]);

function musicController($scope, $location, $stateParams, toastr, toastrProvider, appEvent, musicService) {

    $scope.musics = [];

    var defaultPage = [1, 2, 3, 4, 5, 6];

    $scope.page = defaultPage;

    $scope.musicName = "";

    // request musics list
    if (typeof($stateParams.search) !== "undefined" && $stateParams.search !== "") {
        queryMusicByName($stateParams.search);
    } else if (typeof($stateParams.label) !== "undefined" && $stateParams.label !== "") {
        queryMusicByLabel($stateParams.label);
    } else {
        queryMusicByNone();
    }

    $scope.nextPages = function () {
        if (Number($stateParams.p) === $scope.page[5] && $scope.musics.length == 10) {
            for (var i = 0; i < 6; i++) {
                $scope.page[i] += 3;
            }
        }
    };

    $scope.beforePages = function () {
        if ($scope.page[0] > 3) {
            for (var i = 0; i < 6; i++) {
                $scope.page[i] -= 3;
            }
        }
    };

    $scope.pageSelect = function (page) {

        $stateParams = {
            search: typeof($stateParams.search) === "undefined" ? "": $stateParams.search,
            label: typeof($stateParams.label) === "undefined" ? "": $stateParams.label,
            p: page
        };

        $location.search('p', $stateParams.p);
        $location.search('search', $stateParams.search);
        $location.search('label', $stateParams.label);

        $scope.musics.splice(0, $scope.musics.length);

        if (typeof($stateParams.search) !== "undefined" && $stateParams.search !== "") {
            queryMusicByName($stateParams.search);

        } else if (typeof($stateParams.label) !== "undefined" && $stateParams.label !== "") {
            queryMusicByLabel($stateParams.label);
        } else {
            queryMusicByNone();
        }
    };

    $scope.getMusicByLabel = function ($event) {

        $scope.page = defaultPage;

        $stateParams = {
            label: $event.target.innerText,
            p: 1,
            search: "",
        };

        $location.search('p', $stateParams.p);
        $location.search('label', $stateParams.label);
        $location.search('search', $stateParams.search);

        $scope.musics.splice(0, $scope.musics.length);
        queryMusicByLabel($event.target.innerText);
    };

    $scope.addMusic = function (id) {
        for (var i = 0; i < $scope.musics.length; i++) {
            if (id === $scope.musics[i].id) {
                $scope.player.addPlayMusic($scope.musics[i]);
                break;
            }
        }

    };

    $scope.search = function () {

        $stateParams = {
            search: $scope.musicName,
            label: "",
            p: 1
        };

        $scope.pageSelect(1);
    };

    $scope.downMusic = function (id) {
        for (var i = 0; i < $scope.musics.length; i++) {
            if (id === $scope.musics[i].id) {
                var path = document.location.origin + document.location.pathname + $scope.musics[i].url;
                downloadMusic(path, $scope.musics[i].title + ' - ' + $scope.musics[i].author);
                break;
            }
        }
    };

    function queryMusicByName(name) {

        var page = 1;
        if (typeof($stateParams.p) !== "undefined" && $stateParams.p !== "") {
            page = $stateParams.p;
        }

        musicService
            .findMusicByName(decodeURIComponent(name), page)
            .then(
                function (data) {

                    data = data.MusicsByMusicName;

                    if (!jQuery.isEmptyObject(data) && data.length > 0) {
                        for (var i = 0; i < data.length; i++) {
                            var music = {};
                            music.id = data[i].id;
                            music.title = data[i].name;
                            music.author = data[i].sName;
                            music.url = data[i].link;
                            music.pic = data[i].aPicture;
                            music.album = data[i].aName;
                            music.lrc = data[i].lyrics;

                            $scope.musics.splice(i, 0, music);
                        }

                    } else {
                        toastr.warning(toastrProvider.textCenter(appEvent.noneMusic));
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
    }

    function queryMusicByLabel(label) {

        var page = 1;
        if (typeof($stateParams.p) !== "undefined" && $stateParams.p !== "") {
            page = $stateParams.p;
        }

        musicService
            .findMusicByLabelGet(decodeURIComponent(label), page)
            .then(
                function (data) {

                    data = data.labelmusic;

                    if (!jQuery.isEmptyObject(data) && data.length > 0) {
                        for (var i = 0; i < data.length; i++) {
                            var music = {};
                            music.id = data[i].id;
                            music.title = data[i].name;
                            music.author = data[i].sName;
                            music.url = data[i].link;
                            music.pic = data[i].aPicture;
                            music.album = data[i].aName;
                            music.lrc = data[i].lyrics;

                            $scope.musics.splice(i, 0, music);
                        }

                    } else {
                        toastr.warning(toastrProvider.textCenter(appEvent.noneMusic));
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
    }

    function queryMusicByNone() {

        var page = 1;
        if (typeof($stateParams.p) !== "undefined" && $stateParams.p !== "") {
            page = $stateParams.p;
        }

        musicService
            .findMusic(page)
            .then(
                function (data) {

                    data = data.All_Musics;

                    if (!jQuery.isEmptyObject(data) && data.length > 0) {
                        for (var i = 0; i < data.length; i++) {
                            var music = {};
                            music.id = data[i].id;
                            music.title = data[i].name;
                            music.author = data[i].sName;
                            music.url = data[i].link;
                            music.pic = data[i].aPicture;
                            music.album = data[i].aName;
                            music.lrc = data[i].lyrics;

                            $scope.musics.splice(i, 0, music);
                        }

                    } else {
                        toastr.warning(toastrProvider.textCenter(appEvent.noneMusic));
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
    }

    function downloadMusic(url, name) {
        jQuery('<a href="' + url + '" download="' + name + '">Download</a>')[0].click();
    }
}