/**
 * Created by qinshen on 2017/2/24.
 */

angular
    .module("app.ctrls")
    .controller("adminSongController", [
        "$scope",
        "$location",
        "$document",
        "$stateParams",
        "$state",
        "$sessionStorage",
        "toastr",
        "toastrProvider",
        "appEvent",
        "musicService",
        adminSongController
    ]);

function adminSongController($scope, $location, $document, $stateParams, $state, $sessionStorage, toastr, toastrProvider, appEvent, musicService) {

    if($sessionStorage.isAuthed === false || typeof($sessionStorage.isAuthed) === "undefined" || $sessionStorage.roleName !== "admin"){
        $state.go("app.home");
    }

    $scope.musics = [];

    $scope.currentMusic = {};

    $scope.musicName = "";

    $scope.newMusic = {};

    var defaultPage = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

    $scope.page = defaultPage;

    queryMusics();

    $scope.fakeAdd = function (name) {
        $scope.musics.splice(0, $scope.newMusic);
        toastr.success("[" + name + "] 添加成功!");
        $scope.closePanel(123);
    };

    $scope.fakeEdit = function (id, name) {
        $scope.closePanel(123);
        for (var i = 0; i < $scope.musics.length; i++) {
            if ($scope.musics[i].id === $scope.currentMusic.id) {
                $scope.musics[i] = $scope.currentMusic;
                toastr.success("[" + name + "(" + id + ")] 修改成功!");
                break;
            }
        }
    };

    $scope.editSinger = function (id) {
        for (var i = 0; i < $scope.musics.length; i++) {
            if ($scope.musics[i].id === id) {
                $scope.currentMusic = $scope.musics[i];
                break;
            }
        }
    };

    $scope.delSinger = function (id, name) {
        delSingerById(id, name);
    };

    $scope.getMusicByName = function () {
        $scope.page = defaultPage;

        $stateParams = {
            p: 1,
            search: $scope.singerName
        };

        $location.search('p', $stateParams.p);
        $location.search('search', $stateParams.search);

        $scope.musics.splice(0, $scope.musics.length);

        queryMusicByName();
    };

    $scope.nextPages = function () {
        if (Number($stateParams.p) === $scope.page[defaultPage.length] && $scope.musics.length == defaultPage.length) {
            for (var i = 0; i < defaultPage.length; i++) {
                $scope.page[i] += defaultPage.length / 2;
            }
        }
    };

    $scope.beforePages = function () {
        if ($scope.page[0] > defaultPage.length / 2) {
            for (var i = 0; i < defaultPage.length; i++) {
                $scope.page[i] -= defaultPage.length / 2;
            }
        }
    };

    $scope.pageSelect = function (page) {

        $stateParams = {
            p: page,
            search: $scope.musicName
        };

        $location.search('p', $stateParams.p);
        $location.search('search', $stateParams.search);

        $scope.musics.splice(0, $scope.musics.length);

        queryMusics();
    };

    $scope.editMusic = function (id) {
        for (var i = 0; i < $scope.musics.length; i++) {
            if ($scope.musics[i].id === id) {
                var music = {};
                music.id = $scope.musics[i].id;
                music.title = $scope.musics[i].title;
                music.author = $scope.musics[i].author;
                music.url = $scope.musics[i].url;
                music.pic = $scope.musics[i].pic;
                music.album = $scope.musics[i].album;
                music.lrc = $scope.musics[i].lrc;
                $scope.currentMusic = music;
                break;
            }
        }
    };

    $scope.delSinger = function (id, name) {
        delMusicById(id, name);
    };

    function delMusicById(id, name) {
        musicService
            .delMusicById(id)
            .then(
                function (data) {
                    if (typeof(data) !== "undefined" && data) {
                        queryMusics();
                        toastr.success(appEvent.delMusicOk + "[" + name + "("+ id +")]");
                    } else {
                        toastr.error(toastrProvider.textCenter(appEvent.delMusicError));
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

    function queryMusicByName() {

        var page = 1;
        if (typeof($stateParams.p) !== "undefined" && $stateParams.p !== "") {
            page = $stateParams.p;
        }

        musicService
            .findMusicByNameAdmin(decodeURIComponent($scope.musicName), page, defaultPage.length)
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

    function queryMusics() {

        var page = 1;
        if (typeof($stateParams.p) !== "undefined" && $stateParams.p !== "") {
            page = $stateParams.p;
        }

        musicService
            .findMusicByAdmin(page, defaultPage.length)
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

    var isPanelOpened = false;

    $scope.closePanel = function ($event) {
        jQuery('.song-edit-wrapper').removeClass('open');
        jQuery('.song-add-edit-wrapper').removeClass('open');
        isPanelOpened = false;
    };

    $scope.openEditSongPanel = function ($event) {
        $event.preventDefault();
        jQuery('.song-edit-wrapper').addClass('open');
        isPanelOpened = true;
    };

    $scope.openAddSongPanel = function ($event) {
        $event.preventDefault();
        jQuery('.song-add-edit-wrapper').addClass('open');
        isPanelOpened = true;
    };

    $document.on('click', function($event) {

        if (!isPanelOpened) {
            if (!jQuery($event.target).closest('.song-edit').length && !jQuery($event.target).closest('.song-edit-open').length) {
                jQuery('.song-edit-wrapper').removeClass('open');
            }
            if (!jQuery($event.target).closest('.song-add-edit').length && !jQuery($event.target).closest('.song-add-edit-open').length) {
                jQuery('.song-add-edit-wrapper').removeClass('open');
            }
        } else {
            isPanelOpened = false;
        }


    });
}