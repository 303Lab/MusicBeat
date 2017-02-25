/**
 *
 * @author windawings
 * @create.time 2017/02/23 21:42
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("adminSingerController", ["$scope", "$document", adminSingerController]);

function adminSingerController($scope, $document) {

    // open edit panel
    jQuery(".singer-edit-open").on("click", function(event){
        event.preventDefault();
        jQuery(".singer-edit-wrapper").addClass("open");
    });

    $document.on("click", function (event) {
        if (!jQuery(event.target).closest(".singer-edit").length && !jQuery(event.target).closest(".singer-edit-open").length) {
            jQuery(".singer-edit-wrapper").removeClass("open");
        }
    });
}