

angular.module('app')

    .factory('ReponseQuestionService', ['$http', '$location', function ($http, $location) {

        var urlBase = 'http://localhost:8090/reponseQuestion';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getReponseQuestion = function (idEvaluation, idQuestion) {
            return $http.get(urlBase + '/' + idEvaluation + '/' + idQuestion);
        };

        dataFactory.addReponseQuestion = function (entity) {
            return $http.post(urlBase + '/' + "addReponseQuestion", entity);
        };

        dataFactory.updateReponseQuestion = function (entity) {
            return $http.put(urlBase + '/' + "updateReponseQuestion", entity)
        };

        dataFactory.deleteReponseQuestion = function (entity) {
            return $http.delete(urlBase + '/' + "deleteReponseQuestion", entity)
        };

        return dataFactory;

    }]);


