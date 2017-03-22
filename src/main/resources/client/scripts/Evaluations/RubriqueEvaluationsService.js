
//DataFactory de l'entité RubriqueEvaluation
angular.module('app')
    .factory('RubriqueEvaluationsService', ['$http', function ($http) {

        var urlBase = 'http://localhost:8090/rubriqueEvaluation';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getRubriqueEvaluation = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        dataFactory.addRubriqueEvaluation = function (entity) {
            return $http.post(urlBase, entity);
        };

        dataFactory.updateRubriqueEvaluation = function (entity) {
            return $http.put(urlBase, entity);
        };

        dataFactory.deleteRubriqueEvaluation = function (id) {
            return $http.delete(urlBase + '/' + id);
        };

        return dataFactory;
    }]);


