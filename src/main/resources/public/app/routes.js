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
                .state('transit', {
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
                    templateUrl: '/app/transit/transit.list.html',
                    controller: 'TransitController'
                })
                .state('transit.details', {
                    url: '/transit/{id}',
                    parent: 'nav',
                    templateUrl: '/app/transit/transit.details.html',
                    controller: 'TransitController'
                })
                .state('search', {
                    url: '/search',
                    parent: 'nav',
                    abstract: true
                })
                .state('search.form', {
                    url: '/search',
                    parent: 'nav',
                    templateUrl: '/app/search/search.form.html',
                    controller: 'SearchController'
                })
                .state('search.results', {
                    url: '/search/results',
                    parent: 'nav',
                    templateUrl: '/app/search/search.results.html',
                    controller: 'SearchController'
                })
                .state('settingslayout', {
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
                            templateUrl: 'app/settings/sidebar.html'
                        },
                        footer: {
                            templateUrl: 'app/commons/footer.html'
                        }
                    }
                })
                .state('settings', {
                    url: '/settings',
                    parent: 'settingslayout',
                    templateUrl: '/app/settings/edit.profile.html',
                    controller: 'SettingsController'
                })
                .state('settings.profile', {
                    url: '/settings/profile',
                    parent: 'settingslayout',
                    templateUrl: '/app/settings/edit.profile.html',
                    controller: 'SettingsController'
                })
                .state('settings.email', {
                    url: '/settings/email',
                    parent: 'settingslayout',
                    templateUrl: '/app/settings/edit.email.html',
                    controller: 'SettingsController'
                })
                .state('reservation', {
                    url: '/reservation',
                    parent: 'nav',
                    abstract: true
                })
                 .state('reservation.my', {
                    url: '/reservation/my',
                    parent: 'nav',
                    templateUrl: '/app/reservation/reservation.list.html',
                    controller: 'ReservationController'
                })
        }
    ]);
