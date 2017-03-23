/**
 * Created by DOSI on 10/03/2017.
 */
'use strict';

angular.module('app').controller('EvaluationListCtrl', ['$scope','$route','$rootScope','$routeParams','$http','$location','EvaluationService','RubriqueService','$modal',function ($scope,$route,$rootScope,$routeParams,$http,$location, EvaluationService, RubriqueService,$modal) {


console.log("je suis dans EvaluationListController");

//Recupération de toutes les évaluations
var promiseEvaluation = EvaluationService.getAll();
promiseEvaluation.success(function(data) {
	$scope.evaluations = data;
	console.log($scope.evaluations);
}).error(function(data) {
	console.log("get evaluation: erreur");
});



//Recupération des rubriques 
$scope.select = function(evaluation){
	$scope.evaCodeFormation = evaluation.codeFormation;
	
	$scope.evaCodeUe = evaluation.codeUe;
	$scope.evaCodeEc = evaluation.codeEc;
	$scope.evaPeriode = evaluation.periode;
	
	console.log($scope.evaCodeFormation);
	console.log('affichage des rubriques liées a l\'évaluation'+ evaluation.designation);
	$rootScope.selectedEvaluation = evaluation.idEvaluation;
	$scope.selectIdEvaluation = evaluation.idEvaluation;
	console.log($scope.selectIdEvaluation);
	
	var promiseRubrique = RubriqueService.getRubriqueEvaluation($scope.selectIdEvaluation);
	promiseRubrique.success(function(data) {
		$scope.rubriques = data;
		console.log($scope.rubriques);
	}).error(function(data) {
		console.log("get rubrique: erreur");
	});
	
	
}


}]);
