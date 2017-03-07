(function() {
  'use strict';

  var app = angular.module('app.formations', []);
  
  Array.prototype.removeValue = function(name, value){
	   var array = $.map(this, function(v,i){
	      return v[name] === value ? null : v;
	   });
	   this.length = 0; //clear original array
	   this.push.apply(this, array); //push all elements except the one we want to delete
	}
 
  Array.prototype.retourValue = function(name, value){
	   var array = $.map(this, function(v,i){
	      return v[name] === value ? v : null;
	   });
	   return array[0];
	}

  app.factory('formationsFactory',['$http', function($http){
	/*  var getPoneys = function(callbackFn) {
		    $http.get('/api/poneys').success(function(data) {
		      callbackFn(data);
		    });
		  };
		    */
		    
    var list = function() {
        //var defer = $q.defer();

       return  $http.get('http://localhost:8090/frm')
       /*.then(function(response) {
          defer.resolve(response.data);
        });

        return defer.promise;*/
      };
    	/*function(callbackFn){
		$http.get("http://localhost:8090/frm").success(function(response) {
			console.log("TODO 1: entrer response" + response);
			callbackFn(response);
		});
    	}/* [ 
      // TODO alimenter   
      {
    	  code : "M2DOSI", diplome : "M", no_annee : "2", 
    	  nom :"Master Développement à l'Offshore des Systèmes d'Information", double_diplome : "O", 
    	  debut_accreditation :"01/09/12" , fin_accreditation : "30/09/17"
    		  
      },
      {
    	  code : "M1TIIL", diplome : "M", no_annee : "1", 
    	  nom :"Master technologie de l'Information et Ingénierie du Logiciel", double_diplome : "N", 
    	  debut_accreditation :"01/09/12" , fin_accreditation : "30/09/17"
      },
      {
    	  code : "M2TIIL", diplome : "M", no_annee : "2", 
    	  nom :"Master technologie de l'Information et Ingénierie du Logiciel", double_diplome : "N", 
    	  debut_accreditation :"01/09/12" , fin_accreditation : "30/09/17"
      },
      {
    	  code : "M2LSE", diplome : "M", no_annee : "2", 
    	  nom :"Master Logiciel pour Système Embarqué", double_diplome : "N", 
    	  debut_accreditation :"01/09/12" , fin_accreditation : "30/09/17"
      }
    ]*/ 
    	;
            
    return {
      // renvoi la liste de tous les enseignants
      all: function() { // TODO retourner la liste 
    	  return  $http.get('http://localhost:8090/formations') //list,//;
    	  //console.log("TODO : retourner la liste des formations", formation);
    	  },
      // renvoi l'enseignant avec le code demandé
      get: function(codeFormation) { 
        // TODO Retourner un enregistrement
    	  console.log("TODO : get formation",codeFormation);
    	  //return list.retourValue("no_enseignant",idx);
    	  return  $http.get('http://localhost:8090/formation/'+codeFormation);
    	  //return list.retourValue("code",code);
    	  //console.log("TODO : retourner formation", formation);
      },
      set: function(formation) {
        console.log("TODO : enregistrer formation", formation);
        //var idf = formation.codeFormation;
        // si modification d'une formation existante
        //if(idf){
          // TODO alimenter l'objet formation trouvé
        	//console.log("TODO : update formation",idf);
        	//list.removeValue("code",formation.code);
        	//return list.push(formation);
        //} else { // si ajout d'un nouvel formation
          // TODO ajouter un formation à la liste
        	$http.post('http://localhost:8090/formation/ajouterformation',formation);
        	//return list.push(formation);
        //}
      },
      delete: function(formation) { 
        console.log("TODO : supprimer formation", formation.codeFormation);
        $http.get('http://localhost:8090/formation/delete/'+formation.codeFormation);
  	    //$http.get('http://localhost:8090/formation/delete/'+codeformation)
        //list.removeValue("code",formation.code);
  	  	//return list;
      }
    };
  }]);


  app.controller('FormationsController', 
    ['$scope', '$location', 'formationsFactory', '$http',
    function($scope, $location, formationsFactory, $http){
    	
    	var promise = formationsFactory.all();
    	promise.success(function(data) {
    		    $scope.formations = data;
    		  }
    		)
    		.error(function(data) {
    			 $scope.error = 'unable to get the poneys';
    		  }
    		);
    
      // la liste globale des formations
      //$scope.formations = formationsFactory.all();      

    	
    	
 /* $scope.formations = [];
      
  listfrm.fetchPopular(function(data) {
    	  console.log("TODO 1: entrer fetchpopular");
			$scope.formations = data;
			console.log("TODO 2: donnee " + data);
			console.log("TODO 3: fin fetchpopular");
		});*/
      // Crée la page permettant d'ajouter une formation
      $scope.ajoutFormation = function(){
        $location.path("/admin/formation/nouveau"); 
      }

      // affiche les détails d'une formation
      $scope.edit = function(formation){
        $location.path("/admin/formation/"+ formation.codeFormation);
      }

      // supprime une formation
      $scope.supprime = function(formation){        
        formationsFactory.delete(formation);
      }
    }]
  );

  app.controller('FormationDetailsController', 
    ['$scope', '$routeParams', '$location', 'formationsFactory',
    function($scope, $routeParams, $location, formationsFactory){      
      $scope.edit= false;    

      // si creation d'une nouvelle formation
      if($routeParams.id == "nouveau"){
        $scope.formation= { };
        $scope.edit= true;    
      } else { // sinon on edite une formation existante
        //var f = formationsFactory.get($routeParams.id);
        // clone de l'objet pour conserver l'objet initial
        //$scope.formation = JSON.parse(JSON.stringify(f));
        var promise = formationsFactory.get($routeParams.id);
        promise
		.success(function(data,status) {
			$scope.formation = data ;
        	console.log("Dans FormationDetailsController : success : "+$scope.formation.nomFormation);
			//$scope.formation = JSON.parse(JSON.stringify(data));
		  }
		)
		 .error(function(data,status){
	        	console.log("erreur de recupere la formation choisi");
	      });
      }      

      $scope.edition = function(){
        $scope.edit = true;
      }

      // valide le formulaire d'édition d'une formation
      $scope.submit = function(){
    	  formationsFactory.set($scope.formation);        
          $scope.edit = false;  
          $location.path('/admin/formations'); 
        }
      
      // TODO coder une fonction submit permettant de modifier une formation et rediriger vers /admin/formations 


      // annule l'édition
      $scope.cancel = function(){ 
    	  $scope.formations = {};
          $location.path('/admin/formations');
    	  /*if(!$scope.formation.codeFormation){
          $location.path('/admin/formations');
      } else {
        var e = formationsFactory.get($routeParams.id);
        $scope.formation = JSON.parse(JSON.stringify(e));
        $scope.edit = false;
      }*/
    } 
      // TODO coder une fonction cancel permettant de modifier une formation et rediriger vers /admin/formations 

    }]
  );
})();
