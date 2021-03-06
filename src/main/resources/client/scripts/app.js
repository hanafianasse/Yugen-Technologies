(function () {
	'use strict';
	var app = angular.module(
		'app',
		['dndLists','ngRoute', 'ngAnimate', 'ui.bootstrap', 'easypiechart',
			'mgo-angular-wizard', 'textAngular', 'ui.tree',
			'ngTagsInput', 'app.authentication', 'app.enseignants',
			'app.formations', 'app.ue', 'app.ui.ctrls',
			'app.ui.directives', 'app.ui.services', 'app.controllers',
			'app.directives', 'app.form.validation',
			'app.ui.form.ctrls', 'app.ui.form.directives',
			'app.tables', 'app.task', 'app.localization',
			'app.chart.ctrls', 'app.chart.directives',
			'app.page.ctrls', 'app.auth']).config(
		['$routeProvider', function ($routeProvider, $urlRouterProvider) {
			return $routeProvider.when('/', {
				redirectTo: '/dashboard'
			}).when('/admin/etudiants/reponseEvaluation', {
				templateUrl: 'views/reponseEvaluation/reponseEvaluation.html'
			}).when('/admin/enseignants', {
				templateUrl: 'views/enseignants/list.html'
			})
			
			.when('/admin/etudiants/:id', {
				templateUrl: 'views/etudiants/details.html'
			}).when('/admin/enseignantsConnected', {
				templateUrl: 'views/enseignants/pagevierge.html'
			}).when('/admin/enseignant/:id', {
				templateUrl: 'views/enseignants/details.html'
			}).when('/admin/formations', {
				templateUrl: 'views/formations/list.html'
			}).when('/admin/formation/:id', {
			}).when('/admin/formation/:id', {
				templateUrl: 'views/formations/details.html'
			}).when('/admin/questionsStandard', {
				templateUrl: 'views/question/list.html'
			}).when('/admin/RubriqueStandard', {
				templateUrl: 'views/rubrique/rubrique.html'
			}).when('/admin/ajoutrubrique', {
				templateUrl: 'views/rubrique/Ajoutrubrique.html'
			}).when('/admin/questionsStandard/maj/:idQuestionToBeUpdated', {
				templateUrl: 'views/question/update.html'
			}).when('/admin/ue', {
				templateUrl: 'views/ue/list.html'
			}).when('/admin/promotion', {
				templateUrl: 'views/promotion/list.html'
			}).when('/admin/promotion/:anneeUniversitaire/:codeFormation', {
				templateUrl: 'views/promotion/list.html'
			}).when('/admin/promotion/ajout/:codeFormation/:anneeUniversitaire', {
				templateUrl: 'views/promotion/ajout.html'
			}).when('/admin/promotion/modif/:codeFormation/:anneeUniversitaire/:noEtudiant', {
				templateUrl: 'views/promotion/modif.html'
			}).when('/admin/qualificatif', {
				templateUrl: 'views/qualificatif/list.html'
			}).when('/admin/qualificatif/AjouterQualificatif', {
				templateUrl: 'views/qualificatif/details.html'
			}).when('/admin/qualificatif/updateQualificatif/:idQualificatif', {
				templateUrl: 'views/qualificatif/updateQualificatif.html'
			}).when('/admin/evaluation', {
                templateUrl: 'views/evaluation/list.html'
            }).when('/admin/evaluation/Ajout', {
                templateUrl: 'views/evaluation/ajout.html'
            }).when('/admin/ue/:id', {
				templateUrl: 'views/ue/details.html'
			}).when('/admin/newQuesstion', {
				templateUrl: 'views/question/ajouter.html'
			}).when('/admin/etu/:id', {
				templateUrl: 'views/ue/ajoutEtudiant.html'
			}).when('/dashboard', {
				templateUrl: 'views/dashboard.html'
			}).when('/ui/typography', {
				templateUrl: 'views/ui/typography.html'
			}).when('/ui/buttons', {
				templateUrl: 'views/ui/buttons.html'
			}).when('/ui/icons', {
				templateUrl: 'views/ui/icons.html'
			}).when('/ui/grids', {
				templateUrl: 'views/ui/grids.html'
			}).when('/ui/widgets', {
				templateUrl: 'views/ui/widgets.html'
			}).when('/ui/components', {
				templateUrl: 'views/ui/components.html'
			}).when('/ui/timeline', {
				templateUrl: 'views/ui/timeline.html'
			}).when('/ui/nested-lists', {
				templateUrl: 'views/ui/nested-lists.html'
			}).when('/ui/pricing-tables', {
				templateUrl: 'views/ui/pricing-tables.html'
			}).when('/forms/elements', {
				templateUrl: 'views/forms/elements.html'
			}).when('/forms/layouts', {
				templateUrl: 'views/forms/layouts.html'
			}).when('/forms/validation', {
				templateUrl: 'views/forms/validation.html'
			}).when('/forms/wizard', {
				templateUrl: 'views/forms/wizard.html'
			}).when('/tables/static', {
				templateUrl: 'views/tables/static.html'
			}).when('/tables/responsive', {
				templateUrl: 'views/tables/responsive.html'
			}).when('/tables/dynamic', {
				templateUrl: 'views/tables/dynamic.html'
			}).when('/charts/others', {
				templateUrl: 'views/charts/charts.html'
			}).when('/charts/morris', {
				templateUrl: 'views/charts/morris.html'
			}).when('/charts/flot', {
				templateUrl: 'views/charts/flot.html'
			}).when('/mail/inbox', {
				templateUrl: 'views/mail/inbox.html'
			}).when('/mail/compose', {
				templateUrl: 'views/mail/compose.html'
			}).when('/mail/single', {
				templateUrl: 'views/mail/single.html'
			}).when('/pages/features', {
				templateUrl: 'views/pages/features.html'
			}).when('/pages/signin', {
				templateUrl: 'views/pages/signin.html',
				notLoggedNeeded: true
			}).when('/admin/UpdateRubrique/:idRubrique', {
				templateUrl: 'views/rubrique/UpdateRubrique.html'
			}).when('/pages/signup', {
				templateUrl: 'views/pages/signup.html',
				notLoggedNeeded: true
				/*
				 * .when('/pages/signin', { templateUrl:
				 * 'views/pages/signin.html' }) .when('/pages/signup', {
				 * templateUrl: 'views/pages/signup.html'
				 */
			}).when('/pages/forgot', {
				templateUrl: 'views/pages/forgot-password.html'
			}).when('/pages/lock-screen', {
				templateUrl: 'views/pages/lock-screen.html'
			}).when('/pages/profile', {
				templateUrl: 'views/pages/profile.html'
			}).when('/404', {
				templateUrl: 'views/pages/404.html'
			}).when('/pages/500', {
				templateUrl: 'views/pages/500.html'
			}).when('/pages/blank', {
				templateUrl: 'views/pages/blank.html'
			}).when('/pages/invoice', {
				templateUrl: 'views/pages/invoice.html'
			}).when('/pages/services', {
				templateUrl: 'views/pages/services.html'
			}).when('/pages/about', {
				templateUrl: 'views/pages/about.html'
			}).when('/pages/contact', {
				templateUrl: 'views/pages/contact.html'
			}).when('/tasks', {
				templateUrl: 'views/tasks/tasks.html'
			}).when('/404', {
				templateUrl: 'views/pages/404.html'
			}).when('/update/evaluation/:idEvaluation', {
				templateUrl: 'views/evaluation/update.html'
			}).when('/500', {
				templateUrl: 'views/pages/500.html'
			}).	otherwise({
				redirectTo: '/404'
			});
		}]).run(function ($rootScope, $route, $location, AuthService,enseignantsFactory,EtudiantsService) {
			$rootScope.$on("$routeChangeStart", function (e, to) {
				if ($rootScope.firstConnection === undefined) {
					$rootScope.firstConnection = true;
				}

				if (to != null && to.notLoggedNeeded) {
					AuthService.getUser().success(function (data) {
						if(data) {
							if (data.role === "ADM")
								$location.path("/");

							else
								$location.path("/admin/enseignantsConnected");
						}
						else
							return;
					}).error(function (data) {
						$location.path("/pages/signin");
					});
				}

				AuthService.getUser().success(function (data) {
					if (data) {
						if ($rootScope.firstConnection) {
							// if first cnx
							$rootScope.connectedUser = data;
							if($rootScope.connectedUser.role == 'ENS'){
								var promise = enseignantsFactory.get($rootScope.connectedUser.noEnseignant);
								promise.success(function(data){
									$rootScope.connectedUserAsEns = data;
								}).error(function(statu){
									console.log("get enseignants : error");
								});
							}
							if($rootScope.connectedUser.role == 'ETU'){
								var promise = EtudiantsService.getEtudiant($rootScope.connectedUser.noEtudiant);
								promise.success(function(data){
									$rootScope.connectedUserAsEtu = data;
									$location.path("/admin/etudiants/"+ $rootScope.connectedUser.noEtudiant);
								}).error(function(statu){
									console.log("get etudiants : error");
								});
							}

							 else {
								$location.path("/dashboard");
							}
							$rootScope.firstConnection = false;
						}
						e.preventDefault();
					} else {
						$location.path("/pages/signin");
					}
				}).error(function (data) {
					$location.path("/pages/signin");
				});
			});
		});
}).call(this);