//Controlleur de la page qui modifie un étudiant
angular.module('app').controller('editEtudiantsCtrl', ['$scope', '$location', 'EtudiantsService','$routeParams','promotionService','domaineService',
    function ($scope, $location, EtudiantsService,$routeParams,promotionService,domaineService) {
        $scope.status;
        $scope.error = false;
        $scope.success = false;
        console.log('je suis dans le controller modifier étudiant');
 
//Récuperation des domaines par UNIVERSITE
        var promise = domaineService.getDomaine("UNIVERSITE");
    	promise.success(function(data) { 
    		console.log("récupération du domaine terminé");
    		$scope.domaineUniv = data;
    		console.log($scope.domaineUniv);
    	}).error(function(data) {
    		console.log("get domaine : erreur");
    	});
    	
    	
    	//Récuperation des domaines par UNIVERSITE
        var promise = domaineService.getDomaine("UNIVERSITE");
    	promise.success(function(data) { 
    		console.log("récupération du domaine terminé");
    		$scope.domaineUniv = data;
    		console.log($scope.domaineUniv);
    	}).error(function(data) {
    		console.log("get domaine : erreur");
    	});

        
        
            
        
//Initialisation des champs        
        $scope.noEtudiant = $routeParams.noEtudiant;
        $scope.codeFormation = $routeParams.codeFormation;
        $scope.anneeUniversitaire = $routeParams.anneeUniversitaire;
        

//Récupération des donnée etudiant
        
    var promise = EtudiantsService.getEtudiant($scope.noEtudiant);
    promise.success(function(data) { 
    	console.log("récupération de l'étudiant terminé");
    	$scope.etudiant = data;
    	console.log($scope.etudiant);
        var dateNaissance = new Date($scope.etudiant.dateNaissance);
        var maxDateFormatted = dateNaissance.getFullYear() +
            '/' + dateNaissance.getMonth()+'/' +dateNaissance.getDate();
        
    	}).error(function(data) {
    		console.log("get etudiant : erreur");
    	});
        
        
        
//création de la variable etudiant
        $scope.modifierEtudiant = function (etudiant) {
        	console.log($scope.etudiant.noEtudiant);
        	console.log('je suis dans la methode put');
          var promise = promotionService.getPromotion($scope.codeFormation,$scope.anneeUniversitaire);
        	promise.success(function(data) {
        		var maPromotion = data;
               $scope.promotionEtudiant = {
                		etudiant : $scope.etudiant,
                		promotion : {
                			promotionPK : maPromotion.promotionPK,
                			formation : {
                				codeFormation : $scope.codeFormation
                			} 
                		}
                }
               
                EtudiantsService.updateEtudiant($scope.promotionEtudiant)
                .then(function (response) {
                	
                    $scope.status = 'Modification étudiant effectuée!';
                    $scope.error = false;
                    $scope.success = true;
                }, function (error) {
                    $scope.success = false;
                    $scope.error = true;
                    $scope.status = 'Erreur lors de la modification de l\'etudiant: ' + error.message;
                });
        	}).error(function(data) {
        		console.log("get : erreur");
        	});
        };

        $scope.closeAlert = function () {
            $scope.error = false;

            if ($scope.success) {
                $scope.success = false;
                $location.path('/admin/promotion');
            }
        };
    }
]);