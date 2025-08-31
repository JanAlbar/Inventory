var app = angular.module('inventory', ['ngRoute']);

app.config(function($routeProvider, $locationProvider) {
    //  Remove the '!' so URLs look like #/login instead of #!/login
    $locationProvider.hashPrefix("");

    $routeProvider
        .when('/login', {
            templateUrl: 'views/login.html',
            controller: 'LoginController'
        })
        .otherwise({
            redirectTo: '/login'
        });
});