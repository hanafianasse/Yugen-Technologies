
'use strict';

angular.module('app').controller('EvaluationListCtrl', ['$scope','$route','$rootScope','$routeParams','$http','$location','$q','EvaluationService','RubriqueService','questionService', 'RubriqueEvaluationsService','$modal',function ($scope,$route,$rootScope,$routeParams,$http,$location,$q, EvaluationService, RubriqueService, questionService, RubriqueEvaluationsService,$modal) {


console.log("je suis dans EvaluationListController");

//Recupération de toutes les évaluations
var promiseEvaluation = EvaluationService.getAll();
promiseEvaluation.success(function(data) {
	$scope.evaluations = data;
	console.log($scope.evaluations);
}).error(function(data) {
	console.log("get evaluation: erreur");
});


/********************FONCTION DE RECUPERATION**************************/

//Recupération des rubriques
$scope.select = function(evaluation){
	
	$scope.evaCodeFormation = evaluation.codeFormation;
	$scope.evaCodeUe = evaluation.codeUe;
	$scope.evaCodeEc = evaluation.codeEc;
	$scope.evaPeriode = evaluation.periode;
	$scope.evaId = evaluation.idEvaluation;
	
	//Recupération des evaluationRubrique de l'évaluation
	var promiseRubriqueEvaluation = RubriqueEvaluationsService.getRubriqueEvaluationByIdEva($scope.evaId);
	promiseRubriqueEvaluation.success(function(data) {
		$scope.rubevaluations = data;
		console.log($scope.rubevaluations);
	}).error(function(data) {
		console.log("get evaluationRubrique: erreur");
	});
	
	
	//$rootScope.selectedEvaluation = evaluation.idEvaluation;
	
 $scope.rubriques = [];
 
	$q.all(promiseRubriqueEvaluation).then(function () {
		angular.forEach($scope.rubevaluations, function(rubEval) {
			var promiseRubrique = RubriqueService.getRubrique(rubEval.idRubrique);
			promiseRubrique.success(function (data) {
				var rubrique = {
						idRubrique: data.idRubrique,
					    designation: data.designation,
					    ordre: data.ordre,
					    type: data.type,
					    questions: []
				};
				
				
				$q.all(promiseRubrique).then(function(data){
					questionService.getQuestionEvaluation(rubEval.idRubriqueEvaluation).success(function (data){
						rubrique.questions = data;
					});
				});
				
				$scope.rubriques.push(rubrique);
				console.log($scope.rubriques);
			}, function (error) {
				console.log("Get rubrique: Error");
			});
		});
	});
}	
}]);


