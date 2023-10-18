<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SHOW DOCTORS</title>
<style>
table {
  		font-family: arial, sans-serif;
  		border-collapse: collapse;
 		width: 100%;
	}
	button {
 		display: block;
 	 	color: white;
  		background-color: black;
  		text-align: center;
 	 	padding: 14px 16px;
 	 	text-decoration: none;
	}
	#add input{
		padding: 25px 10px;
		margin:3px;
		width: 40%;
		font-size: 22px;
	}

	td, th {
 		border: 1px solid #dddddd;
  		text-align: left;
  		padding: 8px;
	}

		tr:nth-child(even) {
  		background-color: #dddddd;
	}
</style>
<script>

function doc() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("box").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("GET", "RetrieveDoctor", true);
	  xhttp.send();
	}
</script>
</head>
<body>
<h2 align=center>GET ALL DOCTORS <br><br><button align=center type="button" onclick="doc()">CLICK ME</button></h2><br><br>
<div id="box">

</div>
</body>
</html>