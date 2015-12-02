angular.module('carpooling.search', []).controller('SearchController', ['$scope', '$rootScope', '$http', '$state',
    function ($scope, $rootScope, $http, $state) {

        $scope.search = function (searchObject) {
            if(searchObject.date === null || searchObject.date === undefined) {
                searchByRoute(searchObject);
            } else {
                searchByRouteAndDate(searchObject);
            }
        };


        function searchByRouteAndDate(searchObject) {
            $http({
                url: '/searchByRouteAndDate',
                method: 'GET',
                params: {
                    'startCity': searchObject.startCity,
                    'endCity': searchObject.endCity,
                    'date': searchObject.date,
                    'time': searchObject.time
                }
            }).success(function (response) {
                $rootScope.results = response;
                $state.go('search.results');
            }).error(function (error) {
                console.error('search error');
            });
        }

        function searchByRoute(searchObject) {
            $http({
                url: '/searchByRoute',
                method: 'GET',
                params: {
                    'startCity': searchObject.startCity,
                    'endCity': searchObject.endCity
                }
            }).success(function (response) {
                $rootScope.results = response;
                $state.go('search.results');
            }).error(function (error) {
                console.error('search error');
            });
        }
    }]);