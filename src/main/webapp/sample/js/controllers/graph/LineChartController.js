/**
 * LineChartController 
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

		mainApp.controller('LineChartController', function($scope) {

		console.log('LineChartController Call');
		$scope.$emit('updateCSS', 'css/nv.d3.min.css');

		 $scope.options = {
		            chart: {
		                type: 'lineChart',
		                height: 450,
		                margin : {
		                    top: 20,
		                    right: 20,
		                    bottom: 40,
		                    left: 55
		                },
		                x: function(d){ return d.x; },
		                y: function(d){ return d.y; },
		                useInteractiveGuideline: true,
		                dispatch: {
		                    stateChange: function(e){ console.log("stateChange"); },
		                    changeState: function(e){ console.log("changeState"); },
		                    tooltipShow: function(e){ console.log("tooltipShow"); },
		                    tooltipHide: function(e){ console.log("tooltipHide"); }
		                },
		                xAxis: {
		                    axisLabel: 'Time (ms)'
		                },
		                yAxis: {
		                    axisLabel: 'Voltage (v)',
		                    tickFormat: function(d){
		                        return d3.format('.02f')(d);
		                    },
		                    axisLabelDistance: 30
		                },
		                callback: function(chart){
		                    console.log("!!! lineChart callback !!!");
		                }
		            },
		            title: {
		                enable: true,
		                text: 'Title for Line Chart'
		            },
		            subtitle: {
		                enable: true,
		                text: 'Subtitle for simple line chart.',
		                css: {
		                    'text-align': 'center',
		                    'margin': '10px 13px 0px 7px'
		                }
		            },
		            caption: {
		                enable: true,
		                text: 'Figure 1. Line Chart',
		                css: {
		                    'text-align': 'justify',
		                    'margin': '10px 13px 0px 7px'
		                }
		            }
		        };

		        $scope.data = sinAndCos();

		        /*Random Data Generator */
		        function sinAndCos() {
		            var sin = [],sin2 = [],
		                cos = [];

		            //Data is represented as an array of {x,y} pairs.
		            for (var i = 0; i < 100; i++) {
		                sin.push({x: i, y: Math.sin(i/10)});
		                sin2.push({x: i, y: i % 10 == 5 ? null : Math.sin(i/10) *0.25 + 0.5});
		                cos.push({x: i, y: .5 * Math.cos(i/10+ 2) + Math.random() / 10});
		            }

		            //Line chart data should be sent as an array of series objects.
		            return [
		                {
		                    values: sin,      //values - represents the array of {x,y} data points
		                    key: 'Sine Wave', //key  - the name of the series.
		                    color: '#ff7f0e'  //color - optional: choose your own line color.
		                },
		                {
		                    values: cos,
		                    key: 'Cosine Wave',
		                    color: '#2ca02c'
		                },
		                {
		                    values: sin2,
		                    key: 'Another sine wave',
		                    color: '#7777ff',
		                    area: true      //area - set to true if you want this line to turn into a filled area chart.
		                }
		            ];
		        };

	});
});