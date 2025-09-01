app.controller('InventoryController', function($scope, $http, AuthService) {
    $scope.items = [];
    $scope.getItem = function() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/item',
            headers: {
                "Authorization" : "Bearer " + AuthService.getToken()
            }
        }).then(function(response) {
            console.log(response.data);
            $scope.items = response.data;
        }, function(error) {
            console.log("Failed to fetch items : ", error);
        });
    };
});