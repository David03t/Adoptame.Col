<%-- 
    Document   : consultarAdopcionFecha
    Created on : 10/03/2022, 09:13:08 AM
    Author     : DAVID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <%@include file="header.jsp" %>
        <main>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <form:form commandName="adopcion">
                    <div class="mb-3" style="background: whitesmoke;padding: 20px;">
                        <div class="mb-3 row">
                        <form:label path="fecha_de_adopcion" cssClass="col-sm-2 col-form-label">Fecha de Adopcion:</form:label>
                            <div class="col-sm-10">
                            <form:input path="fecha_de_adopcion" cssClass="form-control" placeholder="ingrese la fecha de adopcion"></form:input>
                            <form:errors path='fecha_de_adopcion' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
                            </div>
                        </div>
                        <br>
                        <form:button name="ingresar" class="btn btn-outline-secondary">Ingresar</form:button>
                        <a class="btn btn-outline-secondary" href="index.htm">Regresar</a>
                    </div>
                </form:form>    
            </div>
        </main>
        <%@include file="footer.jsp" %>
    </body>
</html>
