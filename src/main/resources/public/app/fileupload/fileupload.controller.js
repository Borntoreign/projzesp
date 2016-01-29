angular.module('carpooling.fileupload', []).controller('FileUploadController', ['$scope', '$rootScope', '$http', '$state',
    function ($scope, $rootScope, $http, $state) {
        $scope.filename = '';
        $scope.alertMessage = '';

        $scope.uploadFile = function() {
            $scope.processDropzone();
        };

        $scope.reset = function() {
            $scope.resetDropzone();
        };

        $scope.setAlert = function(msg, msgClass) {
            if (!msgClass) {
                msgClass = 'info';
            }
            $scope.alertMessage = msg;
            $scope.alertMessageClass = 'alert alert-' + msgClass;
        }
    }
]).directive('dropzone', function(){
    return {
        restrict: 'C',
        link: function(scope, element, attrs) {
            var config = {
                url: '/upload/avatar',
                maxFilesize: 0.3, // MB
                paramName: "uploadfile",
                maxThumbnailFilesize: 10,
                parallelUploads: 1,
                autoProcessQueue: false // I make sure that the files aren't queued until they are manually added.
            };

            var eventHandlers = {
                'addedfile': function(file) {
                    scope.file = file;
                    if (this.files[1]!=null) {
                        this.removeFile(this.files[0]);
                    }
                    scope.$apply(function() {
                        scope.fileAdded = true;
                    });
                },
                'success': function (file, response) {
                    scope.$apply(function() {
                        scope.setAlert('Your avatar has been saved.', 'success');
                    });
                    this.removeAllFiles();
                }
            };

            var dropzone = new Dropzone(element[0], config);

            angular.forEach(eventHandlers, function(handler, event) {
                dropzone.on(event, handler);
            });

            scope.processDropzone = function() {
                dropzone.processQueue();
            };

            scope.resetDropzone = function() {
                dropzone.removeAllFiles();
            }
        }
    }
});