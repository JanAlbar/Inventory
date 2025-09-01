app.controller('LoginController', function($scope, $http, AuthService, $location){
    $scope.credentials = {username: '', password: ''};
    $scope.errorMessage = '';

    $scope.login = function() {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/user/login',
            data: $scope.credentials,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function(response){
            $scope.errorMessage = '';
            AuthService.setToken(response.data.token);
            $location.path("/inventory");
        }, function(error) {
            $scope.errorMessage = 'Invalid username or password';
        });
    };
});