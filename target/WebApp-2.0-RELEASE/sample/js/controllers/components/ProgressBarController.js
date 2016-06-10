/**
 * ProgressBarController
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

	  mainApp.controller('ProgressBarController', function($scope){
			
	  console.log('ProgressBarController Call');
      $scope.max = 200;

      $scope.random = function() {
        var value = Math.floor((Math.random() * 100) + 1);
        var type;

        if (value < 25) {
          type = 'success';
        } else if (value < 50) {
          type = 'info';
        } else if (value < 75) {
          type = 'warning';
        } else {
          type = 'danger';
        }

        $scope.showWarning = (type === 'danger' || type === 'warning');

        $scope.dynamic = value;
        $scope.type = type;
      };
      $scope.random();

      $scope.randomStacked = function() {
        $scope.stacked = [];
        var types = ['success', 'info', 'warning', 'danger'];

        for (var i = 0, n = Math.floor((Math.random() * 4) + 1); i < n; i++) {
          var index = Math.floor((Math.random() * 4));
          $scope.stacked.push({
            value: Math.floor((Math.random() * 30) + 1),
            type: types[index]
          });
        }
      };
      $scope.randomStacked();


    });
});

