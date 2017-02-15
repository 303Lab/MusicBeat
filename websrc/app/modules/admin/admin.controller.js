/**
 *
 * @author windawings
 * @create.time 2017/02/13 21:37
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("adminController", ["$scope", adminController]);

function adminController($scope) {
    /*==========  Accordion  ==========*/
    jQuery(".panel-heading a").on("click", function() {
        if (jQuery(this).parents(".panel-heading").hasClass("active")) {
            jQuery(".panel-heading").removeClass("active");
        } else {
            jQuery(".panel-heading").removeClass("active");
            jQuery(this).parents(".panel-heading").addClass("active");
        }
    });
}