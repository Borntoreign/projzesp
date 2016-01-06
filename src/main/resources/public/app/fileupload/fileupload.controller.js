angular.module('carpooling.fileupload', []).controller('FileUploadController', ['$scope', '$rootScope', '$http', '$state',
    function ($scope, $rootScope, $http, $state) {
        $scope.filename = '';

        $scope.uploadFile = function() {
            $scope.processDropzone();
        };

        $scope.reset = function() {
            $scope.resetDropzone();
        };
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