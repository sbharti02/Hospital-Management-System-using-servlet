<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assistant Panel</title>
<style>
iframe {
	height:900px;
	resize:both;
}
#panel {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

#panel li button{
  float: left;
}

#panel li button {
  display: block;
  color: white;
  background-color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

#panel li button:hover:not(.active) {
  background-color: lightblue;
  color: #111
}

.active {
  background-color: #4CAF50;
}

.prof{
  float: right;
}
</style>
<script>
function show(value){
	document.getElementById("frame").innerHTML = "<iframe src=\""+ value+".html\" height=\"100%\" width=\"100%\" ></iframe>";
}
</script>
</head>
<body>
<div align=center id="title"><h1>HOSPITAL</h1></div>
<ul id="panel">
  <li><button onClick="show('addDoctor')">ADD DOCTOR</button></li>
  <li><button onClick="show('addPatient')">ADD PATIENT</button></li>
  <li><button onClick="show('addMedicine')">ADD MEDICINE</button></li>
  <li><button onClick="show('getDoctor')">VIEW DOCTORS</button></li>
  <li><button onClick="show('getPatients')">VIEW PATIENTS</button></li>
  <li><button onClick="show('getMedicine')">MEDICINE STORE</button></li>
  <li><button onClick="show('discharge')">DISCHARGE</button></li>
  <li class="prof 1"><button>ABOUT US</button></li>
  <li class="prof 2"><form method="post" action="Logout"><button type="submit">LOGOUT</button></form></li>
</ul>
<br>
<div id="frame"></div>
</body>
</html>