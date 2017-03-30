(function() {'use strict';
angular.module('app')
	.controller('QuestionController',[ '$scope', '$location', '$http','questionService','QualificatifService','$q','$modal','$rootScope',
function($scope, $location, $http,questionService,QualificatifService,$q,$modal,$rootScope) {


 	$scope.getQuestions = function(){
		var questions = new Array();
		var qualificatifs = new Array();
		var qualificatifRequestsPromise = new Array();
		$scope.mesQuestions = new Array();
		var promise = questionService.getAll();
		promise.success(function(data) {
			data.forEach(function(question){
				questions.push(question);
			});
		}).error(function(data) {
			console.log("get questions : erreur");
		});

		var questionDefered = $q.all(promise);
		var QuestionsPromises = questionDefered.then(function(data) {
			angular.forEach(questions,function(question){
				var promise = QualificatifService.getQualificatif(question.idQualificatif);
				promise.success(function(data){
					qualificatifs.push(data);
				}).error(function(data) {
					console.log("get qualificatifs : erreur");
				});
				qualificatifRequestsPromise.push(promise);
			});

			var qualificatifDefered = $q.all(qualificatifRequestsPromise);
			qualificatifDefered.then(function(data){
				console.log(questions);
				console.log(qualificatifs);
				for(var index = 0 ; index < questions.length; index++){
					var uneQuestion = {
						question: '',
						qualificatif : ''
					}
					uneQuestion.question = questions[index];
					uneQuestion.qualificatif = findById(qualificatifs,questions[index].idQualificatif);
					$scope.mesQuestions.push(uneQuestion);
				}/*
                console.log($scope.mesQuestions);
                $scope.mesQuestions.sort(function(a, b){
                    return a.question.intitule-b.question.intitule;
                });
                console.log($scope.mesQuestions);*/
			});
		});
	}

	function findById(tableau,val){
		for(var index = 0; index < tableau.length ;index++){
			if(tableau[index].idQualificatif == val){
				return tableau[index];
			}
		}
		return null; // will never happen ! ask anasse
	}

	$scope.getQuestions();
	$rootScope.refresh = $scope.getQuestions;


    $scope.ouvrirModelSuppresion = function(question){
        console.log(question);
        $rootScope.etat = null;
        $rootScope.questionToBeDeleted = question;
        $modal.open({
            templateUrl: 'myModalContent.html',
            backdrop: true,
            controller: function ($scope, $modalInstance,$rootScope,questionService) {
                $scope.annulerSuppresion = function () {
                    $modalInstance.dismiss('cancel');
                };
                $scope.doSupprimer = function(){
                    var promise = questionService.deleteQuestion($rootScope.questionToBeDeleted.question.idQuestion);
                    promise.success(function(status){
                        $rootScope.refresh();
                        $modalInstance.dismiss('cancel');
                        // $rootScope.message = "Qualificatif supprimé";
                        //$rootScope.etat = "done";

                    }).error(function(data,status){
                        $rootScope.message = "Impossible de supprimer la question  choisi !";
                        $rootScope.etat = "not done";
                    });

                };
            }
        });
    }

	}]);
})();
