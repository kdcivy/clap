/**
 * DropDownController
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

		mainApp.controller('DropDownController', function($scope){

					
		console.log('DropDownController Call');

		// dropdown 메뉴
		$scope.items = [ 'The first choice!', 'And another choice for you.',
				'but wait! A third!' ];

		$scope.status = {
			isopen : false
		};

		// 토글 버튼 드롭다운
		$scope.toggleDropdown = function($event) {
			$event.preventDefault();
			$event.stopPropagation();
			$scope.status.isopen = !$scope.status.isopen;
		};
	});
});
