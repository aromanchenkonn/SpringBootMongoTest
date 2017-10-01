var app=angular.module("springDemo", []);

app.controller("AppCtrl", function($scope, $http){
    $scope.websites = [];
    $http.get('http://localhost:8882/api/stackoverflow')
    .success(function(data) {
      $scope.websites = data;
    })
    .error(function(data, status) {
      console.error('Repos error', status, data);
    })
    .finally(function() {
      console.log("finally finished repos");
    });
 });






//app.controller("AppCtrl", function($scope){
//             $scope.websites = [{
//             iconImageUrl: 'https://www.santouka.co.jp/wp/wp-content/themes/santouka/img/home/icon-mark.png',
//             id: 'stackoverflow',
//             website: 'http://www.google.com',
//             title: 'my name',
//             description: 'my plot'
//             }];
//         });