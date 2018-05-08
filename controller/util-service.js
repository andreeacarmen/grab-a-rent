
(function() {
        var inject = ['$http'];
        var utilService = function($http){
            var self = this;
            var userId = 0;
            self.isLoggedin = false;

            self.makeGETReq = function(endpoint) {
                return $http({method: 'GET', url: endpoint});
            };

            self.makePOSTReq = function(endpoint, data) {
                return $http({
                    method: 'POST',
                    url: endpoint,
                    data: data,
                    headers: {'Content-Type': 'application/json'}
                });
            };


            self.makePUTReq = function(endpoint, data) {
                return $http({
                    method: 'PUT',
                    url: endpoint,
                    data: data,
                    headers: {'Content-Type': 'application/json'}
                });
            }

        };

        utilService.$inject = inject;
        angular.module('myApp').service('utilService',utilService);
    }()
);