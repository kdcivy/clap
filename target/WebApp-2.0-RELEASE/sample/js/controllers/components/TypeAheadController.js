/**
 * TypeAheadController
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

		mainApp.controller('TypeAheadController', function($scope, $http) {

		console.log('TypeAheadController Call');

		$scope.selected = undefined;
		$scope.states = [ 'Alabama', 'Alaska', 'Arizona', 'Arkansas',
				'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida',
				'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa',
				'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland',
				'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi',
				'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire',
				'New Jersey', 'New Mexico', 'New York', 'North Dakota',
				'North Carolina', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania',
				'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee',
				'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington',
				'West Virginia', 'Wisconsin', 'Wyoming' ];

		// google map api 이용 
		$scope.getLocation = function(val) {
			return $http.get(
					'http://maps.googleapis.com/maps/api/geocode/json', {
						params : {
							address : val,
							sensor : false
						}
					}).then(function(response) {
				return response.data.results.map(function(item) {
					return item.formatted_address;
				});
			});
		};
	});
});
