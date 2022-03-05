<%-- 
    Document   : vistaMascotas
    Created on : 14/02/2022, 03:25:17 PM
    Author     : DAVID
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista Madscotas</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <table class="table">
                    <thead>
                      <tr>
                        <th scope="col">NOMBRE</th>
                        <th scope="col">CATEGORIA</th>
                        <th scope="col">RAZA</th>
                        <th scope="col">EDAD</th>
                        <th scope="col">DESCRIPCION</th>
                        <th scope="col">GENERO</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td><c:out value="${nombre}"></c:out></td>
                        <td><c:out value="${categoria}"></c:out></td>
                        <td><c:out value="${raza}"></c:out></td>
                        <td><c:out value="${edad}"></c:out></td>
                        <td><c:out value="${descripcion}"></c:out></td>
                        <td><c:out value="${genero}"></c:out></td>
                      </tr>
                    </tbody>
                </table>
                      <a class="btn btn-outline-secondary" href="mascotas.htm">Regresar</a>
            </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
