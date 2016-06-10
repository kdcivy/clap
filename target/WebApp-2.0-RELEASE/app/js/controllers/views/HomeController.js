/**
 * HomeController - home 화면 컨트롤러
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

		mainApp.controller('HomeController', function($scope) {

		console.log('HomeController Call');
		$scope.$emit('updateCSS', 'css/nv.d3.min.css');

		$scope.options = {
			chart : {
				type : 'lineChart',
				height : 180,
				margin : {
					top : 20,
					right : 20,
					bottom : 40,
					left : 55
				},
				x : function(d) {
					return d.x;
				},
				y : function(d) {
					return d.y;
				},
				useInteractiveGuideline : true,
				transitionDuration : 500,
				yAxis : {
					tickFormat : function(d) {
						return d3.format('.01f')(d);
					}
				}
			},
			title : {
				enable : true,
				text : "CPU Performance"
			},
			subtitle : {
				enable : true,
				text : 'Host1에 대한 CPU 값입니다.'
			},
			caption : {
				enable : true,
				text : "Figure 1. AngularJS Framework"
			}
		};

		$scope.options1 = angular.copy($scope.options);
		$scope.options1.chart.transitionDuration = 1;
		$scope.options1.chart.yDomain = [ -1, 1 ];

		$scope.data = [ {
			values : [],
			key : 'CPU'
		} ];

		$scope.run = true;

		var x = 0;
		setInterval(function() {
			if (!$scope.run)
				return;
			$scope.data[0].values.push({
				x : x,
				y : Math.random()
			});
			if ($scope.data[0].values.length > 20)
				$scope.data[0].values.shift();
			x++;
			$scope.$apply();
		}, 500);

	});
});