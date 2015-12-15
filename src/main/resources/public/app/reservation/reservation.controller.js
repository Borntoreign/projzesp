angular.module('carpooling.reservation', []).controller('ReservationController', ['$scope', '$rootScope', '$http', '$state',
    function ($scope, $rootScope, $http, $state) {
        $scope.getReservationDetails = function () {
            var id = $state.params.id;
            $http({
                method: 'GET',
                url: '/reservation/' + id
            }).success(function (response) {
                $rootScope.currentTransit = response;
            }).error(function (error) {
                console.error('getReservationDetails error');
            });
        };

        $scope.getMyReservation = function () {
            $http({
                method: 'GET',
                url: '/reservation/my/' + $rootScope.user.login
            }).success(function (response) {
                $scope.reservations = response;
            }).error(function (error) {
                console.error('getMyReservation error');
            });
        };

        $scope.deleteReservation = function (reservation) {
            $http.delete('/reservation/' + reservation.id).success(function () {
                console.log('Reservation is deleted');
                $state.go('reservation.my');
            }).error(function (error) {
                console.error('deleteReservation error');
            })
        }    

    }]);
