<%-- 
    Document   : Clientes
    Created on : May 24, 2019, 12:42:30 PM
    Author     : danvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers</title>
    </head>
    <body>
        <header>
            <nav>
                <a href="home">Inicio</a>
                <a href="insertar">Agregar Cliente</a>
                <a href="sigout">Salir</a>
            </nav>
        </header>
        <main>
            <h2>Lista Clientes</h2>
            <table border="1" cellpadding="3">
                <tr>
                    <th>Id</th>
                    <th>N.I.T</th>
                    <th>Cliente</th>
                </tr>
                    <c:forEach items="${listaClientes}" var="cliente">
                        <tr>
                            <td>${cliente.getIdCliente()}</td>
                            <td>${cliente.getNombreCliente()}</td>
                            <td>${cliente.getNitCliente()}</td>       
                        </tr>
                        <tr>
                        </tr>
                        
                    </c:forEach>      
            </table>
        </main>      
    </body>
</html>
