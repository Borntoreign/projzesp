'use strict';

(function () {
    angular
        .module('carpooling', [
            'ngMap',
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
            'ui.bootstrap.dateparser',
            'ui.bootstrap.position',
        ]);
}());