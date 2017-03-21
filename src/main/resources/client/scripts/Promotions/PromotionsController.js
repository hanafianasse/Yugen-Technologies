(function() {
	'use strict';
	angular.module('app')
		.controller('PromotionsController',[ '$scope', '$location', '$http','$q','formationService','promotionService','EtudiantsService','$modal','$rootScope','$routeParams',function($scope, $location, $http, $q, formationService,promotionService,EtudiantsService,$modal,$rootScope,$routeParams) {
/*
	$scope.formations = null;
	$scope.promotions = null;
	$scope.etudiants = null;*/
	$rootScope.promotionselected = null;

	//Récupération de toutes les formations
	var promise = formationService.getAll();
	promise.success(function(data) {
		$scope.formations = data;
		for(var index = 0; index < $scope.formations.length ;index++){
			if($scope.formations[index].doubleDiplome == 'O'){
				$scope.formations[index].doubleDiplome = 'Oui';
			}
			if($scope.formations[index].doubleDiplome == 'N'){
				$scope.formations[index].doubleDiplome = 'Non';
			}
		}
	}).error(function(data) {
		console.log("get formtions: erreur");
	});	

	// Affiche les promotions
	$scope.select = function(formation){
		$rootScope.selectedFormation = formation;
		$scope.selectedCodeFormation = formation.codeFormation;
		if($rootScope.promotionselected != null){
			$rootScope.promotionselected = null;
		}
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

			$q.all(promise).then(function () {
				angular.forEach($scope.promotions, function(promotion) {
					EtudiantsService.getNbEtudiantParPromotion(promotion.promotionPK.codeFormation, promotion.promotionPK.anneeUniversitaire).success(function (data) {
						promotion.nombreEtudiants = data;
					}, function (error) {
						console.log("GetNombreEtudiantParPromotion: Error");
					});
				});
			});
		}).error(function(data,status){
			console.log("get promotion d'une formation : erreur");
		});
	}

	$scope.selectEtudiants = function(promotion){
		$scope.selectedAnneeUniversitaire = promotion.promotionPK.anneeUniversitaire;
		$rootScope.promotionselected = promotion;
		for(var index = 0; index < $scope.promotions.length; index++) {
			var tr = document.getElementById(($scope.promotions[index]).promotionPK.anneeUniversitaire);
			tr.classList.remove("trSelected");
		}
		var tr = document.getElementById(promotion.promotionPK.anneeUniversitaire);
		tr.classList.add("trSelected");
		var promise = promotionService.getEtudiants(promotion.promotionPK.codeFormation,promotion.promotionPK.anneeUniversitaire);
		promise.success(function(data,status) {
			$scope.etudiants = data;
			for(var index = 0; index < $scope.etudiants.length; index++){
				if($scope.etudiants[index].telephone == null){
					$scope.etudiants[index].telephone = "--";
				}
			}
		}).error(function(data,status){
			console.log("get Etudiants d'une Promotion : erreur");
		});
	}

	$rootScope.selectEtudiants = $scope.selectEtudiants;
	$rootScope.selectPromotions = $scope.select;

    	$scope.ouvrirModelSuppresion = function(etudiant){
		$rootScope.EtudiantToBeDeleted = etudiant;
		$rootScope.etat = null;
		$modal.open({
			templateUrl: 'myModalContent.html',
			backdrop: true,
			controller: function ($scope, $modalInstance,$rootScope,EtudiantsService) {
				$scope.annulerSuppresion = function () {
					$modalInstance.dismiss('cancel');
					$rootScope.selectEtudiants($rootScope.promotionselected);
					$modalInstance.dismiss('cancel');
				};
				$scope.doSupprimer = function(){
					console.log($rootScope.EtudiantToBeDeleted.noEtudiant);
					var promise = EtudiantsService.deleteEtudiant($rootScope.EtudiantToBeDeleted.noEtudiant);
	    			promise.success(function(status){

	    				$modalInstance.dismiss('cancel');
						//$rootScope.message = "Etudiant supprimé";
						//$rootScope.etat = "done";

						$rootScope.etat = "done";
						var selectedPromotion =  $rootScope.promotionselected;
						$rootScope.selectPromotions($rootScope.selectedFormation);
						$rootScope.promotionselected = selectedPromotion;
						

						$rootScope.selectEtudiants($rootScope.promotionselected);
					}).error(function(data,status){
						$rootScope.message = "Impossible de supprimer l'étudiant(e) choisi(e) !";
 						$rootScope.etat = "not done";
					});
				};
			}
		});
	}

	if($routeParams.anneeUniversitaire != null && $routeParams.codeFormation != null){
		var promise = formationService.getFormation($routeParams.codeFormation);
		promise.success(function(data){
			$scope.select(data);
			var anotherPromise = formationService.getPromotions($routeParams.codeFormation);
			anotherPromise.success(function(data_){
				var promotions = data_;
				for(var index = 0; index < promotions.length ;index++){
					if(promotions[index].promotionPK.anneeUniversitaire == $routeParams.anneeUniversitaire){
						$scope.selectEtudiants(promotions[index]);
						break;
					}
				}
			}).error(function(statu){
				console.log("get promotion : error");
			});
		}).error(function(statu){
			console.log("get formation : error");
		});
	}
} ]);

})();
