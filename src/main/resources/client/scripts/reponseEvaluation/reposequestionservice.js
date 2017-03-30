

angular.module('app')

    .factory('ReponseEvaluationService', ['$http','$location', function ($http,$location) {


        var urlBase = 'http://localhost:8090/reponseQuestion';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getreponseQuestion = function (ideval,idqst) {
            return $http.get(urlBase + '/' + ideval+'/'+idqst);
        };

       
        dataFactory.addreponseQuestion = function (entity) {
            return $http.post(urlBase+'/'+"addReponseQuestion" , entity);

        };
        
        dataFactory.updatereponseQuestion = function (entity) {
            return $http.put(urlBase+'/'+"updateReponseQuestion", entity)
        };

        dataFactory.deletereponseQuestion = function (entity) {
            return $http.delete(urlBase+'/'+"deleteReponseQuestion", entity)
        };
        
    }]);


