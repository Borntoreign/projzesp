'use strict';

(function () {
    angular
        .module('carpooling', [
            'carpooling.auth',
            'carpooling.transit',
            'ui.bootstrap',
            'ui.router',
            'ngCookies',
            'uiGmapgoogle-maps',
            'ngAnimate',
            'ui.bootstrap.datetimepicker'
        ]);
}());