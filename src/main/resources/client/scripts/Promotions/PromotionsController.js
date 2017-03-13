(function() {
	'use strict';
	angular.module('app')
		.controller('PromotionsController',[ '$scope', '$location', '$http','formationService','promotionService','EtudiantsService','$modal','$rootScope',function($scope, $location, $http,formationService,promotionService,EtudiantsService,$modal,$rootScope) {

	console.log("je suis dans la promotion");

	$scope.formations = null;
	$scope.promotions = null; 
	$scope.etudiants = null;
	
//Récupération de toutes les formations
	var promise = formationService.getAll();
	promise.success(function(data) { 
		console.log("récupération des formation terminé");
		$scope.formations = data;
	}).error(function(data) {
		console.log("get formtions : erreur");
	});

	
// Affiche les promotions liéé a une formation
	$scope.select = function(formation){
		$scope.selectedCodeFormation = formation.codeFormation;
		for(var index = 0; index < $scope.formations.length; index++) {
			var tr = document.getElementById(($scope.formations[index]).codeFormation);
			tr.classList.remove("trSelected");
		}
		var tr = document.getElementById(formation.codeFormation);
		tr.classList.add("trSelected");
		$scope.etudiants = null;
		var promise = formationService.getPromotions(formation.codeFormation);
		promise.success(function(data,status) {
			$scope.promotions = [];
			for(var index = 0; index < data.length; index++) {
				var res = data[index].promotionPK.anneeUniversitaire.split("-");
				var promotion = {
					promotionPK : {
						anneeUniversitaire : data[index].promotionPK.anneeUniversitaire,
						codeFormation : data[index].promotionPK.codeFormation
					},
					dateRentree : data[index].dateRentree,
					lieuRentree : data[index].lieuRentree,
					debutAnneeUniversitaire : res[0]
				};
				$scope.promotions.push(promotion);
			}
		}).error(function(data,status){
			console.log("get promotion d'une formation : erreur");
		});
	}

	$scope.selectEtudiants = function(promotion){
		$scope.selectedAnneeUniversitaire = promotion.promotionPK.anneeUniversitaire;
		for(var index = 0; index < $scope.promotions.length; index++) {
			console.log(($scope.promotions[index]).promotionPK.anneeUniversitaire);
			var tr = document.getElementById(($scope.promotions[index]).promotionPK.anneeUniversitaire);
			tr.classList.remove("trSelected");
		}
		var tr = document.getElementById(promotion.promotionPK.anneeUniversitaire);
		tr.classList.add("trSelected");
		var promise = promotionService.getEtudiants(promotion.promotionPK.codeFormation,promotion.promotionPK.anneeUniversitaire);
		promise.success(function(data,status) {
			$scope.etudiants = data;
			for(var index = 0; index < $scope.etudiants.length; index++){
				console.log($scope.etudiants[index].noEtudiant);
				if($scope.etudiants[index].telephone == null){
					$scope.etudiants[index].telephone = "--";
				}
			}
		}).error(function(data,status){
			console.log("get Etudiants d'une Promotion : erreur");
		});
	}

	$scope.ouvrirModelSuppresion = function(etudiant){
		$rootScope.EtudiantToBeDeleted = etudiant;
		$modal.open({
			templateUrl: 'myModalContent.html',
			backdrop: true,
			controller: function ($scope, $modalInstance,$rootScope,EtudiantsService) {
				$scope.annulerSuppresion = function () {
					$modalInstance.dismiss('cancel');
				};
				$scope.doSupprimer = function(){
					console.log($rootScope.EtudiantToBeDeleted.noEtudiant);
					var promise = EtudiantsService.deleteEtudiant($rootScope.EtudiantToBeDeleted.noEtudiant);
	    			promise.success(function(status){
	    				console.log('Yes Working'+ status);
					}).error(function(data,status){
						console.log("supprimer etudiant : erreur");
					});
					$modalInstance.dismiss('cancel');
				};
			}
		});	
	}
} ]);
	
})();
