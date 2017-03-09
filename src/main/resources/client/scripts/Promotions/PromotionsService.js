//DataFactory de l'entité Promotion
angular.module('app')
    .factory('promotionService', ['$http', function ($http) {

        var urlBase = 'http://localhost:8090/promotion';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getPromotion = function (id) {
            return $http.get(urlBase, id);
        };

        dataFactory.addPromotion = function (entity) {
            return $http.post(urlBase, entity);
        };

        dataFactory.updatePromotion = function (entity) {
            return $http.put(urlBase, entity)
        };

        dataFactory.deletePromotion = function (id) {
            return $http.delete(urlBase, id);
        };

        return dataFactory;
    }]);


