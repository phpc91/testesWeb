<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<style>
.list-control {
	width: 300px;
	text-align: left;
}

.list-radio {
	display: inline;
}

.wrapper {
	text-align: center;
}

.wrapper ul {
	display: inline-block;
	/* For IE, the outcast */
	zoom: 1;
	*display: inline;
}

.wrapper li {
	padding: 2px 5px;
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
	<div id="resultado" class="">
		<form id="escolha" method="post" action="${pageContext.request.contextPath}/prova" style="text-align:center">
		<% String objFuncionario = (String) request.getAttribute("obj_funcionario"); %>
			<input type="hidden" name="funcionario" value='<%= objFuncionario %>'>
			<div class="wrapper">
				<ul class="list-control mdl-list">
				<%	String[] nomesTreinamentos = (String[]) request.getAttribute("nomes_treinamentos");	%>
				<%	Integer[] idsTreinamentos = (Integer[]) request.getAttribute("ids_treinamentos"); %>
				<%	for (int i = 0; i < nomesTreinamentos.length; i++) { %>
					<li class="mdl-list__item">
						<span class="mdl-list__item-primary-content"> 
							<i class="material-icons  mdl-list__item-avatar">school</i>
							<span><%= nomesTreinamentos[i] %></span>
						</span> 
						<span class="mdl-list__item-secondary-action"> 
							<label class="list-radio mdl-radio mdl-js-radio mdl-js-ripple-effect" for="treino<%= i %>"> 
								<input type="radio"	id="treino<%= i %>" class="mdl-radio__button" name="id_treinamento" value="<%= idsTreinamentos[i] %>">
							</label>
						</span>
					</li>
				<%	} %>
				</ul>
			</div>
			<input type="submit" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised" value="Próximo">
		</form>
	</div>
</body>
</html>