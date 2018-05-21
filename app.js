// create the module and name it
var myApp = angular.module('myApp', ['ngRoute', 'ngCookies']);

// configure the routes
myApp.config(function($routeProvider) {

    $routeProvider
        .when('/', {
            templateUrl : 'view/homePage.html',
        })
        .when('/home', {
            templateUrl : 'view/home.html',
            controllerAs: 'homeController',
            controller: 'homeController'
        })
        .when('/about',{
                    templateUrl: 'view/edit.html',
                    controller: 'editController',
                    controllerAs: 'editController'
                })
        .when('/register', {
            templateUrl : 'view/signup.html',
            controllerAs: 'signUp',
            controller  : 'signUpController'
        })
        .when('/addProperty', {
            templateUrl : 'view/addProperty.html',
            controllerAs: 'addProperty',
            controller  : 'addPropertyController'
        })
        .when('/contact',{
            templateUrl: 'view/contact.html'
        })
        .when('/properties/:id',{
            templateUrl: 'view/property.html',
            controllerAs: 'propertyController',
            controller: 'propertyController'
        })

});




