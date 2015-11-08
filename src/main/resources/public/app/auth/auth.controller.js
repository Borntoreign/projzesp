angular.module('carpooling.auth', []).controller('AuthController', [
    '$scope', '$rootScope', '$modal', '$http', '$location', '$cookieStore',
    function ($scope, $rootScope, $modal, $http, $location, $cookieStore) {

        $scope.open = function (size) {
            var modalInstance = $modal.open({
                animation: true,
                templateUrl: '/app/auth/register.html',
                controller: 'RegisterController',
                size: size
            });
        };

        $scope.login = function (username, password) {
            $http({
                method: 'POST',
                url: 'login',
                params: {'username': username, 'password': password, 'ajax': true}
            }).success(function () {
                $http.get('/users/' + username).success(function (user) {
                        $rootScope.user = user;
                        $cookieStore.put('user', user.login);
                        $location.path('/home');
                    }
                );
            }).error(function () {
                alert("check your login and password");
            });
        };

        $scope.logout = function (path) {
            $http({
                method: 'POST',
                url: 'logout'
            }).success(function () {
                $cookieStore.remove('user');
                delete $rootScope.user;
                $location.path(path);
            }).error(function (e) {
                alert(e);
            });
        };

        $scope.isAuthorize = function () {
            var result = $rootScope.user !== null && $rootScope.user !== undefined;
            return result;
        };

        $scope.isNotAuthorize = function () {
            var result = $rootScope.user === null || $rootScope.user === undefined;
            return result;
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
        }).success(function () {
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