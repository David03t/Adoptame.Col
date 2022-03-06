<%-- 
    Document   : adopcion
    Created on : 14/02/2022, 03:25:56 PM
    Author     : DAVID
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adopcion</title>
    </head>

        <%@include file="header.jsp" %>
        <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
            <form:form commandName="adopcion">
                    <div class="mb-3" style="background: whitesmoke;padding: 20px;">
                        <div class="mb-3 row">
                        <form:label path="id_usuario" cssClass="col-sm-2 col-form-label">Nombre:</form:label>
                            <div class="col-sm-10">
                            <form:input path="id_usuario" cssClass="form-control" placeholder="ingrese el id_usuario"></form:input>
                            <form:errors path='id_usuario' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="id_mascota" cssClass="col-sm-2 col-form-label">Apellido:</form:label>
                            <div class="col-sm-10">
                            <form:input path="id_mascota" cssClass="form-control" placeholder="ingrese el id_mascota"></form:input>
                            <form:errors path='id_mascota' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <br>
                        <form:button name="ingresar" class="btn btn-outline-secondary">Ingresar</form:button>
                        <a class="btn btn-outline-secondary" href="index.htm">Regresar</a>
                        <a class="btn btn-outline-secondary" href="listaAdopcion.htm">Listar</a>
                    </div>
                </form:form>    
            </div>
        <%@include file="footer.jsp" %>

</html>
