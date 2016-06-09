/**
 * mainRoute.js - AngularJS App Config (Route 및 Dialog config)
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

	// Import Controller
	'controllers/BaseController',
	'controllers/GnBController',
	'controllers/SnBController',
	'controllers/views/HomeController',
	'controllers/views/HelloController',
	/*
	'controllers/components/AccordionController',
	'controllers/components/AlertController',
	'controllers/components/ButtonController',
	'controllers/components/ModalController',
	'controllers/components/DatePickerController',
	'controllers/components/DropDownController',
	'controllers/components/TabController',
	'controllers/components/ProgressBarController',
	'controllers/components/TypeAheadController',
	'controllers/services/FactoryController',
	'controllers/services/ServiceController',
	'controllers/services/DirectiveController',
	'controllers/services/FilterController',
	'controllers/services/ConstantController',
	'controllers/services/ValueController',
	'controllers/route/RouteTestController',
	'controllers/forms/WebFormController',
	'controllers/forms/ValidationFormController',
	'controllers/forms/ContactFormController',
	'controllers/forms/CRUDFormController',
	'controllers/grid/BasicGridController',
	'controllers/grid/EditableGridController',
	'controllers/grid/FilterGridController',
	'controllers/grid/AddDeleteSwapGridController',
	'controllers/grid/MenuGridController',
	'controllers/grid/PaginationGridController',
	'controllers/grid/CRUDGridController',
	'controllers/crypt/cryptTestController'*/
	], 

	function (mainApp){
	
	

		mainApp.config(function($routeProvider,$locationProvider){
					
	
			
			$routeProvider
			.when('/',
			{
				controller : 'HomeController',
				templateUrl : './partials/views/home.html'
			})
			.when('/hello',
			{
				controller : 'HelloController',
				templateUrl : './partials/views/hello.html'
			})
//			.when('/accordion',
//			{
//				controller : 'AccodionController',
//				templateUrl : './partials/views/components/accordion.html'
//			})
//			.when('/alert',
//			{
//				controller : 'AlertController',
//				templateUrl : './partials/views/components/alert.html'
//			})
//			.when('/button',
//			{
//				controller : 'ButtonController',
//				templateUrl : './partials/views/components/button.html'
//			})
//			.when('/modal',
//			{
//				controller : 'ModalController',
//				templateUrl : './partials/views/components/modal.html'
//			})
//			.when('/datepicker',
//			{
//				controller : 'DatePickerController',
//				templateUrl : './partials/views/components/datepicker.html'
//			})
//			.when('/dropdown',
//			{
//				controller : 'DropDownController',
//				templateUrl : './partials/views/components/dropdown.html'
//			})
//			.when('/tab',
//			{
//				controller : 'TabController',
//				templateUrl : './partials/views/components/tab.html'
//			})
//			.when('/progressbar',
//			{
//				controller : 'ProgressBarController',
//				templateUrl : './partials/views/components/progressbar.html'
//			})
//			.when('/typeahead',
//			{
//				controller : 'TypeAheadController',
//				templateUrl : './partials/views/components/typeahead.html'
//			})
//			.when('/factory',
//			{
//				controller : 'FactoryController',
//				templateUrl : './partials/services/factory.html'
//			})
//			.when('/service',
//			{
//				controller : 'ServiceController',
//				templateUrl : './partials/services/service.html'
//			})
//			.when('/directive',
//			{
//				controller : 'DirectiveController',
//				templateUrl : './partials/services/directive.html'
//			})
//			.when('/filter',
//			{
//				controller : 'FilterController',
//				templateUrl : './partials/services/filter.html'
//			})
//			.when('/constant',
//			{
//				controller : 'ConstantController',
//				templateUrl : './partials/services/constant.html'
//			})
//			.when('/value',
//			{
//				controller : 'ValueController',
//				templateUrl : './partials/services/value.html'
//			})
//			.when('/route/:id',
//			{
//				controller : 'RouteTestController',
//				templateUrl : './partials/route/conservative-route.html'
//			})
//			.when('/route/:id/:data*',
//			{
//				controller : 'RouteTestController',
//				templateUrl : './partials/route/eager-route.html'
//			})
//			.when('/webform',
//			{
//				controller : 'WebFormController',
//				templateUrl : './partials/views/forms/webform.html'
//			})
//			.when('/valiform',
//			{
//				controller : 'ValidationFormController',
//				templateUrl : './partials/views/forms/validationform.html'
//			})
//			.when('/contactform',
//			{
//				controller : 'ContactFormController',
//				templateUrl : './partials/views/forms/contactform.html'
//			})
//			.when('/crudform',
//			{
//				controller : 'CRUDFormController',
//				templateUrl : './partials/views/forms/crudform.html'
//			})
//			.when('/basic_grid',
//			{
//				controller : 'BasicGridController',
//				templateUrl : './partials/views/grid/basic_grid.html'
//			})
//			.when('/editable_grid',
//			{
//				controller : 'EditableGridController',
//				templateUrl : './partials/views/grid/editable_grid.html'
//			})
//			.when('/filter_grid',
//			{
//				controller : 'FilterGridController',
//				templateUrl : './partials/views/grid/filter_grid.html'
//			})
//			.when('/ads_grid',
//			{
//				controller : 'AddDeleteSwapGridController',
//				templateUrl : './partials/views/grid/ads_grid.html'
//			})
//			.when('/menu_grid',
//			{
//				controller : 'MenuGridController',
//				templateUrl : './partials/views/grid/menu_grid.html'
//			})
//			.when('/pagination_grid',
//			{
//				controller : 'PaginationGridController',
//				templateUrl : './partials/views/grid/pagination_grid.html'
//			})
//			.when('/crud_grid',
//			{
//				controller : 'CRUDGridController',
//				templateUrl : './partials/views/grid/crud_grid.html'
//			})
//			.when('/etc_grid',
//			{
//				templateUrl : './partials/views/grid/etc_grid.html'
//			})
//			.when('/crypt',
//			{
//				controller : 'cryptTestController',
//				templateUrl : './partials/views/crypt/crypt.html'
//			})
			
			.otherwise({
				redirectTo : '/'
			});
			
			
//			// Dialog 옵션
//			dialogsProvider.useBackdrop('static');
//			dialogsProvider.useEscClose(false);
//			dialogsProvider.useCopy(false);
//			dialogsProvider.setSize('sm');
			
			
			
			
		});  
		
		
	});
