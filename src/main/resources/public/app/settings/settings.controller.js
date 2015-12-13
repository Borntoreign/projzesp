angular.module('carpooling.settings', [])
    .controller('SettingsController', ['$scope', '$rootScope', '$http', '$state',
        function ($scope, $rootScope, $http, $state) {
            $scope.updateEmail = function (profile) {
                if (profile.currentPassword === $rootScope.user.password) {
                    $http({
                        url: "/people/" + $rootScope.user.user.id,
                        method: "PATCH",
                        data: {
                            'email': profile.newEmail
                        }
                    }).success(function () {
                        $rootScope.user.user.email = profile.newEmail;
                        setAlert('New email saved.', 'success');
                    }).error(function (data) {
                        setAlert('Error during saving changes.', 'danger');
                    });
                }
                else {
                    setAlert('Passwords do not match.', 'danger');
                }
            };

            $scope.updateUser = function (newPhoneNumber) {
                if (!newPhoneNumber || newPhoneNumber === $rootScope.user.user.phoneNumber) {
                    setAlert('New number is empty or is currently in use.', 'danger');
                    return;
                }

                $http({
                    url: "/people/" + $rootScope.user.user.id,
                    method: "PATCH",
                    data: {
                        'phoneNumber': newPhoneNumber
                    }
                }).success(function () {
                    $rootScope.user.user.phoneNumber = newPhoneNumber;
                    setAlert('Settings Saved.', 'success');
                }).error(function (data) {
                    setAlert('Error during saving changes.', 'danger');
                });
            };

            function setAlert(msg, msgClass) {
                if (!msgClass) {
                    msgClass = 'info';
                }
                $scope.alertMessage = msg;
                $scope.alertMessageClass = 'alert alert-' + msgClass;
            }
        }]);
