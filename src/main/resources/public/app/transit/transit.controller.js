angular.module('carpooling.transit', []).controller('TransitController', ['$scope', '$rootScope', '$http',
    function ($scope, $rootScope, $http) {
        $scope.createTransit = function (transit) {
            $http.post('/transit', {
                'startCity': transit.startCity,
                'endCity': transit.endCity,
                'driver': $rootScope.user.login,
                'startDate': transit.date
            }).success(function () {
                logger.info('dodano');
            }).error(function (data) {
                logger.error('nie dodano');
            });
        };

        $scope.getMyTransit = function() {
            $http({
                method:'GET',
                url:'/transit/'+$rootScope.user.login
            }).success(function (response) {
                $scope.myTransits = response;
            }).error(function(error) {
                logger.error('getMyTransit error');
            });
        };

        $scope.getRole = function(transit) {
            if(transit.driver.id === $rootScope.user.user.id) {
                return "Driver";
            } else {
                return "Passenger";
            }
        }
    }]);
