var app = angular.module('inventoryApp', ['ngRoute']);

app.config(function($routeProvider, $locationProvider) {
    //  Remove the '!' so URLs look like #/login instead of #!/login
    $locationProvider.hashPrefix("");

    $routeProvider
        .when('/login', {
            templateUrl: 'views/login.html',
            controller: 'LoginController'
        })
        .when('/inventory', {
            templateUrl: 'views/inventory.html',
            controller: 'InventoryController'
        })
        .otherwise({
            redirectTo: '/login'
        });
});