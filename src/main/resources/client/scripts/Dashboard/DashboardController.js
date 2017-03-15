/**
 * Created by DOSI on 15/03/2017.
 */
angular.module('app').controller('DashboardController', ['$scope', '$location','$routeParams', 'EtudiantsService', 'formationService','promotionService','enseignantsFactory',function ($scope,$route,$routeParams,EtudiantsService, formationService,PromotionsService,enseignantsFactory) {

    $scope.nbEnseignant = null;

    function getNbEnseignant() {
        enseignantsFactory.getNbEnseignant().then(function (response) {
            $scope.nbEnseignant = response.data;
            console.log($scope.nbEnseignant);
        }, function (error) {
            console.log("get nbEnseignant : erreur");
        });

    };
    getNbEnseignant();

    function getNbEtudiant() {
        EtudiantsService.getNbEtudiant().then(function (response) {
            $scope.nbEtudiant = response.data;
            console.log($scope.nbEtudiant);
        }, function (error) {
            console.log("get nbEtudiant : erreur");
        });

    };
    getNbEtudiant();

}]);
