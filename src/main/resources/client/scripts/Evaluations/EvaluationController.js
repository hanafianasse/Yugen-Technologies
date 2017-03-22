/**
 * Created by DOSI on 10/03/2017.
 */
'use strict';

angular.module('app').controller('EvaluationsCtrl', ['$scope','$route','$rootScope','$routeParams','$http','$location','EvaluationService','$modal','promotionService',function ($scope,$route,$rootScope,$routeParams,$http,$location, EvaluationService,$modal,promotionService) {

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

    var promise = promotionService.getAll();
    promise.success(function(data) {
        $scope.promotions = data;
    }).error(function(data) {
        console.log("get promotions : erreur");
    });

    /************************** info Generale End  ************************************/




    /************************** Rubrique Start ************************************/
    $scope.models = {
        selected: null,
        lists: {"A": [], "B": []}
    };

    // Generate initial model
    for (var i = 1; i <= 3; ++i) {
        $scope.models.lists.A.push({label: "Item A" + i});
        $scope.models.lists.B.push({label: "Item B" + i});
    }

    // Model to JSON for demo purpose
    $scope.$watch('models', function(model) {
        $scope.modelAsJson = angular.toJson(model, true);
    }, true);

    /************************** Rubrique End ************************************/




    /************************** Question Start ************************************/

    /************************** Question End ************************************/
}]);
