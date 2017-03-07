angular.module('app.auth', [])

/**
 * A simple example service that returns some data.
 */
.factory('AuthService', function($http, $window) {

	return {
		authLocal : function(requestAuth) {
			config = {
				url : '/auth',
				method : "POST",
				data : requestAuth
			};
			return $http(config);
		},
		getUser : function() {
			config = {
				url : '/user',
				method : "GET"
			}
			return $http(config);
		},
		deconnexion : function() {
			config = {
				url : '/deconnexion',
				method : "GET"
			}
			return $http(config);
		}
	}

})

/**
 * Controleur pour la page d'authentification.
 */
.controller(
		'AuthenticationController',
		[ '$scope', '$location', '$animate', 'AuthService',
				function($scope, $location, $animate, AuthService) {
					$scope.login = {};
					/*
					 * // Nom utilisateur et image (affichés dans le header)
					 * $scope.username = auth.username(); $scope.userimg = ""; //
					 * Réception de l'événement de login (voir le service
					 * 'auth') $scope.$on('login-success', function(){
					 * $scope.username = auth.username(); $scope.userimg =
					 * auth.userimg(); })
					 */

					// Executé lors du click sur le bouton de login
					this.submit = function() {
						var authuser = {
							"username" : $scope.login.username,
							"pwd" : $scope.login.password,
						};
						AuthService.authLocal(authuser).success(function() {
							$location.path('/');
						})
						.error(function() {
							// si la connexion a échoué : "secoue" le formulaire
							// de connexion
							// TODO : afficher un message d'erreur de connexion
							var elt = angular.element('.form-container');
							$animate.addClass(elt, 'shake', function() {
								$animate.removeClass(elt, 'shake');
							});
						});
					}
				} ]);
;