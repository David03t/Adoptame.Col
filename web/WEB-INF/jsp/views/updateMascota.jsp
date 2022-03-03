<%-- 
    Document   : updateMascotas
    Created on : 3/03/2022, 10:53:19 AM
    Author     : DAVID
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Mascotas</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
       <main>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <form:form commandName="mascotas">
                    <div class="mb-3" style="background: whitesmoke;padding: 20px;">
                        <div class="mb-3 row">
                        <form:label path="nombre" cssClass="col-sm-2 col-form-label">Nombre:</form:label>
                            <div class="col-sm-10">
                            <form:input path="nombre" cssClass="form-control" placeholder="ingrese el nombre de la Mascota"></form:input>
                            <form:errors path='nombre' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="categoria" cssClass="col-sm-2 col-form-label">Categoria:</form:label>
                            <div class="col-sm-10">
                            <form:input path="categoria" cssClass="form-control" placeholder="ingrese la categoria de la Mascota"></form:input>
                            <form:errors path='categoria' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="raza" cssClass="col-sm-2 col-form-label">Raza:</form:label>
                            <div class="col-sm-10">
                            <form:input path="raza" cssClass="form-control" placeholder="ingrese la raza de la Mascota"></form:input>
                            <form:errors path='raza' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="edad" cssClass="col-sm-2 col-form-label">Edad:</form:label>
                            <div class="col-sm-10">
                            <form:input path="edad" cssClass="form-control" placeholder="ingrese la edad de la Mascota"></form:input>
                            <form:errors path='edad' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="descripcion" cssClass="col-sm-2 col-form-label">Descripcion:</form:label>
                            <div class="col-sm-10">
                            <form:input path="descripcion" cssClass="form-control" placeholder="ingrese la descripcion de la Mascota"></form:input>
                            <form:errors path='descripcion' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                        <form:label path="genero" cssClass="col-sm-2 col-form-label">Genero:</form:label>
                            <div class="col-sm-10">
                            <form:input path="genero" cssClass="form-control" placeholder="ingrese el genero de la Mascota"></form:input>
                            <form:errors path='genero' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <br>
                        <form:button name="ingresar" class="btn btn-outline-secondary">Ingresar</form:button>
                        <a class="btn btn-outline-secondary" href="listaMascotas.htm">Regresar</a>
                    </div>
                </form:form>    
            </div>
        </main>
        <%@include file="footer.jsp" %>
    </body>
</html>
