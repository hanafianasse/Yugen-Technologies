(function() {
	'use strict';
	angular.module('app')
		.controller('PromotionsController',[ '$scope', '$location', '$http','formationService','promotionService','EtudiantsService','$modal','$rootScope',function($scope, $location, $http,formationService,promotionService,EtudiantsService,$modal,$rootScope) {

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
		}).error(function(data,status){
			console.log("get promotion d'une formation : erreur");
		});
	}

	$scope.selectEtudiants = function(promotion){
		$rootScope.promotionselected = promotion;
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
				if($scope.etudiants[index].telephone == null){
					$scope.etudiants[index].telephone = "--";
				}
			}
		}).error(function(data,status){
			console.log("get Etudiants d'une Promotion : erreur");
		});
	}

	$rootScope.selectEtudiants = $scope.selectEtudiants;

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
						$rootScope.message = "Etudiant supprimé";
						$rootScope.etat = "done";
						$rootScope.selectEtudiants($rootScope.promotionselected);
					}).error(function(data,status){
						$rootScope.message = "impossible de supprimer cet étudiant(e)";
 						$rootScope.etat = "not done";
					});
				};
			}
		});
	}
} ]);

})();
