<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
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
		<form id="escolha" method="post" action="${pageContext.request.contextPath}/treinamentos" style="text-align:center">
			<% //logica para obter todos os funcionarios serializados e passá-los ao próximo servlet 
			for (int i=0; i<(int)request.getAttribute("numero_funcionarios"); i++) {
				String nome = "obj_funcionario"+(i+1);
				String obj = (String) request.getAttribute(nome); %>
				<input type="hidden" name="<%= nome %>" value='<%= obj %>'>
			<% } %>
			<div class="wrapper">
				<ul class="list-control mdl-list">
				<%	String[] nomesFunc = (String[]) request.getAttribute("nomes_funcionarios");	%>
				<%	Integer[] idsFunc = (Integer[]) request.getAttribute("ids_funcionarios"); %>
				<%	String[] cargosFunc = (String[]) request.getAttribute("cargos_funcionarios"); %>
				<%	for (int i = 0; i < nomesFunc.length; i++) { %>
					<li class="mdl-list__item mdl-list__item--two-line">
						<span class="mdl-list__item-primary-content"> 
							<i class="material-icons  mdl-list__item-avatar">person</i>
							<span><%= nomesFunc[i] %></span>
							<span class="mdl-list__item-sub-title"><%= cargosFunc[i] %></span>
						</span> 
						<span class="mdl-list__item-secondary-action"> 
							<label class="list-radio mdl-radio mdl-js-radio mdl-js-ripple-effect" for="func<%= i %>"> 
								<input type="radio"	id="func<%= i %>" class="mdl-radio__button" name="id_funcionario" value="<%= idsFunc[i] %>">
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