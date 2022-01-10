<%-- 
    Document   : lista
    Created on : 15-nov-2021, 17:36:47
    Author     : Cristian
--%>

<%@page import="modelo.Destinos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de destinos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <style>
            table,th,tr,td{
                border: 2px solid black;
                text-align: center;
            }
            table tr th{
                background-color: yellow;
            }
        </style>
    </head>
    <body>
        <h1>Listado de Destinos</h1>
        <a href="Controlador?op=insertar" class="btn btn-primary">Nuevo Destino</a>
        <% 
            List<Destinos> listaDestinos = ( List<Destinos> ) request.getAttribute("listado");
            String mensaje = ( String ) request.getAttribute("mensaje");
        %>
        <h3><%=mensaje%></h3>
        <table class="table table-striped table-dark">
            <tr>
                <th>Nº</th>
                <th>Lugar</th>
                <th>Zona</th>
                <th colspan="2">Accion</th>
            </tr>
            <% for (Destinos d: listaDestinos) { %>
            <tr>
                <td><%= d.getId() %></td>
                <td><%= d.getLugar() %></td>
                <td><%= d.getZona() %></td>
                <td><a href="Controlador?op=actualizar&id=<%=d.getId() %>" class="btn btn-light">Actualizar</a></td>
                <td><a href="Controlador?op=borrar&id=<%=d.getId() %>" onclick="return Confirmacion()" class="btn btn-light">Borrar</a></td>
            </tr>
            <%}%>
        </table>
        <a href="index.html" class="btn btn-primary">Volver a inicio</a>
        <script type="text/javascript">
            function Confirmacion() {
                if(confirm("¿Está seguro de que quiere eliminar el producto?")){
                    alert("El producto se eliminará");
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </body>
</html>