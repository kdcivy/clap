/**
 * PieChartController 
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

		mainApp.controller('PieChartController', function($scope) {

		console.log('PieChartController Call');
		$scope.$emit('updateCSS', 'css/nv.d3.min.css');

		$scope.options = {
	            chart: {
	                type: 'pieChart',
	                height: 500,
	                x: function(d){return d.key;},
	                y: function(d){return d.y;},
	                showLabels: true,
	                transitionDuration: 500,
	                labelThreshold: 0.01,
	                legend: {
	                    margin: {
	                        top: 5,
	                        right: 35,
	                        bottom: 5,
	                        left: 0
	                    }
	                }
	            }
	        };

	        $scope.data = [
	            {
	                key: "One",
	                y: 5
	            },
	            {
	                key: "Two",
	                y: 2
	            },
	            {
	                key: "Three",
	                y: 9
	            },
	            {
	                key: "Four",
	                y: 7
	            },
	            {
	                key: "Five",
	                y: 4
	            },
	            {
	                key: "Six",
	                y: 3
	            },
	            {
	                key: "Seven",
	                y: .5
	            }
	        ];

	});
});