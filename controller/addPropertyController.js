
/**
 * Created by Andreea on 22.11.2016.
 */
(function() {
        'use strict';

        var inject = ['$scope', 'utilService'];
        var addPropertyController = function($scope, utilService){
            var self = this;

            $scope.submit = function() {

                var endpoint = 'http://localhost:8080/properties/new';
                self.data = {
                    "propertyName": $scope.propertyName,
                    "propType": $scope.propType,
                    "description": $scope.description,
                    "mp": $scope.mp,
                    "price": $scope.price,
                    "furniture": $scope.furniture,
                    "constructionYear": $scope.constructionYear,
                    "lvl": $scope.lvl,
                    "roomNr": $scope.roomNr,
                    "facilities": $scope.facilities
                };

                utilService.makePOSTReq(endpoint,self.data).then(function success(response){
                    console.log(response.data);
                });

                window.location.replace("#/home");
        };

        };

        addPropertyController.$inject = inject;
        angular.module('myApp').controller('addPropertyController',addPropertyController);
    }
)();