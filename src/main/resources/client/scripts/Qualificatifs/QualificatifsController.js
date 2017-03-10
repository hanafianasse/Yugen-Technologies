/**
 * Created by DOSI on 10/03/2017.
 */
'use strict';


angular.module('app').controller('QualificatifsCtrl', ['$scope','$routeParams','$http','QualificatifService',function ($scope,$routeParams,$http, QualificatifService) {

    $scope.qualificatifs = [];

    QualificatifService.getAll(function (data) {
        $scope.qualificatifs = data;

    });


}]);
