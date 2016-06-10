/**
 * NGPinningGridController
 * 
 * @author SW기술연구소
 * @since 2015. 05. 01
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일          수정자                수정내용
 *  -------    --------    ---------------------------
 *  2015.05.01 SW기술연구소              최초생성
 * 
 * </pre>
 */
'use strict';

define ([
	'mainApp',
	'factories/httpFactory'
	],

	function (mainApp){

		mainApp.controller('NGPinningGridController', function($scope, dialogs,httpFactory) {

		console.log('NGPinningGridController Call');

		$scope.$emit('updateCSS', 'css/ng-grid/ng-grid.css');
		
		 $scope.myData = [{ name: "Moroni", age: 50, birthday: "Oct 28, 1970", salary: "60,000" },
		                    { name: "Tiancum", age: 43, birthday: "Feb 12, 1985", salary: "70,000" },
		                    { name: "Jacob", age: 27, birthday: "Aug 23, 1983", salary: "50,000" },
		                    { name: "Nephi", age: 29, birthday: "May 31, 2010", salary: "40,000" },
		                    { name: "Enos", age: 34, birthday: "Aug 3, 2008", salary: "30,000" },
		                    { name: "Moroni", age: 50, birthday: "Oct 28, 1970", salary: "60,000" },
		                    { name: "Tiancum", age: 43, birthday: "Feb 12, 1985", salary: "70,000" },
		                    { name: "Jacob", age: 27, birthday: "Aug 23, 1983", salary: "40,000" },
		                    { name: "Nephi", age: 29, birthday: "May 31, 2010", salary: "50,000" },
		                    { name: "Enos", age: 34, birthday: "Aug 3, 2008", salary: "30,000" },
		                    { name: "Moroni", age: 50, birthday: "Oct 28, 1970", salary: "60,000" },
		                    { name: "Tiancum", age: 43, birthday: "Feb 12, 1985", salary: "70,000" },
		                    { name: "Jacob", age: 27, birthday: "Aug 23, 1983", salary: "40,000" },
		                    { name: "Nephi", age: 29, birthday: "May 31, 2010", salary: "50,000" },
		                    { name: "Enos", age: 34, birthday: "Aug 3, 2008", salary: "30,000" }];
		

		$scope.gridOptions = {
			data : 'myData',
			enablePinning: true,
			columnDefs: [{ field: "name", width: 120, pinned: true },
		                    { field: "age", width: 120 },
		                    { field: "birthday", width: 120 },
		                    { field: "salary", width: 120 }]

		};

	});
});
