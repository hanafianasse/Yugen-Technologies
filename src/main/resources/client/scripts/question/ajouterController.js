/**
 * Created by Anasse on 12/03/2017.
 */
'use strict';

angular.module('app')
	.controller('AddQuestionController', ['$scope','$routeParams','$http','QualificatifService','questionService','domaineService','$location',
	function ($scope,$routeParams,$http,QualificatifService,questionService,domaineService,$location) {

		var promise = QualificatifService.getAll();
		promise.success(function(data) {
			$scope.qualificatifs = data;
		}).error(function(data) {
			console.log("get questions : erreur");
		});

		$scope.ajouter = function(){
			$scope.question.noEnseignant = null;
			console.log($scope.question);
			var promise = questionService.addQuestion($scope.question);
			promise.success(function(data){
				$location.path('/admin/questionsStandard');
			}).error(function(status){
				console.log('add question : error');
			});
		}
}]);