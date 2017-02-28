/**
 *
 * @author windawings
 * @create.time 2017/02/26 20:40
 * @version 1.0.0
 * @since 1.0.0
 */


angular
    .module("app.services")
    .factory("billboardService", [
        "$http",
        "$q",
        "appConst",
        billboardService
    ]);

function billboardService($http, $q, appConst) {

    var serviceBaseApi = appConst.apiUrl;
    var findMusicByLatestApi = serviceBaseApi + "/latest_music_list";
    var findMusicByPlayAmountApi = serviceBaseApi + "/pAmount_music_list";
    var findMusicByDownAmountApi =serviceBaseApi + "/dAmount_music_list";

    function findMusicByLatest() {
        var deferred = $q.defer();

        $http.get(findMusicByLatestApi)
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

    function findMusicByPlayAmount() {
        var deferred = $q.defer();

        $http.get(findMusicByPlayAmountApi)
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

    function findMusicByDownAmount() {
        var deferred = $q.defer();

        $http.get(findMusicByDownAmountApi)
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

        findMusicByLatest: findMusicByLatest,

        findMusicByPlayAmount: findMusicByPlayAmount,

        findMusicByDownAmount: findMusicByDownAmount,

    };
}