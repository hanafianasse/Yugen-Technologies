//Controlleur de la page qui ajoute un étudiant
angular.module('app').controller('addEtudiantsCtrl', ['$scope', '$location', 'EtudiantsService','$routeParams','promotionService','domaineService',
    function ($scope, $location, EtudiantsService,$routeParams,promotionService,domaineService) {
    $scope.status;
    $scope.error = false;
    $scope.success = false;
        
    $('input').on('input', function() {
        var c = this.selectionStart,
            r = /[^a-z0-9êéàçèù@ .\-\/]/gi,
            v = $(this).val();
        if(r.test(v)) {
            $(this).val(v.replace(r, ''));
            c--;
        }
        this.setSelectionRange(c, c);
    });
        
    //Récuperation des domaines par UNIVERSITE
    var promise = domaineService.getDomaine("UNIVERSITE");
	promise.success(function(data) { 
		console.log("récupération du domaine UNIVERSITE terminé");
		$scope.domaineUniv = data;
		console.log($scope.domaineUniv);
	}).error(function(data) {
		console.log("get domaine : erreur");
	});
	
	
    //Récuperation des domaines par PAYS
    var promise = domaineService.getDomaine("PAYS");
	promise.success(function(data) { 
		console.log("récupération du domaine PAYS terminé");
		$scope.domainePays = data;
		console.log($scope.domainePays);
	}).error(function(data) {
		console.log("get domaine : erreur");
	});
    
    
    
    $scope.codeFormation = $routeParams.codeFormation;
    $scope.anneeUniversitaire = $routeParams.anneeUniversitaire;
    $scope.ajouterEtudiant = function (etudiant) {
        console.log(" anasse chuf hna ::: " + $scope.etudiant.dateNaissance);
        $scope.etudiant.dateNaissance = new Date($scope.etudiant.dateNaissance);
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
            console.log($scope.promotionEtudiant);
            EtudiantsService.addEtudiant($scope.promotionEtudiant)
            .then(function (response) {
                $scope.status = 'Insertion étudiant effectuée!';
                $scope.error = false;
                $scope.success = true;
                $location.path('/admin/promotion');
            }, function (error) {
                $scope.success = false;
                $scope.error = true;
                $scope.status = 'Erreur lors de l\'insertion de l\'etudiant: ' + error.message;
            });
    	}).error(function(data) {
    		console.log("get formtions : erreur");
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