/**
 * main.js - Requirejs를 이용하여 모듈 정의 및 의존성 관계 정의 및 로드
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

requirejs.config({

	// js파일 Base 경로 설정
	baseUrl : 'js',
	//waitSeconds:4,

	// baseUrl 을 기준으로 모듊명과 경로 매
	paths : {
		'jquery' : '../libs/jquery-2.1.3/jquery-2.1.3.min',
	
		'angular' : '../libs/angular-1.3.9/angular.min',
		'ngRoute' : '../libs/angular-1.3.9/angular-route.min',
		'ngAnimate' : '../libs/angular-1.3.9/angular-animate.min',
		'ngSanitize' : '../libs/angular-1.3.9/angular-sanitize.min',
		'angularTreeview' : '../libs/angular-tree-0.1.6/angular.treeview.min',
		'ui.grid' : '../libs/ui-grid-3.0.0/ui-grid-unstable',
		'ngGrid': '../libs/ng-grid-2.0.14/ng-grid-2.0.14.min',
		'ui.bootstrap' : '../libs/ui-bootstrap-0.12/ui-bootstrap-tpls-0.12.0.min',
		'bootstrap' : '../libs/bootstrap-3.3.2/js/bootstrap.min',
		'ngStrap' : '../libs/angular-strap-2.1.2/angular-strap.min',
		'ngStrapTpl' : '../libs/angular-strap-2.1.2/angular-strap.tpl.min',
		'd3' : '../libs/angular-nvd3-0.0.3/d3.min', // graph
		'nvd3' : '../libs/angular-nvd3-0.0.3/nv.d3.min',// graph
		'ngnvd3' : '../libs/angular-nvd3-0.0.3/angular-nvd3.min', // graph
		'dialogs' : '../libs/angular-dialog-5.2.1/dialogs.min',
		'treasure-overlay-spinner' : '../libs/angular-treasure-overlay-spinner-1.0.2/treasure-overlay-spinner',
		'jsbn' : '../libs/jsbn-1.4/jsbn', // crypt
		'rsa' : '../libs/jsbn-1.4/rsa', // crypt
		'prng4' : '../libs/jsbn-1.4/prng4', // crypt
		'rng' : '../libs/jsbn-1.4/rng', // crypt
		'domReady' : '../libs/requirejs-2.1.17/domReady-2.0.1',

	},
	/*
	 * shim: AMD 형식을 지원하지 않는 라이브러리의 경우 아래와 같이 SHIM을 사용해서 모듈로 불러올 수 있다. 참고 :
	 * http://gregfranko.com/blog/require-dot-js-2-dot-0-shim-configuration/
	 */
	shim : {
		'angular' : {
			exports : 'angular'
		},
		'ngRoute' : {
			deps : [ 'angular' ]
		},
		'ngSanitize' : {
			deps : [ 'angular' ]
		},
		'ngAnimate' : {
			deps : [ 'angular' ]
		},
		'ui.grid' : {
			deps : [ 'angular' ]
		},
		'ngGrid' : {
			deps : [ 'angular','jquery' ]
		},
		'ngStrap' : {
			deps : [ 'angular' ]
		},
		'ngStrapTpl' : {
			deps : [ 'angular', 'ngStrap' ]
		},
		'bootstrap' : {
			deps : [ 'jquery' ]
		},
		'ui.bootstrap' : {
			deps : [ 'angular', 'jquery', 'bootstrap' ]
		},
		'dialogs' : {
			deps : [ 'angular', 'ngSanitize', 'ui.bootstrap' ]
		},
		'treasure-overlay-spinner' : {
			deps : [ 'angular', 'ngAnimate' ]
		},
		'angularTreeview' : {
			deps : [ 'angular' ]
		},
		'd3' : {
			deps : [ 'angular' ]
		},
		'ngnvd3' : {
			deps : [ 'angular', 'd3' ]
		},
		'nvd3' : {
			deps : [ 'angular', 'd3' ]
		},
		'rng' : {
			deps : [ 'jsbn', 'rsa','prng4' ]
		}

	},

	// ts값을 배포시간으로 설정하여 캐싱을 피할 수 있다.
	urlArgs : 'ts=' + (new Date()).getTime()
});


// 모듈 로드
require([
	'jquery',
	'angular',
	'ngAnimate',
	'ngRoute',
	'ngSanitize',
	'ui.grid',
	'ngGrid',
	'ngStrap',
	'ngStrapTpl',
	'bootstrap',
	'ui.bootstrap',
	'angularTreeview',
	'd3',
	'nvd3',
	'ngnvd3',
	'dialogs',
	'treasure-overlay-spinner',
	'mainApp',
	'mainRoutes',
	'jsbn',
	'rsa',
	'prng4',
	'rng',
	'domReady!'
	],

	// 로드 완료 된 뒤 콜백 
	function(domReady,angular) {
	

		// 모든 모듈이 로드되면 mainApp 부트스트랩
	    domReady(function () {
	        angular.bootstrap(document,['mainApp']);
	    });
	           

});