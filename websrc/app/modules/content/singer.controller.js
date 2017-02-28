/**
 *
 * @author windawings
 * @create.time 2017/02/24 15:25
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("singerController", [
        "$scope",
        "$stateParams",
        "$location",
        "toastr",
        "toastrProvider",
        "baseConst",
        "appEvent",
        "singerService",
        singerController
    ]);

function singerController($scope, $stateParams, $location, toastr, toastrProvider, baseConst, appEvent, singerService) {

    $scope.menu = baseConst.menu;

    var defaultPage = [1, 2, 3, 4, 5, 6];

    $scope.page = defaultPage;

    $scope.singerName = "";

    $scope.singers = [];

    var reflectorSingerMenu = {
        "华语男歌手": {
            country: "Chinese",
            sex: 1,
            band: 0,
        },
        "华语女歌手": {
            country: "Chinese",
            sex: 0,
            band: 0,
        },
        "华语乐队组合": {
            country: "Chinese",
            band: 1,
        },
        "日本男歌手": {
            country: "Japanese",
            sex: 1,
            band: 0,
        },
        "日本女歌手": {
            country: "Japanese",
            sex: 0,
            band: 0,
        },
        "日本乐队组合": {
            country: "Japanese",
            band: 1,
        },
        "韩国男歌手": {
            country: "Korean",
            sex: 1,
            band: 0,
        },
        "韩国女歌手": {
            country: "Korean",
            sex: 0,
            band: 0,
        },
        "韩国乐队组合": {
            country: "Japanese",
            band: 1,
        },
        "欧美男歌手": {
            country: "English",
            sex: 1,
            band: 0,
        },
        "欧美女歌手": {
            country: "English",
            sex: 0,
            band: 0,
        },
        "欧美乐队组合": {
            country: "English",
            band: 1,
        },
        "其他男歌手": {
            country: "Others",
            sex: 1,
            band: 0,
        },
        "其他女歌手": {
            country: "Others",
            sex: 0,
            band: 0,
        },
        "其他乐队组合": {
            country: "Others",
            band: 0,
        },
    };

    // get singers
    if (typeof($stateParams.type) !== "undefined" && $stateParams.type !== "") {
        querySingersByType($stateParams.type);
    } else if (typeof($stateParams.search) !== "undefined" && $stateParams.search !== "") {
        querySingersByName();
    } else{
        querySingersByNone();
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
            type: typeof($stateParams.type) === "undefined" ? "": $stateParams.type,
            search: typeof($stateParams.search) === "undefined" ? "": $stateParams.search,
            p: page
        };

        $location.search('p', $stateParams.p);
        $location.search('type', $stateParams.type);
        $location.search('search', $stateParams.search);

        $scope.singers.splice(0, $scope.singers.length);

        if (typeof($stateParams.type) !== "undefined" && $stateParams.type !== "") {
            querySingersByType($stateParams.type);
        } else if (typeof($stateParams.search) !== "undefined" && $stateParams.search !== "") {
            querySingersByName();
        } else{
            querySingersByNone();
        }
    };

    $scope.getSingerByType = function ($event) {

        $scope.page = defaultPage;

        $stateParams = {
            type: $event.target.innerText,
            p: 1,
            search: ""
        };

        $location.search('p', $stateParams.p);
        $location.search('type', $stateParams.type);
        $location.search('search', $stateParams.search);

        $scope.singers.splice(0, $scope.singers.length);

        querySingersByType($event.target.innerText);
    };

    $scope.getSingerByName = function () {
        $scope.page = defaultPage;

        $stateParams = {
            type: "",
            p: 1,
            search: $scope.singerName
        };

        $location.search('p', $stateParams.p);
        $location.search('type', $stateParams.type);
        $location.search('search', $stateParams.search);

        $scope.singers.splice(0, $scope.singers.length);

        querySingersByName();
    };

    function querySingersByType(type) {

        var page = 1;
        if (typeof($stateParams.p) !== "undefined" && $stateParams.p !== "") {
            page = $stateParams.p;
        }

        singerService
            .getSingersByType(reflectorSingerMenu[type], page)
            .then(
                function (data) {

                    data = data.KindsOfSingers;

                    if (!jQuery.isEmptyObject(data) && data.length > 0) {
                        for (var i = 0; i < data.length; i++) {
                            var singer = {};
                            singer.id = data[i].id;
                            singer.name = data[i].name;
                            singer.albums = data[i].albums;
                            singer.gender = data[i].gender;
                            singer.intro = data[i].introduction;
                            singer.lang = data[i].lang;
                            singer.pic = data[i].picture;
                            singer.isBand = data[i].band;

                            $scope.singers.splice(i, 0, singer);
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

    function querySingersByNone() {
        var page = 1;
        if (typeof($stateParams.p) !== "undefined" && $stateParams.p !== "") {
            page = $stateParams.p;
        }

        singerService
            .getSingers(page)
            .then(
                function (data) {

                    data = data.All_Singer;

                    if (!jQuery.isEmptyObject(data) && data.length > 0) {
                        for (var i = 0; i < data.length; i++) {
                            var singer = {};
                            singer.id = data[i].id;
                            singer.name = data[i].name;
                            singer.albums = data[i].albums;
                            singer.gender = data[i].gender;
                            singer.intro = data[i].introduction;
                            singer.lang = data[i].lang;
                            singer.pic = data[i].picture;
                            singer.isBand = data[i].band;

                            $scope.singers.splice(i, 0, singer);
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

    function querySingersByName() {
        var page = 1;
        if (typeof($stateParams.p) !== "undefined" && $stateParams.p !== "") {
            page = $stateParams.p;
        }

        singerService
            .getSingersByName($scope.singerName, page)
            .then(
                function (data) {

                    data = data.SingersBySingerName;

                    if (!jQuery.isEmptyObject(data) && data.length > 0) {
                        for (var i = 0; i < data.length; i++) {
                            var singer = {};
                            singer.id = data[i].id;
                            singer.name = data[i].name;
                            singer.albums = data[i].albums;
                            singer.gender = data[i].gender;
                            singer.intro = data[i].introduction;
                            singer.lang = data[i].lang;
                            singer.pic = data[i].picture;
                            singer.isBand = data[i].band;

                            $scope.singers.splice(i, 0, singer);
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
}