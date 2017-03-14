/**
 * 
 */


angular.module('app').controller('RubriqueController', ['$scope','$routeParams','$http','RubriqueService',function ($scope,$routeParams,$http, RubriqueService) {

    $scope.mesrubriques = [];

    $scope.getRubriques = function(){   
        var promise = RubriqueService.getAll();
        promise.success(function(data) {
            $scope.mesrubriques = data;
        }).error(function(data) {
            console.log("get rubriques : erreur");
        });
    };
    
    $rootScope.refresh = $scope.getRubriques;
    
    $scope.ouvrirModelSuppresion = function(rubrique){
        //console.log(qualificatif);
        $rootScope.etat = null;
        $rootScope.rubriqueToBeDeleted = rubrique;
        $modal.open({
            templateUrl: 'myModalContent.html',
            backdrop: true,
            controller: function ($scope, $modalInstance,$rootScope,RubriqueService) {
                $scope.annulerSuppresion = function () {
                    $modalInstance.dismiss('cancel');
                };
                $scope.doSupprimer = function(){
                  //  console.log(" here ::: --->>> "+$rootScope.QualificatifToBeDeleted.idQualificatif);
                    var promise = QualificatifService.deleteQualificatif($rootScope.QualificatifToBeDeleted.idQualificatif);
                    promise.success(function(status){
                        $rootScope.message = "Rubrique supprimé";
                        $rootScope.etat = "done";
                        $rootScope.refresh();
                    }).error(function(data,status){
                        $rootScope.message = "impossible de supprimer cette Rubrique";
                        $rootScope.etat = "not done";
                    });

                };
            }
        });
    }
    
    $scope.addrubrique=function () {

        $scope.rubrique["Content-Type"]="application/json";
       RubriqueService.addRubrique($scope.rubrique);
        $location.path("/admin/rubrique");

    }
    
    


}]);
