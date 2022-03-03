<%-- 
    Document   : vistaPersonas
    Created on : 14/02/2022, 03:24:53 PM
    Author     : DAVID
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista Personas</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <table class="table">
                    <thead>
                      <tr>
                        <th scope="col">NOMBRE</th>
                        <th scope="col">APELLIDO</th>
                        <th scope="col">TELEFONO</th>
                        <th scope="col">CORREO</th>
                        <th scope="col">EDAD</th>
                        <th scope="col">DIRECCION</th>
                        <th scope="col">CIUDAD</th>
                        <th scope="col">GENERO...</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td><c:out value="${nombrep}"></c:out></td>
                        <td><c:out value="${apellidop}"></c:out></td>
                        <td><c:out value="${telefonop}"></c:out></td>
                        <td><c:out value="${correop}" ></c:out></td>
                        <td><c:out value="${edadp}" ></c:out></td>
                        <td><c:out value="${direccionp}"></c:out></td>
                        <td><c:out value="${ciudadp}" ></c:out></td>
                        <td><c:out value="${generop}" ></c:out></td>
                      </tr>
                    </tbody>
                </table>
                      <a class="btn btn-outline-secondary" href="personas.htm">Regresar</a>
            </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
