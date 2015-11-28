angular.module('carpooling.transit', []).controller('TransitController', ['$scope', '$rootScope', '$http',
    function ($scope, $rootScope, $http) {
        $scope.createTransit = function (transit) {
            $http.post('/transit', {
                'startCity': transit.startCity,
                'endCity': transit.endCity,
                'driver': $rootScope.user.login,
                'startDate': transit.date
            }).success(function () {
                alert('dodano');
            }).error(function (data) {
                alert(data);
            });
        }
    }]);