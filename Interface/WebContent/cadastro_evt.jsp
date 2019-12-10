<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> --%>
<%-- <c:url value="/passeioServlet" var="linkPasseioServlet"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>Cadastro de Evento</title>
<link rel="stylesheet" href="css/foundation.css">
<link rel="stylesheet" href="css/app.css">

</head>
<body>

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

	<form action="CadastroEvt" method="post">
		<h1 class="text-center">Cadastrar Eventos</h1>

		<div class="grid-container">

			<div class="grid-x grid-padding-x">

				<div class="medium-12 cell">
					<div class="input-group">
						<span class="input-group-label">Nome do Evento</span> <input
							class="input-group-field" type="text" name="nome_evt" />
					</div>
				</div>

				<div class="medium-12 cell">
					<label for="hora_enc">Data </label>
				</div>

				<div class="medium-6 cell">
					<div class="input-group">
						<span class="input-group-label">Início</span> <input
							class="input-group-field" type="date" name="inicio" />
					</div>
				</div>

				<div class="medium-6 cell">
					<div class="input-group">
						<span class="input-group-label">Fim</span> <input
							class="input-group-field" type="date" name="fim" />
					</div>
				</div>

				<!-- 				<div class="medium-12 cell"> -->
				<!-- 					<div class="input-group"> -->
				<!-- 						<span class="input-group-label">Local</span> <input -->
				<!-- 							class="input-group-field" type="text" name="local"> -->
				<!-- 					</div> -->
				<!-- 				</div> -->

				<!-- 				<div class="medium-4 cell"> -->
				<!-- 					<div class="input-group"> -->
				<!-- 						<span class="input-group-label">Bloco</span> <input -->
				<!-- 							class="input-group-field" type="text" name="bloco"> -->
				<!-- 					</div> -->
				<!-- 				</div> -->

				<!-- 				<div class="medium-4 cell"> -->
				<!-- 					<div class="input-group"> -->
				<!-- 						<span class="input-group-label">Espaço</span> <input -->
				<!-- 							class="input-group-field" type="text" name="espaco"> -->
				<!-- 					</div> -->
				<!-- 				</div> -->

				<!-- 				<div class="medium-4 cell"> -->
				<!-- 					<div class="input-group"> -->
				<!-- 						<span class="input-group-label">Sala</span> <input -->
				<!-- 							class="input-group-field" type="text" name="sala"> -->
				<!-- 					</div> -->
				<!-- 				</div> -->

				<!-- 				<div class="medium-12 cell"> -->

				<!-- 					<div class="input-group"> -->
				<!-- 						<span class="input-group-label">Staff</span> <input -->
				<!-- 							class="input-group-field" type="text" name=""> -->
				<!-- 						<div class="input-group-button"> -->
				<!-- 							<input type="button" class="button" value="+" id="botao_staff"></input> -->
				<!-- 						</div> -->
				<!-- 					</div> -->

				<!-- 					<table> -->
				<!-- 						<tr> -->
				<!-- 							<td></td> -->
				<!-- 						</tr> -->
				<!-- 					</table> -->

				<!-- 				</div> -->

				<!-- 				<table> -->
				<!-- 					<thead> -->
				<!-- 						<tr> -->
				<!-- 							<th width="20">Id</th> -->
				<!-- 							<th>Nome</th> -->
				<!-- 							<th>Local</th> -->
				<!-- 							<th>Tipo</th> -->
				<!-- 							<th>Dia</th> -->
				<!-- 							<th>Horário</th> -->
				<!-- 							<th>Apresentador</th> -->
				<!-- 						</tr> -->
				<!-- 					</thead> -->
				<!-- 					<tbody> -->
				<!-- 						<tr> -->
				<!-- 							<td>001</td> -->
				<!-- 							<td>Introdução à IA</td> -->
				<!-- 							<td>Bloco 12 Espaço 2 Sala 1</td> -->
				<!-- 							<td>Palestra</td> -->
				<!-- 							<td>27/08/19</td> -->
				<!-- 							<td>13h00</td> -->
				<!-- 							<td>Alguém</td> -->
				<!-- 						</tr> -->
				<!-- 						<tr> -->
				<!-- 							<td>002</td> -->
				<!-- 							<td>TeleConferência</td> -->
				<!-- 							<td>Bloco 12 Espaço 2 Sala 2</td> -->
				<!-- 							<td>Oficina</td> -->
				<!-- 							<td>28/08/19</td> -->
				<!-- 							<td>15h00</td> -->
				<!-- 							<td>Ninguém</td> -->
				<!-- 						</tr> -->
				<!-- 					</tbody> -->
				<!-- 				</table> -->

				<a class="button float-center" href="cadastrar_ativ.jsp">Cadastrar
					Atividade</a>

			</div>

			<%-- 			<h1>${nome_evt}</h1> --%>
			<%-- 			<h1>${inicio}</h1> --%>
			<%-- 			<h1>${fim}</h1> --%>

			<input class="button" type="submit" value="Salvar"></input>

		</div>

	</form>

	<script src="./js/vendor/jquery-3.4.1.js" type="text/javascript"></script>
	<script src="./js/vendor/foundation.js" type="text/javascript"></script>
	<script>
		$(document).foundation();
	</script>
</body>
</html>