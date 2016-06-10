'use strict';

define ([
	'mainApp'
	],

	function (mainApp){

	mainApp.controller('LoginModalController',function($scope, $log, $modal){
          
  
	
      console.log('Login ModalController Call');

      $scope.authInfo='';
      

      $scope.open = function (size) {

        var modalInstance = $modal.open({
        	
          templateUrl: 'partials/auth/login.html',
        // 모달 인스턴스 컨트롤러를 따로 만들어야 한다.
        controller: 'LoginModalInstanceCtrl',
        size: size,
        backdrop : 'static',
        resolve: {
          authInfo: function () {
            return $scope.authInfo;
          }
        }
      });

      // 모달이 종료되면 모달에서 선택된 값과 로그 출력
      modalInstance.result.then(function (inputVal) {
        console.log(inputVal);
      }, function () {
        $log.info('Modal dismissed at: ' + new Date());
      });


    };
  });


    mainApp.controller('LoginModalInstanceCtrl', function($scope,$modalInstance,authInfo){
    	
      $scope.authInfo = authInfo;
      

      $scope.ok = function () {
        $modalInstance.close($scope.authInfo);
      };

      $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
      };
    });


  });

