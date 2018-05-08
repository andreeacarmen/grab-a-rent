
(function() {
        'use strict';

        var inject = ['$scope','$rootScope', 'utilService', '$location', '$cookies'];
        var loginController = function($scope, $rootScope, utilService, $location, $cookies){
            var self = this;

            self.init = function(){
                self.isLoggedin = utilService.isLoggedin;
            };

            self.logout = function(){
                self.isLoggedin = false;
            };

            self.login = function(){
                var endpoint = 'http://localhost:8080/users/login';
                self.data = {
                    "email": $scope.email,
                    "password": $scope.password
                };

                utilService.email = $scope.email;
                //console.log(self.data);
                utilService.makePOSTReq(endpoint,self.data).then(function success(response){
                    //console.log(self.data);
                    //console.log("response" + response);

                    if(response.data == ""){
                        self.isLoggedin = false;
                    } else {
                        utilService.userId = response.data;
                        self.isLoggedin = true;
                        self.email = $scope.email;
                        console.log("succes " + response.data);
                        $rootScope.globals = {
                            currentSession: response.data
                        };
                        $location.path('/home');
                        //$window.location.href = '/query';
                        $cookies.put('app-data', $rootScope.globals);
                  //      $route.reload();
                        //console.log("Aici" + $rootScope.globals);

                    }

                });
                /*$http.post('http://localhost:8080/login', JSON.stringify({
                    username: $scope.username,
                    password: $scope.password
                })).then(function(respounse){
                    if(respounse.data == ""){
                        $scope.loginError =  true;
                    } else {
                        $rootScope.globals = {
                            currentSession: respounse.data
                        };
                        $location.path('/home');
                        //$window.location.href = '/query';
                        console.log($rootScope.globals.currentSession.sid);

                        $cookieStore.put('app-data', $rootScope.globals);
                    }
                });*/
            }
        };

        loginController.$inject = inject;
        angular.module('myApp').controller('loginController',loginController);
    }
)();