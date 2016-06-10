/**
 * ModalController
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

		mainApp.controller('ModalController', function($scope, $modal, $log) {

		console.log('ModalController Call');

		$scope.items = [ 'item1', 'item2', 'item3' ];

		$scope.open = function(size) {

			var modalInstance = $modal.open({
				templateUrl : 'partials/views/components/myModalContent.html',
				// 모달 인스턴스 컨트롤러를 따로 만들어야 한다.
				controller : 'ModalInstanceCtrl',
				size : size,
				resolve : {
					items : function() {
						return $scope.items;
					}
				}
			});

			// 모달이 종료되면 모달에서 선택된 값과 로그 출력
			modalInstance.result.then(function(selectedItem) {
				$scope.selected = selectedItem;
			}, function() {
				$log.info('Modal dismissed at: ' + new Date());
			});

		};
	});

	mainApp.controller('ModalInstanceCtrl', function($scope, $modalInstance,
			items) {
		$scope.items = items;
		$scope.selected = {
			item : $scope.items[0]
		};

		$scope.ok = function() {
			$modalInstance.close($scope.selected.item);
		};

		$scope.cancel = function() {
			$modalInstance.dismiss('cancel');
		};
	});

});

