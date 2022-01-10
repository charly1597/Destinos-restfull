<%-- 
    Document   : actualizar
    Created on : 22-nov-2021, 17:42:59
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${mensaje}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <% 
            String mensaje = ( String ) request.getAttribute("mensaje");
            String operacion = ( String ) request.getAttribute("operacion");
        %>
        <h1><%=mensaje%></h1>
        <h1>${mensaje2}</h1>
        <form action="Controlador">
            <input type="hidden" value="<%=operacion%>" name="op">
            <p>ID: <input type="text" value="${destino.id}" name="id" placeholder="Autonumérico" readonly></p>
            <p>Zona: <input type="text" value="${destino.zona}" name="zona"></p>
            <p>Lugar: <input type="text" value="${destino.lugar}" name="lugar"></p>
            <input type="submit" value="<%=mensaje%>">
        </form>
        <br>
        <a href="Controlador?op=listar" class="btn btn-primary">Volver</a>
    </body>
</html>
