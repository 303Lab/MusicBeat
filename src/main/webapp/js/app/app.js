/**
 * AngularJS App
 * Created by windawings on 2017/1/9 0009.
 */
'use strict';


// Declare app level module which depends on filters, and services
angular.module('musicbeat', ['musicbeat.filters', 'musicbeat.services', 'musicbeat.directives']).
config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: MyCtrl2});
    $routeProvider.when('/register', {templateUrl: 'partials/register.html', controller: MyCtrl2});
    $routeProvider.otherwise({redirectTo: '/login'});
}]);