

angular.module('app')
    .factory('ReponseEvaluationService', ['$http', function ($http) {
        
        var urlBase = 'http://localhost:8090/reponseEvaluation';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getReponseEvaluation = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        dataFactory.getReponseEvaluationByIdEvaluationNoEtudiant = function (idEvaluation, noEtudiant) {
            return $http.get(urlBase + '/getReponseEvaluationByIdEvaluationNoEtudiant/' + idEvaluation + '/' + noEtudiant);
        };

        dataFactory.addReponseEvaluation = function (entity) {
            return $http.post(urlBase, entity);

        };

        dataFactory.updateReponseEvaluation = function (entity) {
            return $http.put(urlBase, entity)
        };

        dataFactory.deleteReponseEvaluation = function (id) {
            return $http.delete(urlBase + '/' + "delete" + '/' + id, entity)
        };

        return dataFactory;
    }]);


