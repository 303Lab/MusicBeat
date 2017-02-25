/**
 * 歌手信息请求
 * @author windawings
 * @create.time 2017/02/25 0:45
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.services")
    .factory("singerService", [
        "$http",
        "$q",
        "appConst",
        singerService
    ]);

function singerService($http, $q, appConst) {

    var serviceBaseApi = appConst.apiUrl;
    var getSingersByMenuApi = serviceBaseApi + "/getSingersByMenu";

    function getSingersByMenu(type) {

        var deferred = $q.defer();

        var url = getSingersByMenuApi + "?country=" + type.country + "&sex=" + (typeof(type.sex) === 'undefined' ? "" : type.sex) + "&band=" + (typeof(type.band) === 'undefined' ? "" : type.band);

        $http.get(url)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                }
            )
            .catch(
                function (err) {
                    deferred.reject(err.data);
                }
            );

        return deferred.promise;

    }

    return {

        getSingersByMenu: getSingersByMenu,

    };
}