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

//recupération des rubriques 

$scope.select = function(evaluation){
	console.log('affichage des rubriques liées a l\'évaluation'+ evaluation.designation);
	
	
}


}]);
