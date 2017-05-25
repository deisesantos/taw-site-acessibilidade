angular
		.module('sempre-alerta-app', [ 'ngRoute', 'auth', 'navigation', 'patrulha'])
		.config(

				function($routeProvider, $httpProvider, $locationProvider) {

					$locationProvider.html5Mode(true);

					$routeProvider.when('/', {
						templateUrl : 'js/patrulha/patrulha.html',
						controller : 'patrulha',
						controllerAs : 'controller'
					}).when('/patrulha/add', {
						templateUrl : 'js/patrulha/addPatrulha.html',
						controller : 'patrulha',
						controllerAs : 'controller'
					}).when('/patrulha/edit', {
						templateUrl : 'js/patrulha/editPatrulha.html',
						controller : 'patrulha',
						controllerAs : 'controller'
					}).when('/login', {
						templateUrl : 'js/navigation/login.html',
						controller : 'navigation',
						controllerAs : 'controller'
					}).otherwise('/');

					$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

				}).run(function(auth) {

			// Initialize auth module with the home page and login/logout path
			// respectively
			auth.init('/', '/login', '/logout');

		});
