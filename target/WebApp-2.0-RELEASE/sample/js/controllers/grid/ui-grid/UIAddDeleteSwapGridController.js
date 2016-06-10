/**
 * UIAddDeleteSwapGridController
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

		mainApp.controller('UIAddDeleteSwapGridController', function($scope,httpFactory,dialogs) {

		console.log('UIAddDeleteSwapGridController Call');
		$scope.$emit('updateCSS', 'css/ui-grid/ui-grid-default.css');
		$scope.$emit('Spinner',true);
		
		httpFactory.getHttp('../angular_grid/selectList').then(function(response) {
			
			$scope.myData = response.data.rows;
			$scope.gridOptions.data = response.data.rows;
			$scope.$emit('Spinner',false);

		}, function(error) {
			$scope.$emit('Spinner',false);
			 dialogs.notify('실패','로딩 실패!');
		});

		$scope.swapData = function() {
			if ($scope.gridOptions.data === $scope.myData) {

				$scope.gridOptions.data = data2;
				$scope.gridOptions.columnDefs = columnDefs2;
			} else {

				$scope.gridOptions.data = $scope.myData;
				$scope.gridOptions.columnDefs = columnDefs1;
			}
		};

		$scope.addData = function() {
			var n = $scope.gridOptions.data.length + 1;
			$scope.gridOptions.data.push({
				"id" : n,
				"firstName" : "New " + n,
				"lastName" : "Person " + n,
				"company" : "ABC",
				"age" : "30",
				"address" : "Bundang"
			});
		};

		$scope.removeFirstRow = function() {
			if ($scope.gridOptions.data.length > 1) {
				$scope.gridOptions.data.splice(0, 1);
			} else
				console.log('Last Data!');
		};

		var columnDefs1 = [ {
			name : 'id',
			field : 'id'
		}, {
			name : '이름',
			field : 'firstName'
		}, {
			name : '성',
			field : 'lastName'
		}, {
			name : '회사',
			field : 'company'
		}, {
			name : '나이',
			field : 'age'
		} ];
		var columnDefs2 = [ {
			name : 'id',
			field : 'id'
		}, {
			name : '이름',
			field : 'firstName'
		}, {
			name : '성',
			field : 'lastName'
		}, {
			name : '회사',
			field : 'company'
		}, {
			name : '주소',
			field : 'address'
		} ];
		var data2 = [ {
			"id" : "1",
			"firstName" : "Cox",
			"lastName" : "Carney",
			"company" : "Enormo",
			"address" : "Seoul"
		}, {
			"id" : "2",
			"firstName" : "Lorraine",
			"lastName" : "Wise",
			"company" : "Comveyer",
			"address" : "Busan"
		} ];

		$scope.gridOptions = {

			columnDefs : columnDefs1,

		};

	});
});
