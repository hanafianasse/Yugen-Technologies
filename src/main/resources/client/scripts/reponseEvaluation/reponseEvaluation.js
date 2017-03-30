
'use strict';

angular.module('app').controller('EvaluationreponseCtrl', ['$scope', '$route', '$rootScope', '$routeParams', '$http', '$location', '$q', 'ReponseEvaluationService', 'ReponseQuestionService', 'EvaluationService', 'RubriqueService', 'questionService', 'QuestionEvaluationsService', 'RubriqueEvaluationsService', 'QualificatifService', '$modal',
	function ($scope, $route, $rootScope, $routeParams, $http, $location, $q, ReponseEvaluationService, ReponseQuestionService, EvaluationService, RubriqueService, questionService, QuestionEvaluationsService, RubriqueEvaluationsService, QualificatifService, $modal) {


		/********************FONCTION DE RECUPERATION**************************/

		//Recupération des rubriques
		$scope.getEvaluationWithRubAndQst = function(evaluation){

		var promiseReponseEvaluation = ReponseEvaluationService.getReponseEvaluationByIdEvaluationNoEtudiant(evaluation.idEvaluation,$scope.etudiant.noEtudiant);
    	promiseReponseEvaluation.success(function(reponseEvaluation){
			if(reponseEvaluation.idReponseEvaluation == undefined){
			    var ReponseEvaluation = {
		        	"nom" : null, 
		        	"prenom" : null, 
		        	"commentaire" : null, 
		        	"noEtudiant" : $scope.etudiant.noEtudiant, 
		        	"idEvaluation" : evaluation.idEvaluation
		        }
				ReponseEvaluationService.addReponseEvaluation(ReponseEvaluation).success(function(ReponseEvaluationAdded){
					$scope.reponseEvaluation = ReponseEvaluationAdded;
					console.log("reponse evaluation ajouté ");
				});
			}
		});

        $scope.longueur = null;
        $scope.evaCodeFormation = evaluation.codeFormation;
        $scope.evaCodeUe = evaluation.codeUe;
        $scope.evaCodeEc = evaluation.codeEc;
        $scope.evaPeriode = evaluation.periode;
        $scope.evaId = evaluation.idEvaluation;

        $scope.rubriques = [];
        RubriqueEvaluationsService.getAll().success(function(lesRubriqueEvaluation){
            lesRubriqueEvaluation.sort(function(a,b){
                return a.ordre - b.ordre;
            });
            angular.forEach(lesRubriqueEvaluation,function(rubriqueEvaluation,j){
                if(rubriqueEvaluation.idEvaluation == evaluation.idEvaluation){
                    //RubriqueShowed.push(rubriqueEvaluation.idRubrique);
                    RubriqueService.getRubrique(rubriqueEvaluation.idRubrique).success(function(data){
                        var mesQuestions = [];
                        QuestionEvaluationsService.getAll().success(function(LesQuestionsEvaluation){
                            LesQuestionsEvaluation.sort(function(a,b){
                                return a.ordre - b.ordre;
                            });
                            angular.forEach(LesQuestionsEvaluation,function(uneQuestionEvaluation,k){
                                if(uneQuestionEvaluation.idRubriqueEvaluation == rubriqueEvaluation.idRubriqueEvaluation){
                                    var promese = questionService.getQuestion(uneQuestionEvaluation.idQuestion);
                                    promese.success(function(qst){
                                        var promise = QualificatifService.getQualificatif(qst.idQualificatif).success(function(qualificatif){
                                        	var promiseReponseEvaluation = ReponseEvaluationService.getReponseEvaluationByIdEvaluationNoEtudiant(evaluation.idEvaluation,$scope.etudiant.noEtudiant);
                                        	promiseReponseEvaluation.success(function(reponseEvaluation){
                                        		if(reponseEvaluation.idReponseEvaluation != undefined){
                                        			$scope.reponseEvaluation = reponseEvaluation;
                                        			ReponseQuestionService.getReponseQuestion(reponseEvaluation.idReponseEvaluation,uneQuestionEvaluation.idQuestionEvaluation).success(function(reponseQuestion){
                                        				var myQstObject = {
                                        						"reponseQuestion" : reponseQuestion,
				                                                "question" : qst,
				                                                "qualificatif" : qualificatif,
				                                                "idQuestionEvaluation" : uneQuestionEvaluation.idQuestionEvaluation
                                            				}
                                            			mesQuestions.push(myQstObject);
                                        			});
                                        		}else{
		                                            var myQstObject = {
		                                            	"reponseQuestion" : null,
 		                                                "question" : qst,
        	                	                        "qualificatif" : qualificatif,
            	        	                            "idQuestionEvaluation" : uneQuestionEvaluation.idQuestionEvaluation
                		                            }
                             			            mesQuestions.push(myQstObject);
                                        		}
                                        	}).error(function(status){
                                        		console.log("get reponse eva : error");
                                        	});

                                        }).error(function(status){
                                            console.log("get qualificatif by id error");
                                        });
                                    }).error(function(status){
                                    });
                                }
                            });
                            var myObject = {
                                "idRubriqueEvaluation":rubriqueEvaluation.idRubriqueEvaluation,
                                "rubrique": data,
                                "questions":mesQuestions
                            }
                            $scope.rubriques.push(myObject);
                        }).error(function(status){

                        });
                    }).error(function(status){

                    });
                }
            })
        }).error(function(){

        });
    }

    $scope.repondreAQuestion = function (reponseQuestion,positionnement,indexRubrique,indexQuestion){

    	if(reponseQuestion.id == undefined){
    		//add
			var reponseQuestion_ = {
				"id" : {
					"idReponseEvaluation" : $scope.reponseEvaluation.idReponseEvaluation,
					"idQuestionEvaluation" : $scope.rubriques[indexRubrique].questions[indexQuestion].idQuestionEvaluation
				},
				"positionnement" : positionnement
			}
    		ReponseQuestionService.addReponseQuestion(reponseQuestion_).success(function(reponseQuestionAdded){
    			$scope.rubriques[indexRubrique].questions[indexQuestion].reponseQuestion = reponseQuestionAdded;
    			console.log('good');
    		});
    	}else{
    		//update
    		ReponseQuestionService.updateReponseQuestion(reponseQuestion).success(function(reponseQuestionAdded){
    			$scope.rubriques[indexRubrique].questions[indexQuestion].reponseQuestion = reponseQuestionAdded;
    			console.log('good');
    		});
    	}
    }


	if ($rootScope.selectedeval != undefined) {
		$scope.selectedeval = $rootScope.selectedeval;
		$scope.etudiant = $rootScope.connectedUserAsEtu;

		//getDetailsEvaluation($scope.selectedeval);
		$scope.getEvaluationWithRubAndQst($scope.selectedeval);
		console.log($scope.rubriques);
	}

}]);


