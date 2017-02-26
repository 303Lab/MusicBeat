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
    var getSingersApi = serviceBaseApi + "/All_Singers";
    var getSingersByTypeApi = serviceBaseApi + "/Kinds_of_Singers";
    var getSingerByIdApi = serviceBaseApi + "/Musics_of_Singer";
    var getSingersByNameApi = serviceBaseApi + "/Singers_of_Sname";

    function getSingersByType(type, page) {

        var deferred = $q.defer();

        var url = getSingersByTypeApi + "?country=" + type.country + "&sex=" + (typeof(type.sex) === 'undefined' ? "" : type.sex) + "&isBand=" + (typeof(type.band) === 'undefined' ? "" : type.band) + "&pageNum=" + (typeof(page) === 'undefined' ? "" : page);

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

    function getSingers(page) {
        var deferred = $q.defer();

        var url = getSingersApi + "?pageNum=" + (typeof(page) === 'undefined' ? "" : page);

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

    function getSingerById(id) {
        var deferred = $q.defer();

        var url = getSingerByIdApi + "?singer_id=" + (typeof(id) === 'undefined' ? "" : id);

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

    function getSingersByName(name, page) {
        var deferred = $q.defer();

        var url = getSingersByNameApi + "?singer_name=" + (typeof(name) === 'undefined' ? "" : name.trim()) + "&pageNum=" + (typeof(page) === 'undefined' ? "" : page);

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

        getSingers: getSingers,

        getSingersByType: getSingersByType,

        getSingerById: getSingerById,

        getSingersByName: getSingersByName,
    };
}