angular.module('carpooling.transit', []).controller('TransitController', ['$scope', '$rootScope', '$http', '$location',
    function ($scope, $rootScope, $http, $location) {
        $scope.createTransit = function (transit) {
            $http.post('/transit', {
                'startCity': transit.startCity,
                'endCity': transit.endCity,
                'driver': $rootScope.user.login,
                'startDate': transit.date
            }).success(function () {
                console.log('dodano');
            }).error(function (data) {
                console.error('nie dodano');
            });
        };

        $scope.getTransitDetails = function (transit) {
            $http({
                method: 'GET',
                url: '/transit/' + transit.id
            }).success(function (response) {
                $rootScope.currentTransit = response;
            }).error(function (error) {
                console.error('getTransitDetails error');
            });
        };

        $scope.getMyTransit = function () {
            $http({
                method: 'GET',
                url: '/transit/my/' + $rootScope.user.login
            }).success(function (response) {
                $scope.myTransits = response;
            }).error(function (error) {
                console.error('getMyTransit error');
            });
        };

        $scope.deleteTransit = function (transit) {
            $http.delete('/transit/' + transit.id).success(function () {
                console.log('Transit is deleted');
                $location.path('/transit/my');
            }).error(function (error) {
                console.error('deleteTransit error');
            })
        };

        $scope.getRole = function (transit) {
            if (transit.driver.id === $rootScope.user.user.id) {
                return "Driver";
            } else {
                return "Passenger";
            }
        }

    }]);
