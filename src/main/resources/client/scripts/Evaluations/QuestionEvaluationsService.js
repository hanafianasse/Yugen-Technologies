
//DataFactory de l'entité QuestionEvaluation
angular.module('app')
    .factory('QuestionEvaluationsService', ['$http', function ($http) {

        var urlBase = 'http://localhost:8090/questionEvaluation';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getQuestionEvaluation = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        dataFactory.addQuestionEvaluation = function (entity) {
            return $http.post(urlBase, entity);
        };

        dataFactory.updateQuestionEvaluation = function (entity) {
            return $http.put(urlBase, entity);
        };

        dataFactory.deleteQuestionEvaluation = function (id) {
            return $http.delete(urlBase + '/' + id);
        };

        return dataFactory;
    }]);


