/**
 * Created by Anasse on 12/03/2017.
 */
'use strict';

angular.module('app')
	.controller('AddQuestionController', ['$scope','$routeParams','$http','QualificatifService','questionService',
	function ($scope,$routeParams,$http,QualificatifService,questionService) {

		$scope.qualificatifs

		var promise = QualificatifService.getAll();
		promise.success(function(data) {
			$scope.qualificatifs = data;
		}).error(function(data) {
			console.log("get questions : erreur");
		});

		$scope.ajouter = function(){
			/*$scope.question.intitule = "ttestting";
			$scope.question.type = "QUS";
			$scope.question.noEnseignant = null;
			$scope.question.idQualificatif = 2;*/
			console.log($scope.question);
			var promise = questionService.addQuestion($scope.question);
			promise.success(function(data){
				console.log('question ajouté');
			}).error(function(status){
				console.log('add question : error');
			});
		}
}]);