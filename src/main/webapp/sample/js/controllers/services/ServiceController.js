/**
 * ServiceController
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
	'services/ServiceTest'
	],

	function (mainApp){

		mainApp.controller('ServiceController', function($scope, ServiceTest) {

		console.log('ServiceController Call');

		$scope.hello = ServiceTest.sayHello("World");

	});

});
		
	