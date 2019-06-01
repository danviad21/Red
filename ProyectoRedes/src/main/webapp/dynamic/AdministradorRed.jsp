<%-- 
    Document   : AdministradorRed
    Created on : May 24, 2019, 8:16:04 PM
    Author     : danvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador de Red</title>
    </head>
    <body>
        <h1>Administrador de Red</h1>
        <table border="1" cellpadding="3">
            <tr>
                <th>Id</th>
                <th>Nombre Red</th>
                <th>IP Red</th>
                <th>Mascara Subred</th>
                <th>Administrador</th>
            </tr>
            <c:forEach items="${listaRedes}" var="red">
                <tr>
                    <td>${red.getIdRed()}</td>
                    <td>${red.getNombreRed()}</td>
                    <td>${red.getIpRed()}</td>
                    <td>${red.isEsRedAdmin()}</td>
                </tr>
            </c:forEach>  
        </table>
    </body>
</html>
