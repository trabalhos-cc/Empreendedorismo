<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Excluir Eventos</title>

<link rel="stylesheet" href="css/foundation.css">
</head>
<body>

	<div class="top-bar" style="background-color: black">
		<div class="top-bar-right">
			<ul class="menu">
				<li><a class="button" href="home.html">Voltar</a></li>
			</ul>
		</div>
	</div>
	
	

	<div class="grid-container" style="margin-top: 50px">
	
				<h1 class="text-center">Excluir Eventos</h1>
	

		<div class="grid-x grid-padding-x">

			<div class="medium-12 cell">


				<div class="input-group">
					<input class="input-group-field" type="search">
					<div class="input-group-button">
						<input type="submit" class="button" value="Pesquisar">
					</div>
				</div>

			</div>

		</div>

	</div>

	<table>
		<thead>
			<tr>
				<th width="20">Id</th>
				<th>Nome</th>
				<th>Local</th>
				<th>Tipo</th>
				<th>Dia</th>
				<th>Horário</th>
				<th>Apresentador</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>001</td>
				<td>Introdução à IA</td>
				<td>Bloco 12 Espaço 2 Sala 1</td>
				<td>Palestra</td>
				<td>27/08/19</td>
				<td>13h00</td>
				<td>Alguém</td>
			</tr>
			<tr>
				<td>002</td>
				<td>TeleConferência</td>
				<td>Bloco 12 Espaço 2 Sala 2</td>
				<td>Oficina</td>
				<td>28/08/19</td>
				<td>15h00</td>
				<td>Ninguém</td>
			</tr>
		</tbody>
	</table>


</body>
</html>