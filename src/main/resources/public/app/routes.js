'use strict';

angular.module('carpooling')
    .config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {

        // For unmatched routes
        $urlRouterProvider.otherwise('/');

        // Application routes
        $stateProvider
            .state('start', {
                url: '/',
                templateUrl: '/app/commons/start.html'
            })
            .state('home', {
                url: '/home',
                templateUrl: '/app/home/home.html',
                controller: 'HomeController'
            });
    }
]);
