<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body><br><br><h1 align=center >Register Assistant</h1><br><br>
<form  class="form-group" id="form" action="CreateAssistant" method="POST">
<input class="form-control" type="text" name="name" placeholder="NAME"><br>
<input class="form-control" type="text" name="email" placeholder="EMAIL"><br>
<input class="form-control" type="number" name="phone" placeholder="PHONE"><br>
<input class="form-control" type="password" name="pwd" placeholder="PASSWORD"><br>
<input class="form-control" type="submit" value="SIGNUP">
</form>
</body>
</html>