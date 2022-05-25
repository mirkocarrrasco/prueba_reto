<%@page import="com.bcp.tipocambio.dto.TipoCambioDTO"%>
<%@page import="com.bcp.tipocambio.dto.MonedaDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Mantenimiento de Tipo de Cambio</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<h1>Mantenimiento de Tipo de Cambio</h1>
	<br/>
	<% if (request.getAttribute("lista") != null) {	%>
		<div class="table-responsive">
			<table class="table table-responsive table-sm table-light table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>idtipocambio</th>
						<th>idmonedaorig</th>
						<th>idmonedadest</th>
						<th>conversion</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<TipoCambioDTO> lista = (List<TipoCambioDTO>) request.getAttribute("lista");
						for (TipoCambioDTO tipoCambioDTO : lista) {
					%>
						<tr>
							<td><%= tipoCambioDTO.getIdtipocambio() %></td>
							<td><%= tipoCambioDTO.getMonedaorig().getNommoneda() %></td>
							<td><%= tipoCambioDTO.getMonedadest().getNommoneda() %></td>
							<td><%= tipoCambioDTO.getConversion() %></td>
							<td>
								<a href="tipoCambioEliminar?codigo=<%= tipoCambioDTO.getIdtipocambio() %>">SI</a>
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
				<h1>Datos del tipo de cambio a ingresar</h1>
				<form action="tipoCambioGrabar" method="post">		
					
					
					<div class="form-group">
						Moneda Origen: 
						<select name="monedaorig" class="form-control text-box"	placeholder="Nombre Moneda Origen" required="true">
							<% List<MonedaDTO> listaMoneOrig = (List<MonedaDTO>) request.getAttribute("listaMonedaOrig");
										for(MonedaDTO monedaDTOOrig : listaMoneOrig) {
								%>			
									<option value="<%= monedaDTOOrig.getIdmoneda()%>"><%= monedaDTOOrig.getNommoneda()%></option>
								<%}%>
						</select>
					</div>
					<div class="form-group">
						Moneda Destino: 
						<select name="monedadest" class="form-control text-box"	placeholder="Nombre Moneda Destino" required="true">
							<% List<MonedaDTO> listaMoneDest = (List<MonedaDTO>) request.getAttribute("listaMonedaDest");
										for(MonedaDTO monedaDTODest : listaMoneDest) {
								%>			
									<option value="<%= monedaDTODest.getIdmoneda()%>"><%= monedaDTODest.getNommoneda()%></option>
								<%}%>
						</select>
					</div>
										
					<div class="form-group">
						<input type="text" name="conversion" class="form-control text-box"
							placeholder="Conversion" required="true" />
					</div>
					<input type="submit" value="Grabar"
						class="btn btn-primary button-submit" /> <a href="tipoCambioListar"
						class="btn btn-primary button-submit">Cancelar</a>
				</form>

			</div>
		</div>
	</div>


</body>
</html>