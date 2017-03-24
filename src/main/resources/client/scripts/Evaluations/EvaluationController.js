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

    var promise = promotionService.getAll();
    promise.success(function(data) {
        $scope.promotions = data;
    }).error(function(data) {
        console.log("get promotions : erreur");
    });

    /************************** info Generale End  ************************************/




    /************************** Rubrique Start ************************************/

    var RubriqueShowed = [];

    var promise = RubriqueService.getAll();
    promise.success(function (data){
      $scope.rubriques = data;
    }).error(function(statut){
       console.log("get rubriques erreur");
    });
    
    // add question to the dnd list
    $scope.selectRubrique = function(){
        var myObject = {"rubrique" : "","questions":[]};
        myObject.rubrique = getRubriqueById($scope.selectedIdRubrique);
        $scope.models.lists.mesRubriquesSelected.push(myObject);  
        $scope.selectedIdRubrique = null; 
    }

    $scope.models = {
        selected: null,
        lists: {"mesRubriquesSelected": []}
    };

    // Model to JSON for demo purpose (generet the new list)
    $scope.$watch('models', function(model) {
        $scope.modelAsJson = angular.toJson(model, true);
    }, true);

    $scope.modelsQuestion = {
        selected: null,
        lists: {"mesQuestionsSelected": $scope.models.lists.mesRubriquesSelected.questions}
    };

    $scope.$watch('modelsQuestion', function(model) {
        $scope.modelAsJson = angular.toJson(model, true);
    }, true);

    //this is a local function
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

    if($rootScope.QuestionSelected == undefined){
        $rootScope.QuestionSelected = [];
    }

    $scope.addQuestionsToRubrique = function(){
        for(var index = 0 ; index < $rootScope.QuestionSelected.length ;index++){
            for(var j = 0; j < $scope.models.lists.mesRubriquesSelected.length ;j++){
                if($rootScope.QuestionSelected[index].idRubrique == $scope.models.lists.mesRubriquesSelected[j].rubrique.idRubrique){
                    $scope.models.lists.mesRubriquesSelected[j].questions.push($rootScope.QuestionSelected[index].question);
                    RubriqueShowed.push($scope.models.lists.mesRubriquesSelected[j].rubrique.idRubrique);
                }
            }
        }
        console.log($scope.models.lists.mesRubriquesSelected);
    }

    $scope.deleteQuestionFromRubrique = function(idRubrique,idQuestion){
        console.log(idRubrique + " " + idQuestion);
        for(var i = 0 ; i < $scope.models.lists.mesRubriquesSelected.length; i++){
            for(var j = 0 ; j < $scope.models.lists.mesRubriquesSelected[i].questions.length ; j++ ){
                if($scope.models.lists.mesRubriquesSelected[i].rubrique.idRubrique == idRubrique
                && $scope.models.lists.mesRubriquesSelected[i].questions[j].idQuestion == idQuestion ){
                    $scope.models.lists.mesRubriquesSelected[i].questions.splice(j,1);
                }
            }
        }
    }

    $rootScope.refresh = $scope.addQuestionsToRubrique;


    $scope.rubriqueClicked = function(idRubrique){
        var bool = false;
        RubriqueShowed.forEach(function(item, index){
            if(item == idRubrique){
                RubriqueShowed.splice(index,1);
                bool = true;
            }
        });
        
        if(!bool)
            RubriqueShowed.push(idRubrique);
    }

    $scope.verifyShowedRubriques = function(idRubrique){
        return RubriqueShowed.includes(idRubrique);
    }

    $scope.openModalAddQuestion = function(idRubrique){
        if($rootScope.QuestionSelected.length != 0){
            $rootScope.QuestionSelected = [];
        }
        console.log($rootScope.QuestionSelected);
        $rootScope.selectedIdRubrique = idRubrique;
        $modal.open({
            templateUrl: 'AddQuestionModalContent.html',
            backdrop: false,
            controller: function ($scope, $modalInstance,$rootScope,questionService) {
                $scope.annuler = function () {
                    $modalInstance.dismiss('cancel');
                };

                // get questions and add them to the select input
                var promise = questionService.getAll();
                promise.success(function (data){
                  $scope.questions = data;
                }).error(function(statut){
                   console.log("get questions : erreur");
                });

                $scope.models = {
                    selected: null,
                    lists: {"mesQuestionsSelected": []}
                };

                var getQuestionById = function(id){
                    for(var i = 0; i < $scope.questions.length ; i++){
                        if($scope.questions[i].idQuestion == id){
                            return $scope.questions[i];
                        }
                    }
                    return null;
                }

                $scope.selectQuestion = function(){
                    var myObject = {"question" : ""};
                    myObject.question = getQuestionById($scope.selectedIdQuestion);;
                    $scope.models.lists.mesQuestionsSelected.push(myObject);  
                    $scope.selectedIdQuestion = null; 
                }

                // add question to the dnd list
                $scope.deleteQuestion = function(idQuestion){
                    for(var i = 0 ; i < $scope.models.lists.mesQuestionsSelected.length ; i++){
                        if($scope.models.lists.mesQuestionsSelected[i].question.idQuestion == idQuestion){
                            $scope.models.lists.mesQuestionsSelected.splice(i,1);
                            break;
                        }
                    }
                }

                $scope.validerLesQuestions = function(){
                    for(var index = 0; index < $scope.models.lists.mesQuestionsSelected.length ;index++){
                        var myObject = {"idRubrique": "","question":""}
                        myObject.idRubrique = $rootScope.selectedIdRubrique;
                        myObject.question = $scope.models.lists.mesQuestionsSelected[index].question;
                        $rootScope.QuestionSelected.push(myObject);                        
                    }
                    $rootScope.refresh();
                    $modalInstance.dismiss('cancel');
                }




            }
        });
    }

    /************************** Rubrique End ************************************/




    /************************** Question Start ************************************/

    /************************** Question End ************************************/
}]);
