<%-- 
    Document   : listaAdopcion
    Created on : 6/03/2022, 09:49:10 AM
    Author     : DAVID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Adopciones</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <table class="formularios table">
                    <a href="addAdopcion.htm" class="btn btn-outline-primary" style="float: left; margin: 20px">Añadir</a>
                    <thead>
                      <tr>
                        <th scope="col">ID</th>
                        <th scope="col">ID USUARIO</th>
                        <th scope="col">ID MASCOTA</th>
                        <th scope="col">FECHA DE ADOPCION</th>
                        <th scope="col">OPCIONES</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${adopcion}" var="adopcion">    
                      <tr>
                        <td><c:out value="${adopcion.id}"></c:out></td>
                        <td><c:out value="${adopcion.nombrep}"></c:out>   <img width="50px" height="50px" src="<c:url value="${adopcion.fotoOld}"></c:url>"/></td>
                        <td><c:out value="${adopcion.nombre}"></c:out>  <img width="50px" height="50px" src="<c:url value="${adopcion.foto}"></c:url>"/></td>
                        <td><c:out value="${adopcion.fecha_de_adopcion}"></c:out></td>
                        <td><a href="updateAdopcion.htm?id=${adopcion.id}" class="btn btn-outline-warning">Modificar</a>  <a href="borrarAdopcion.htm?id=${adopcion.id}" class="btn btn-outline-danger">Eliminar</a></td>
                      </tr>
                        </c:forEach>
                    </tbody>
                </table>
                      <a class="btn btn-outline-secondary" href="index.htm">Regresar</a>
            </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
