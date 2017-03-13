/**
 * Created by DOSI on 10/03/2017.
 */
'use strict';

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
        $rootScope.QualificatifToBeDeleted = qualificatif;
        $modal.open({
            templateUrl: 'myModalContent.html',
            backdrop: true,
            controller: function ($scope, $modalInstance,$rootScope,QualificatifService) {
                $scope.annulerSuppresion = function () {
                    $modalInstance.dismiss('cancel');
                };
                $scope.doSupprimer = function(){
                    console.log(" here ::: --->>> "+$rootScope.QualificatifToBeDeleted.idQualificatif);
                    var promise = QualificatifService.deleteQualificatif($rootScope.QualificatifToBeDeleted.idQualificatif);
                    promise.success(function(status){
                        $rootScope.message = "Qualificatif supprimé";
                        $rootScope.etat = "done";
                        $rootScope.refresh();
                    }).error(function(data,status){
                        $rootScope.message = "impossible de supprimer cet Qualificatif";
                        $rootScope.etat = "not done";
                    });

                };
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



}]);
