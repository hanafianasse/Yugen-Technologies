(function() {
  'use strict';

  var app = angular.module('app.ue', []);

  app.factory('ueFactory', function(){
    var list = [ 
      // TODO    
    ];
            
    return {
      // TODO
    };
  });

  

  app.controller('UEController', 
    ['$scope', '$location', 'ueFactory',
    function($scope, $location, ueFactory){
      // la liste globale des ue
      // TODO
    }]
  );

  app.controller('UEDetailsController', 
    ['$scope', '$routeParams', '$location', 'ueFactory',
    function($scope, $routeParams, $location, ueFactory){      
      // TODO
    }]
  );
})();
