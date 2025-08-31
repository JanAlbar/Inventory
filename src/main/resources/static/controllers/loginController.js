app.controller('LoginController', function($scope, $http){
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
            console.log(response.data);
            $scope.errorMessage = '';
            alert('Login successful!');
        }, function(error) {
            $scope.errorMessage = 'Invalid username or password';
        });
    };
});