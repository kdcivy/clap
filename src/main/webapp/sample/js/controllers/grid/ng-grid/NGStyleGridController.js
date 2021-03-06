/**
 * NGStyleGridController
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

		mainApp.controller('NGStyleGridController', function($scope, dialogs,httpFactory) {

		console.log('NGStyleGridController Call');

		$scope.$emit('updateCSS', 'css/ng-grid/ng-grid.css');
		$scope.$emit('updateCSS', 'css/ng-grid/jquery-ui.theme.css');
		
		$scope.$emit('Spinner',true);

		httpFactory.getHttp('../angular_grid/selectList').then(function(response) {
			console.log(response);
			$scope.myData = response.data.rows;
			$scope.$emit('Spinner',false);
		

		}, function(error) {
			$scope.$emit('Spinner',false);
			 dialogs.notify('실패','로딩 실패!');
			 
		});

		$scope.gridOptions = {
			data : 'myData',
			jqueryUITheme: true,
			columnDefs : [ {
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
			} ]

		};

	});
});
