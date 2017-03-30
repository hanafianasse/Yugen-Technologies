
'use strict';

angular.module('app').controller('EvaluationListCtrl', ['$scope','$route','$rootScope','$routeParams','$http','$location','$q','EvaluationService','RubriqueService','questionService', 'RubriqueEvaluationsService','QualificatifService','$modal',function ($scope,$route,$rootScope,$routeParams,$http,$location,$q, EvaluationService, RubriqueService, questionService, RubriqueEvaluationsService, QualificatifService,$modal) {


console.log("je suis dans EvaluationListController");

$scope.evaId = 0;


//Recupération de toutes les évaluations
var promiseEvaluation = EvaluationService.getAll();
promiseEvaluation.success(function(data) {
	$scope.evaluations = data;
	console.log($scope.evaluations);
}).error(function(data) {
	console.log("get evaluation: erreur");
});

/********************FONCTION DE RECUPERATION**************************/

//Recupération des rubriques et question et qualificatif
$scope.select = function(evaluation){

	$scope.evaCodeFormation = evaluation.codeFormation;
	$scope.evaCodeUe = evaluation.codeUe;
	$scope.evaCodeEc = evaluation.codeEc;
	$scope.evaPeriode = evaluation.periode;
	$scope.evaId = evaluation.idEvaluation;
	
	
	$scope.rubriqueEva = [];
	$scope.Questions = [];
	$scope.rubriques = [];
	$scope.qualificatifs = [];
	var promessesRubriques = [];
	var promessesQuestions = [];
	var promessesQualificatifs = [];
	
	$scope.isActive = '';
	$scope.selectLine = function (group) {
	    $scope.check = group.title
	};
	
	RubriqueEvaluationsService.getRubriqueEvaluationByIdEva($scope.evaId
	).then(
			function(success) {
				$scope.rubevaluations = success.data;
				//Récupère l'objet rubrique_evaluation à partir de ID EVALUATION (tableau pour faire for)
				console.log($scope.rubevaluations);
				angular.forEach($scope.rubevaluations, function(rubEval) {
					/*rubEval represente un seul objet qui normalement est dans le tableau rubevaluations*/
					console.log(rubEval);
					
					var rubrique = {
							idRubrique: null, 
							idRubriqueEvaluation: null, 
						    designation: null,
						    ordre: null,
						    type: null,
						    questions: []
					};
					
					rubrique.idRubrique = rubEval.idRubrique;
					rubrique.idRubriqueEvaluation = rubEval.idRubriqueEvaluation;
					
					
					$scope.rubriques.push(rubrique);
					promessesRubriques.push(RubriqueService.getRubrique(rubEval.idRubrique));
				});
				
				/*Récuperation de toute les promesses*/
				return $q.all(promessesRubriques);
			},
			function(error) {
				console.log("get evaluationRubrique: erreur");
				return error;
			}
	).then(
			function(reponsesPromessesRubriques) {
				console.log('------');
				console.log(reponsesPromessesRubriques);
				var index = 0;
				angular.forEach(reponsesPromessesRubriques, function(reponse) {
					$scope.rubriques[index].designation = reponse.data.designation;
					$scope.rubriques[index].ordre = reponse.data.ordre;
					$scope.rubriques[index].type = reponse.data.type;
					promessesQuestions.push(questionService.getQuestionEvaluation($scope.rubriques[index].idRubriqueEvaluation));		    
					index ++;		    	
				});
					
				console.log('------');
				console.log($scope.rubriques);
				console.log('------');
				/*Récuperation de toute les promesses*/
				return $q.all(promessesQuestions);	
			},
			function (error) {
				console.log("get Rubrique: erreur2");
			}
	).then(
			function(reponsesPromessesQuestions) {
				console.log('------R');
				console.log(reponsesPromessesQuestions);
				var index = 0;
				console.log($scope.rubriques);
				
				for(var i=0; i < reponsesPromessesQuestions.length; i++){
					for(var j=0; j < reponsesPromessesQuestions[i].data.length; j++){
						var question = {}
						question.idQualificatif = reponsesPromessesQuestions[i].data[j].idQualificatif;
						question.idQuestion = reponsesPromessesQuestions[i].data[j].idQuestion;
						question.intitule = reponsesPromessesQuestions[i].data[j].intitule;
						question.type = reponsesPromessesQuestions[i].data[j].type;
						
						$scope.rubriques[i].questions.push(question);
						
						promessesQualificatifs.push(QualificatifService.getQualificatif(reponsesPromessesQuestions[i].data[j].idQualificatif));
					}
				};
				
				console.log($scope.rubriques);
				
				return $q.all(promessesQualificatifs);
			},
			function(error) {
				console.log("get question: erreur");
			}
	).then(
			function(reponsesPromessesQualificatifs){
				console.log(reponsesPromessesQualificatifs);
				angular.forEach(reponsesPromessesQualificatifs, function(reponse) {
				//for(var index=0; index< reponsesPromessesQualificatifs.length; index++){
					for(var i=0; i<$scope.rubriques.length; i++){
						for(var j=0; j<$scope.rubriques[i].questions.length; j++){
							if($scope.rubriques[i].questions[j].idQualificatif == reponse.data.idQualificatif)
								$scope.rubriques[i].questions[j].qualificatif = reponse.data;
						}
					}
				})
				
				console.log($scope.rubriques);
			})
					
	
}	
}]);


