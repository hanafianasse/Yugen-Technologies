

angular.module('app')

    .factory('EvaluationService', ['$http','$location', function ($http,$location) {


        var urlBase = 'http://localhost:8090/evaluation';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getEvaluation = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        dataFactory.addEvaluation = function (entity) {
            return $http.post(urlBase+'/addEvaluation', entity);

        };
        dataFactory.getNbEvaluations = function () {
            return $http.get(urlBase + '/nombreEvaluations')
        };
        dataFactory.updateEvaluation = function (entity) {
            return $http.put(urlBase, entity)
        };



        return dataFactory;
    }]);


