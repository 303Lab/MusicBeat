/**
 * Created by qinshen on 2017/2/24.
 */

angular
    .module("app.ctrls")
    .controller("adminSingerController", ["$scope", "$document", adminSingerController]);

function adminSingerController($scope, $document) {
    /*==========Singer  Edit ==========*/
    jQuery('.singer-edit-open').on('click', function(event) {
        event.preventDefault();
        jQuery('.singer-edit-wrapper').addClass('open');
    });
    $document.on('click', function(event) {
        if (!jQuery(event.target).closest('.singer-edit').length && !jQuery(event.target).closest('.singer-edit-open').length) {
            jQuery('.singer-edit-wrapper').removeClass('open');
        }
    });

    /*==========Singer Add Edit ==========*/
    jQuery('.singer-add-edit-open').on('click', function(event) {
        event.preventDefault();
        jQuery('.singer-add-edit-wrapper').addClass('open');
    });
    $document.on('click', function(event) {
        if (!jQuery(event.target).closest('.singer-add-edit').length && !jQuery(event.target).closest('.singer-add-edit-open').length) {
            jQuery('.singer-add-edit-wrapper').removeClass('open');
        }
    });

}