/**
 * 主页控制器
 * @author windawings
 * @time.creation 2017/02/06 19:17
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("indexController", ["$scope", "$state", "authService", "authEvent", indexController]);

function indexController($scope, $state, authService, authEvent) {
    $state.go("app.home");
    $scope.session = authService.session;
    $scope.credentials = {userId: "", password: ""};
    $scope.registerMsg = {name: "", email: "", message: authEvent.registerDefault, color: {"color": "#FFFFFF"}};
    $scope.retrieve = {email: "", message: authEvent.retrieveDefault, color: {"color": "#FFFFFF"}};
    $scope.message = {text: ""};

    $scope.player = new APlayer({
        element: document.getElementById('player'),
        narrow: false,
        autoplay: false,
        showlrc: 3,
        mutex: true,
        theme: '#ad7a86',
        mode: 'random',
        listmaxheight: '80px',
        music: [
            {
                title: 'あっちゅ～ま青春!',
                author: '七森中☆ごらく部',
                url: 'http://devtest.qiniudn.com/あっちゅ～ま青春!.mp3',
                pic: 'http://devtest.qiniudn.com/あっちゅ～ま青春!.jpg',
                lrc: 'あっちゅ～ま青春!.lrc'
            },
            {
                title: 'secret base~君がくれたもの~',
                author: '茅野愛衣',
                url: 'http://devtest.qiniudn.com/secret base~.mp3',
                pic: 'http://devtest.qiniudn.com/secret base~.jpg',
                lrc: 'secret base~君がくれたもの~.lrc'
            },
            {
                title: '回レ！雪月花',
                author: '小倉唯',
                url: 'http://devtest.qiniudn.com/回レ！雪月花.mp3',
                pic: 'http://devtest.qiniudn.com/回レ！雪月花.jpg',
                lrc: '回レ！雪月花.lrc'
            }
        ]
    });
}