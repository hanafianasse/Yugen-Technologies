(function() {'use strict';
angular.module('app')
	.controller('QuestionController',[ '$scope', '$location', '$http','questionService','QualificatifService','$q','$modal','$rootScope',
		function($scope, $location, $http,questionService,QualificatifService,$q,$modal,$rootScope) {
		$scope.mesQuestions = new Array();
		var questions = new Array();
		var qualificatifs = new Array();
		var qualificatifRequestsPromise = new Array();


 	function getQuestions(){
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
				console.log(qualificatifs);
				console.log(questions);

				for(var index = 0 ; index < questions.length; index++){
					var uneQuestion = {
						question: '',
						qualificatif : ''
					}
					uneQuestion.question = questions[index];
					uneQuestion.qualificatif = qualificatifs[index];
					$scope.mesQuestions.push(uneQuestion);				
				}
			});
		});     
	}
	
	getQuestions();
	
	$scope.ouvrirModelSuppresion = function(question){
		$rootScope.questionToBeDeleted = question;
		$scope.etat = null;
		console.log(question);
		$modal.open({
			templateUrl: 'myModalContent.html',
			backdrop: true,
			controller: function ($scope, $modalInstance,$rootScope,questionService) {
				$scope.annulerSuppresion = function () {
					$modalInstance.dismiss('cancel');
				};
				$scope.doSupprimer = function(){
					console.log($rootScope.questionToBeDeleted.idQuestion);
					var promise = questionService.deleteQuestion($rootScope.questionToBeDeleted.idQuestion);
					promise.success(function(status){
	    				$scope.message = 'Question supprimé';
	    				// refresh here !!!!!
	    				getQuestions();
					}).error(function(data,status){
						$scope.message = 'Suppresion Impossible !';
					});
					$scope.etat = "done";
				};
			}
		});	
	}

	}]);
})();