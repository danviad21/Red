<%-- 
    Document   : NuevoCliente
    Created on : May 24, 2019, 7:09:22 PM
    Author     : danvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Cliente</title>
    </head>
    <body>
        <form action="./UsuariosServlet" name="form1" id="form1" method="post">      
            <label for="nom-cliente">Nombre:</label>
            <input name="ncliente" id="nom-cliente">
            <label for="nit-cliente">N.I.T.:</label>
            <input name="nitC" id="nit-cliente">
            <label for="dire-cliente">Direccion:</label>
            <input name="dirCliente" id="dire-cliente">
            <input type="hidden" value="Usuario" id="pageOperation" name="pageOperation" />
            <input type="submit"  value="Crear usuario"  id="evento_nuevo" name="evento_nuevo" />
            <input type="submit" value="Eliminar usuario" id="evento_eliminar" name="evento_eliminar" />
            <input type="submit" value="Cancelar" id="evento_cancelar"  name="evento_cancelar" />
        </form>
    </body>
</html>
