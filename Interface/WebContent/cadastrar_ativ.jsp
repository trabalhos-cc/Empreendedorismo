<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de Atividades</title>
<link rel="stylesheet" href="css/foundation.css">
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
							class="input-group-field" type="text">
					</div>
				</div>

				<div class="medium-12 cell">
					<div class="input-group">
						<span class="input-group-label">Horário</span> <input
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

				<div class="medium-12 cell">
					<label for="hora_enc">Data </label>
				</div>

				<div class="medium-6 cell">
					<div class="input-group">
						<span class="input-group-label">Início</span> <input
							class="input-group-field" type="date">
					</div>
				</div>

				<div class="medium-6 cell">
					<div class="input-group">
						<span class="input-group-label">Fim</span> <input
							class="input-group-field" type="date">
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

				<div class="medium-12 cell">
					<div class="input-group">
						<span class="input-group-label">Staff</span> <input
							class="input-group-field" type="text">
						<div class="input-group-button">
							<input type="button" class="button" value="+" id="botao_staff"></input>
						</div>
					</div>
				</div>

				<table>
					<tr>
						<td>Ciclano da Silva</td>
					</tr>
					<tr>
						<td>Fulano Pereira</td>
					</tr>
				</table>

			</div>

			<input type="submit" class="button" value="Salvar"></input> <input
				type="reset" class="button float-right" value="Cancelar"></input>

		</div>

	</form>

</body>
</html>