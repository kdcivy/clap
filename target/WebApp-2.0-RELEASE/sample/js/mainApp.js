/**
 * mainApp.js - AngularJS App 생성
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
	'angular'
	], 

	function(angular){
		
		
		// App Module Include
		var mainApp = angular.module('mainApp',[
		                                        
		    // 사용한 angular모듈을 Injection한다.
			'ngAnimate',
			'ngRoute',
			'ngSanitize',
			'ui.grid',
			'ui.grid.edit', // Editable
			'ui.grid.exporter', // csv Export
			'ui.grid.selection', // Select
			'ui.grid.pagination', // Pagination
			'ngGrid',
			'mgcrea.ngStrap',
			// DatePicker에서 함수 디펜더시 관련해서 ngStrap을 먼저 로드해야한다.
			'ui.bootstrap',
			'dialogs.main', // dialog
			'treasure-overlay-spinner',
			'angularTreeview', // treeview
			'nvd3' // graph
			
			]);
		
		
		
		return mainApp;
	});