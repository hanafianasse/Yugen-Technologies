
'use strict';

angular.module('app').controller('EvaluationreponseCtrl', ['$scope', '$route', '$rootScope', '$routeParams', '$http', '$location', '$q', 'ReponseEvaluationService', 'ReponseQuestionService', 'EvaluationService', 'RubriqueService', 'questionService', 'QuestionEvaluationsService', 'RubriqueEvaluationsService', 'QualificatifService', '$modal',
	function ($scope, $route, $rootScope, $routeParams, $http, $location, $q, ReponseEvaluationService, ReponseQuestionService, EvaluationService, RubriqueService, questionService, QuestionEvaluationsService, RubriqueEvaluationsService, QualificatifService, $modal) {


		/********************FONCTION DE RECUPERATION**************************/

		//Recupération des rubriques
		function getDetailsEvaluation(evaluation) {

			$scope.evaCodeFormation = evaluation.codeFormation;
			$scope.evaCodeUe = evaluation.codeUe;
			$scope.evaCodeEc = evaluation.codeEc;
			$scope.evaPeriode = evaluation.periode;
			$scope.evaId = evaluation.idEvaluation;

			$scope.rubriques = [];

			var idQuestionsEval = [];

			var promessesRubriques = [];
			var promessesQuestionsEvaluations = [];
			var promessesQuestions = [];
			var promessesQualificatifs = [];

			RubriqueEvaluationsService.getRubriqueEvaluationByIdEva($scope.evaId
			).then(
				function (success) {
					$scope.rubevaluations = success.data;

					angular.forEach($scope.rubevaluations, function (rubEval) {
						var rubrique = {
							idRubrique: null,
							idRubriqueEvaluation: null,
							designation: null,
							ordre: null,
							type: null,
							questions: [],
							questionsEvaluation: []
						};

						rubrique.idRubrique = rubEval.idRubrique;
						rubrique.idRubriqueEvaluation = rubEval.idRubriqueEvaluation;

						$scope.rubriques.push(rubrique);

						promessesRubriques.push(RubriqueService.getRubrique(rubEval.idRubrique));

						promessesQuestionsEvaluations.push(QuestionEvaluationsService.getQuestionEvaluationByIdRubriqueEvaluation(rubEval.idRubriqueEvaluation));

						promessesQuestions.push(questionService.getQuestionEvaluation(rubEval.idRubrique));
					});

					console.log("Après récupération des rubriques evaluations");
					console.log($scope.rubriques);

					return $q.all(promessesRubriques);
				},
				function (error) {
					console.log("get evaluationRubrique: erreur");
				}
				).then(
				function (reponsesPromessesRubriques) {
					var index = 0;
					angular.forEach(reponsesPromessesRubriques, function (reponse) {
						$scope.rubriques[index].designation = reponse.data.designation;
						$scope.rubriques[index].ordre = reponse.data.ordre;
						$scope.rubriques[index].type = reponse.data.type;

						index++;
					});

					return $q.all(promessesQuestionsEvaluations);
				}
				).then(
				function (reponsesPromessesQuestionsEvaluation) {
					for (var i = 0; i < reponsesPromessesQuestionsEvaluation.length; i++) {
						for (var j = 0; j < reponsesPromessesQuestionsEvaluation[i].data.length; j++) {
							if ($scope.rubriques[i].idRubriqueEvaluation == reponsesPromessesQuestionsEvaluation[i].data[j].idRubriqueEvaluation &&
								reponsesPromessesQuestionsEvaluation[i].data[j].idQuestion != null) {
								$scope.rubriques[i].questionsEvaluation.push(reponsesPromessesQuestionsEvaluation[i].data[j]);
							}
						}
					}

					$q.all(promessesQuestions).then(function (reponsesPromessesQuestions) {
						for (var i = 0; i < $scope.rubriques.length; i++) {
							for (var j = 0; j < $scope.rubriques[i].questionsEvaluation.length; j++) {
								for (var k = 0; k < reponsesPromessesQuestions.length; k++) {
									for (var l = 0; l < reponsesPromessesQuestions[k].data.length; l++) {
										if ($scope.rubriques[i].questionsEvaluation[j].idQuestion == reponsesPromessesQuestions[k].data[l].idQuestion) {
											var question = {}
											question.idQualificatif = reponsesPromessesQuestions[k].data[l].idQualificatif;
											question.idQuestion = reponsesPromessesQuestions[k].data[l].idQuestion;
											question.intitule = reponsesPromessesQuestions[k].data[l].intitule;
											question.type = reponsesPromessesQuestions[k].data[l].type;

											$scope.rubriques[i].questions.push(question);

											promessesQualificatifs.push(QualificatifService.getQualificatif(reponsesPromessesQuestions[k].data[l].idQualificatif));
										}
									}
								}
							}
						}
					})

					return $q.all(promessesQualificatifs);
				}
				).then(
				function (reponsesPromessesQualificatifs) {
					angular.forEach(reponsesPromessesQualificatifs, function (reponse) {
						for (var i = 0; i < $scope.rubriques.length; i++) {
							for (var j = 0; j < $scope.rubriques[i].questions.length; j++) {
								if ($scope.rubriques[i].questions[j].idQualificatif == reponse.data.idQualificatif)
									$scope.rubriques[i].questions[j].qualificatif = reponse.data;
							}
						}

					})

					console.log("Après récupération des qualificatifs des questions");
					console.log($scope.rubriques);

					return ReponseEvaluationService.getReponseEvaluationByIdEvaluationNoEtudiant($scope.selectedeval.idEvaluation, $scope.etudiant.noEtudiant);
				}
				).then(
				function (response) {
					if (response.data != null) {
						$scope.reponseEvaluation = response.data;

						var promessesReponsesQuestions = [];

						for (var i = 0; i < $scope.rubriques.length; i++) {
							for (var j = 0; j < $scope.rubriques[i].questions.length; j++) {
								promessesReponsesQuestions.push(ReponseQuestionService.getReponseQuestion($scope.selectedeval.idEvaluation, $scope.rubriques[i].questions[j].idQuestion));
							}
						}

						console.log("Après récupération de la réponse évaluation");
						console.log($scope.rubriques);

						$q.all(promessesReponsesQuestions).then(
							function (response) {
								for (var index = 0; index < response.length; index++) {
									for (var i = 0; i < $scope.rubriques.length; i++) {
										for (var j = 0; j < $scope.rubriques[i].questions.length; j++) {
											if (response[index].data.id.idQuestionEvaluation == $scope.rubriques[i].questionsEvaluation[j].idQuestionsEvaluation)
												$scope.rubriques[i].questions[j].reponseQuestion = response[index].data;
										}
									}
								}

								console.log("Après récupération des réponses des questions")
								console.log($scope.rubriques);
							}
						)

						console.log($scope.rubriques);
					}
				}, function (error) {
					console.log("getReponseEvaluatioByIdEvaluationNoEtudiant: Error");
					return error;
				});
		}

		if ($rootScope.selectedeval != undefined) {
			$scope.selectedeval = $rootScope.selectedeval;
			$scope.etudiant = $rootScope.connectedUserAsEtu;

			getDetailsEvaluation($scope.selectedeval);
		}

	}]);


