<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style>
input{
	padding: 12px 10px;
	margin:10px;
	width: 40%;
	font-size: 22px;
}
#form{
width:40%;
margin:0 auto;
}
</style>
</head>
<body>
<br><br><h1 align=center >Assistant Login</h1><br><br>
<form class="form-group" id="form" action="Login" method="POST">
<input class="form-control" type="text" name="email" placeholder="EMAIL"><br>
<input class="form-control" type="password" name="pwd" placeholder="PASSWORD"><br>
<input class="form-control" type="submit" value="LOGIN">
</form>
</body>
</html>