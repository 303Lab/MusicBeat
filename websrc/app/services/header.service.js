/**
 *
 * @author windawings
 * @create.time 2017/02/26 21:49
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.services")
    .factory("headerService", [
        "$http",
        "$q",
        "appConst",
        headerService
    ]);

function headerService($http, $q, appConst) {
    var serviceBaseApi = appConst.apiUrl;
    var findAllLabelsApi = serviceBaseApi + "/All_Labels";

    function findAllLabels() {
        var deferred = $q.defer();

        $http.get(findAllLabelsApi)
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

        findAllLabels: findAllLabels,

    };
}