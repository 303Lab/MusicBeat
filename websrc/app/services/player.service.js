/**
 *
 * @author windawings
 * @create.time 2017/02/20 11:26
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.services")
    .factory("playerService", ["$scope", playerService]);

function playerService($scope) {

    function addPlayList(musics) {
        $scope.player.addPlayList(musics);
    }

    function addMusic(music) {
        return $scope.player.addMusic(music);
    }

    return {

        addPlayList: addPlayList,

        addMusic: addMusic,
    };
}