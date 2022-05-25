<%@page import="com.bcp.tipocambio.dto.TipoCambioDTO"%>
<%@page import="com.bcp.tipocambio.dto.MonedaDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Sistema de Cambio</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<h1>Sistema de Cambio</h1>
	<br/>	

	<div class="container">
		<div class="row d-flex justify-content-center mx-auto">
			<br />
			<div class="login-form">
				<h1>Datos del cambio a ingresar</h1>
				<form action="realizarCalculo" method="post">	
					
					
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
						Monto Origen:
						<input type="text" name="montoorig" class="form-control text-box" placeholder="Monto Origen" required="true" />
					</div>
					
					<input type="submit" value="Calcular" class="btn btn-primary button-submit" />
					
					<br>
					<hr>
					
					
				</form>

			</div>
		</div>
	</div>


</body>
</html>