/**
 *
 * @author windawings
 * @create.time 2017/02/13 21:39
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("homeController", [
        "$scope",
        "$state",
        "$timeout",
        "toastr",
        "toastrProvider",
        "baseConst",
        "appEvent",
        "musicService",
        "singerService",
        homeController
    ]);

function homeController($scope, $state, $timeout, toastr, toastrProvider, baseConst, appEvent, musicService, singerService) {

    $scope.freeTypes = baseConst.freeTypes;
    $scope.page = 1;
    $scope.label = "";
    $scope.search = {
        name: ""
    };
    $scope.recommend = [];

    querySingersByNone();

    $scope.changeStateSinger = function () {
        $state.go("app.singer");
    };

    $scope.getMusicByCasualLabel = function ($event) {

        var label = $event.target.innerHTML;
        if (label === $scope.label) {
            $scope.page += 1;
        } else {
            $scope.label = label;
            $scope.page = 1;
        }

        musicService
            .findMusicByLabelGet(label, $scope.page)
            .then(
                function (data) {
                    data = data.labelmusic;

                    if (!jQuery.isEmptyObject(data) && data.length > 0) {
                        var musics = [];
                        for (var i = 0; i < data.length; i++) {
                            var music = {};
                            music.id = data[i].id;
                            music.title = data[i].name;
                            music.author = data[i].sName;
                            music.url = data[i].link;
                            music.pic = data[i].aPicture;
                            music.lrc = data[i].lyrics;

                            musics.splice(i, 0, music);
                        }

                        $scope.player.addPlayList(musics);
                    } else {
                        toastr.warning(toastrProvider.textCenter(appEvent.noneMusic));
                        $scope.page = 1;
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

    $scope.searchMusicByName = function () {
        $state.go("app.music", {search: $scope.search.name});
    };

    function querySingersByNone() {
        singerService
            .getSingers(1)
            .then(
                function (data) {

                    data = data.All_Singer;

                    var length = 0;

                    if (data.length > 12) {
                        length = 12;
                    } else {
                        length = data.length;
                    }

                    if (!jQuery.isEmptyObject(data) && data.length > 0) {
                        for (var i = 0; i < length; i++) {
                            var singer = {};
                            singer.id = data[i].id;
                            singer.name = data[i].name;
                            singer.albums = data[i].albums;
                            singer.gender = data[i].gender;
                            singer.intro = data[i].introduction;
                            singer.lang = data[i].lang;
                            singer.pic = data[i].picture;
                            singer.isBand = data[i].band;

                            $scope.recommend.splice(i, 0, singer);
                        }

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

    // Highlights Slider
    $timeout(function() {
        jQuery(".highlight-slider").owlCarousel({
                                                    loop: true,
                                                    nav: true,
                                                    dots: false,
                                                    navText: ['<i class="pe-7s-angle-left"></i>', '<i class="pe-7s-angle-right"></i>'],
                                                    items: 6,
                                                    responsive: {0: {items: 2}, 480: {items: 6}, 769: {items: 6}}
                                                });
    });
}
