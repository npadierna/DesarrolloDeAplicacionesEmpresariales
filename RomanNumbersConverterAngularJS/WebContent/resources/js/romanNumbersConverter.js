/**
 * Web Services URL
 */
// var ROMAN_NUMBERS_CONVERTER_WEB_SERVICE =
// 'http://192.168.195.14:8081/RomanNumbersConverterWebService/rest/number/roman/converter/decimalnumber?';
// var ROMAN_NUMBERS_CONVERTER_WEB_SERVICE =
// 'http://localhost:8081/RomanNumbersConverterWebService/rest/number/roman/converter/decimalnumber?';
var ROMAN_NUMBERS_CONVERTER_WEB_SERVICE = 'http://romannumbersconverterws.herokuapp.com/rest/number/roman/converter/decimalnumber?';

/**
 * Web Services Constants
 */
var MAXIMUM_DECIMAL_NUMBER = 3999;
var MINMUM_DECIMAL_NUMBER = 1;

/**
 * Modules
 */
var romanNumbersConverterModule = angular.module('romanNumbersConverterModule',
		[ 'ngRoute' ]);

/**
 * View Controllers
 */
romanNumbersConverterModule
		.controller(
				'romanNumbersConverterController',
				function($scope, romanNumbersConverterWebService) {
					$scope.convertToRomanNumberconvertToRomanNumber = function() {
						romanNumbersConverterWebService
								.convertToRomanNumber($scope, $scope.decimalNumber)
								.success(
										function(data, status, headers, config) {
											if (data != '') {
												$scope.romanNumber = data.romanNumber;
											} else {
												$scope.romanNumber = '';

												alert('The Roman Numbers Converters Web Service was not successfully.');
											}
										})
								.error(
										function(data, status, headers, config) {
											$scope.romanNumber = '';

											alert('The Roman Numbers Converters Web Service was not successfully.');
										});
					};
				});

/**
 * Navigation Rules
 */
romanNumbersConverterModule.config([ '$routeProvider',
		function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : './pages/romanNumbersConverter.html',
				controller : 'romanNumbersConverterController'
			});
		} ]);

/**
 * Runners
 */
romanNumbersConverterModule.run(function($rootScope, $location) {
	$rootScope.$on('$routeChangeStart', function() {
		$location.url('/');
	});
});

/**
 * Web Services
 */
romanNumbersConverterModule.service('romanNumbersConverterWebService',
		function($http) {

			this.convertToRomanNumber = function($scope, decimalNumber) {

				if ((decimalNumber == '') || (decimalNumber == undefined)
						|| (decimalNumber < MINMUM_DECIMAL_NUMBER)
						|| (decimalNumber > MAXIMUM_DECIMAL_NUMBER)) {
					$scope.romanNumber = '';

					alert('The Decimal Number value is not valid.');
				} else {
					return ($http({
						method : 'GET',
						params : {
							decimalNumber : decimalNumber
						},
						url : ROMAN_NUMBERS_CONVERTER_WEB_SERVICE
					}));
				}
			};
		});