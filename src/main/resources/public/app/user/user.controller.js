angular.module('carpooling.user', [])
    .controller('UserController', ['$scope', '$rootScope', '$http', '$state',
        function ($scope, $rootScope, $http, $state) {

            $scope.getUserDetails = function () {
                var id = $state.params.id;
                $http({
                    method: 'GET',
                    url: '/people/' + id
                }).success(function (response) {
                    $scope.currentUser = response;
                }).error(function (error) {
                    setAlert('An error occurred while fetching data.', 'danger');
                });
            };

            function setAlert(msg, msgClass) {
                if (!msgClass) {
                    msgClass = 'info';
                }
                $scope.alertMessage = msg;
                $scope.alertMessageClass = 'alert alert-' + msgClass;
            };
        }]);
