
//DataFactory de l'entité Etudiant
angular.module('app')
    .factory('EtudiantsService', ['$http', function ($http) {

        var urlBase = 'http://localhost:8090/etudiant';
        var dataFactory = {};

        dataFactory.getAll = function () {
            return $http.get(urlBase);
        };

        dataFactory.getEtudiant = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        dataFactory.addEtudiant = function (entity) {
            return $http.post(urlBase, entity);
        };

        dataFactory.updateEtudiant = function (entity,oldEntityId) {
            return $http.put(urlBase +'/'+oldEntityId, entity);
        };

        dataFactory.deleteEtudiant = function (id) {
            return $http.delete(urlBase + '/delete/' + id);
        };

        dataFactory.getNbEtudiant = function () {
            return $http.get(urlBase + '/nombreEtudiants')
        }


        dataFactory.getNbEtudiantParPromotion = function (codeFormation, anneeUniversitaire) {
            return $http.get(urlBase + '/nombreEtudiants/' + codeFormation + '/' + anneeUniversitaire);
        }

        dataFactory.getPromotionEtudiant=function(id){
            return $http.get(urlBase+'/getPromotionEtudiant/'+id);
        }


        /*dataFactory.get= function(noEtudiant) {

          	  return  $http.get('http://localhost:8090/getetu/'+noEtudiant);
          	};*/



        return dataFactory;
    }]);


