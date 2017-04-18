/**
 * 
 */
var app = angular.module('app', ['ui.router']);
//var app = angular.module('app', ['ui.router']);
//
//app.config(function ($stateProvider, $urlRouterProvider,$httpProvider) {
//	$httpProvider.defaults.useXDomain = true;
//	delete $httpProvider.defaults.headers.common['X-Requested-With'];
//	
//    $urlRouterProvider.otherwise("/registration");
//    
//    $stateProvider
//            .state("registration", {
//                url: '/registration',
//                templateUrl: "app/classroom/studentRegistration.html",
//                controller:"studentRegistrationCtrl"
//            });
//});
//
//app.run(['$rootScope', '$state', '$stateParams', function ($rootScope, $state, $stateParams) {
//        $rootScope.$state = $state;
//        console.log("Run Called");
//        $rootScope.$stateParams = $stateParams;
//        $state.go("registration");
//    }]);