
/**
 * Created by Andreea on 22.11.2016.
 */
(function() {
        'use strict';

        var inject = ['$scope', 'utilService'];
        var signUpController = function($scope, utilService){
            var self = this;

            $scope.submit = function() {

                var endpoint = 'http://localhost:8080/users/new';

                self.data = {
                    "location": $scope.city,
                    "email": $scope.email,
                    "name": $scope.name,
                    "password": $scope.password
                };

                utilService.makePOSTReq(endpoint,self.data).then(function success(response){
                    console.log(response.data);
                    utilService.isLoggedin = true;
                });

                window.location.replace("#/home");
        };

        };

        signUpController.$inject = inject;
        angular.module('myApp').controller('signUpController',signUpController);
    }
)();