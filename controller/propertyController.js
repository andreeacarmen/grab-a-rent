/**
 * Created by Andreea on 09.05.2018.
 */

(function() {
        'use strict';

        var inject = ['$scope', 'utilService', '$q', '$routeParams'];
        var propertyController = function($scope, utilService, $q, $routeParams){
            var self = this;
            self.init = init;


            function init() {
                console.log("init");
                getPropertyData();
            }

            function getPropertyData(){
                var propertyId = $routeParams.id;

                var url = 'http://localhost:8080/properties/property/' + propertyId;
                return utilService.makeGETReq(url).then(function success(response) {
                    self.data = response.data[0];
                    console.log(self.data);
                });
            }

        };

        propertyController.$inject = inject;
        angular.module('myApp').controller('propertyController',propertyController);
    }
)();