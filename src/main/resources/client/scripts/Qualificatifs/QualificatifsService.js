
//DataFactory de l'entité Etudiant
angular.module('app')
    .factory('EtudiantsService', ['$http', function ($http) {

        var urlBase = 'http://localhost:8090/qualificatif';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getQualificatif = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        dataFactory.addQualificatif = function (entity) {
            return $http.post(urlBase, entity);
        };

        dataFactory.updateQualificatif = function (entity) {
            return $http.put(urlBase, entity)
        };

        dataFactory.deleteQualificatif = function (id) {
            return $http.delete(urlBase + '/remove/' + id);
        };

        return dataFactory;
    }]);


