/**
 * SnBController - sidebar 메뉴 컨트롤러
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

		mainApp.controller('SnBController', function($scope,$window,$rootScope){
			
		console.log('SnBController Call');

		$scope.roleList= [
     
        { "roleName" : "Forms", 				 "link": "#/", 					"children" : [
        { "roleName" : "Web Form", 				 "link": "#/hello",				"children" : []},
        ]} 
        ];

      $scope.$watch('menuTree.currentNode', function(newValue){
        if( $scope.menuTree && angular.isObject($scope.menuTree.currentNode) ) {
          $window.location=$scope.menuTree.currentNode['link'];
        }
      },true);

 

    });
});

