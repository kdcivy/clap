/**
 * DatePickerController
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
	'mainApp'
	],

	function(mainApp) {

	mainApp.controller('DatePickerController', function($scope) {

		console.log('DatePickerController Call');

		// 달력 모델 생성
		$scope.today = function() {
			$scope.dt = new Date();
		};
		$scope.today();

		// 달력 초기화
		$scope.clear = function() {
			$scope.dt = null;
		};

		//이전 날짜는 disable
		$scope.toggleMin = function() {
			$scope.minDate = $scope.minDate ? null : new Date();
		};
		$scope.toggleMin();

		// 달력 오픈
		$scope.open = function($event) {
			$event.preventDefault();
			$event.stopPropagation();

			$scope.opened = true;
		};

		// 옵션
		$scope.dateOptions = {
			formatYear : 'yy',
			startingDay : 1
		};


		$scope.formats = [ 'dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy','shortDate' ];
		$scope.format = $scope.formats[1];

	});
});
