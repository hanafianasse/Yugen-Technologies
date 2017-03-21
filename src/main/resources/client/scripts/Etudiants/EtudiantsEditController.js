//Controlleur de la page qui modifie un étudiant
angular.module('app').controller('editEtudiantsCtrl', ['$scope', '$location', 'EtudiantsService','$routeParams','promotionService','domaineService','$filter','$rootScope','$modal',
    function ($scope, $location, EtudiantsService,$routeParams,promotionService,domaineService,$filter,$rootScope,$modal) {


    $('input').on('input', function() {
        var c = this.selectionStart,
            r = /[^a-z0-9êéàçèù@ ()+.\-\/]/gi,
            v = $(this).val();
        if(r.test(v)) {
            $(this).val(v.replace(r, ''));
            c--;
        }
        this.setSelectionRange(c, c);
    });


    $scope.status;
    $scope.error = false;
    $scope.success = false;

    //Récuperation des domaines par UNIVERSITE
    var promise = domaineService.getDomaine("UNIVERSITE");
	promise.success(function(data) {
		$scope.domaineUniv = data;
	}).error(function(data) {
		console.log("get domaine : erreur");
	});


    //Récuperation des domaines par PAYS
    var promise = domaineService.getDomaine("PAYS");
	promise.success(function(data) {
		$scope.domainePays = data;
	}).error(function(data) {
		console.log("get domaine : erreur");
	});


    //Initialisation des champs
    $scope.noEtudiant = $routeParams.noEtudiant;
    $scope.codeFormation = $routeParams.codeFormation;
    $scope.anneeUniversitaire = $routeParams.anneeUniversitaire;


    //Récupération des données etudiant
    var promise = EtudiantsService.getEtudiant($scope.noEtudiant);
    promise.success(function(data) {
    	console.log("récupération de l'étudiant terminé");
    	$scope.etudiant = data;
        $rootScope.noEtudiantOld = $scope.etudiant.noEtudiant;
        $scope.etudiant.dateNaissance.toString("yyyy-MM-dd");
        console.log($scope.etudiant.dateNaissance);
    	console.log($scope.etudiant);
	}).error(function(data) {
		console.log("get etudiant : erreur");
	});

    //création de la variable etudiant
    $scope.modifierEtudiant = function (etudiant) {
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
            EtudiantsService.updateEtudiant($scope.promotionEtudiant,$rootScope.noEtudiantOld)
            .then(function (response) {
                $scope.status = 'Modification étudiant effectuée!';
                $scope.error = false;
                $scope.success = true;
                $location.path('/admin/promotion/'+$scope.promotionEtudiant.promotion.promotionPK.anneeUniversitaire+'/'+$scope.promotionEtudiant.promotion.promotionPK.codeFormation);
            }, function (error) {
                $modal.open({
                    templateUrl: 'myModalContent_EditEtudiant.html',
                    backdrop: true,
                    controller: function ($scope, $modalInstance) {
                        $scope.annulerSuppresion = function () {
                            $modalInstance.dismiss('cancel');
                        };
                    }
                });
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
