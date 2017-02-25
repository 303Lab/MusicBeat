/**
 *
 * @author windawings
 * @create.time 2017/02/18 16:05
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.providers")
    .config(["$provide", "toastrConfig", toastrProvider]);

function toastrProvider($provide, toastrConfig) {

    angular.extend(toastrConfig, {
        autoDismiss: false,
        containerId: "toast-container",
        maxOpened: 0,
        newestOnTop: true,
        positionClass: "toast-top-center",
        preventDuplicates: false,
        preventOpenDuplicates: false,
        target: "body",

        showEasing: "swing",
        hideEasing: "linear",
        showMethod: "fadeIn",
        hideMethod: "fadeOut",
        allowHtml: true,
        closeButton: true,
        closeHtml: "<button>&times;</button>",
        extendedTimeOut: 1000,
        iconClasses: {
            error: "toast-error",
            info: "toast-info",
            success: "toast-success",
            warning: "toast-warning"
        },
        messageClass: "toast-message",
        onHidden: null,
        onShown: null,
        onTap: null,
        progressBar: true,
        tapToDismiss: true,
        templates: {
            toast: "directives/toast/toast.html",
            progressbar: "directives/progressbar/progressbar.html"
        },
        timeOut: 5000,
        titleClass: "toast-title",
        toastClass: "toast"
    });

    function fnTextCenter(text) {
        return '<div class="text-center">' + text + '</div>';
    }

    $provide.provider("toastrProvider", function () {
        this.$get = function () {
            var service={};
            service.textCenter = fnTextCenter;

            return service;
        };
    });
}