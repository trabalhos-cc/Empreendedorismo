<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>Mapa</title>

<link rel="stylesheet" href="./css/layout.css" type="text/css">

<link rel="stylesheet" href="./css/foundation.css">

<link rel="stylesheet" href="./ol/v6.1.1-dist/ol.css">

<!-- <style type="text/css">
/* html, body, .map { */
/* 	margin: 0; */
/* 	padding: 0; */
/* 	width: 100%; */
/* 	height: 100%; */
/* } */ -->


<!-- </style> -->

</head>
<body>

	<div class="top-bar" style="background-color: black">
		<div class="top-bar-right">
			<ul class="menu">
				<li><a class="button" href="login.html">Logar</a></li>
			</ul>
		</div>
	</div>

	<div id="map" class="map"></div>

	<img id="geolocation_marker" src="./img/geolocation_marker.png" />

	<div class="buttons">
		<a class="button" id="camera" style="max-width: 5%; height: auto"
			href="camera.jsp"> <img src="img/Camera-Next-icon.png" />
		</a>

		<button id="geolocate">Geolocate Me!</button>
		<!-- 	<script src="common.js"></script> -->
		<!-- 	<script src="geolocation-orientation.js"></script> -->
	</div>

	<script src="./js/main.js" type="text/javascript"></script>
	<script src="./ol/v6.1.1-dist/ol.js" type="text/javascript"></script>
	
</body>
</html>