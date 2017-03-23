/**
 * Created by DOSI on 10/03/2017.
 */
'use strict';

angular.module('app').controller('EvaluationsCtrl', ['RubriqueService','$scope','$route','$rootScope','$routeParams','$http','$location','EvaluationService','$modal','promotionService',function (RubriqueService,$scope,$route,$rootScope,$routeParams,$http,$location, EvaluationService,$modal,promotionService) {

    console.log('je suis la');
    /************************** info Generale Start  ************************************/
    $scope.tabs = ['info','rubrique','question'];

	$scope.changeTab = function(tab){
		var selectedTab = document.getElementById(tab);
		selectedTab.classList.add("active");
		var selectedTabContent = document.getElementById(tab+"Content");
		selectedTabContent.classList.add("active");
		for(var index = 0 ; index < $scope.tabs.length; index ++){
			if($scope.tabs[index] != tab){
				var otherTab = document.getElementById($scope.tabs[index]);
				otherTab.classList.remove("active");
				var otherTabContent = document.getElementById($scope.tabs[index]+"Content");
				otherTabContent.classList.remove("active");
			}
		}
    };

    var promise = promotionService.getPromotionsEnCours();
    promise.success(function(data) {
        $scope.promotions = data;
    }).error(function(data) {
        console.log("get promotions : erreur");
    });

    /************************** info Generale End  ************************************/




    /************************** Rubrique Start ************************************/
    var promise = RubriqueService.getAll();
    promise.success(function (data){
      $scope.rubriques = data;
       console.log($scope.rubriques);
    }).error(function(statut){
       console.log("et rubriques erreur");
    });
    
    $scope.selectRubrique = function(){
        var myObject = {"rubrique" : ""};
        myObject.rubrique = getRubriqueById($scope.selectedIdRubrique);
        $scope.models.lists.mesRubriquesSelected.push(myObject);  
        $scope.selectedIdRubrique = null; 
    }
    $scope.models = {
        selected: null,
        lists: {"mesRubriquesSelected": []}
    };
    // Model to JSON for demo purpose
    $scope.$watch('models', function(model) {
        $scope.modelAsJson = angular.toJson(model, true);
    }, true);

    var getRubriqueById = function(id){
        for(var i = 0; i < $scope.rubriques.length;i++){
            if($scope.rubriques[i].idRubrique == id){
                return $scope.rubriques[i];
            }
        }
        return null;
    }

    $scope.deleteRubrique = function(idRubrique){
        for(var i = 0 ; i < $scope.models.lists.mesRubriquesSelected.length ; i++){
            if($scope.models.lists.mesRubriquesSelected[i].rubrique.idRubrique == idRubrique){
                console.log($scope.models.lists.mesRubriquesSelected[i]);
                $scope.models.lists.mesRubriquesSelected.splice(i,1);
                break;
            }
        }
    }

    /************************** Rubrique End ************************************/




    /************************** Question Start ************************************/

    /************************** Question End ************************************/
}]);
