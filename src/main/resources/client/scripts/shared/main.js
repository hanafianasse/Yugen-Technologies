(function() {
  'use strict';
  angular.module('app.controllers', ['app.auth']).controller('AppCtrl', [
    '$scope', '$location', 'AuthService', function($scope, $location, AuthService) {
      $scope.isSpecificPage = function() {
        var path;
        path = $location.path();
        return _.contains(['/404', '/pages/500', '/pages/login', '/pages/signin', '/pages/signin1', '/pages/signin2', '/pages/signup', '/pages/signup1', '/pages/signup2', '/pages/forgot', '/pages/lock-screen'], path);
      };
      $scope.deconnexion = function() {
    	  
    	  AuthService.deconnexion().success(function() {
    		  $location.path('/pages/signin');
    	  });
    	  
      };
      
      $scope.login = function() {
    	  $location.path('/pages/signin');
      };
      
      return $scope.main = {
        brand: 'Square',
        name: 'Lisa Doe'
      };
    }
  ]).controller('NavCtrl', [
    '$scope', 'taskStorage', 'filterFilter', function($scope, taskStorage, filterFilter) {
      var tasks;
      tasks = $scope.tasks = taskStorage.get();
      $scope.taskRemainingCount = filterFilter(tasks, {
        completed: false
      }).length;
      return $scope.$on('taskRemaining:changed', function(event, count) {
        return $scope.taskRemainingCount = count;
      });
    }
  ]).controller('DashboardCtrl', ['$scope', function($scope) {}]);

}).call(this);

