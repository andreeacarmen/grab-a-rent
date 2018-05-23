
(function() {
        'use strict';

        var inject = ['$scope', 'utilService'];
        var addPropertyController = function($scope, utilService){
            var self = this;

            var map;
            var mapOptions = {
                center: {lat: -33.8688, lng: 151.2195},
                zoom: 13,
                mapTypeId: 'roadmap'
            };

            // Display a map on the page
            map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
            map.setTilt(45);

            // Create the search box and link it to the UI element.
            var input = document.getElementById('pac-input');
            var searchBox = new google.maps.places.SearchBox(input);
            map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

            // Bias the SearchBox results towards current map's viewport.
            map.addListener('bounds_changed', function() {
                searchBox.setBounds(map.getBounds());
            });

            var markers = [];
            // Listen for the event fired when the user selects a prediction and retrieve
            // more details for that place.
            searchBox.addListener('places_changed', function() {
                var places = searchBox.getPlaces();

                self.places = places;
                if (places.length == 0) {
                    return;
                }

                // Clear out the old markers.
                markers.forEach(function(marker) {
                    marker.setMap(null);
                });
                markers = [];

                // For each place, get the icon, name and location.
                var bounds = new google.maps.LatLngBounds();
                places.forEach(function(place) {
                    if (!place.geometry) {
                        console.log("Returned place contains no geometry");
                        return;
                    }
                    var icon = {
                        url: place.icon,
                        size: new google.maps.Size(71, 71),
                        origin: new google.maps.Point(0, 0),
                        anchor: new google.maps.Point(17, 34),
                        scaledSize: new google.maps.Size(25, 25)
                    };

                    // Create a marker for each place.
                    markers.push(new google.maps.Marker({
                        map: map,
                        icon: icon,
                        title: place.name,
                        position: place.geometry.location
                    }));

                    if (place.geometry.viewport) {
                        // Only geocodes have viewport.
                        bounds.union(place.geometry.viewport);
                    } else {
                        bounds.extend(place.geometry.location);
                    }
                });
                map.fitBounds(bounds);
            });

            $scope.uploadFile = function uploadSingleFile(file) {
                var formData = new FormData();
                formData.append("file", file);
                var endpoint = 'http://localhost:8080/pictures';

                utilService.makePOSTMultipart(endpoint,formData).then(function success(response){
                    console.log(response.data);
                });

               /* var xhr = new XMLHttpRequest();
                xhr.open("POST", "/pictures");

                xhr.onload = function() {
                    console.log(xhr.responseText);
                    var response = JSON.parse(xhr.responseText);
                };

                xhr.send(formData);*/
            }

            $scope.submit = function() {

                console.log(self.places);
                var address = self.places[0].formatted_address;
                var lat = self.places[0].geometry.location.lat();
                var lng = self.places[0].geometry.location.lng();
                var endpoint = 'http://localhost:8080/properties/new';
                self.data = {
                    "userId": utilService.userId,
                    "propertyName": $scope.propertyName,
                    "propType": $scope.propType,
                    "description": $scope.description,
                    "mp": $scope.mp,
                    "lat": lat,
                    "lg": lng,
                    "price": $scope.price,
                    "furniture": $scope.furniture,
                    "constructionYear": $scope.constructionYear,
                    "lvl": $scope.lvl,
                    "roomNr": $scope.roomNr,
                    "facilities": $scope.facilities,
                    "pictureURL": $scope.pictureURL,
                    "address": address
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