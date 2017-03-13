/**
 * Created by DOSI on 10/03/2017.
 */
'use strict';


angular.module('app').controller('QualificatifsCtrl', ['$scope','$route','$rootScope','$routeParams','$http','QualificatifService','$modal',function ($scope,$route,$rootScope,$routeParams,$http, QualificatifService,$modal) {

    console.log("je suis dans qualificatif");
    $scope.qualificatifs = [];




    var promise = QualificatifService.getAll();
    promise.success(function(data) {
        $scope.qualificatifs = data;
    }).error(function(data) {
        console.log("get qualificatifs : erreur");
    });


    $rootScope.selectQualificatifs = $scope.selectQualificatifs;

    $scope.ouvrirModelSuppresion = function(qualificatif){
        $rootScope.QualificatifToBeDeleted = qualificatif;
        $modal.open({
            templateUrl: 'myModalContent.html',
            backdrop: true,
            controller: function ($scope, $modalInstance,$rootScope,QualificatifService) {
                console.log($rootScope.message);
                $scope.annulerSuppresion = function () {
                    $modalInstance.dismiss('cancel');

                };

                $scope.doSupprimer = function(idQualificatif){
                    console.log($rootScope.QualificatifToBeDeleted.idQualificatif);
                    var promise = QualificatifService.deleteQualificatif($rootScope.QualificatifToBeDeleted.idQualificatif);
                    promise.success(function(status){
                        $rootScope.message = "Qualificatif supprimé";
                        $rootScope.etat = "done";
                        var promise = QualificatifService.getAll();
                        promise.success(function(data) {
                            $scope.qualificatifs = data;
                        }).error(function(data) {
                            console.log("get qualificatifs : erreur");
                        });
                    }).error(function(data,status){
                        $rootScope.message = "impossible de supprimer cet Qualificatif";
                        $rootScope.etat = "not done";
                    });

                };


                // Crée la page permettant d'ajouter un qualificatif
                $scope.ajoutFormation = function(){
                    $location.path("/admin/qualificatif/nouveau");
                }








            }
        });
    }


}]);
