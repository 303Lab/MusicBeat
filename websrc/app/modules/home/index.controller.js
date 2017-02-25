/**
 * 主页控制器
 * @author windawings
 * @time.creation 2017/02/06 19:17
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("indexController", [
        "$scope",
        "$state",
        "$document",
        "authService",
        "appEvent",
        indexController
    ]);

function indexController($scope, $state, $document, authService, appEvent) {
    $state.go("app.home");
    $scope.session = authService.session;
    $scope.credentials = {userId: "", password: ""};
    $scope.registerMsg = {name: "", email: "", message: appEvent.registerDefault, color: {"color": "#FFFFFF"}};
    $scope.retrieve = {email: "", message: appEvent.retrieveDefault, color: {"color": "#FFFFFF"}};
    $scope.message = {text: ""};

    // APlayer
    $scope.musics = {
        element: $document[0].getElementsByClassName("aplayer")[0],
        narrow: false,
        autoplay: false,
        showlrc: 3,
        mutex: true,
        theme: "#b7daff",
        mode: "circulation",
        listmaxheight: "379.5px",
    };
    $scope.player = new APlayer($scope.musics);

    $scope.getCurrentSingerCartImg = function (id) {
        return "background-image: url('images/category" + id + ".jpg');";
    };

    // 当前歌手推荐
    $scope.current = {
        singer :{
            recommend: [
                {
                    id: 1,
                    img: $scope.getCurrentSingerCartImg("02"),
                    number: "36",
                    title: "周杰伦"
                },
                {
                    id: 2,
                    img: $scope.getCurrentSingerCartImg("03"),
                    number: "26",
                    title: "李宇春"
                }
            ],
            category: {
                id: 1,
                name: "薛之谦",
                pic: "images/xuezhiqian.jpg",
                intro: "薛之谦，1983年7月17日出生于上海，华语流行乐男歌手、音乐制作人、演员、商人，毕业于格里昂酒店管理学院[1]  。2005年，参加选秀节目《我型我秀》。2006年，发行首张同名专辑《薛之谦》正式出道，并凭借歌曲《认真的雪》获得一定的关注度[2-3]  。 2007年，推出第二张个人原创专辑《你过得好吗》[4]  。2008年，发行第三张音乐专辑《深深爱过你》；同年，举行了个人首场演唱会“谦年传说”[5]  。2012年，发行专辑《几个薛之谦》；同年，薛之谦第一家连锁火锅店“上上谦”开业，随后，薛之谦又自创了UUJULY品牌女装、UUJULYKIDS品牌童装、Dangerous People品牌男装[6]  。2013年，发行专辑《意外》[7]  。",
                musics: [
                    {
                        id: 1,
                        name: "演员",
                        albumId: 1,
                        album: "绅士",
                    },
                    {
                        id: 2,
                        name: "方圆几里",
                        albumId: 1,
                        album: "意外",
                    },
                    {
                        id: 3,
                        name: "刚刚好",
                        albumId: 1,
                        album: "初学者",
                    },
                    {
                        id: 4,
                        name: "演员",
                        albumId: 1,
                        album: "绅士",
                    },
                ]
            },
        },
        music: [],

    };

    // 判断是否为数组
    $scope.isArray = function (object){
        return object && typeof object === 'object' && Array == object.constructor;
    };
}
