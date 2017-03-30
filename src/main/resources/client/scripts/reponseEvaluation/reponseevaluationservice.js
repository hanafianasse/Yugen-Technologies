

angular.module('app')

    .factory('ReponseEvaluationService', ['$http','$location', function ($http,$location) {


        var urlBase = 'http://localhost:8090/reponseEvaluation';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getreponseEvaluation = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        dataFactory.getreponseEvaluation = function (id,noetudiant) {
            return $http.get(urlBase + '/' + id +'/'+noetudiant);
        };

        dataFactory.addreponseEvaluation = function (entity) {
            return $http.post(urlBase , entity);

        };
        
        dataFactory.updatereponseEvaluation = function (entity) {
            return $http.put(urlBase, entity)
        };
        dataFactory.deletereponseEvaluation = function (id) {
            return $http.delete(urlBase+'/'+"delete"+'/'+id, entity)
        };
    }]);


