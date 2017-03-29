angular.module('app')
    .factory('RubriqueService', ['$http', function ($http) {

        var urlBase = 'http://localhost:8090/rubrique';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };
        
        dataFactory.getRubriquesQuestion = function (id) {
            return $http.get('http://localhost:8090/rubriqueQuestion' + '/' + id);
        };

        dataFactory.getRubrique = function (id) {
            return $http.get(urlBase + '/' + id);
        };
        
        dataFactory.getRubriqueEvaluation = function (id) {
            return $http.get(urlBase + '/getRubriqueByIdEvaluation/' + id);
        };

        
        dataFactory.addRubrique = function (entity) {
            return $http.post(urlBase, entity);
        };

        dataFactory.updateRubrique = function (entity) {
            return $http.put(urlBase, entity)
        };

        dataFactory.deleteRubrique = function (id) {
            return $http.delete(urlBase + '/delete/' + id);
        };

        return dataFactory;
    }]);


