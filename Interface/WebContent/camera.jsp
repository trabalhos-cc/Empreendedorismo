<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Leitor de QRCode</title>

<script type="text/javascript" src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js" ></script>	


<link rel="stylesheet" href="css/foundation.css">
<link rel="stylesheet" href="css/app.css">

<style type="text/css">
html, body, #webcam {
	margin: 0;
	width: 100%;
	height: 100%;
}

#webcam {
	position: absolute;
}
</style>

</head>
<body style="background: none;">

	<div class="title-bar" data-responsive-toggle="responsive-menu"
		data-hide-for="medium">
		<button class="menu-icon" type="button" data-toggle="responsive-menu"></button>
		<div class="title-bar-title">Menu</div>
	</div>

	<div class="top-bar" id="responsive-menu">
		<div class="top-bar-right">
			<ul class="dropdown menu" data-dropdown-menu>
				<li><a class="button" href="home.html">Voltar</a></li>
			</ul>
		</div>
	</div>

	<video id="webcam"></video>

	<script>
	
	 let scanner = new Instascan.Scanner(
	            {
	                video: document.getElementById('webcam')
	            }
	        );
	        scanner.addListener('scan', function(content) {
	            alert('Escaneou o conteudo: ' + content);
	            window.open(content, "_blank");
	        });
	        Instascan.Camera.getCameras().then(cameras => 
	        {
	            if(cameras.length > 0){
	                scanner.start(cameras[0]);
	            } else {
	                console.error("Não existe câmera no dispositivo!");
	            }
	        });
	        
	        
	</script>

	<script src="./js/vendor/jquery-3.4.1.js" type="text/javascript"></script>
	<script src="./js/vendor/foundation.js" type="text/javascript"></script>
	<script src="./js/app.js" type="text/javascript"></script>

</body>
</html>