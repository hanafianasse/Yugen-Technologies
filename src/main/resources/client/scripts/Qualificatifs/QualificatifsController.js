/**
 * Created by DOSI on 10/03/2017.
 */
'use strict';

<<<<<<< HEAD

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
=======
angular.module('app').controller('QualificatifsCtrl', ['$scope','$route','$rootScope','$routeParams','$http','$location','QualificatifService','$modal',function ($scope,$route,$rootScope,$routeParams,$http,$location, QualificatifService,$modal) {

    $scope.qualificatifs = [];


    $scope.getQualificatifs = function(){

        console.log("je suis dans qualificatif");
        var promise = QualificatifService.getAll();
        promise.success(function(data) {
            $scope.qualificatifs = data;
        }).error(function(data) {
            console.log("get qualificatifs : erreur");
        });
    };

    $scope.getQualificatifs();

    $rootScope.refresh = $scope.getQualificatifs;

    $scope.ouvrirModelSuppresion = function(qualificatif){
        console.log(qualificatif);
        $rootScope.etat = null;
>>>>>>> 96940b3ce9510d51304df903aae68d5641c2057e
        $rootScope.QualificatifToBeDeleted = qualificatif;
        $modal.open({
            templateUrl: 'myModalContent.html',
            backdrop: true,
            controller: function ($scope, $modalInstance,$rootScope,QualificatifService) {
<<<<<<< HEAD
                console.log($rootScope.message);
                $scope.annulerSuppresion = function () {
                    $modalInstance.dismiss('cancel');

                };

                $scope.doSupprimer = function(idQualificatif){
                    console.log($rootScope.QualificatifToBeDeleted.idQualificatif);
=======
                $scope.annulerSuppresion = function () {
                    $modalInstance.dismiss('cancel');
                };
                $scope.doSupprimer = function(){
                    console.log(" here ::: --->>> "+$rootScope.QualificatifToBeDeleted.idQualificatif);
>>>>>>> 96940b3ce9510d51304df903aae68d5641c2057e
                    var promise = QualificatifService.deleteQualificatif($rootScope.QualificatifToBeDeleted.idQualificatif);
                    promise.success(function(status){
                        $rootScope.message = "Qualificatif supprimé";
                        $rootScope.etat = "done";
<<<<<<< HEAD
                        var promise = QualificatifService.getAll();
                        promise.success(function(data) {
                            $scope.qualificatifs = data;
                        }).error(function(data) {
                            console.log("get qualificatifs : erreur");
                        });
=======
                        $rootScope.refresh();
>>>>>>> 96940b3ce9510d51304df903aae68d5641c2057e
                    }).error(function(data,status){
                        $rootScope.message = "impossible de supprimer cet Qualificatif";
                        $rootScope.etat = "not done";
                    });

                };
<<<<<<< HEAD


                // Crée la page permettant d'ajouter un qualificatif
                $scope.ajoutFormation = function(){
                    $location.path("/admin/qualificatif/nouveau");
                }








            }
        });
    }


=======
            }
        });
    }
    $scope.addQualificatif=function () {

        $scope.qualificatif["Content-Type"]="application/json";
        QualificatifService.addQualificatif($scope.qualificatif);
        $location.path("/admin/qualificatif");

    }

    $scope.cancel = function() {

        $location.path('/admin/qualificatif');

    }



>>>>>>> 96940b3ce9510d51304df903aae68d5641c2057e
}]);
