'use strict';
appCtrl = angular.module('attendance', [])
  .controller('DashCtrl', function($scope, $state) {
	console.log($state);
  });