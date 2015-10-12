//angular.module('app', ['ngRoute']);


angular.module('hello', [ 'ngRoute' ])
	
	.config(function($routeProvider, $httpProvider) {
		
		$routeProvider.when('/', {
				templateUrl : 'templates/home.html',
				controller : 'HomeCtrl'
			})
			.when('/login', {
				templateUrl : 'templates/login.html',
				//templateUrl : 'login',
				controller : 'LoginCtrl'
			})
			.otherwise('/');

	})
	
	.controller('LoginCtrl', function($scope, $location, $route, LoginService) {
		
		$scope.login = function () {
			LoginService.login($scope.credentials.username, $scope.credentials.password, function (response) {
				$scope.success = response.data.message;
			});
		};

	})
	
	.controller('HomeCtrl', function($scope, $http) {
	
	})
	
	.service('LoginService', function ($http) {
		this.login = function (username, password, callback) {
			$http({
				method: 'POST',
				url: '/login',
				headers: {
					Authorization: 'Basic ' + btoa(username + ':' + password)
				}
			}).then(function (response) {
				console.log(response);
				callback(response.data);
			});
		};
		
		this.isAuthenticated = function () {
			
		};
		
		this.logout = function () {
			
		};
		
		this.getUser = function () {
			
		};
		
	});
