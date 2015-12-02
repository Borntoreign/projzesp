'use strict';

(function () {
    angular
        .module('carpooling', [
            'carpooling.auth',
            'carpooling.transit',
            'carpooling.search',
            'ui.bootstrap',
            'ui.router',
            'ngCookies',
            'uiGmapgoogle-maps',
            'ngAnimate',
            'ui.bootstrap.datetimepicker'
        ]);
}());