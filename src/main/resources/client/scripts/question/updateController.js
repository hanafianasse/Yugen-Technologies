/**
 * Created by Anasse on 13/03/2017.
 */
'use strict';

angular.module('app')
	.controller('UpdateQuestionController', ['$scope','$routeParams','$http','QualificatifService','questionService','domaineService','$location',
	function ($scope,$routeParams,$http,QualificatifService,questionService,domaineService,$location) {

		$('input').on('input', function() {
			var c = this.selectionStart,
                r = /[^a-z0-9êéàçèù '\-]/gi,
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

		var promise = questionService.getQuestion($routeParams.idQuestionToBeUpdated);
		promise.success(function(data) {
			$scope.question = data;
			console.log(data);
		}).error(function(data) {
			console.log("get questions : erreur");
		});

		$scope.update = function(){
			console.log($scope.question);
            $scope.question.type = 'QUS';
            var promise = questionService.updateQuestion($scope.question);
			promise.success(function(data){
				$location.path('/admin/questionsStandard');
			}).error(function(status){
				console.log('update question : error');
			});
		}
}]);
