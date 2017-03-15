
//DataFactory de l'entité Etudiant
angular.module('app')
    .factory('formationService', ['$http', function ($http) {

        var urlBase = 'http://localhost:8090/formation';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getFormation = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        dataFactory.addFormation = function (entity) {
            return $http.post(urlBase, entity);
        };

        dataFactory.updateFormation = function (entity) {
            return $http.put(urlBase, entity)
        };

        dataFactory.deleteFormation = function (id) {
            return $http.delete(urlBase + '/' + id);
        };

        dataFactory.getPromotions = function (id) {
            return $http.get(urlBase + '/' + id + '/promotion');
        };

        return dataFactory;
    }]);


