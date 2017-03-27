/**
 * Created by DOSI on 10/03/2017.
 */
'use strict';

angular.module('app').controller('EvaluationsCtrl', ['QuestionEvaluationsService','RubriqueEvaluationsService','RubriqueService','$scope','$q','$route','$rootScope','$routeParams','$http','$location','EvaluationService','$modal','promotionService','UEService','ECService','domaineService',
    function (QuestionEvaluationsService,RubriqueEvaluationsService,RubriqueService,$scope,$q,$route,$rootScope,$routeParams,$http,$location, EvaluationService,$modal,promotionService,UEService,ECService,domaineService) {

    /************************** info Generale Start  ************************************/

    var promise = domaineService.getDomaine('ETAT-EVALUATION');
    promise.success(function(data){
        $scope.etatsEvaluation = data;
        $scope.evaluation = {};
        $scope.evaluation.etat = "ELA";
        angular.forEach($scope.etatsEvaluation,function(item,index){
            if(item.rvAbbreviation == 'ELA'){
                $scope.etatsEvaluation.splice(index,1);
            }
        });
    }).error(function(status){
        console.log('get Etat evaluation (domaine) : error');
    });

    var promise = promotionService.getPromotionsEnCours();
    promise.success(function(data) {
        $scope.promotions = data;
    }).error(function(data) {
        console.log("get promotions : erreur");
    });

    $scope.selectUE=function () {
        var promise = UEService.getByCodeFormation($scope.evaluation.codeFormation);
        promise.success(function(data) {
            $scope.UE = data;
        }).error(function(data) {
            console.log("get UE : erreur");
        });

    }
    $scope.selectEC=function () {
        var promise = ECService.getByCodeUe($scope.evaluation.codeUe);
        promise.success(function(data) {
            $scope.EC = data;
        }).error(function(data) {
            console.log("get EC : erreur");
        });

    }

    $scope.addEvaluation=function () {
        $scope.evaluation.noEnseignant = $rootScope.connectedUser.noEnseignant;
        $scope.evaluation.anneeUniversitaire = "2016-2017";
        $scope.evaluation.noEvaluation = 1;
        console.log($scope.evaluation);
        var promise = EvaluationService.addEvaluation($scope.evaluation);
        promise.success(function(data){
            console.log(data);
            $rootScope.addedEvaluationId = data.idEvaluation;
        }).error(function(data){
            $modal.open({
                templateUrl: 'ajoutEvaError.html',
                backdrop: true,
                controller: function ($scope, $modalInstance,$rootScope,questionService) {
                    $scope.annuler = function(){
                        $modalInstance.dismiss('cancel');
                    }
                }
            });
        });
    }
    /************************** info Generale End  ************************************/




    /************************** Rubrique Start ************************************/

    var RubriqueShowed = [];

    var promise = RubriqueService.getAll();
    promise.success(function (data){
      $scope.rubriques = data;
    }).error(function(statut){
       console.log("get rubriques erreur");
    });

    var getOrdreOfRubriqueById = function(idRubrique){
        var _index = null;
        angular.forEach($scope.models.lists.mesRubriquesSelected,function(item,index){
            if($scope.models.lists.mesRubriquesSelected[index].rubrique.idRubrique == idRubrique){
                _index = index;
            }
        });
        return _index + 1;
    } 

    $scope.selectRubrique = function(){
        var myObject = {"rubrique" : "","questions":[]};
        myObject.rubrique = getRubriqueById($scope.selectedIdRubrique);
        $scope.models.lists.mesRubriquesSelected.push(myObject);
        
        // call web service add rubriqueEvaluation
        var rubriqueEvaluation = {
            'designation'  : null,
            'idEvaluation' : $rootScope.addedEvaluationId,
            'idRubrique'   : myObject.rubrique.idRubrique,
            'ordre'        : getOrdreOfRubriqueById($scope.selectedIdRubrique)
        }
        $scope.selectedIdRubrique = null;
        console.log(rubriqueEvaluation);
        var promise = RubriqueEvaluationsService.addRubriqueEvaluation(rubriqueEvaluation);
        promise.success(function(data){
            console.log("good");
        }).error(function(status){
            console.log("post rubrique evaluation error");
        });
    }

    $scope.models = {
        selected: null,
        lists: {"mesRubriquesSelected": []}
    };

    // Model to JSON for demo purpose (generet the new list)
    $scope.$watch('models', function(model) {
        $scope.modelAsJson = angular.toJson(model, true);
        console.log($scope.models.mesRubriquesSelected);
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
                //delete from DB
                console.log($scope.models.lists.mesRubriquesSelected[i]);
                var promise = RubriqueEvaluationsService.getAll();
                $q.all(promise).then(function(){
                    promise.success(function(data){
                        angular.forEach(data,function(item,index){
                            if(item.idRubrique == idRubrique && item.idEvaluation == $rootScope.addedEvaluationId){
                                var promise = RubriqueEvaluationsService.deleteRubriqueEvaluation(item.idRubriqueEvaluation);
                                promise.success(function(data){
                                    console.log("delete worked");
                                }).error(function(){
                                    console.log("delete rubrique from evaluation : error");
                                });
                            }
                        });
                    }).error(function(){
                        console.log("get rubriqueEvaluation error");
                    });
                });
                // delete local
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
    }

    $scope.deleteQuestionFromRubrique = function(idRubrique,idQuestion){
        for(var i = 0 ; i < $scope.models.lists.mesRubriquesSelected.length; i++){
            for(var j = 0 ; j < $scope.models.lists.mesRubriquesSelected[i].questions.length ; j++ ){
                if($scope.models.lists.mesRubriquesSelected[i].rubrique.idRubrique == idRubrique
                && $scope.models.lists.mesRubriquesSelected[i].questions[j].idQuestion == idQuestion ){
                    // delete from DB
                    var promise = RubriqueEvaluationsService.getAll();
                    promise.success(function(data){
                        angular.forEach(data,function(rubriqueEvaluation,index){
                            if(rubriqueEvaluation.idRubrique == idRubrique && rubriqueEvaluation.idEvaluation == $rootScope.addedEvaluationId){
                                var promise_ = QuestionEvaluationsService.getAll();
                                promise_.success(function(LesQuestionEvaluations){
                                    angular.forEach(LesQuestionEvaluations,function(uneQuestionEvaluation,index){
                                        if(uneQuestionEvaluation.idQuestion == idQuestion && uneQuestionEvaluation.idRubriqueEvaluation == rubriqueEvaluation.idRubriqueEvaluation){
                                            var unePromesse= QuestionEvaluationsService.deleteQuestionEvaluation(uneQuestionEvaluation.idQuestionEvaluation);
                                            unePromesse.success(function(data){
                                                console.log("question evaluation deleted ! ");
                                            }).error(function(status){
                                                console.log("delete question evaluation error");
                                            })
                                        }
                                    })
                                }).error(function(){
                                    console.log("get question evaluation : error");            
                                });
                            }
                        });
                    }).error(function(status){
                        console.log("get rubrique evaluation : error");
                    });
                    // delete local
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
                        // add to DB
                       // angular.forEach(myObject.question,function(uneQuestion,index){
                            var promise = RubriqueEvaluationsService.getAll();
                            promise.success(function(data){
                                angular.forEach(data,function(item,index){
                                    if(item.idRubrique == $rootScope.selectedIdRubrique && item.idEvaluation == $rootScope.addedEvaluationId){
                                        var QuestionEvaluation = {
                                            'idQualificatif' : null,
                                            'idQuestion' : myObject.question.idQuestion,
                                            'idRubriqueEvaluation' :item.idRubriqueEvaluation,
                                            'intitule': null,
                                            'ordre':index
                                        }
                                        var promise = QuestionEvaluationsService.addQuestionEvaluation(QuestionEvaluation);
                                        promise.success(function(){
                                            console.log('Question Added');
                                        }).error(function(){
                                            console.log('Add Question : error');
                                        }); 
                                    }
                                });
                            }).error(function(){
                                console.log("get rubriqueEvaluation error");
                            }); 
                       // });
                        // local add
                        $rootScope.QuestionSelected.push(myObject);                        
                    }
                    $rootScope.refresh();
                    $modalInstance.dismiss('cancel');
                }




            }
        });
    }

    /************************** Rubrique End ************************************/
}]);
