<%-- 
    Document   : vistaAdopcion
    Created on : 20/02/2022, 05:53:34 PM
    Author     : DAVID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista Adopcion</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <table class="table">
                    <thead>
                      <tr>
                        <th scope="col">ID USUARIO</th>
                        <th scope="col">ID MASCOTA</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td><c:out value="${id_usuario}"></c:out></td>
                        <td><c:out value="${id_mascota}"></c:out></td>
                      </tr>
                    </tbody>
                </table>
                      <a class="btn btn-outline-secondary" href="adopcion.htm">Regresar</a>
            </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
