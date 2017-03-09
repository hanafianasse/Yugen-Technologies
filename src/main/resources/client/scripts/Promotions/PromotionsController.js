(function() {
	'use strict';

	angular.module('app').controller(
			'PromotionsController',
			[ '$scope', '$location', '$http', 'FormationsService', 'PromotionsService', 'EtudiantsService',
					function($scope, $location, $http, formationsService, promotionsService, etudiantsService) {

						  console.log("je suis dans la promotion");
						  
						  $scope.promotions = null; 
						  $scope.etudiants = null;
						  
						  
						  var promise = formationsService.();
						  promise.success(function(data) { $scope.formations =
						  data; }).error(function(data) { $scope.error =
						  'unable to get the poneys'; }); 
						  
						  // Affiche promotion
						  $scope.select = function(formation){ $scope.etudiants =
						  null; var promise =
						  promotionsFactory.getPromotion(formation.codeFormation);
						  promise.success(function(data,status) {
						  $scope.promotions = data ; console.log("get promotion
						  d'une formation : success : ");
						  }).error(function(data,status){ console.log("get
						  promotion d'une formation : erreur"); }); }
						 $scope.showEtudiants = function(promotion){ var
						  promise =
						  promotionsFactory.getEtudiants(promotion.codeFormation,promotion.anneeUniversitaire);
						  promise.success(function(data,status) {
						  $scope.etudiants = data ; console.log("get promotion
						  d'une formation : success : ");
						  }).error(function(data,status){ console.log("get
						  promotion d'une formation : erreur"); }); }
						 } ]);
})();
