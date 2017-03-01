/**
 * Created by qinshen on 2017/2/24.
 */

angular
    .module("app.ctrls")
    .controller("adminSingerController", [
        "$scope",
        "$document",
        "$stateParams",
        "$location",
        "$state",
        "$sessionStorage",
        "toastr",
        "toastrProvider",
        "appEvent",
        "singerService",
        adminSingerController
    ]);

function adminSingerController($scope, $document, $stateParams, $location, $state, $sessionStorage, toastr, toastrProvider, appEvent, singerService) {

    if($sessionStorage.isAuthed === false || typeof($sessionStorage.isAuthed) === "undefined" || $sessionStorage.roleName !== "admin"){
        $state.go("app.home");
    }

    $scope.singers = [];

    $scope.currentSinger = {};

    $scope.newSinger = {};

    $scope.singerName = "";

    var defaultPage = [1, 2, 3, 4, 5, 6, 7, 8, 9];

    $scope.page = defaultPage;

    querySingers();

    $scope.fakeAdd = function (name) {
        $scope.singers.splice(0, $scope.newSinger);
        toastr.success("[" + name + "] 添加成功!");
        $scope.closePanel(123);
    };

    $scope.fakeEdit = function (id, name) {
        $scope.closePanel(123);
        for (var i = 0; i < $scope.singers.length; i++) {
            if ($scope.singers[i].id === $scope.currentSinger.id) {
                $scope.singers[i] = $scope.currentSinger;
                toastr.success("[" + name + "(" + id + ")] 修改成功!");
                break;
            }
        }
    };

    $scope.editSinger = function (id) {
        for (var i = 0; i < $scope.singers.length; i++) {
            if ($scope.singers[i].id === id) {
                var singer = {};
                singer.id = $scope.singers[i].id;
                singer.name = $scope.singers[i].name;
                singer.albums = $scope.singers[i].albums;
                singer.gender = $scope.singers[i].gender;
                singer.intro = $scope.singers[i].intro;
                singer.lang = $scope.singers[i].lang;
                singer.pic = $scope.singers[i].pic;
                singer.isBand = $scope.singers[i].isBand;
                $scope.currentSinger = singer;
                break;
            }
        }
    };

    $scope.delSinger = function (id, name) {
        delSingerById(id, name);
    };

    $scope.getSingerByName = function () {
        $scope.page = defaultPage;

        $stateParams = {
            p: 1,
            search: $scope.singerName
        };

        $location.search('p', $stateParams.p);
        $location.search('search', $stateParams.search);

        $scope.singers.splice(0, $scope.singers.length);

        querySingersByName();
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
            search: $scope.singerName
        };

        $location.search('p', $stateParams.p);
        $location.search('search', $stateParams.search);

        $scope.singers.splice(0, $scope.singers.length);

        querySingers();
    };

    function delSingerById(id, name) {
        singerService
            .delSingerById(id)
            .then(
                function (data) {
                    if (typeof(data) !== "undefined" && data) {
                        querySingers();
                        toastr.success(appEvent.delSingerOk + "[" + name + "("+ id +")]");
                    } else {
                        toastr.error(toastrProvider.textCenter(appEvent.delSingerError));
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

    function querySingers() {
        var page = 1;
        if (typeof($stateParams.p) !== "undefined" && $stateParams.p !== "") {
            page = $stateParams.p;
        }

        singerService
            .getSingersByAdmin(page, defaultPage.length)
            .then(
                function (data) {

                    data = data.All_Singer;

                    if (!jQuery.isEmptyObject(data) && data.length > 0) {

                        $scope.singers.splice(0, $scope.singers.length);

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
            .getSingersByNameAdmin($scope.singerName, page, defaultPage.length)
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

    var isPanelOpened = false;

    $scope.closePanel = function ($event) {
        jQuery('.singer-edit-wrapper').removeClass('open');
        jQuery('.singer-add-edit-wrapper').removeClass('open');
        isPanelOpened = false;
    };

    $scope.openEditSingerPanel = function ($event) {
        $event.preventDefault();
        jQuery('.singer-edit-wrapper').addClass('open');
        isPanelOpened = true;
    };

    $scope.openAddSingerPanel = function ($event) {
        $event.preventDefault();
        jQuery('.singer-add-edit-wrapper').addClass('open');
        isPanelOpened = true;
    };

    $document.on('click', function($event) {
        if (!isPanelOpened) {
            if (!jQuery($event.target).closest('.singer-edit').length && !jQuery($event.target).closest('.singer-edit-open').length) {
                jQuery('.singer-edit-wrapper').removeClass('open');
            }
            if (!jQuery($event.target).closest('.singer-add-edit').length && !jQuery($event.target).closest('.singer-add-edit-open').length) {
                jQuery('.singer-add-edit-wrapper').removeClass('open');
            }
        } else {
            isPanelOpened = false;
        }

    });
}