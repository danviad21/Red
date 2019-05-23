<%-- 
    Document   : LoginExitoso
    Created on : May 22, 2019, 10:29:03 PM
    Author     : danvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
    </head>
    <body>
        <h1>Bienvendio</h1>
        <div>
            <p>Usuario: $(userName)</p>
            <p>Direccion IP: $(ipAddress)</p>
            <p>Mascara de Subred: $(netMask)</p>
            <input type="button" value="Ok">
        </div>
    </body>
</html>
