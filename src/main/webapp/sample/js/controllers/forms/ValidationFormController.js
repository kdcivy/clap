/**
 * ValidationFormController
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

	function (mainApp){

		mainApp.controller('ValidationFormController', function($scope) {

		console.log('ValidationFormController Call');

		$scope.signupForm = function() {

			if ($scope.signup_form.$valid) {
				// Submit as normal
				console.log("Valid Form");
			} else {
				//$scope.signup_form.submitted = true;
				console.log("Invalid Form");
			}
		};

		$scope.selectedCounter = 0;
		$scope.update = function(item) {
			if (item.selected) {
				$scope.selectedCounter++;
			} else {
				$scope.selectedCounter--;
			}
		};

	});

	mainApp.directive('ensureUnique', function($http) {
		return {
			require : 'ngModel',
			link : function(scope, ele, attrs, c) {
				scope.$watch(attrs.ngModel, function() {

					// 임시
					// c.$setValidity('unique',false);
					// 
					c.$setValidity('unique', true);

					//			        $http({
					//			          method: 'POST',
					//			          url: '/api/check/' + attrs.ensureUnique,
					//			          data: {'field': attrs.ensureUnique}
					//			        }).success(function(data, status, headers, cfg) {
					//			          c.$setValidity('unique', data.isUnique);      // 서버에 오훛하여 Unique 확인
					//			        }).error(function(data, status, headers, cfg) {
					//			          c.$setValidity('unique', false);
					//			        });

				});
			}
		};

	});
});