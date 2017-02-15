/**
 *
 * @author windawings
 * @create.time 2017/02/14 21:54
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("authWrapperController", ["$scope", authWrapperController]);

function authWrapperController($scope) {
    $scope.credentials = {userId: "", password: ""};
    $scope.message = {text: ""};

    /*==========  Login / Signup / Forget==========*/
    jQuery(".login-open").on("click", function (event) {
        event.preventDefault();
        jQuery(".login-wrapper").addClass("open");
        jQuery(".signup-wrapper").removeClass("open");
    });
    jQuery(".signup-open").on("click", function (event) {
        event.preventDefault();
        jQuery(".signup-wrapper").addClass("open");
        jQuery(".login-wrapper").removeClass("open");
        $scope.credentials.userId = "";
        $scope.credentials.password = "";
        $scope.message.text = "";
    });
    jQuery(".forget-open").on("click", function (event) {
        event.preventDefault();
        jQuery(".forget-wrapper").addClass("open");
        jQuery(".login-wrapper").removeClass("open");
        $scope.credentials.userId = "";
        $scope.credentials.password = "";
        $scope.message.text = "";
    });
    jQuery(document).on("click", function (event) {
        if (!jQuery(event.target).closest(".login").length && !jQuery(event.target).closest(".login-open").length) {
            jQuery(".login-wrapper").removeClass("open");
            $scope.credentials.userId = "";
            $scope.credentials.password = "";
            $scope.message.text = "";
        }
        if (!jQuery(event.target).closest(".signup").length && !jQuery(event.target).closest(".signup-open").length) {
            jQuery(".signup-wrapper").removeClass("open");
        }
        if (!jQuery(event.target).closest(".forget").length && !jQuery(event.target).closest(".forget-open").length) {
            jQuery(".forget-wrapper").removeClass("open");
        }
    });
}