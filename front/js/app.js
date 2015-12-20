'use strict';
var app = angular.module('attendance', []);
app.controller('ctrl_homepage', function($scope, $http){
	$scope.username = window.localStorage.name;
	$scope.today = new Date().getFullYear()+"年"+(new Date().getMonth()+1)+"月"+new Date().getDate()+"日";
	$http
	.get('http://api.map.baidu.com/telematics/v3/weather?location=%E5%A4%A9%E6%B4%A5&output=json&ak=A070e14d4e685d26358a908a3c896567')
	.success(function (response){
		$scope.temperature = response.results[0].weather_data[0].temperature;
		$scope.pm25 = response.results[0].pm25;
		$scope.des = response.results[0].index[0].des;
	});
});
