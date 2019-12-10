<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de Atividades</title>
<link id="found" rel="stylesheet" href="css/foundation.css">
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

	<form action="CadastroAtiv" method="post">
		<h1 class="text-center">Cadastrar Atividades</h1>

		<div class="grid-container">

			<div class="grid-x grid-padding-x">

				<div class="medium-12 cell">
					<div class="input-group">
						<span class="input-group-label"> Nome do Evento</span> <input
							class="input-group-field" type="text" name="nome_evt"
							value="${nome_evt}">
					</div>
				</div>

				<div class="medium-12 cell">
					<div class="input-group">
						<span class="input-group-label"> Nome da Atividade</span> <input
							class="input-group-field" type="text" name="nome">
					</div>
				</div>

				<div class="medium-6 cell">
					<div class="input-group">
						<span class="input-group-label">Tipo</span> <select
							class="input-group-field" name="tipo">
							<option value="palestra">Palestra</option>
							<option value="oficina">Oficina</option>
							<option value="minicurso">Minicurso</option>
							<option value="minicurso">Workshop</option>
							<option value="minicurso">Mesa Redonda</option>
							<option value="minicurso">Comunicação Oral</option>
							<option value="minicurso">Apresentação de Poster</option>
							<option value="minicurso">Roda de Conversa</option>
						</select>
					</div>
				</div>

				<div class="medium-6 cell">
					<div class="input-group">
						<span class="input-group-label">Data</span> <input
							class="input-group-field" type="date" name="data">
					</div>
				</div>

				<div class="medium-6 cell">
					<div class="input-group">
						<span class="input-group-label">Horário de início</span> <input
							class="input-group-field" type="time" name="horarioIni">
					</div>
				</div>

				<div class="medium-6 cell">
					<div class="input-group">
						<span class="input-group-label">Horário de fim</span> <input
							class="input-group-field" type="time" name="horarioFim">
					</div>
				</div>

				<!-- 				<div class="medium-12 cell"> -->
				<!-- 					<div class="input-group"> -->
				<!-- 						<span class="input-group-label">Nome do local</span> <input -->
				<!-- 							class="input-group-field" type="text" name="local"> -->
				<!-- 					</div> -->
				<!-- 				</div> -->

				<div class="medium-4 cell">
					<div class="input-group">
						<span class="input-group-label">Bloco</span> <input
							class="input-group-field" type="text" name="bloco">
					</div>
				</div>

				<div class="medium-4 cell">
					<div class="input-group">
						<span class="input-group-label">Espaço</span> <input
							class="input-group-field" type="text" name="espaco">
					</div>
				</div>

				<div class="medium-4 cell">
					<div class="input-group">
						<span class="input-group-label">Sala</span> <input
							class="input-group-field" type="text" name="sala">
					</div>
				</div>

				<div class="medium-12 cell">
					<div class="input-group">
						<span class="input-group-label">Apresentadores</span> <input
							id="candidate" class="input-group-field" type="text"></input>
						<div class="input-group-button">
							<button class="button" type="button" onclick="addItem()"
								id="botao_staff">+</button>
						</div>
					</div>
				</div>

				<script>
					function addItem() {
						var tbody = document.getElementById("tbody");

						var candidate = document.getElementById("candidate");

						var tr = document.createElement("tr");

						var td = document.createElement("td");
						td.setAttribute('id', candidate.value);

						var input = document.createElement("input");
						input.setAttribute("name", "apresentador");
						input.setAttribute("type", "text");
						input.setAttribute("value", candidate.value);

						tbody.appendChild(tr);
						tr.appendChild(td);
						td.appendChild(input);
					}
				</script>

				<table id="table" class="unstriped">
					<tbody id="tbody">
					</tbody>
				</table>

			</div>

			<input type="submit" class="button" value="Salvar"></input> <input
				type="reset" class="button float-right" value="Cancelar"></input>

		</div>

	</form>

	<script src="./js/vendor/jquery-3.4.1.js" type="text/javascript"></script>
	<script src="./js/vendor/foundation.js" type="text/javascript"></script>
	<script src="./js/app.js" type="text/javascript"></script>

</body>
</html>