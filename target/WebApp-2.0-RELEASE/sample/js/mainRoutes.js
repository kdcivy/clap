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
	'controllers/grid/ng-grid/NGBasicGridController',
	'controllers/grid/ng-grid/NGGroupGridController',
	'controllers/grid/ng-grid/NGRowTemplateGridController',
	'controllers/grid/ng-grid/NGSelectionGridController',
	'controllers/grid/ng-grid/NGEditableGridController',
	'controllers/grid/ng-grid/NGPinningGridController',
	'controllers/grid/ng-grid/NGStyleGridController',
	'controllers/grid/ui-grid/UIBasicGridController',
	'controllers/grid/ui-grid/UIEditableGridController',
	'controllers/grid/ui-grid/UIFilterGridController',
	'controllers/grid/ui-grid/UIAddDeleteSwapGridController',
	'controllers/grid/ui-grid/UIMenuGridController',
	'controllers/grid/ui-grid/UIPaginationGridController',
	'controllers/grid/ui-grid/UICRUDGridController',
	'controllers/grid/ui-grid/UICRUDGridMysqlController',
	'controllers/grid/ui-grid/UIStyleGridController',
	'controllers/crypt/cryptTestController',
	'controllers/graph/LineChartController',
	'controllers/graph/CumulativeLineChartController',
	'controllers/graph/StackedAreaController',
	'controllers/graph/MultiBarChartController',
	'controllers/graph/MultiBarHorizontalChartController',
	'controllers/graph/DiscreteBarChartController',
	'controllers/graph/PieChartController',
	'controllers/graph/ScatterChartController',
	'controllers/graph/DonutChartController',
	'controllers/graph/BulletChartController',
	'controllers/graph/RealTimeController'
	], 

	function (mainApp){
	
	

		mainApp.config(function($routeProvider,$locationProvider,dialogsProvider){
					
	
			// template과 controller를 주소와 매핑한다.
			$routeProvider
			.when('/',
			{
				controller : 'HomeController',
				templateUrl : './partials/views/home.html'
			})
			.when('/accordion',
			{
				controller : 'AccodionController',
				templateUrl : './partials/views/components/accordion.html'
			})
			.when('/alert',
			{
				controller : 'AlertController',
				templateUrl : './partials/views/components/alert.html'
			})
			.when('/button',
			{
				controller : 'ButtonController',
				templateUrl : './partials/views/components/button.html'
			})
			.when('/modal',
			{
				controller : 'ModalController',
				templateUrl : './partials/views/components/modal.html'
			})
			.when('/datepicker',
			{
				controller : 'DatePickerController',
				templateUrl : './partials/views/components/datepicker.html'
			})
			.when('/dropdown',
			{
				controller : 'DropDownController',
				templateUrl : './partials/views/components/dropdown.html'
			})
			.when('/tab',
			{
				controller : 'TabController',
				templateUrl : './partials/views/components/tab.html'
			})
			.when('/progressbar',
			{
				controller : 'ProgressBarController',
				templateUrl : './partials/views/components/progressbar.html'
			})
			.when('/typeahead',
			{
				controller : 'TypeAheadController',
				templateUrl : './partials/views/components/typeahead.html'
			})
			.when('/factory',
			{
				controller : 'FactoryController',
				templateUrl : './partials/services/factory.html'
			})
			.when('/service',
			{
				controller : 'ServiceController',
				templateUrl : './partials/services/service.html'
			})
			.when('/directive',
			{
				controller : 'DirectiveController',
				templateUrl : './partials/services/directive.html'
			})
			.when('/filter',
			{
				controller : 'FilterController',
				templateUrl : './partials/services/filter.html'
			})
			.when('/constant',
			{
				controller : 'ConstantController',
				templateUrl : './partials/services/constant.html'
			})
			.when('/value',
			{
				controller : 'ValueController',
				templateUrl : './partials/services/value.html'
			})
			.when('/route/:id',
			{
				controller : 'RouteTestController',
				templateUrl : './partials/route/conservative-route.html'
			})
			.when('/route/:id/:data*',
			{
				controller : 'RouteTestController',
				templateUrl : './partials/route/eager-route.html'
			})
			.when('/webform',
			{
				controller : 'WebFormController',
				templateUrl : './partials/views/forms/webform.html'
			})
			.when('/valiform',
			{
				controller : 'ValidationFormController',
				templateUrl : './partials/views/forms/validationform.html'
			})
			.when('/contactform',
			{
				controller : 'ContactFormController',
				templateUrl : './partials/views/forms/contactform.html'
			})
			.when('/crudform',
			{
				controller : 'CRUDFormController',
				templateUrl : './partials/views/forms/crudform.html'
			})
			.when('/ng-basic_grid',
			{
				controller : 'NGBasicGridController',
				templateUrl : './partials/views/grid/ng-grid/ng_basic_grid.html'
			})
			.when('/ng-group_grid',
			{
				controller : 'NGGroupGridController',
				templateUrl : './partials/views/grid/ng-grid/ng_group_grid.html'
			})
			.when('/ng-rowtemplate_grid',
			{
				controller : 'NGRowTemplateGridController',
				templateUrl : './partials/views/grid/ng-grid/ng_rowtemplate_grid.html'
			})
			.when('/ng-selection_grid',
			{
				controller : 'NGSelectionGridController',
				templateUrl : './partials/views/grid/ng-grid/ng_selection_grid.html'
			})
			.when('/ng-editable_grid',
			{
				controller : 'NGEditableGridController',
				templateUrl : './partials/views/grid/ng-grid/ng_editable_grid.html'
			})
			.when('/ng-pinning_grid',
			{
				controller : 'NGPinningGridController',
				templateUrl : './partials/views/grid/ng-grid/ng_pinning_grid.html'
			})
			.when('/ng-style_grid',
			{
				controller : 'NGStyleGridController',
				templateUrl : './partials/views/grid/ng-grid/ng_style_grid.html'
			})
			.when('/ui-basic_grid',
			{
				controller : 'UIBasicGridController',
				templateUrl : './partials/views/grid/ui-grid/ui_basic_grid.html'
			})
			.when('/ui-editable_grid',
			{
				controller : 'UIEditableGridController',
				templateUrl : './partials/views/grid/ui-grid/ui_editable_grid.html'
			})
			.when('/ui-filter_grid',
			{
				controller : 'UIFilterGridController',
				templateUrl : './partials/views/grid/ui-grid/ui_filter_grid.html'
			})
			.when('/ui-ads_grid',
			{
				controller : 'UIAddDeleteSwapGridController',
				templateUrl : './partials/views/grid/ui-grid/ui_ads_grid.html'
			})
			.when('/ui-menu_grid',
			{
				controller : 'UIMenuGridController',
				templateUrl : './partials/views/grid/ui-grid/ui_menu_grid.html'
			})
			.when('/ui-pagination_grid',
			{
				controller : 'UIPaginationGridController',
				templateUrl : './partials/views/grid/ui-grid/ui_pagination_grid.html'
			})
			.when('/ui-crud_grid',
			{
				controller : 'UICRUDGridController',
				templateUrl : './partials/views/grid/ui-grid/ui_crud_grid.html'
			})
			.when('/ui-crud_grid_mysql',
			{
				controller : 'UICRUDGridMysqlController',
				templateUrl : './partials/views/grid/ui-grid/ui_crud_grid_mysql.html'
			})
			.when('/ui-etc_grid',
			{
				templateUrl : './partials/views/grid/ui-grid/ui_etc_grid.html'
			})
			.when('/ui-style_grid',
			{
				controller : 'UIStyleGridController',
				templateUrl : './partials/views/grid/ui-grid/ui_style_grid.html'
			})
			.when('/crypt',
			{
				controller : 'cryptTestController',
				templateUrl : './partials/views/crypt/crypt.html'
			})
			.when('/linechart',
			{
				controller : 'LineChartController',
				templateUrl : './partials/views/graph/linechart.html'
			})
			.when('/cumulative',
			{
				controller : 'CumulativeLineChartController',
				templateUrl : './partials/views/graph/cumulativelinechart.html'
			})
			.when('/stackedarea',
			{
				controller : 'StackedAreaController',
				templateUrl : './partials/views/graph/stackedarea.html'
			})
			.when('/multibar',
			{
				controller : 'MultiBarChartController',
				templateUrl : './partials/views/graph/multibarchart.html'
			})
			.when('/mulbibarhorizontal',
			{
				controller : 'MultiBarHorizontalChartController',
				templateUrl : './partials/views/graph/multibarhorizontalchart.html'
			})
			.when('/discrete',
			{
				controller : 'DiscreteBarChartController',
				templateUrl : './partials/views/graph/discretebarchart.html'
			})
			.when('/piechart',
			{
				controller : 'PieChartController',
				templateUrl : './partials/views/graph/piechart.html'
			})
			.when('/scatterchart',
			{
				controller : 'ScatterChartController',
				templateUrl : './partials/views/graph/scatterchart.html'
			})
			.when('/donutchart',
			{
				controller : 'DonutChartController',
				templateUrl : './partials/views/graph/donutchart.html'
			})
			.when('/bulletchart',
			{
				controller : 'BulletChartController',
				templateUrl : './partials/views/graph/bulletchart.html'
			})
			.when('/realtime',
			{
				controller : 'RealTimeController',
				templateUrl : './partials/views/graph/realtime.html'
			})
			
			.otherwise({
				redirectTo : '/'
			});
			
			
			// Dialog 옵션
			dialogsProvider.useBackdrop('static');
			dialogsProvider.useEscClose(false);
			dialogsProvider.useCopy(false);
			dialogsProvider.setSize('sm');
			
			
			
			
		});  
		
		
	});
