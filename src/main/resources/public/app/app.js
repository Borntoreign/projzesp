'use strict';

(function () {
    angular
        .module('carpooling', [
            'carpooling.auth',
            'carpooling.transit',
            'carpooling.search',
            'carpooling.settings',
            'carpooling.reservation',
            'carpooling.user',
            'carpooling.fileupload',
            'ui.bootstrap',
            'ui.router',
            'ngCookies',
            'uiGmapgoogle-maps',
            'ngAnimate',
            'ui.bootstrap.datetimepicker',
            'ui.validate',
        ]);
}());