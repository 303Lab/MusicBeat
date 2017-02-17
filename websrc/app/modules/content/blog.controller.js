/**
 *
 * @author windawings
 * @create.time 2017/02/13 21:43
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("blogController", ["$scope", blogController]);

function blogController($scope) {
    /*==========  Blog Gallery  ==========*/
    jQuery(".blog-gallery").owlCarousel({
        loop: true,
        nav: true,
        dots: false,
        navText: ['<i class="pe-7s-angle-left"></i>', '<i class="pe-7s-angle-right"></i>'],
        items: 1
    });

    /*==========  Load more button  ==========*/
    jQuery(".blog-grid .row").hide();
    jQuery(".blog-grid .row").slice(0, 3).show();
    jQuery("#blog-load-more").on("click", function (e) {
        e.preventDefault();
        jQuery(".blog-grid .row:hidden").slice(0, 1).slideDown();
        if (jQuery(".blog-grid .row:hidden").length === 0) {
            jQuery("#blog-load-more").fadeOut("slow");
        }
    });
}