angular.module('carpooling.auth', []).controller('AuthController', ['$scope', '$rootScope', '$modal', function ($scope,
                                                                                                                $rootScope,
                                                                                                                $modal) {
    $scope.open = function (size) {
        var modalInstance = $modal.open({
            templateUrl: '/app/auth/register.html',
            controller: 'RegisterController',
            size: size
        });
    };

}]);

angular.module('carpooling.auth').controller('RegisterController', function ($scope,
                                                                             $rootScope,
                                                                             $http,
                                                                             $modalInstance) {
    $scope.register = function (login, password, email, firstname, lastname) {
        $http.post('/register', {
            'login': login,
            'password': password,
            'user': {
                'email': email,
                'firstName': firstname,
                'lastName': lastname
            }
        }).success(function (data) {
            $rootScope.user = data;
            $modalInstance.dismiss('cancel');
        }).error(function (data) {
            $scope.message = 'Error: Cannot create account';
            $scope.messageClass = 'alert alert-danger';
        });
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
});