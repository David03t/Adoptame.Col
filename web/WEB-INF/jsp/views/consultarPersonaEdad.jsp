<%-- 
    Document   : consultarPersonaEdad
    Created on : 9/03/2022, 07:44:33 PM
    Author     : DAVID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Persona Edad</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            <div class="container-lg" style="background: white;padding: 20px; border-radius: 30px">
                <form:form commandName="persona">
                    <div class="mb-3" style="background: whitesmoke;padding: 20px;">
                        <div class="mb-3 row">
                        <form:label path="edadp" cssClass="col-sm-2 col-form-label">Edad:</form:label>
                            <div class="col-sm-10">
                            <form:input path="edadp" cssClass="form-control" placeholder="ingrese su Edad"></form:input>
                            <form:errors path='edadp' element="div" cssStyle="color: red; font-size : 10px; text-align: center"/>
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
