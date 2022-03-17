<%-- 
    Document   : listaMascotas
    Created on : 24/02/2022, 08:11:54 AM
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Mascotas</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <table class="formularios table">
                    <a href="addMascotas.htm" class="btn btn-outline-primary" style="float: left; margin: 20px">Añadir</a>
                    <thead>
                      <tr>
                        <th scope="col">ID</th>
                        <th scope="col">NOMBRE</th>
                        <th scope="col">CATEGORIA</th>
                        <th scope="col">RAZA</th>
                        <th scope="col">EDAD</th>
                        <th scope="col">DESCRIPCION</th>
                        <th scope="col">GENERO</th>
                        <th scope="col">FOTO</th>
                        <th scope="col">OPCIONES</th>
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
                        <td><img width="50px" height="50px" src="<c:url value="${mascotas.foto}"></c:url>"/></td>
                        <td><a  href="updateMascota.htm?id=${mascotas.id}&foto=${mascotas.foto}" class="btn btn-outline-warning">Modificar</a>  <a href="borrarMascota.htm?id=${mascotas.id}" class="btn btn-outline-danger">Eliminar</a></td>
                      </tr>
                        </c:forEach>
                    </tbody>
                </table>
                      <a class="btn btn-outline-secondary" href="mascotas.htm">Regresar</a>
            </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
