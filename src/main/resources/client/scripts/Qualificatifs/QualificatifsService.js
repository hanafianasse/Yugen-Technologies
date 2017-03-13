

angular.module('app')
<<<<<<< HEAD
    .factory('QualificatifService', ['$http','$location', function ($http,$location) {
=======
    .factory('QualificatifService', ['$http', function ($http) {
>>>>>>> 9e4c5370a7650aaca884753de9e7c8df71530419

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
<<<<<<< HEAD

=======
>>>>>>> 9e4c5370a7650aaca884753de9e7c8df71530419
        };

        dataFactory.updateQualificatif = function (entity) {
            return $http.put(urlBase, entity)
        };

        dataFactory.deleteQualificatif = function (id) {
<<<<<<< HEAD
            return $http.delete(urlBase + '/' + id);
=======
            return $http.delete(urlBase + '/remove/' + id);
>>>>>>> 9e4c5370a7650aaca884753de9e7c8df71530419
        };

        return dataFactory;
    }]);


