<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>Mapa</title>

<link rel="stylesheet" href="./ol/v6.1.1-dist/ol.css">

<link rel="stylesheet" href="css/foundation.css">
<link rel="stylesheet" href="css/app.css">

<style type="text/css">
html, body, #map {
	margin: 0;
	width: 100%;
	height: 100%;
}

#map {
	position: absolute;
}
</style>

</head>
<body>

	<div class="title-bar" data-responsive-toggle="responsive-menu"
		data-hide-for="medium">
		<button class="menu-icon" type="button" data-toggle="responsive-menu"></button>
		<div class="title-bar-title">Menu</div>
	</div>

	<div class="top-bar" id="responsive-menu">
		<div class="top-bar-left">
			<ul class="dropdown menu" data-dropdown-menu>
				<li><a class="button" href="camera.jsp">Camera</a></li>
			</ul>
		</div>
		<div class="top-bar-right">
			<ul class="dropdown menu" data-dropdown-menu>
				<li><a class="button" href="login.html">Logar</a></li>
			</ul>
		</div>
	</div>

	<div id="map"></div>

	<script src="./js/vendor/jquery-3.4.1.js" type="text/javascript"></script>
	<script src="./js/vendor/foundation.js" type="text/javascript"></script>
	<script src="./js/app.js" type="text/javascript"></script>

	<script src="./js/main.js" type="text/javascript"></script>
	<script src="./ol/v6.1.1-dist/ol.js" type="text/javascript"></script>

</body>
</html>