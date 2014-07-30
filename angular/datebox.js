//entry point for the application
var app = angular.module('Cloudure',[
	'ui.router',
	'ui.bootstrap'
]);

//routing configuration for the application
app.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise("/");

	$stateProvider
		.state('home', {
			url: "/home",
			templateUrl: "",
			controller: homeCtrl
		})
});