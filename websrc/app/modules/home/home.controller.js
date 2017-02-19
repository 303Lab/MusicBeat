/**
 *
 * @author windawings
 * @create.time 2017/02/13 21:39
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("homeController", ["$scope", "$state", "$timeout", homeController]);

function homeController($scope, $state, $timeout) {
    $scope.changeStateSinger = function () {
        $state.go("app.singer");
    };

    /*==========  Highlights Slider  ==========*/
    $timeout(function() {
        jQuery(".highlight-slider").owlCarousel({
            loop: true,
            nav: true,
            dots: false,
            navText: ['<i class="pe-7s-angle-left"></i>', '<i class="pe-7s-angle-right"></i>'],
            items: 6,
            responsive: {0: {items: 2}, 480: {items: 6}, 769: {items: 6}}
        });
     });
}