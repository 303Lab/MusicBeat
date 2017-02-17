/**
 * APP模块
 * @author windawings
 * @time.creation 2017/02/06 17:03
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("musicbeat", [
        "app.configs",
        "app.providers",
        "app.routes",
        "app.services",
        "app.filters",
        "app.ctrls"
    ])
    .run(["$rootScope", "$state", "$stateParams", function ($scope, $rootScope, $state, $stateParams) {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
    }]
);
