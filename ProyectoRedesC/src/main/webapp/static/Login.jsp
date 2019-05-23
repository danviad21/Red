<%-- 
    Document   : Login
    Created on : May 21, 2019, 8:46:23 PM
    Author     : danvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form name="Login" action="LoginServlet" method="POST">
            <label for="user-name">Nombre de Usuario</label>
            <input name ="user-name">
            <label for="user-pass">Password</label>
            <input name="user-pass">
            <input type="submit" value="enviar">
        </form>
    </body>
</html>
