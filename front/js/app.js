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
	var storage = window.localStorage;
	var root = storage.getItem("root");
	$scope.comeMsg = "还未签到";
	$scope.leaveMsg = "还未签退";
	$http
	.get(root+'/sign/getDay')
	.success(function (response){
		if(response.status == "OK"){
			if(response.sign != null){
				switch(response.sign.come){
					case "0":
						$scope.comeMsg = "还未签到";
						break;
					case "1":
						$scope.comeMsg = "迟到签到";
						break;
					case "2":
						$scope.comeMsg = "准时签到";
						break;
				}
				switch(response.sign.leave){
					case "0":
						$scope.leaveMsg = "还未签退";
						break;
					case "1":
						$scope.leaveMsg = "早退签退";
						break;
					case "2":
						$scope.leaveMsg = "准时签退";
						break;
				}
			}else{
				$scope.comeMsg = "还未签到";
				$scope.leaveMsg = "还未签退";
			}
		}else{
			$scope.comeMsg = "还未签到";
			$scope.leaveMsg = "还未签退";
		}
	});
	$scope.comeSign = function(){
		$http
		.post(root+'/sign/addSign')
		.success(function (response){
			alert(response);
			mui.toast('开始');
			$http
			.get(root+'/sign/getDay')
			.success(function (response){
				if(response.status == "OK"){
					if(response.sign != null){
						mui.toast("成功签到");
						switch(response.sign.come){
							case "0":
								$scope.comeMsg = "还未签到";
								break;
							case "1":
								$scope.comeMsg = "迟到签到";
								break;
							case "2":
								$scope.comeMsg = "准时签到";
								break;
						}
					}else{
						$scope.comeMsg = "还未签到";
					}
				}else{
					$scope.comeMsg = "还未签到";
				}
			});
		});
	};
	$scope.leaveSign = function(){
		$http
		.post(root+'/sign/addSign')
		.success(function (response){
			alert(response);
			if(response.status == "OK"){
				if(response.sign != null){
					mui.toast("成功签退");
					switch(response.sign.leave){
						case "0":
							$scope.leaveMsg = "还未签退";
							break;
						case "1":
							$scope.leaveMsg = "早退签退";
							break;
						case "2":
							$scope.leaveMsg = "准时签退";
							break;
					}
				}else{
					$scope.leaveMsg = "还未签退";
				}
			}else{
				$scope.leaveMsg = "还未签退";
			}
		});
	};
});
app.controller('ctrl_self', function($scope, $http){
	$scope.name = window.localStorage.name;
	$scope.phone = "账号："+window.localStorage.phone;
});

app.controller('ctrl_setting', function($scope, $http){
	$scope.name = window.localStorage.name;
	$scope.phone = "账号："+window.localStorage.phone;
	$scope.email = window.localStorage.email;
	$scope.gender = window.localStorage.gender == "0"? "男":"女";
	$scope.startworkdate = window.localStorage.startworkdate;
	$scope.department = window.localStorage.department;
	switch(window.localStorage.position){
		case "0":
			$scope.position = "员工";
			break;
		case "1":
			$scope.position = "部门经理";
			break;
		case "2":
			$scope.position = "副总经理";
			break;
		case "3":
			$scope.position = "总经理";
			break;
	}
});
