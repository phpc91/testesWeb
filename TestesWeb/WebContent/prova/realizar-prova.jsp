<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<style>
h1{
	text-align: center;
}
h5{
	margin-top: 0px;
	margin-bottom: 10px;
}
#questionario{
	text-align:center;
}
.border{
	border-bottom: 1px solid black;
}/*
#questoes{
	margin-left: 0px;
	margin-right: 0px;
}
#respostas{
	margin-left: 0px;
	margin-right: 0px;
}*/
</style>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.blue-indigo.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<meta charset="UTF-8">
<title>TestesWeb</title>
</head>
<% Integer idProva = (Integer) request.getAttribute("id_prova"); %>
<body>
	<h1>Prova Tipo <%= idProva %></h1>
	<form id="questionario" action="${pageContext.request.contextPath}/" method="post">
		<div id="prova" class="mdl-grid">
			<% String[] questoes = (String[]) request.getAttribute("questoes"); %>
			<% for(int i=0; i < questoes.length; i++) { %>
				<div id="questoes" class="mdl-cell mdl-cell--6-col border">
				<h5 style="margin-top:0px; margin-bottom:7px;"><strong>Questão <%= i+1 %>:</strong></h5>
				<h6 style="margin-top:0px; margin-bottom:6px;"><%= questoes[i] %></h6></div>
				<div id="respostas" class="mdl-cell mdl-cell--6-col border">
					<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="resposta<%= i %>V" style="margin-top:15px;margin-right:10px">
						<input type="radio" id="resposta<%= i %>V" class="mdl-radio__button" name="respostas<%= i %>" value=true>
						<span class="mdl-radio__label">Verdadeiro&emsp;</span>
					</label>
					<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="resposta<%= i %>F" style="margin-top:15px;">
						<input type="radio" id="resposta<%= i %>F" class="mdl-radio__button" name="respostas<%= i %>" value=false>
						<span class="mdl-radio__label">Falso</span>
					</label>
				</div>
			<% } %>
		</div>
		<input type="submit" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised" value="Enviar Respostas">
	</form>
</body>
</html>