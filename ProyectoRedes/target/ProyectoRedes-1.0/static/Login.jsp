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
            <form id="Login" action="LoginServlet" method="POST">
                <div>
                    <label for="user-name">Usuario:</label>
                    <input id="user-name" name="name" type="text" placeholder="Nombre de Usuario" required>
                </div>
            </form>
    </body>
</html>
