/**
 *
 * @author windawings
 * @create.time 2017/02/23 14:53
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.services")
    .factory("musicService", [
        "$http",
        "$q",
        "appConst",
        musicService
    ]);

function musicService($http, $q, appConst) {

    var serviceBaseApi = appConst.apiUrl;
    var findMusicApi = serviceBaseApi + "/All_Musics";
    var findMusicByLabelApi = serviceBaseApi + "/findMusicByLabel";

    function findMusic() {

        var deferred = $q.defer();

        $http.get(findMusicApi)
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


    // find music by label
    function findMusicByLabel(name) {

        var data = {
            label: encodeURIComponent(typeof(name) === "undefined" ? "": name.trim())
        };

        var deferred = $q.defer();

        var header = {
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        };

        console.log(angular.toJson(decodeURIComponent(data)));

        $http.post(findMusicByLabelApi, angular.toJson(data), header)
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

        findMusic: findMusic,

        findMusicByLabel: findMusicByLabel,

    };
}