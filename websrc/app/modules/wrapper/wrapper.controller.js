/**
 *
 * @author windawings
 * @create.time 2017/02/15 22:49
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("wrapperController", ["$scope", wrapperController]);

function wrapperController($scope) {

    // login signup forget Panel
    $scope.openLoginPanel = function () {
        jQuery(".login-wrapper").addClass("open");
        jQuery(".signup-wrapper").removeClass("open");
    };

    $scope.openSignupPanel = function () {
        jQuery(".signup-wrapper").addClass("open");
        jQuery(".login-wrapper").removeClass("open");
    };

    $scope.openForgetPanel = function () {
        jQuery(".forget-wrapper").addClass("open");
        jQuery(".login-wrapper").removeClass("open");
    };

    jQuery(document).on("click", function (event) {
        if (!jQuery(event.target).closest(".login").length && !jQuery(event.target).closest(".login-open").length) {
            jQuery(".login-wrapper").removeClass("open");
        }
        if (!jQuery(event.target).closest(".signup").length && !jQuery(event.target).closest(".signup-open").length) {
            jQuery(".signup-wrapper").removeClass("open");
        }
        if (!jQuery(event.target).closest(".forget").length && !jQuery(event.target).closest(".forget-open").length) {
            jQuery(".forget-wrapper").removeClass("open");
        }
    });
}
