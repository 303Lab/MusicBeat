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
        homeController
    ]);

function homeController($scope, $state, $timeout, toastr, toastrProvider, baseConst, appEvent, musicService) {

    $scope.freeTypes = baseConst.freeTypes;

    $scope.changeStateSinger = function () {
        $state.go("app.singer");
    };

    $scope.getMusicByCasualLabel = function ($event) {

        musicService
            .findMusic()
            .then(
                function (data) {
                    data = data.All_Musics;

                    if (!jQuery.isEmptyObject(data) && data.length > 0) {
                        var musics = [];
                        for (var i = 0; i < data.length; i++) {
                            var music = {};
                            music.id = data[i].id;
                            music.title = data[i].name;
                            music.author = data[i].author;
                            music.url = data[i].link;
                            music.pic = data[i].picture;
                            music.lrc = data[i].lyrics;

                            musics.splice(i, 0, music);
                        }

                        $scope.player.addPlayList(musics);
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
