<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<link rel="stylesheet" href="./css/foundation.css">
<script type="text/javascript" src="./js/app.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>

</head>
<body onload=camera()>

	<div class="top-bar" style="background-color: black">
		<div class="top-bar-right">
			<ul class="menu">
				<li><a class="button" href="index.jsp">Voltar</a></li>
			</ul>
		</div>
	</div>

	<video id="preview"></video>

</body>
</html>