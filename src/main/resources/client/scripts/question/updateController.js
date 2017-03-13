/**
 * Created by Anasse on 13/03/2017.
 */
'use strict';

angular.module('app')
	.controller('UpdateQuestionController', ['$scope','$routeParams','$http','QualificatifService','questionService','domaineService','$location',
	function ($scope,$routeParams,$http,QualificatifService,questionService,domaineService,$location) {

		var promise = QualificatifService.getAll();
		promise.success(function(data) {
			$scope.qualificatifs = data;
		}).error(function(data) {
			console.log("get questions : erreur");
		});

		var promise = questionService.getQuestion($routeParams.idQuestionToBeUpdated);
		promise.success(function(data) {
			$scope.question = data;
			console.log(data);
		}).error(function(data) {
			console.log("get questions : erreur");
		});

		$scope.update = function(){
			console.log('je suis hna');
			console.log($scope.question);
			var promise = questionService.updateQuestion($scope.question);
			promise.success(function(data){
				$location.path('/admin/questionsStandard');
			}).error(function(status){
				console.log('update question : error');
			});
		}
}]);