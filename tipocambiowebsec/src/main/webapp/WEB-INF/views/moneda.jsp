<%@page import="com.bcp.tipocambio.dto.MonedaDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Mantenimiento de monedas</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<h1>Mantenimiento de Monedas</h1>
	<br/>
	<% if (request.getAttribute("lista") != null) {	%>
		<div class="table-responsive">
			<table class="table table-responsive table-sm table-light table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Código</th>
						<th>Nombre</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<MonedaDTO> lista = (List<MonedaDTO>) request.getAttribute("lista");
						for (MonedaDTO monedaDTO : lista) {
					%>
						<tr>
							<td><%= monedaDTO.getIdmoneda() %></td>
							<td><%= monedaDTO.getNommoneda() %></td>
							<td>
								<a href="monedaEliminar?codigo=<%= monedaDTO.getIdmoneda() %>">SI</a>
							</td>
						</tr>
					<% } %>
				</tbody>
			</table>
		</div>
	<% } %>
	<br />
	<hr />

	<div class="container">
		<div class="row d-flex justify-content-center mx-auto">
			<br />
			<div class="login-form">
				<h1>Datos de la moneda a ingresar</h1>
				<form action="monedaGrabar" method="post">
					<div class="form-group">
						<input type="text" name="nommoneda" class="form-control text-box"
							placeholder="Nombre Moneda" required="true" />
					</div>
					
					<input type="submit" value="Grabar"
						class="btn btn-primary button-submit" /> <a href="monedaListar"
						class="btn btn-primary button-submit">Cancelar</a>
				</form>

			</div>
		</div>
	</div>


</body>
</html>