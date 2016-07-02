angular.module('carpooling.transit', []).controller('TransitController', ['$scope', '$rootScope', '$http', '$state',
    function ($scope, $rootScope, $http, $state) {
        /* Date filter comparator */
        $scope.equalOrGreater = function (actual, expected) {
            console.debug(actual, expected, actual >= expected);
            return actual >= expected;
        };
            

        $scope.filteringRules = {
            showArchived: false,
            showUpToDate: false,
            reset: function () {
                this.showArchived = false;
                this.showUpToDate = false;
            }
        };

        $scope.showAll = function () {
            $scope.filteringRules.reset();
        };

        $scope.showArchived = function () {
            $scope.filteringRules.showArchived = true;
        };


        $scope.showUpToDateTransits = function () {
            $scope.filteringRules.showUpToDate = true;
        };

        $scope.getTodayTimeStamp = function () {
            return Date.now();
        };



        $scope.createTransit = function (transit) {
            $http.post('/transit', {
                'startCity': transit.startCity,
                'endCity': transit.endCity,
                'driver': $rootScope.user.login,
                'startDate': transit.date,
                'cost': transit.cost
            }).success(function () {
                $state.go('transit.my');
                console.log('dodano');
            }).error(function (data) {
                console.error('nie dodano');
            });
        };

        $scope.editTransit = function (transit) {
            $http.put('/transit/' + transit.id, {
                'startCity': transit.route.startCity.cityName,
                'endCity': transit.route.endCity.cityName,
                'driver': $rootScope.user.login,
                'startDate': transit.startDate,
                'cost': transit.cost
            }).success(function () {
                $state.go('transit.my');
                console.log('Edycja przebiegla pomyslenie.');
            }).error(function (data) {
                console.error('Nie udalo sie zedytowac przejazdu.');
            });
        };

        $scope.redoTransit = function (transit) {
            $http.post('/transit', {
                'startCity': transit.route.startCity.cityName,
                'endCity': transit.route.endCity.cityName,
                'driver': $rootScope.user.login,
                'startDate': transit.startDate,
                'cost': transit.cost
            }).success(function () {
                $state.go('transit.my');
                console.log('Dodanie zarchiwizowanego przejazdu przebieglo pomyslnie.');
            }).error(function (data) {
                console.error('Dodanie zarchiwizowanego przejazdu nie udalo sie.');
            });
        };

        $scope.getTransitDetails = function () {
            var id = $state.params.id;
            $http({
                method: 'GET',
                url: '/transit/' + id
            }).success(function (response) {
                $rootScope.currentTransit = response;
            }).error(function (error) {
                console.error('getTransitDetails error');
            });
        };

        $scope.fillTransitFields = function () {
            var id = $state.params.id;
            $http({
                method: 'GET',
                url: '/transit/' + id
            }).success(function (response) {
                $rootScope.currentTransit = response;
                $scope.currentTransit.route.startCity.cityName = response.route.startCity.cityName;
                $scope.currentTransit.route.endCity.cityName = response.route.endCity.cityName;
                $scope.currentTransit.startDate = response.startDate;

            }).error(function (error) {
                console.error('Nie udalo sie pobrac przejazdu i wypelnic pol.');
            });
        };

        $scope.getMyTransit = function () {
            $http({
                method: 'GET',
                url: '/transit/my/' + $rootScope.user.login,
                transformResponse: function (requestBody) {
                    requestBody = JSON.parse(requestBody);
                    requestBody.map(function (transit) {
                        var localDateObject = transit.startDateObject;
                        var dateString = localDateObject.year + '/' +
                                localDateObject.monthOfYear + '/' +
                                localDateObject.dayOfMonth + ' ' +
                                localDateObject.hourOfDay + ':' +
                                localDateObject.minuteOfHour + ':' +
                                localDateObject.secondOfMinute + '.' +
                                localDateObject.millisOfSecond;
                        transit.timeStamp = Date.parse(dateString);
                        return transit;
                    });
                    return requestBody;
                }
            }).success(function (response) {
                $scope.transits = response;
            }).error(function (error) {
                console.error('getMyTransit error');
            });
        };

        $scope.deleteTransit = function (transit) {
            $http.delete('/transit/' + transit.id).success(function () {
                console.log('Transit is deleted');
                $state.go('transit.my');
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
        };

        $scope.reserveTransit = function (transit) {
            $http.post('/reservation', {
                'transitId': transit.id,
                'username': $rootScope.user.login
            }).success(function () {
                console.log('utworzono rezerwacje');
                $state.go('reservation.my');
            }).error(function (data) {
                console.error('nie utworzono rezerwacji');
            });
        };

        $scope.canReserve = function (transit) {
            if (transit.driver.id === $rootScope.user.user.id) {
                return false;
            } else {
                for (i = 0; i < transit.passengers.length; i++) {
                    if (transit.passengers[i].id == $rootScope.user.user.id) {
                        return false;
                    }
                }
                return true;
            }
        };

        $scope.canEdit = function (transit) {
            if (transit.driver.id === $rootScope.user.user.id) {
                return true;
            }
            return false;
        };

        $scope.canArchive = function (transit) {
            if (transit.driver.id === $rootScope.user.user.id) {
                if (transit.archived)
                {
                    return false;
                }
                return true;
            }
            return false;
        };

        $scope.archiveTransit = function (transit) {
            $http({
                method: 'PATCH',
                url: '/transits/' + transit.id,
                data: {
                    'archived': true
                }
            }).success(function () {
                $state.go('transit.my');
            }).error(function (error) {
                console.error('archiveTransit error');
            });
        };

        $scope.isOpen = false;

        $scope.openCalendar = function(e) {
            e.preventDefault();
            e.stopPropagation();

            $scope.isOpen = true;
        };

    }]).directive('transitForm', function(){
    return {
        restrict: 'E',
        templateUrl: '/app/transit/transit-form.html'
    }
});
