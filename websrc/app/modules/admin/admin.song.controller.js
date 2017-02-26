/**
 * Created by qinshen on 2017/2/24.
 */

angular
    .module("app.ctrls")
    .controller("adminSongController", ["$scope", "$document", adminSongController]);

function adminSongController($scope, $document) {
    /*==========song  Edit ==========*/
    jQuery('.song-edit-open').on('click', function(event) {
        event.preventDefault();
        jQuery('.song-edit-wrapper').addClass('open');
    });
    $document.on('click', function(event) {
        if (!jQuery(event.target).closest('.song-edit').length && !jQuery(event.target).closest('.song-edit-open').length) {
            jQuery('.song-edit-wrapper').removeClass('open');
        }
    });

    /*==========song Add Edit ==========*/
    jQuery('.song-add-edit-open').on('click', function(event) {
        event.preventDefault();
        jQuery('.song-add-edit-wrapper').addClass('open');
    });
    $document.on('click', function(event) {
        if (!jQuery(event.target).closest('.song-add-edit').length && !jQuery(event.target).closest('.song-add-edit-open').length) {
            jQuery('.song-add-edit-wrapper').removeClass('open');
        }
    });
}