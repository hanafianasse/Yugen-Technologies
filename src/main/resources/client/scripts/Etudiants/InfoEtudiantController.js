angular.module('app').controller('infoEtudiantCtrl', ['$scope', '$location', 'EtudiantsService','$routeParams','$rootScope',
    function ($scope, $location, EtudiantsService,$routeParams,$rootScope) {

    	//Récupération d'un étudiant
    $scope.getEtudiant=function  () {
   console.log("i'm here");
    var promise=EtudiantsService.getEtudiant($rootScope.connectedUser.noEtudiant);
    promise.success(function(data){
        $scope.etudiant=data;
        
    }).error(function(data){
        console.log("get etudiant : erreur");

    });
    };
    $scope.getEtudiant();
    }]);