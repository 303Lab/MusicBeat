/**
 * 主页控制器
 * @author windawings
 * @time.creation 2017/02/06 19:17
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("indexController", ["$scope", "$state", "$document", "authService", "authEvent", indexController]);

function indexController($scope, $state, $document, authService, authEvent) {
    $state.go("app.home");
    $scope.session = authService.session;
    $scope.credentials = {userId: "", password: ""};
    $scope.registerMsg = {name: "", email: "", message: authEvent.registerDefault, color: {"color": "#FFFFFF"}};
    $scope.retrieve = {email: "", message: authEvent.retrieveDefault, color: {"color": "#FFFFFF"}};
    $scope.message = {text: ""};

    $scope.playerOptions = {
        element: $document[0].getElementsByClassName("aplayer")[0],
        narrow: false,
        autoplay: false,
        showlrc: 3,
        mutex: true,
        theme: "#b7daff",
        mode: "circulation",
        listmaxheight: "379.5px",
        music: [
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
        ]
    };

    $scope.player = new APlayer($scope.playerOptions);
}
