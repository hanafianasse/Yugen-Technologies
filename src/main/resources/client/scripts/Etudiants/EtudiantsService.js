
//DataFactory de l'entité Etudiant
angular.module('app')
    .factory('EtudiantsService', ['$http', function ($http) {

        var urlBase = 'http://localhost:8090/etudiant';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getEtudiant = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        dataFactory.addEtudiant = function (entity) {
            return $http.post(urlBase, entity);
        };

        dataFactory.updateEtudiant = function (entity) {
            return $http.put(urlBase, entity)
        };

        dataFactory.deleteEtudiant = function (id) {
            return $http.delete(urlBase + '/delete/' + id);
        };

        return dataFactory;
    }]);


