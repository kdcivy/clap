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
     
        { "roleName" : "Forms", 				 "link": "#/", 						"children" : [
        { "roleName" : "Web Form", 				 "link": "#/webform",				"children" : []},
        { "roleName" : "Validation Form", 		 "link": "#/valiform",				"children" : []},
        { "roleName" : "Contact Form",			 "link": "#/contactform",  	  		"children" : []},
        { "roleName" : "CRUD Form",				 "link": "#/crudform",  	  		"children" : []}
      ]},
        { "roleName" : "Grid", 					 "link": "#/", 						"children" : [
        { "roleName" : "ngGrid", 				 "link": "#/", 						"children" : [
        { "roleName" : "Basic Grid",	 		 "link": "#/ng-basic_grid",			"children" : []},
        { "roleName" : "Grouping Grid",	 		 "link": "#/ng-group_grid",			"children" : []},
        { "roleName" : "Row Tempalte Grid",		 "link": "#/ng-rowtemplate_grid",	"children" : []},
        { "roleName" : "Selection Grid",		 "link": "#/ng-selection_grid",		"children" : []},
        { "roleName" : "Editable Grid",			 "link": "#/ng-editable_grid",		"children" : []},
        { "roleName" : "Pinning Grid",			 "link": "#/ng-pinning_grid",		"children" : []},
        { "roleName" : "CSS Style 적용",			 "link": "#/ng-style_grid",			"children" : []}
        ]},
        { "roleName" : "uiGrid", 				 "link": "#/", 						"children" : [
        { "roleName" : "Basic Grid",	 		 "link": "#/ui-basic_grid",			"children" : []},
		{ "roleName" : "Editable Grid", 		 "link": "#/ui-editable_grid",		"children" : []},
		{ "roleName" : "Filter Grid", 			 "link": "#/ui-filter_grid",		"children" : []},
		{ "roleName" : "Add/Delete/Swap Grid",   "link": "#/ui-ads_grid",	    	"children" : []},
		{ "roleName" : "Menu Grid",  			 "link": "#/ui-menu_grid",	     	"children" : []},
		{ "roleName" : "Pagination Grid",  		 "link": "#/ui-pagination_grid",	"children" : []},
		{ "roleName" : "[PPAS] CRUD Grid",		 "link": "#/ui-crud_grid",			"children" : []},
		{ "roleName" : "[MySQL] CRUD Grid",		 "link": "#/ui-crud_grid_mysql",	"children" : []},
		{ "roleName" : "ETC Grid",  	     	 "link": "#/ui-etc_grid",			"children" : []},
		{ "roleName" : "CSS Style 적용",  	   	 "link": "#/ui-style_grid",			"children" : []}
	  ]}]},
    	{ "roleName" : "Graph",	 				 "link": "#/",		 				"children" : [
    	{ "roleName" : "LineChart Graph",		 "link": "#/linechart",				"children" : []},
    	{ "roleName" : "Cumulative Graph",		 "link": "#/cumulative",			"children" : []},
    	{ "roleName" : "StakedArea Graph",		 "link": "#/stackedarea",			"children" : []},
    	{ "roleName" : "MultiBar Graph",		 "link": "#/multibar",				"children" : []},
    	{ "roleName" : "MultlBar(horizon) Graph","link": "#/mulbibarhorizontal",	"children" : []},
    	{ "roleName" : "Discrete Graph",		 "link": "#/discrete",				"children" : []},
    	{ "roleName" : "Pie Graph",		 	 	 "link": "#/piechart",				"children" : []},
    	{ "roleName" : "Scatter Graph",			 "link": "#/scatterchart",			"children" : []},
    	{ "roleName" : "Donut Graph",		 	 "link": "#/donutchart",			"children" : []},
    	{ "roleName" : "Bullet Graph",			 "link": "#/bulletchart",			"children" : []},
	    { "roleName" : "Realtime Graph",		 "link": "#/realtime",				"children" : []},
	  ]},
        { "roleName" : "Components",	 		 "link": "#/",		 				"collapsed" : true, "children" : [
		{ "roleName" : "Accordion",				 "link": "#/accordion",				"children" : []},
		{ "roleName" : "Alert", 				 "link": "#/alert",					"children" : []},
		{ "roleName" : "Button", 				 "link": "#/button",				"children" : []},
		{ "roleName" : "Modal", 				 "link": "#/modal",					"children" : []},
		{ "roleName" : "DatePicker",			 "link": "#/datepicker",			"children" : []},
		{ "roleName" : "Dropdown", 				 "link": "#/dropdown",				"children" : []},
		{ "roleName" : "Tab", 		    		 "link": "#/tab",					"children" : []},
		{ "roleName" : "ProgressBar", 			 "link": "#/progressbar",			"children" : []},
		{ "roleName" : "TypeAhead",				 "link": "#/typeahead",				"children" : []}
	  ]}

     ];

	  // link로 이동
      $scope.$watch('menuTree.currentNode', function(newValue){
        if( $scope.menuTree && angular.isObject($scope.menuTree.currentNode) ) {
          $window.location=$scope.menuTree.currentNode['link'];
        }
      },true);

 

    });
});

