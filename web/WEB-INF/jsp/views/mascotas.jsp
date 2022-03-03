<%-- 
    Document   : mascotas
    Created on : 14/02/2022, 03:25:28 PM
    Author     : DAVID
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mascotas</title>
    </head>

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
                        <a class="btn btn-outline-secondary" href="index.htm">Regresar</a>
                        <a class="btn btn-outline-secondary" href="listaMascotas.htm">Listar</a>
                    </div>
                </form:form>    
            </div>
        </main>
        <%@include file="footer.jsp" %>

</html>
