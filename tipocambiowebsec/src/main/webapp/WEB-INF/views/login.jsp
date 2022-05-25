<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <style type="text/css">
            .login-form {
                width: 340px;
                margin: 50px auto;
            }
            .login-form form {
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .btn {        
                font-size: 15px;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <h1>Login de la aplicación</h1>
        <div class="login-form">

            <form method="post" action="Login">
                <h2 class="text-center">Log in</h2>
                <div class="form-group">
                    <input type="text" name="usuario" required="true" class="form-control" placeholder="Username"/>
                </div>
                <div class="form-group">
                    <input type="password" name="clave" required="true" class="form-control" placeholder="Password"/> <br/>
                </div>
                <div class="form-group">
                    <input type="submit" value="Ingresar" class="btn btn-primary btn-block"/>
                </div>
            </form>
        </div>
        <% if (request.getAttribute("error")!= null ) { %>
        <h2 style="color:red"><%= request.getAttribute("error") %></h2>
        <% } %>
    </body>
</html>
