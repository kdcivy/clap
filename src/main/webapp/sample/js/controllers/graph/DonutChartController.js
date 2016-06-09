/**
 * DonutChartController 
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

		mainApp.controller('DonutChartController', function($scope) {

		console.log('DonutChartController Call');
		$scope.$emit('updateCSS', 'css/nv.d3.min.css');

		$scope.options = {
	            chart: {
	                type: 'pieChart',
	                height: 450,
	                donut: true,
	                x: function(d){return d.key;},
	                y: function(d){return d.y;},
	                showLabels: true,

	                pie: {
	                    startAngle: function(d) { return d.startAngle/2 -Math.PI/2 },
	                    endAngle: function(d) { return d.endAngle/2 -Math.PI/2 }
	                },
	                transitionDuration: 500,
	                legend: {
	                    margin: {
	                        top: 5,
	                        right: 70,
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