angular.module('carpooling').controller('CarpoolingController', [
    '$rootScope', '$scope', '$cookieStore', '$http', function ($rootScope, $scope, $cookieStore, $http) {
        function initUser() {
            var user = $cookieStore.get('user');
            if(user !== null && user !== undefined) {
                $http.get('/users/' + user).success(function (user) {
                        $rootScope.user = user;
                    }
                );
            }
        }

        initUser();
    }]);