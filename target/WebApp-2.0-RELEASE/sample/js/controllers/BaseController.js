/**
 * BaseController index.html 컨트롤러( 최상위 컨트롤러)
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

	mainApp.controller('BaseController', function($scope) {

		console.log('BaseControoler Call');

		$scope.stylesheets = [];
		$scope.spinner={'active':false};

		// CSS Dynamic Load
		$scope.$on('updateCSS', function(event, args) {

			$scope.stylesheets.push(args);
		});
		
		$scope.$on('Spinner',function(event,args){
			
			$scope.spinner={'active':args};
			
			
		});
		

		
	});

});