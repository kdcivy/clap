var employeeApp = angular.module('employeeApp',[]);
var rootContext = "/";
employeeApp.controller('getEmployeeList', function($scope,$http) {
    $http.get(rootContext + 'sample/employeeList1.json').
    success(function(data) {
        $scope.employees = data;
    });
});
/*
angular.module('hello', [])
  .controller('home', function($scope,$http) {
	    $http.get('/webmvcsample/sample/employeeList1.json').
        success(function(data) {
            $scope.greeting = data;
        });
});
*/