<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de Atividades</title>
<link id="found" rel="stylesheet" href="css/foundation.css">
</head>
<body>

	<div class="top-bar" style="background-color: black">
		<div class="top-bar-right">
			<ul class="menu">
				<li><a class="button" href="eventos.html">Voltar</a></li>
			</ul>
		</div>
	</div>

	<form>
		<h1 class="text-center">Cadastrar Atividades</h1>

		<div class="grid-container">

			<div class="grid-x grid-padding-x">

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
							class="input-group-field" type="time">
					</div>
				</div>

				<div class="medium-6 cell">
					<div class="input-group">
						<span class="input-group-label">Horário de fim</span> <input
							class="input-group-field" type="time">
					</div>
				</div>

				<div class="medium-12 cell">
					<div class="input-group">
						<span class="input-group-label">Nome do local</span> <input
							class="input-group-field" type="text">
					</div>
				</div>

				<div class="medium-4 cell">
					<div class="input-group">
						<span class="input-group-label">Bloco</span> <input
							class="input-group-field" type="text">
					</div>
				</div>

				<div class="medium-4 cell">
					<div class="input-group">
						<span class="input-group-label">Espaço</span> <input
							class="input-group-field" type="text">
					</div>
				</div>

				<div class="medium-4 cell">
					<div class="input-group">
						<span class="input-group-label">Sala</span> <input
							class="input-group-field" type="text">
					</div>
				</div>

				<!-- 				<div class="medium-12 cell"> -->
				<!-- 					<label for="hora_enc">Data </label> -->
				<!-- 				</div> -->

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
						input.setAttribute("name", "apresentador[]");
						input.setAttribute("type", "text");
						input.setAttribute("value", candidate.value);

						tbody.appendChild(tr);
						tr.appendChild(td);
						td.appendChild(input);
					}
				</script>

				<table id="table">
					<tbody id="tbody">

					</tbody>
				</table>

			</div>

			<input type="submit" class="button" value="Salvar"></input> <input
				type="reset" class="button float-right" value="Cancelar"></input>

		</div>

	</form>

</body>
</html>