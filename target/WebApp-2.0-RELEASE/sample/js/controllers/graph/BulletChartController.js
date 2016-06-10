/**
 * BulletChartController 
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

		mainApp.controller('BulletChartController', function($scope) {

		console.log('BulletChartController Call');
		$scope.$emit('updateCSS', 'css/nv.d3.min.css');

		 $scope.options = {
		            chart: {
		                type: 'bulletChart',
		                transitionDuration: 500
		            }
		        };

		        $scope.data = {
		            "title": "Revenue",
		            "subtitle": "US$, in thousands",
		            "ranges": [150,225,300],
		            "measures": [220],
		            "markers": [250]
		        };
	});
});