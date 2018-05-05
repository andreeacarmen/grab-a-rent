
(function() {
        'use strict';

        var inject = ['$scope', 'utilService'];
        var editController = function($scope, utilService){
            var self = this;

            self.init = function(){
                utilService.makeGETReq('http://localhost:8080/users').then(function success(response) {
                    self.data = response.data;
                    var userName = utilService.username;
                    for (var i = 0, length = self.data.length; i < length; i++) {
                        var user = self.data[i];
                        if (user.username == userName) {
                            self.user = user;
                            console.log(self.user);
                        }
                    }

                });
            };

            $scope.edit = function() {

                console.log("Trimitem:");
                console.log(self.user);
                utilService.makePOSTReq(endpoint,self.user).then(function success(response){

                    console.log("Primim:" + response.data);
                });

                window.location.replace("#/home");
            };

        };

        editController.$inject = inject;
        angular.module('myApp').controller('editController', editController);
    }
)();