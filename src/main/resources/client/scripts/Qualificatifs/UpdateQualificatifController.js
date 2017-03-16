/**
 * Created by DOSI on 13/03/2017.
 */

'use strict';

angular.module('app').controller('UpdateQualificatifCtrl', ['$scope', '$location','$routeParams', 'QualificatifService', function ($scope,$location, $routeParams, QualificatifService) {
    $scope.idQualificatif = $routeParams.idQualificatif;
    $scope.qualificatif;

    $('input').on('input', function() {
        var c = this.selectionStart,
            r = /[^a-z0-9êéàçèù .\-]/gi,
            v = $(this).val();
        if(r.test(v)) {
            $(this).val(v.replace(r, ''));
            c--;
        }
        this.setSelectionRange(c, c);
    });

    $scope.updateQualificatif = function (qualificatif) {
        QualificatifService.updateQualificatif(qualificatif).then(function (response) {
            $location.path("/admin/qualificatif");
        }, function(error) {
            console.log("get qualificatifs : erreur");
        });
    };

    $scope.getQualificatif = function (idQualificatif) {
        QualificatifService.getQualificatif(idQualificatif).then(function (response) {
            $scope.qualificatif = response.data;
        }, function(error){
            console.log("get qualificatifs : erreur");
        });

    };

    if ($scope.idQualificatif)
        $scope.qualificatif = $scope.getQualificatif($scope.idQualificatif);


    $scope.cancel = function() {

        $location.path('/admin/qualificatif');

    }

}]);
