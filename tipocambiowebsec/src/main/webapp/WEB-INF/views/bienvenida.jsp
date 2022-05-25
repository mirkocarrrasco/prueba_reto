<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Bienvenida</title>
    </head>
    <body>
        <h1><%= request.getAttribute("mensaje") %></h1>
        
        <a href="cursoListar">Mantenimiento de cursos</a>
    </body>
</html>
