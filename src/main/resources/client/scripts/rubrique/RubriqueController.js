/**
 *
 */

angular.module('app').controller('RubriqueController', ['$scope','$route','$rootScope','$routeParams','$http','RubriqueService','$modal','$location',
function ($scope,$route,$rootScope,$routeParams,$http, RubriqueService,$modal,$location) {

    $('input').on('input', function() {
        var c = this.selectionStart,
            r = /[^a-z0-9êéàçèù \-]/gi,
            v = $(this).val();
        if(r.test(v)) {
            $(this).val(v.replace(r, ''));
            c--;
        }
        this.setSelectionRange(c, c);
    });

    $scope.getRubriques = function(){
        var promise = RubriqueService.getAll();
        promise.success(function(data) {
            $scope.mesrubriques = data;
            console.log( $scope.mesrubriques);
            console.log(data);
        }).error(function(data) {
            console.log("get rubriques : erreur");
        });
    };

    $scope.getRubriques();

    $rootScope.refresh =$scope.getRubriques	;




    $scope.ouvrirModelSuppresion = function(rubrique){
        $rootScope.etat = null;
        $rootScope.rubriqueToBeDeleted = rubrique;
        $modal.open({
            templateUrl: 'myRubriqueModalContent.html',
            backdrop: true,
            controller: function ($scope, $modalInstance,$rootScope,RubriqueService) {
                $scope.annulerSuppresion = function () {
                    $modalInstance.dismiss('cancel');
                };
                $scope.doSupprimer = function(){
                    var promise = RubriqueService.deleteRubrique($rootScope.rubriqueToBeDeleted.idRubrique);
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

    if ($routeParams.idRubrique!=null){
    	 var promise = RubriqueService.getRubrique($routeParams.idRubrique);
         promise.success(function(data){
        	 $scope.rubrique=data;
        	// $scope.rubrique.idRubrique=$routeParams.idRubrique;
        	 console.log( $scope.rubrique);
         }).error(function(status){
             console.log(" rubrique : error");
         });
    }



    $scope.addRubrique=function () {
        $scope.rubrique.type = 'RBS';
        var promise = RubriqueService.addRubrique($scope.rubrique);
        promise.success(function(data){
            $location.path("/admin/RubriqueStandard");
        }).error(function(status){
            console.log(" rubrique : error");
        });
    }

    $scope.update = function(){
        $scope.rubrique.type = 'RBS';
		var promise = RubriqueService.updateRubrique($scope.rubrique);
		promise.success(function(data){
			$location.path("/admin/RubriqueStandard");
		}).error(function(status){
			console.log('update Rubrique : error');
		});
	}
}]);
