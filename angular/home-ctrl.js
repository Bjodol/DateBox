function homeCtrl($scope, $log, $http){
	$http.get('static/dates.json')
		.then(function(res) {
			$scope.dates = res.data;
		});
};