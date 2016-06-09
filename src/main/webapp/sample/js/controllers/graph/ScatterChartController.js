/**
 * ScatterChartController 
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

		mainApp.controller('ScatterChartController', function($scope) {

		console.log('ScatterChartController Call');
		$scope.$emit('updateCSS', 'css/nv.d3.min.css');

		$scope.options = {
	            chart: {
	                type: 'scatterChart',
	                height: 450,
	                color: d3.scale.category10().range(),
	                scatter: {
	                    onlyCircles: false
	                },
	                showDistX: true,
	                showDistY: true,
	                tooltipContent: function(key) {
	                    return '<h3>' + key + '</h3>';
	                },
	                transitionDuration: 350,
	                xAxis: {
	                    axisLabel: 'X Axis',
	                    tickFormat: function(d){
	                        return d3.format('.02f')(d);
	                    }
	                },
	                yAxis: {
	                    axisLabel: 'Y Axis',
	                    tickFormat: function(d){
	                        return d3.format('.02f')(d);
	                    },
	                    axisLabelDistance: 30
	                }
	            }
	        };

	        $scope.data = generateData(4,40);

	        /* Random Data Generator (took from nvd3.org) */
	        function generateData(groups, points) {
	            var data = [],
	                shapes = ['circle', 'cross', 'triangle-up', 'triangle-down', 'diamond', 'square'],
	                random = d3.random.normal();

	            for (var i = 0; i < groups; i++) {
	                data.push({
	                    key: 'Group ' + i,
	                    values: []
	                });

	                for (var j = 0; j < points; j++) {
	                    data[i].values.push({
	                        x: random()
	                        , y: random()
	                        , size: Math.random()
	                        , shape: shapes[j % 6]
	                    });
	                }
	            }
	            return data;
	        }

	});
});