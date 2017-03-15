
//DataFactory de l'entité Etudiant
angular.module('app')
    .factory('domaineService', ['$http', function ($http) {

        var urlBase = 'http://localhost:8090/domaine';
        var dataFactory = {};

        dataFactory.getDomaine = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        return dataFactory;
    }]);


