// main.js
var app = angular.module('errorMgmtApp', ['ngGrid']);
var rootContext = "/";

app.controller('MyCtrl', function($scope,$http) {
/*    $scope.myData = [{name: "Moroni", age: 50},
                     {name: "Tiancum", age: 43},
                     {name: "Jacob", age: 27},
                     {name: "Nephi", age: 29},
                     {name: "Enos", age: 34}];*/
	
	$scope.allData = null;
    $scope.myData = null;
    
	$scope.filterOptions = {
			filterText: "",
			useExternalFilter: true
	}; 
	$scope.totalServerItems = 0;
	$scope.pagingOptions = {
			pageSizes: [10, 15, 20, 50],
			pageSize: 10,
			currentPage: 1
	};
    
    $scope.setPagingData = function(data, page, pageSize){
        var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
        $scope.myData = pagedData;
        $scope.totalServerItems = data.length;
        if (!$scope.$$phase) {
            $scope.$apply();
        }
    };
    
    $scope.getPagedDataAsync = function (pageSize, page, searchText) {
        setTimeout(function () {
            var data;
                       
            if (searchText) {
                var ft = searchText.toLowerCase();
                if($scope.allData == null){
                    $http.get('../../sample/errorList.json').success(function (largeLoad) {
                    	$scope.allData = largeLoad.errorMgmtList;
                        data = largeLoad.errorMgmtList.filter(function(item) {
                            return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
                        });
                        $scope.setPagingData(data,page,pageSize);
                    });   
                }else{
                    data = $scope.allData.filter(function(item) {
                        return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
                    });
                    $scope.setPagingData(data,page,pageSize);
                }
         
            } else {
            	if($scope.allData == null){
                    $http.get('../../sample/errorList.json').success(function (largeLoad) {
                    	$scope.allData = largeLoad.errorMgmtList;
                        $scope.setPagingData(largeLoad.errorMgmtList,page,pageSize);
                    });
            	}else{
            		$scope.setPagingData($scope.allData,page,pageSize);
            	}
            }
        }, 100);
    };
	
    $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
	
    $scope.$watch('pagingOptions', function (newVal, oldVal) {
        //if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
    	if (newVal !== oldVal) {
          $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        }
    }, true);
    $scope.$watch('filterOptions', function (newVal, oldVal) {
        if (newVal !== oldVal) {
          $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        }
    }, true);
    
    $scope.gridOptions = {
    		data: 'myData' ,
    		columnDefs: [
    		             {field:'errorNo', displayName:'에러번호'},
    		             {field:'errorCode', displayName:'에러코드'},
    		             {field:'errorName', displayName:'에러명칭'},
    		             {field:'errorType', displayName:'에러유형'},
    		             {field:'errorMessage', displayName:'에러내용'},
    		             {field:'occurClass', displayName:'발생 Class'},
    		             {field:'occurMethod', displayName:'에러 함수'},
    		             {field:'occurTime', displayName:'에러 발생 일자'}
    		],
    	    enablePaging: true,
    	    showFooter: true,
    	    totalServerItems: 'totalServerItems',
    	    pagingOptions: $scope.pagingOptions,
    	    filterOptions: $scope.filterOptions,
    		plugins: [new ngGridFlexibleHeightPlugin()]
    	};
});