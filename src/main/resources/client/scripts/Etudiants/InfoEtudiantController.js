angular.module('app').controller('infoEtudiantCtrl', ['$scope', '$location', 'EtudiantsService','$routeParams','$rootScope','EvaluationService',
    function ($scope, $location, EtudiantsService,$routeParams,$rootScope,EvaluationService) {

    	//Récupération d'un étudiant
    $scope.getEtudiant=function  () {
   
    var promise=EtudiantsService.getEtudiant($rootScope.connectedUser.noEtudiant);
    promise.success(function(data){
        $scope.etudiant=data;
        
       if($scope.etudiant.telephone == null){
           $scope.etudiant.telephone="-- -- -- -- --"
        switch($scope.etudiant.paysOrigine){
            case("MA"):
                $scope.etudiant.paysOrigine="MAROC";
                break;
            case("FR"):
                $scope.etudiant.paysOrigine="FRANCE";
                break;
            case("TU"):
                $scope.etudiant.paysOrigine="TUNISIE";
                break;
            case("AL"):
                $scope.etudiant.paysOrigine="ALGERIE";
                break;
            case("BF"):
                $scope.etudiant.paysOrigine="BURKINA FASO";
                break;
        }
       }
    }).error(function(data){
        console.log("get etudiant : erreur");

    });
    };
    $scope.getEtudiant();


     $scope.getEvae=function () {
         var promise=EtudiantsService.getPromotionEtudiant($rootScope.connectedUser.noEtudiant);


         promise.then(function (response) {
             $scope.promotion = response.data;
             return EvaluationService.getEvaluationByPromotion($scope.promotion.promotionPK.codeFormation,$scope.promotion.promotionPK.anneeUniversitaire);
        },function (error) {
             console.log("getEval:erreur");

         }).then(function (response) {
            $scope.evaluations=[];
             angular.forEach(response.data,function (item,index) {

                 if(item.codeEc == null){
                     item.codeEc = "--";
                 }
                 if(item.etat != 'ELA'){
                 $scope.evaluations.push(item);}
                 
             })

         })

     };
        $scope.getEvae();


     $scope.getPromotion=function () {
         var promise=EtudiantsService.getPromotionEtudiant($rootScope.connectedUser.noEtudiant);
         promise.success(function (data) {
             $scope.promotion=data;

         }).error(function (data) {
             console.log("get promotion : erreur");
         })     }
     
     
     $scope.select = function(evaluation){
 		$rootScope.selectedeval = evaluation;
 		
 };
 
    }]);
