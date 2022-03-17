<%-- 
    Document   : addPersonas
    Created on : 28/02/2022, 08:41:45 AM
    Author     : SENA
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añadir Personas</title>
    </head>
    <body>
                <%@include file="header.jsp" %>
        <main>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <form:form commandName="persona" enctype="multipart/form-data" method="post">
                    <div class="mb-3" style="background: whitesmoke;padding: 20px;">
                        <div class="mb-3 row">
                        <form:label path="nombrep" cssClass="col-sm-2 col-form-label">Nombre:</form:label>
                            <div class="col-sm-10">
                            <form:input path="nombrep" cssClass="form-control" placeholder="ingrese su nombre"></form:input>
                            <form:errors path='nombrep' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="apellidop" cssClass="col-sm-2 col-form-label">Apellido:</form:label>
                            <div class="col-sm-10">
                            <form:input path="apellidop" cssClass="form-control" placeholder="ingrese su apellido"></form:input>
                            <form:errors path='apellidop' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="telefonop" cssClass="col-sm-2 col-form-label">Telefono:</form:label>
                            <div class="col-sm-10">
                            <form:input path="telefonop" cssClass="form-control" placeholder="ingrese su telefono"></form:input>
                            <form:errors path='telefonop' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="correop" cssClass="col-sm-2 col-form-label">Correo:</form:label>
                            <div class="col-sm-10">
                            <form:input path="correop" cssClass="form-control" placeholder="ingrese su correo"></form:input>
                            <form:errors path='correop' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="edadp" cssClass="col-sm-2 col-form-label">Edad:</form:label>
                            <div class="col-sm-10">
                        <form:input path="edadp" cssClass="form-control" placeholder="ingrese su edad"></form:input>
                        <form:errors path='edadp' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="direccionp" cssClass="col-sm-2 col-form-label">Direccion:</form:label>
                            <div class="col-sm-10">
                        <form:input path="direccionp" cssClass="form-control" placeholder="ingrese su direccion"></form:input>
                        <form:errors path='direccionp' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="ciudadp" cssClass="col-sm-2 col-form-label">Ciudad:</form:label>
                            <div class="col-sm-10">
                        <form:input path="ciudadp" cssClass="form-control" placeholder="ingrese su ciudad"></form:input>
                        <form:errors path='ciudadp' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="generop" cssClass="col-sm-2 col-form-label">Genero:</form:label>
                            <div class="col-sm-10">
                            <form:input path="generop" cssClass="form-control" placeholder="ingrese su genero"></form:input>
                            <form:errors path='generop' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                            <div class="mb-3 row">
                        <form:label path="foto" cssClass="col-sm-2 col-form-label">Foto:</form:label>
                            <div class="col-sm-10">
                            <form:input path="foto" cssClass="form-control" placeholder="ingrese el genero de la Mascota" type="file"></form:input>
                            </div>
                        </div>
                        <br>
                        <form:button name="ingresar" class="btn btn-outline-secondary">Ingresar</form:button>
                        <a class="btn btn-outline-secondary" href="listaPersonas.htm">Regresar</a>
                    </div>
                </form:form>    
            </div>
        </main>
        <%@include file="footer.jsp" %>

    </body>
</html>
