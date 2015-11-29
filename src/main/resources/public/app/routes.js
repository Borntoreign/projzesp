'use strict';

angular.module('carpooling')
    .config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {

        // For unmatched routes
        $urlRouterProvider.otherwise('/');

        // Application routes
        $stateProvider
            .state('layout', {
                abstract: true,
                templateUrl: 'app/commons/layout.html'
            })
            .state('nav', {
                abstract: true,
                parent: 'layout',
                views: {
                    header: {
                        templateUrl: 'app/commons/nav.html'
                    },
                    content: {
                        template: '<ui-view/>'
                    },
                    sidebar: {
                        templateUrl: 'app/commons/sidebar.html'
                    },
                    footer: {
                        templateUrl: 'app/commons/footer.html'
                    }
                }
            })
            .state('start', {
                url: '/',
                parent: 'nav',
                templateUrl: '/app/commons/start.html'
            })
            .state('home', {
                url: '/home',
                parent: 'nav',
                templateUrl: '/app/home/home.html',
                controller: 'HomeController'
            })
            .state('transit',{
                url: '/transit',
                parent: 'nav',
                abstract: true
            })
            .state('transit.create', {
                url: '/transit/create',
                parent: 'nav',
                templateUrl: '/app/transit/transit.create.html',
                controller: 'TransitController'
            })
            .state('transit.my', {
                url: '/transit/my',
                parent: 'nav',
                templateUrl: '/app/transit/transit.my.html',
                controller: 'TransitController'
            })
            .state('transit.details', {
                url: '/transit/{id}',
                parent: 'nav',
                templateUrl: '/app/transit/transit.details.html',
                controller: 'TransitController'
            });
    }
]);
