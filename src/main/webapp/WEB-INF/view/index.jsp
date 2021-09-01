<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Delete user</title>
</head>


	
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script type="text/javascript">
var app = angular.module("Test", []);
app.controller("UserController", function($scope, $http) {
    $scope.users = [];
    $scope.form = {
        id : ''
    };
    
    $scope.deleteUser = function() {
   	 $http({
	         method : "DELETE",
	         url : 'deleteUserById/' +  $scope.form.id,
	         data : $scope.form
	     }).then( _success, _error );
	 };
	 function _success(response) {
		 alert("Success")
		 var id = response.data.message;
		 document.getElementById("numloc").innerHTML = id;
		  console.log(response);
	     _clearForm()
	 }		
	 function _error(response) {
		 alert("error")
	     console.log(response.statusText);
	 }	
	 function _clearForm() {
	     $scope.form.id = '';
	 };
});
/* 	function validate() {
		var num = document.myform.num.value;
		if (isNaN(num)) {
			document.getElementById("numloc").innerHTML = "Enter Numeric value only";
			return false;
		} else if (num == "") {
			document.getElementById("numloc").innerHTML = "You must enter a value";
			return false;
		} else {
			return true;
		}
	} */
</script>

<body ng-app="Test" ng-controller="UserController">
	<form ng-submit="deleteUser()">
		Id: <input type="text" ng-model="form.id">
		<span id="numloc"></span><br />
		<input type="submit" value="Delete">
	</form>
	
</body>
</html>