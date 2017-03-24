

angular.module('app')

    .factory('EvaluationService', ['$http','$location', function ($http,$location) {


        var urlBase = 'http://localhost:8090/evaluation';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getQualificatif = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        dataFactory.addEvaluation = function (entity) {
            return $http.post(urlBase, entity);

        };

        dataFactory.updateQualificatif = function (entity) {
            return $http.put(urlBase, entity)
        };

        dataFactory.deleteQualificatif = function (id) {

            return $http.delete(urlBase + '/' + id);


        };

        return dataFactory;
    }]);


