angular.module('carpooling.settings', []).controller('SettingsController', ['$scope', '$rootScope', '$http', '$state',
    function ($scope, $rootScope, $http, $state) {
        $scope.saveMail = function (profile) {
            console.log("PROFILE DATA: " + JSON.stringify(profile, null, 4));
        };

        $scope.saveUser = function (user) {
            console.log("USER DATA: " + JSON.stringify(user, null, 4));
        };
    }]);
