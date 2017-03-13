/**
 * 
 */


angular.module('app').controller('RubriqueController', ['$scope','$routeParams','$http','RubriqueService',function ($scope,$routeParams,$http, RubriqueService) {

    $scope.mesrubriques = [];

    RubriquesService.getAll(function (data) {
        $scope.mesrubriques = data;

    });


}]);
