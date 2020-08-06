<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test GCP SQL</title>
<!-- Angular -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.8/angular.js"></script>
<!-- End -->
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js"></script>
<!-- End -->

<script type="text/javascript">
//Creating a module
var mainApp = angular.module("Module", []);
mainApp.controller("Controller", [ "$rootScope", "$scope", "$http",
		"$window", function(rs, s, h, wind) {

	s.adduser = function(){
		let data = {
				"usrName" :s.usrName,
				"usrAddress"	: s.usrAddress
		}
		let d = [{"user":data}];
		//ajaxs
		h({
			method : 'POST',
			url : 'addUser',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : JSON.stringify(d)
		}).then(
			function(response) {
				alert(response.data.status);
			},
			function(error) {
				alert('Some this wrong, Try later...');
			});
		//end
		} 
	
}]);
</script>
</head>
<body>
Welcome to test Cloud SQL

<body>
	<div ng-app="Module" class="mt-3" id="mainId">
		<div ng-controller="Controller" id="" ng-cloak>
		<input type="text" id="usrName" ng-model="usrName">
		<input type="text" id="usrName" ng-model="usrAddress">
		
		<input type="button" ng-click="adduser()" value="Add User"> 
		
		</div>
		</div>
</body>
</html>