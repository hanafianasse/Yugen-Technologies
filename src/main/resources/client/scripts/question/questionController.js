(function() {'use strict';
angular.module('app')
	.controller('QuestionController',[ '$scope', '$location', '$http','questionService','QualificatifService',function($scope, $location, $http,questionService,QualificatifService) {
		var promise = questionService.getAll();
		promise.success(function(data) {
			$mesQuestionObject = {
				question: '',
				qualificatif : ''
			}
			$scope.mesQuestions = [];
			$scope.questions = data;
			for(var index = 0; index < $scope.questions.length ;index++){
				mesQuestionObject.question = $scope.questions[index];
				var promise = QualificatifService.get($scope.questions[index].idQualificatif);
				promise.success(function(data){ 
					mesQuestionObject.qualificatif = data[0];
					mesQuestions.push(mesQuestionObject);
				}).error(function(data) {
					console.log("get qualificatifs : erreur");
				});
			}
		}).error(function(data) {
			console.log("get questions : erreur");
		});
	}]);
})();