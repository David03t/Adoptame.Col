<%-- 
    Document   : vistaConsultaMascota
    Created on : 9/03/2022, 08:36:00 PM
    Author     : DAVID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Mascota</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <table class="formularios table">
                    <thead>
                      <tr>
                        <th scope="col">ID</th>
                        <th scope="col">NOMBRE</th>
                        <th scope="col">CATEGORIA</th>
                        <th scope="col">RAZA</th>
                        <th scope="col">EDAD</th>
                        <th scope="col">DESCRIPCION</th>
                        <th scope="col">GENERO</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${mascotas}" var="mascotas">    
                      <tr>
                        <td><c:out value="${mascotas.id}"></c:out></td>
                        <td><c:out value="${mascotas.nombre}"></c:out></td>
                        <td><c:out value="${mascotas.categoria}"></c:out></td>
                        <td><c:out value="${mascotas.raza}"></c:out></td>
                        <td><c:out value="${mascotas.edad}" ></c:out></td>
                        <td><c:out value="${mascotas.descripcion}" ></c:out></td>
                        <td><c:out value="${mascotas.genero}"></c:out></td>
                      </tr>
                        </c:forEach>
                    </tbody>
                </table>
                      <a class="btn btn-outline-secondary" href="index.htm">Regresar</a>
            </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
