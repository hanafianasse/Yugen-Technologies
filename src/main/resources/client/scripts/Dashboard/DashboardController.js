/**
 * Created by DOSI on 15/03/2017.
 */
angular.module('app').controller('DashboardController', ['$scope', '$location','$routeParams', 'EtudiantsService', 'formationService','promotionService','enseignantsFactory',function ($scope,$route,$routeParams,EtudiantsService, formationService,PromotionsService,enseignantsFactory) {



    function getNbEnseignant() {
        enseignantsFactory.getNbEnseignant().then(function (response) {
            $scope.nbEnseignant = response.data;
        }, function (error) {
            console.log("get nbEnseignant : erreur");
        });

    };
    getNbEnseignant();

    function getNbEtudiant() {
        EtudiantsService.getNbEtudiant().then(function (response) {
            $scope.nbEtudiant = response.data;
        }, function (error) {
            console.log("get nbEtudiant : erreur");
        });

    };
    getNbEtudiant();

    function getNbFormations() {
        formationService.getNbFormations().then(function (response) {
            $scope.nbFormation = response.data;
        }, function (error) {
            console.log("get nbFormation : erreur");
        });

    };
    getNbFormations();

    function getNbPromotion() {
        PromotionsService.getNbPromotion().then(function (response) {
            $scope.nbPromotion = response.data;
        }, function (error) {
            console.log("get nbPromotion : erreur");
        });

    };
    getNbPromotion();

}]);
