<%-- 
    Document   : vistaConsultaPersonaId
    Created on : 7/03/2022, 02:59:17 PM
    Author     : DAVID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Persona</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <table  class="formularios table">
                    <thead>
                      <tr>
                        <th scope="col">ID</th>
                        <th scope="col">NOMBRE</th>
                        <th scope="col">APELLIDO</th>
                        <th scope="col">TELEFONO</th>
                        <th scope="col">CORREO</th>
                        <th scope="col">EDAD</th>
                        <th scope="col">DIRECCION</th>
                        <th scope="col">CIUDAD</th>
                        <th scope="col">GENERO</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${persona}" var="persona">    
                      <tr>
                        <td><c:out value="${persona.id}"></c:out></td>
                        <td><c:out value="${persona.nombrep}"></c:out></td>
                        <td><c:out value="${persona.apellidop}"></c:out></td>
                        <td><c:out value="${persona.telefonop}"></c:out></td>
                        <td><c:out value="${persona.correop}" ></c:out></td>
                        <td><c:out value="${persona.edadp}" ></c:out></td>
                        <td><c:out value="${persona.direccionp}"></c:out></td>
                        <td><c:out value="${persona.ciudadp}" ></c:out></td>
                        <td><c:out value="${persona.generop}" ></c:out></td>
                      </tr>
                        </c:forEach>
                    </tbody>
                </table>
                      <a class="btn btn-outline-secondary" href="index.htm">Regresar</a>
            </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
