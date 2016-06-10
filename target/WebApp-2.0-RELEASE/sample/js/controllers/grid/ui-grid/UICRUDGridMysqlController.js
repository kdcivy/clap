/**
 * UICRUDGridMysqlController
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
	'mainApp',
	'controllers/grid/ui-grid/UIaddDialogMysqlController',
	'factories/httpFactory'
	],

	function (mainApp){

		mainApp.controller('UICRUDGridMysqlController', function($scope,httpFactory,uiGridConstants,dialogs,$route){
			
		console.log('UICRUDGridMysqlController Call');
		$scope.$emit('updateCSS', 'css/ui-grid/ui-grid-default.css');
		$scope.$emit('Spinner',true);

		httpFactory.getHttp('../angular_grid_mysql/selectList').
		 then( function(response){
			 console.log(response);
			 $scope.myData = response.data.rows;
			 $scope.$emit('Spinner',false);
			 
		 }, function(error){
			 $scope.$emit('Spinner',false);
			 dialogs.notify('실패','로딩 실패!');
		 });
		
		 
	
         
      $scope.gridOptions = { 
                data: 'myData',
                enableSorting: true,
                multiSelect : false,
                noUnselect : true,
                enableRowHeaderSelection: false, 
                columnDefs: [
                  { name:'emp_no', field: 'emp_no' },
                  { name:'birth_date', field: 'birth_date' },
                  { name:'first_name', field: 'first_name' },
                  { name:'last_name', field: 'last_name'},
                  { name:'gender', field: 'gender'},
                  { name:'hire_date', field: 'hire_date'}
                ]
                
            };

      $scope.gridOptions.onRegisterApi = function( gridApi ) {
    	    $scope.gridApi = gridApi;
    	  
    	    
    	    gridApi.selection.on.rowSelectionChanged($scope,function(row){
    	    	  $scope.selected= $scope.gridApi.selection.getSelectedRows()[0];
    	    	  $scope.info = angular.copy($scope.selected);
    	    	  $scope.isSelect='true';
    	      });
    	    
    	 
    	  };
    	  
    	  $scope.addForm = function(){

    		var dlg = dialogs.create('partials/views/grid/ui-grid/ui_crud_grid_add_mysql.html','UIaddDialogMysqlController',{},{size:'lg'});
    		
    		dlg.result.then(function(info){
    			var data ={'emp_no':info.emp_no,'birth_date':info.birth_date,'first_name':info.first_name,'last_name':info.last_name,'gender':info.gender,'hire_date':info.hire_date};
    			//var params = {'oper':'add'};
    			console.log(data);
    			 httpFactory.postHttp('../angular_grid_mysql/insert',data).
    			 then( function(response){
 
       				  if (  response.data.flag == 1 ) {

       					  dialogs.notify('알림','등록 완료!');
       	    			  $route.reload();
       	    		  }
       	    		  else {
       	    			  dialogs.error('알림','등록 실패!');
       	    			  $route.reload();
       	    	      }
       				  
    
       			 }, function(error){
       				 console.log(error);
       			 });
    			 
    		},function(){
    			console.log('user cancel'); 
    		});
    		  
    	  };
    	  
    });

});

