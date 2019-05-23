<%-- 
    Document   : Cliente
    Created on : May 21, 2019, 9:21:32 PM
    Author     : danvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogo Clientes</title>
        <%--<script type="text/javascript" src="../../static/js/jquery-3.4.1.min.js"></script>--%>
       <%-- <script type="text/javascript" src="../../static/js/load_content2.js"></script>--%>    
    </head>
    <body>
        <header>
            <h1>Gestion Clientes</h1>
            <nav>
            <a href="../home.jsp">Principal</a>
            <a href="../index.jsp">Logout</a>
            </nav>
        </header>
        <aside>
            <nav>
                <a href="new">Agregar Cliente</a>
                <a>Modificar Cliente</a>
                <a>Consultar Un Cliente</a>
                <a>Consultar Todos los Clientes</a>
           </nav>
        </aside>
        <main>
            <div>
                <h2>Agregar Cliente</h2>
                <form id="AgregarCliente" method="POST">
                    <div class="field_grouping">
                        <label for="nom-cliente">Nombre:</label>
                            <input name="ncliente" id="nom-cliente">
                            <label for="nit-cliente">N.I.T.:</label>
                            <input name="nitC" id="nit-cliente">
                            <label for="dire-cliente">Direccion:</label>
                            <input name="dirCliente" id="dire-cliente">
                    </div>
                    <div class="buttons-group">
                        <input class=".btn" type ="submit" value="Guardar">
                        <input class=".btn" type ="button" value="Cancelar">
                    </div>
                </form>
            </div>
        </main> 
    </body>
</html>
