/**
 * Created by Anasse on 12/03/2017.
 */
'use strict';

angular.module('app')
	.controller('AddQuestionController', ['$scope','$routeParams','$http','QualificatifService','questionService','domaineService','$location',
	function ($scope,$routeParams,$http,QualificatifService,questionService,domaineService,$location) {

		$('input').on('input', function() {
			var c = this.selectionStart,
            r = /[^a-z0-9êéàçèù \-]/gi,
				v = $(this).val();
			if(r.test(v)) {
				$(this).val(v.replace(r, ''));
				c--;
			}
			this.setSelectionRange(c, c);
		});

		var promise = QualificatifService.getAll();
		promise.success(function(data) {
			$scope.qualificatifs = data;
		}).error(function(data) {
			console.log("get questions : erreur");
		});

		$scope.ajouter = function(){
			$scope.question.noEnseignant = null;
            $scope.question.type = 'QUS';
			console.log($scope.question);
			var promise = questionService.addQuestion($scope.question);
			promise.success(function(data){
				$location.path('/admin/questionsStandard');
			}).error(function(status){
				console.log('add question : error');
			});
		}
}]);
