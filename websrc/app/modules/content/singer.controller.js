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
        "toastr",
        "toastrProvider",
        "baseConst",
        "appEvent",
        "singerService",
        singerController
    ]);

function singerController($scope, $stateParams, toastr, toastrProvider, baseConst, appEvent, singerService) {

    $scope.menu = baseConst.menu;

    // get singers
    $scope.singers = [
        {
            id: 1,
            name: "薛之谦"
        },
        {
            id: 2,
            name: "周杰伦"
        },
        {
            id: 3,
            name: "陈奕迅"
        },
        {
            id: 4,
            name: "林俊杰"
        },
        {
            id: 5,
            name: "张学友"
        },
        {
            id: 6,
            name: "张杰"
        }
    ];

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
            band: 1,
        },
    };

    singerService
        .getSingersByMenu(reflectorSingerMenu[$stateParams.type])
        .then(
            function (data) {
                if (!jQuery.isEmptyObject(data) && data.length > 0) {
                    for (var i = 0; i < data.length; i++) {
                        var singer = {};
                        singer.id = data[i].id;
                        singer.name = data[i].name;

                        $scope.singers.splice(i, 0, singer);
                    }

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
}