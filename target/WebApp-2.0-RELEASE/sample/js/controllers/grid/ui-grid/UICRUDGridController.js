/**
 * UICRUDGridController
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
	'controllers/grid/ui-grid/UIaddDialogController',
	'factories/httpFactory'
	],

	function (mainApp){

		mainApp.controller('UICRUDGridController', function($scope,httpFactory,uiGridConstants,dialogs,$route){
			
		console.log('UICRUDGridController Call');
		$scope.$emit('updateCSS', 'css/ui-grid/ui-grid-default.css');
		$scope.$emit('Spinner',true);

		httpFactory.getHttp('../angular_grid/selectList').
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
                  { name:'id', field: 'id' },
                  { name:'이름', field: 'firstName' },
                  { name:'성', field: 'lastName' },
                  { name:'회사', field: 'company'},
                  { name:'나이', field: 'age'},
                  { name:'삭제', cellTemplate:' <button type="button" class="btn btn-danger" ng-click="grid.appScope.deleteForm1(row.entity)">삭제</button>' },
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

    		var dlg = dialogs.create('partials/views/grid/ui-grid/ui_crud_grid_add.html','UIaddDialogController',{},{size:'lg'});
    		
    		dlg.result.then(function(info){
    			var data ={'firstName':info.firstName,'lastName':info.lastName,'age':info.age,'company':info.company};
    			//var params = {'oper':'add'};
    			console.log(data);
    			 httpFactory.postHttp('../angular_grid/update?oper=add',data).
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
    	 
    	  $scope.modifyForm = function(){
    		  
    		  var data = {'id':$scope.info.id,'firstName':$scope.info.firstName,'lastName':$scope.info.lastName,'age':$scope.info.age,'company':$scope.info.company};
    		  var dlg = dialogs.confirm('확인','ID : '+$scope.info.id+' 을 정말 수정하시겠습니까?');
    		  
    		  dlg.result.then(function(btn){
    			  
        		  httpFactory.postHttp('../angular_grid/update?oper=edit',data).
        		  then( function(response){
        				 
        				 
        				  if (  response.data.flag == 1 ) {

        					  dialogs.notify('알림','수정 완료!');
        	    			  $route.reload();
        	    		  }
        	    		  else {
        	    			  dialogs.error('알림','수정 실패!');
        	    			  $route.reload();
        	    	      }
        				  
     
        			 }, function(error){
        				 console.log(error);
        			 });
    		  },function(){
    			 console.log('user cancel'); 
    		  });
    		  
    		
    		  
    	  };
    	  
    	  
    	  $scope.deleteForm = function(){
    		  
    		  var data = {'id':$scope.info.id};
    		  var dlg = dialogs.confirm('확인','ID : '+$scope.info.id+' 을 정말 삭제하시겠습니까?');
    		  
    		  dlg.result.then(function(btn){
    			  
        		  httpFactory.postHttp('../angular_grid/update?oper=del',data).
        		  then( function(response){
        				 
        				 
        				  if (  response.data.flag == 1 ) {

        					  dialogs.notify('알림','삭제 완료!');
        	    			  $route.reload();
        	    		  }
        	    		  else {
        	    			  dialogs.error('알림','삭제 실패!');
        	    			  $route.reload();
        	    	      }
        				  
     
        			 }, function(error){
        				 console.log(error);
        			 });
    		  },function(btn){
    			 console.log('user cancel'); 
    		  });
	  
    		
    		  
    	  };
    	  
    	  $scope.deleteForm1 = function(val){
    		  var data = {'id':val.id};
    		  var dlg = dialogs.confirm('확인','ID : '+val.id+' 을 정말 삭제하시겠습니까?');
    		  
    		  dlg.result.then(function(btn){
    			  
        		  httpFactory.postHttp('../angular_grid/update?oper=del',data).
        		  then( function(response){
        				 
        				 
        				  if (  response.data.flag == 1 ) {

        					  dialogs.notify('알림','삭제 완료!');
        	    			  $route.reload();
        	    		  }
        	    		  else {
        	    			  dialogs.error('알림','삭제 실패!');
        	    			  $route.reload();
        	    	      }
        				  
     
        			 }, function(error){
        				 console.log(error);
        			 });
    		  },function(btn){
    			 console.log('user cancel'); 
    		  });
    		  
            };
    	
    });

});

