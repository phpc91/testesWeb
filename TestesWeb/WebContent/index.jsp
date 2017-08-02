<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<style>
#buscar {
	font-weight: bold;
}
</style>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.blue-indigo.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<meta charset="UTF-8">
<title>TestesWeb</title>
</head>
<body>
	<div id="form" style="text-align:center">
		<h1>Home</h1>
		<form method="post" action="${pageContext.request.contextPath}/busca" accept-charset="UTF-8">
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" id="nome" name="nome">
				<label class="mdl-textfield__label" for="nome">Nome Completo</label>
			</div><br>
			<input type="submit" class="bold mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised" value="Buscar" id="buscar">
		</form>
	</div>
</body>
</html>