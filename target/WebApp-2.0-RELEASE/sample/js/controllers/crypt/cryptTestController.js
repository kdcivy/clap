/**
 * BaseController index.html 컨트롤러( 최상위 컨트롤러)
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
	'jsbn',
	'rsa',
	'prng4',
	'rng'
	
	],

	function(mainApp) {

	mainApp.controller('cryptTestController', function($scope,httpFactory) {

		console.log('cryptTestController Call');

		httpFactory.getHttp('../crypt/requestkey').then(function(response) {
			
			$scope.publicKeyModules = response.data.publicKeyModulus;
			$scope.publicKeyExponent = response.data.publicKeyExponent;
			
			$scope.rsa = new RSAKey();
			$scope.rsa.setPublic($scope.publicKeyModules,$scope.publicKeyExponent);
			
			var email = 'adahn.lim@kt.com';
			var password = '1234';
			
			$scope.plain = {
					'email' : email,
					'password' : password
			};
			
			$scope.encrypt = {
					'email' : $scope.rsa.encrypt(email),
					'password' : $scope.rsa.encrypt(password)
			};
			
	
			httpFactory.postHttp('../crypt/requestmessage',$scope.encrypt)
			.then(function(response) {
				//console.log(response);
				$scope.decrypt=response.data;
			}, function(error) {
				console.log(error);
			});
			
			

		}, function(error) {
			console.log(error);
		});
		
		
		
		
	
		
		
		

		
	});

});