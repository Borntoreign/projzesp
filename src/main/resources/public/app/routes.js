'use strict';

angular.module('carpooling').config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {

        // For unmatched routes
        $urlRouterProvider.otherwise('/');

        // Application routes
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: '/app/home/home.html'
            });
    }
]);
