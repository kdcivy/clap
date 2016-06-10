/**
 * AlertController
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

	mainApp.controller('AlertController', function($scope, $alert) {

		console.log('AlertController Call');
		$scope.alert = {
			"title" : "Alert입니다!",
			"content" : "N-Root Framework 입니다.",
			"type" : "info"
		};

		// 로딩될때 바로 실행
		$alert({
			title : 'Alert입니다!',
			content : 'N-Root Framework입니다.',
			container : '.ngViewArea',
			type : 'info',
			show : true
		});

	});
});
