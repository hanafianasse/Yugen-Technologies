(function() {
	'use strict';
	angular.module('app')
		.controller('PromotionsController',[ '$scope', '$location', '$http','formationService','promotionService','EtudiantsService',function($scope, $location, $http,formationService,promotionService,EtudiantsService) {

	console.log("je suis dans la promotion");

	$scope.formations = null;
	$scope.promotions = null; 
	$scope.etudiants = null;

	var promise = formationService.getAll();
	promise.success(function(data) { 
		$scope.formations = data;
	}).error(function(data) {
		console.log("get formtions : erreur");
	}); 
	
	// Affiche les promotions
	$scope.select = function(formation){
		$scope.etudiants = null; 
		//urlBase + '/' + id+'/promotion'
		var promise = formationService.getPromotions(formation.codeFormation);
		promise.success(function(data,status) {
			$scope.promotions = data ; 
		}).error(function(data,status){
			console.log("get promotion d'une formation : erreur");
		});
	}

	$scope.selectEtudiants = function(promotion){
		var promise = promotionService.getEtudiants(promotion.promotionPK.codeFormation,promotion.promotionPK.anneeUniversitaire);
		promise.success(function(data,status) {
			$scope.etudiants = data;
		}).error(function(data,status){
			console.log("get Etudiants d'une Promotion : erreur");
		});
	}
	
	$scope.supprime = function(etudiant){
		var promise = EtudiantsService.deleteEtudiant(etudiant.noEtudiant);
	    promise.success(function(status) 
		{
		//$scope.etudiants = data;
		}).error(function(data,status){
			console.log("supprimer etudiant : erreur");
		});
	}
} ]);
	
})();
