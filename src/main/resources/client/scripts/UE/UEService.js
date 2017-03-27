

angular.module('app')

    .factory('UEService', ['$http','$location', function ($http,$location) {


        var urlBase = 'http://localhost:8090/uniteEnseignement';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getByCodeFormation = function (id) {
            return $http.get(urlBase + '/getByCodeFormation/' + id);
        };

        dataFactory.getNbUE = function () {
            return $http.get(urlBase + '/nombreUE')
        }
        return dataFactory;
    }]);


