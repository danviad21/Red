<%-- 
    Document   : Login
    Created on : May 23, 2019, 1:11:07 AM
    Author     : danvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>Login</div>
            <form id="Login" action="verifyUserServlet" method="POST">
                <div>
                    <label for="user-name">Usuario:</label>
                    <input id="user-name" name="name" type="text" placeholder="Nombre de Usuario" required>
                    <label for="user-name">Usuario:</label>
                    <input id="pass-name" name="pass" type="text" placeholder="Contraseña de Usuario" required>
                </div>
                <div>
                    <input type="submit" value="Agregar">
                    <input type="button" value="Cancelar">
                </div>
            </form>
    </body>
</html>
