/**
 * httpFactory - AJAX 호출 Factory
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

		    
	
		mainApp.factory('httpFactory', function($http, $q) {
		// optional method

		return {
			// Get Method
			getHttp : function(Url) {

				//deferred 객체를 생성한다.				
				var deferred = $q.defer();
	
				$http({
					method : 'GET',
					url : Url,
					header : {
						'Content-Type' : 'application/json; charset=utf-8'
					},
				//	    timeout: deferred.promise
				}).then(function(data) {

					deferred.resolve(data);
				}, function(status) {
					deferred.reject(status);

				});

				//해당 deferred 객체의 약속을 반환한다.
				return deferred.promise;
			},
			
			// Post Method
			postHttp : function(Url,parameters) {

				var deferred = $q.defer();
				
				$http({
					method : 'POST',
					params : parameters,
					url : Url,
				    headers: {	'Content-Type' : 'application/json; charset=utf-8'}

				}).then(function(data) {
					deferred.resolve(data);
				}, function(status) {
					deferred.reject(status);
				});

				return deferred.promise;
			}

		};
	});
});
			    	

			    	
			   

