<%-- 
    Document   : listaPersonas
    Created on : 24/02/2022, 08:11:26 AM
    Author     : SENA
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Personas</title>
        
    </head>
    <body>
        <%@include file="header.jsp" %>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <table  class="formularios table">
                    <a href="addPersonas.htm" class="btn btn-outline-primary" style="float: left; margin: 20px">Añadir</a>
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
                        <th scope="col">FOTO</th>
                        <th scope="col">OPCIONES</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${usuarios}" var="usuarios">    
                      <tr>
                        <td><c:out value="${usuarios.id}"></c:out></td>
                        <td><c:out value="${usuarios.nombrep}"></c:out></td>
                        <td><c:out value="${usuarios.apellidop}"></c:out></td>
                        <td><c:out value="${usuarios.telefonop}"></c:out></td>
                        <td><c:out value="${usuarios.correop}" ></c:out></td>
                        <td><c:out value="${usuarios.edadp}" ></c:out></td>
                        <td><c:out value="${usuarios.direccionp}"></c:out></td>
                        <td><c:out value="${usuarios.ciudadp}" ></c:out></td>
                        <td><c:out value="${usuarios.generop}" ></c:out></td>
                         <td><img width="50px" height="50px" src="<c:url value="${usuarios.foto}"></c:url>"/></td>
                        <td><a href="updatePersona.htm?id=${usuarios.id}&fotoOld=${usuarios.foto}" class="btn btn-outline-warning">Modificar</a>  <a href="borrarPersona.htm?id=${usuarios.id}&foto=${usuarios.foto}" class="btn btn-outline-danger">Eliminar</a></td>
                      </tr>
                        </c:forEach>
                    </tbody>
                </table>
                      <a class="btn btn-outline-secondary" href="personas.htm">Regresar</a>
            </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
