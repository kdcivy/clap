/**
 * MultiBarChartController 
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

		mainApp.controller('MultiBarChartController', function($scope) {

		console.log('MultiBarChartController Call');
		$scope.$emit('updateCSS', 'css/nv.d3.min.css');

		$scope.options = {
	            chart: {
	                type: 'multiBarChart',
	                height: 450,
	                margin : {
	                    top: 20,
	                    right: 20,
	                    bottom: 60,
	                    left: 45
	                },
	                clipEdge: true,
	                staggerLabels: true,
	                transitionDuration: 500,
	                stacked: true,
	                xAxis: {
	                    axisLabel: 'Time (ms)',
	                    showMaxMin: false,
	                    tickFormat: function(d){
	                        return d3.format(',f')(d);
	                    }
	                },
	                yAxis: {
	                    axisLabel: 'Y Axis',
	                    axisLabelDistance: 40,
	                    tickFormat: function(d){
	                        return d3.format(',.1f')(d);
	                    }
	                }
	            }
	        };

	        $scope.data = generateData();

	        /* Random Data Generator (took from nvd3.org) */
	        function generateData() {
	            return stream_layers(3,50+Math.random()*50,.1).map(function(data, i) {
	                return {
	                    key: 'Stream' + i,
	                    values: data
	                };
	            });
	        }

	        /* Inspired by Lee Byron's test data generator. */
	        function stream_layers(n, m, o) {
	            if (arguments.length < 3) o = 0;
	            function bump(a) {
	                var x = 1 / (.1 + Math.random()),
	                    y = 2 * Math.random() - .5,
	                    z = 10 / (.1 + Math.random());
	                for (var i = 0; i < m; i++) {
	                    var w = (i / m - y) * z;
	                    a[i] += x * Math.exp(-w * w);
	                }
	            }
	            return d3.range(n).map(function() {
	                var a = [], i;
	                for (i = 0; i < m; i++) a[i] = o + o * Math.random();
	                for (i = 0; i < 5; i++) bump(a);
	                return a.map(stream_index);
	            });
	        }

	        /* Another layer generator using gamma distributions. */
	        function stream_waves(n, m) {
	            return d3.range(n).map(function(i) {
	                return d3.range(m).map(function(j) {
	                    var x = 20 * j / m - i / 3;
	                    return 2 * x * Math.exp(-.5 * x);
	                }).map(stream_index);
	            });
	        }

	        function stream_index(d, i) {
	            return {x: i, y: Math.max(0, d)};
	        }

	});
});