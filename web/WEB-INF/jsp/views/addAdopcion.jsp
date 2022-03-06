<%-- 
    Document   : addAdopcion
    Created on : 6/03/2022, 10:48:23 AM
    Author     : DAVID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añadir Adopcion</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <form:form commandName="adopcion">
                    <div class="mb-3" style="background: whitesmoke;padding: 20px;">
                        <div class="mb-3 row">
                        <form:label path="id_usuario" cssClass="col-sm-2 col-form-label">Datos Adoptante:</form:label>
                            <div class="col-sm-10">
                            <form:select path="id_usuario" cssClass="form-control" placeholder="ingrese su nombre">
                                <c:forEach var="dato" items="${listaUsuarios}">
                                    <form:option value="${dato.id}"> ${dato.id} - ${dato.nombrep} - ${dato.apellidop} - ${dato.telefonop} - ${dato.edadp} - ${dato.correop} - ${dato.direccionp} - ${dato.ciudadp}</form:option>
                                </c:forEach>
                            </form:select>
                            <form:errors path='id_usuario' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="id_mascota" cssClass="col-sm-2 col-form-label">Datos de la Mascota:</form:label>
                            <div class="col-sm-10">
                            <form:select path="id_mascota" cssClass="form-control" placeholder="ingrese su apellido">
                                <c:forEach var="dato" items="${listaMascotas}">
                                    <form:option value="${dato.id}"> ${dato.id} - ${dato.categoria} - ${dato.raza} - ${dato.edad} - ${dato.genero} - ${dato.descripcion}</form:option>
                                </c:forEach>
                            </form:select>
                            <form:errors path='id_mascota' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <br>
                        <form:button name="ingresar" class="btn btn-outline-secondary">Ingresar</form:button>
                        <a class="btn btn-outline-secondary" href="listaAdopcion.htm">Regresar</a>
                    </div>
                </form:form>    
            </div>
        </main>
        <%@include file="footer.jsp" %>
    </body>
</html>
