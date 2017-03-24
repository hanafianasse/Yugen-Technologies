/**
 * Created by DOSI on 23/03/2017.
 */


angular.module('app')

    .factory('ECService', ['$http','$location', function ($http,$location) {


        var urlBase = 'http://localhost:8090/elementConstitutif';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getByCodeUe = function (id) {
            return $http.get(urlBase + '/getByCodeUe/' + id);
        };


        return dataFactory;
    }]);


