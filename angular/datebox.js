//entry point for the application
var app = angular.module('Datebox',[
	'ui.router',
	'ui.bootstrap',
]);

//routing configuration for the application
app.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise("/");

	$stateProvider
		.state('home', {
			url: "/home",
			templateUrl: "static/partials/home.html",
			controller: homeCtrl
		})
});