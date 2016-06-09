/**
 * CRUDFormController
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

		mainApp.controller('CRUDFormController', function($scope, dialogs,httpFactory, $route) {

		console.log('CRUDFormController Call');
		$scope.$emit('updateCSS', 'css/ui-grid/ui-grid.css');
		$scope.$emit('Spinner',true);

		httpFactory.getHttp('../angular_form/selectList').then(function(response) {
			console.log(response);
			$scope.myData = response.data.rows;
			$scope.$emit('Spinner',false);

		}, function(error) {
			$scope.$emit('Spinner',false);
			 dialogs.notify('실패','로딩 실패!');
		});

		$scope.gridOptions = {
			data : 'myData',
			enableSorting : true,
			columnDefs : [ {
				name : 'id',
				field : 'id'
			}, {
				name : 'email',
				field : 'email'
			}, {
				name : '이름',
				field : 'username'
			}, {
				name : '핸드폰번호',
				field : 'cellphone'
			}, {
				name : '축구',
				field : 'soccer'
			}, {
				name : '야구',
				field : 'baseball'
			}, {
				name : '농구',
				field : 'basketball'
			}, {
				name : '배구',
				field : 'volleyball'
			}, {
				name : '연령',
				field : 'agegroup'
			}, ]

		};

		$scope.cellnos = [{
			number : '011'
		}, {
			number : '010'
		}
		];

		$scope.signupForm = function(form) {

			if (form.$valid) {

				if ($scope.selectedCounter >= 2) {
					console.log($scope.signup);

					var data = {
						'email' : $scope.signup.email,
						'password' : $scope.signup.password,
						'username' : $scope.signup.username,
						'cellphone' : $scope.signup.number0.number + '-'
								+ $scope.signup.number1 + '-'
								+ $scope.signup.number2,
						'soccer' : $scope.signup.favorite.soccer,
						'baseball' : $scope.signup.favorite.baseball,
						'basketball' : $scope.signup.favorite.basketball,
						'volleyball' : $scope.signup.favorite.volleyball,
						'agegroup' : $scope.signup.agegroup,

					};
					console.log(data);
					httpFactory.postHttp('../angular_form/update?oper=add', data)
							.then(function(response) {

								if (response.data.flag == 1) {

									dialogs.notify('알림', '등록 완료!');
									$route.reload();
								} else {
									dialogs.error('알림', '등록 실패!');
									$route.reload();
								}

							}, function(error) {
								dialogs.error('알림', '등록 실패!');
								console.log(error);
							});

				} else {
					dialogs.error('알림', '관심사를 2개 이상 입력해주세요!');
				}
			}
		};

		$scope.selectedCounter = 0;
		$scope.update = function(item) {
			if (item) {
				$scope.selectedCounter++;
			} else {
				$scope.selectedCounter--;
			}
		};

		mainApp.directive('ensureUnique', function($http) {
			return {
				require : 'ngModel',
				link : function(scope, ele, attrs, c) {
					scope.$watch(attrs.ngModel, function() {

						// 임시
						// c.$setValidity('unique',false);
						// 
						c.$setValidity('unique', true);

						//						        $http({
						//						          method: 'POST',
						//						          url: '/api/check/' + attrs.ensureUnique,
						//						          data: {'field': attrs.ensureUnique}
						//						        }).success(function(data, status, headers, cfg) {
						//						          c.$setValidity('unique', data.isUnique);      // 서버에 오훛하여 Unique 확인
						//						        }).error(function(data, status, headers, cfg) {
						//						          c.$setValidity('unique', false);
						//						        });

					});
				}
			};

		});
	});

});
