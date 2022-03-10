<%-- 
    Document   : vistaConsultaAdopcion
    Created on : 10/03/2022, 08:26:06 AM
    Author     : DAVID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Adopcion</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <table class="formularios table">
                    <thead>
                      <tr>
                        <th scope="col">ID</th>
                        <th scope="col">ID USUARIO</th>
                        <th scope="col">ID MASCOTA</th>
                        <th scope="col">FECHA DE ADOPCION</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${adopcion}" var="adopcion">    
                      <tr>
                        <td><c:out value="${adopcion.id}"></c:out></td>
                        <td><c:out value="${adopcion.nombrep}"></c:out></td>
                        <td><c:out value="${adopcion.nombre}"></c:out></td>
                        <td><c:out value="${adopcion.fecha_de_adopcion}"></c:out></td>
                      </tr>
                        </c:forEach>
                    </tbody>
                </table>
                      <a class="btn btn-outline-secondary" href="index.htm">Regresar</a>
            </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
