/**
 * TabController
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

		mainApp.controller('TabController', function($scope, $window) {

		console.log('TabController Call');

		// Tab Contents
		$scope.tabs = [ {
			title : 'Dynamic Title 1',
			content : 'Dynamic content 1'
		}, {
			title : 'Dynamic Title 2',
			content : 'Dynamic content 2',
			disabled : true
		} ];
		// alert Tab
		$scope.alertMe = function() {
			$window.alert('You\'ve selected the alert tab!');
		};

	});
});
