angular.module('app')
    .factory('questionService', ['$http', function ($http) {

        var urlBase = 'http://localhost:8090/question';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getQuestion = function (id) {
            return $http.get(urlBase +'/'+id);
        };

        dataFactory.addQuestion = function (entity) {
            return $http.post(urlBase,entity);
        };

        dataFactory.updateQuestion = function (entity) {
            return $http.put(urlBase,entity)
        };

        dataFactory.deleteQuestion = function (id) {
            return $http.delete(urlBase + '/delete/' + id);
        };
        return dataFactory;
    }]);


