
//Test unitaire du dataFactory de l'entité Etudiant
describe('EtudiantsService', function(){

  var EtudiantsService;
  var $http;
  var url = "http://localhost:8090/etudiant";

  beforeEach(function(){
    angular.mock.module('app')
    angular.mock.inject(function(_EtudiantService_, $httpBackend){
      EtudiantService = _EtudiantService_
      $http = $httpBackend
    })
  })

})