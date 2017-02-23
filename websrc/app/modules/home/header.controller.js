/**
 *
 * @author windawings
 * @create.time 2017/02/15 10:22
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("headerController", ["$scope", "$state", "authService", "authEvent", headerController]);

function headerController($scope, $state, authService, authEvent) {

    var musics = [
        {
            id: 0,
            title: 'Preparation',
            author: 'Hans Zimmer/Richard Harvey',
            url: 'music/Preparation.mp3',
            pic: 'music/Preparation.jpg'
        },
        {
            id: 1,
            title: "あっちゅ～ま青春!",
            author: "七森中☆ごらく部",
            url: "music/あっちゅ～ま青春!.mp3",
            pic: "music/あっちゅ～ま青春!.jpg",
            lrc: "music/あっちゅ～ま青春!.lrc"
        },
        {
            id: 2,
            title: "secret base~君がくれたもの~",
            author: "茅野愛衣",
            url: "music/secret base~.mp3",
            pic: "music/secret base~.jpg",
            lrc: "music/secret base~君がくれたもの~.lrc"
        },
        {
            id: 3,
            title: "回レ！雪月花",
            author: "小倉唯",
            url: "music/回レ！雪月花.mp3",
            pic: "music/回レ！雪月花.jpg",
            lrc: "music/回レ！雪月花.lrc"
        }
    ];

    // 注销
    $scope.logout = function () {
        authService
            .logout()
            .then(
                function (data) {
                    if($state.current.name === "app.user") {
                        $state.go("app.home");
                    }
                    console.log(angular.toJson(data));
                },
                function (reason) {
                    console.log(angular.toJson(reason));
                }
            )
        ;
    };

    // 点击登陆按钮清除旧认证数据
    $scope.clearMessage = function () {
        $scope.credentials.userId = "";
        $scope.credentials.password = "";
        $scope.registerMsg.name = "";
        $scope.registerMsg.email = "";
        $scope.registerMsg.message = authEvent.registerDefault;
        $scope.registerMsg.color = {"color": "#FFFFFF"};
        $scope.retrieve.email = "";
        $scope.retrieve.message = authEvent.retrieveDefault;
        $scope.retrieve.color = {"color": "#FFFFFF"};
        $scope.message.text = "";
    };
}
