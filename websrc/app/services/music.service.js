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
    var findMusicByLabelGetApi = serviceBaseApi + "/label_music_list";
    var findMusicByNameApi = serviceBaseApi + "/Musics_of_Mname";
    var findMusicByIdApi = serviceBaseApi + "/Music_of_MusicId";
    var delMusicByIdApi = serviceBaseApi + "/deleteMusic";

    function findMusic(page) {

        var deferred = $q.defer();

        var url = findMusicApi + '?pageNum=' + (typeof(page) === "undefined" ? 1: page);

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

    function findMusicByAdmin(page, pageSize) {

        var deferred = $q.defer();

        var url = findMusicApi + '?pageNum=' + (typeof(page) === "undefined" ? 1: page) + '&pageSize=' + (typeof(pageSize) === "undefined" ? null: pageSize);

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

    // find music by label by page get method
    function findMusicByLabelGet(name, page) {

        var deferred = $q.defer();

        var url = findMusicByLabelGetApi + '?label_name=' + (typeof(name) === "undefined" ? "": name.trim()) + '&pageNum=' + (typeof(page) === "undefined" ? 1: page);

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

    function findMusicByName(name, page) {
        var deferred = $q.defer();

        var url = findMusicByNameApi + '?music_name=' + (typeof(name) === "undefined" ? "": name.trim()) + "&pageNum=" + (typeof(page) === "undefined" ? 1: page);

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

    function findMusicByNameAdmin(name, page, pageSize) {
        var deferred = $q.defer();

        var url = findMusicByNameApi + '?music_name=' + (typeof(name) === "undefined" ? "": name.trim()) + "&pageNum=" + (typeof(page) === "undefined" ? 1: page) + "&pageSize=" + (typeof(pageSize) === "undefined" ? null: pageSize);

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

    function findMusicById(id) {
        var deferred = $q.defer();

        var url = findMusicByIdApi + '?music_id=' + (typeof(id) === "undefined" ? "": id);

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

    function delMusicById(id) {
        var data = {
            musicid: encodeURIComponent(id),
        };

        var deferred = $q.defer();

        var header = {
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        };

        $http.post(delMusicByIdApi, angular.toJson(data), header)
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

        findMusicByAdmin: findMusicByAdmin,

        findMusicByLabelGet: findMusicByLabelGet,

        findMusicByName: findMusicByName,

        findMusicById: findMusicById,

        delMusicById: delMusicById,

        findMusicByNameAdmin: findMusicByNameAdmin,
    };
}