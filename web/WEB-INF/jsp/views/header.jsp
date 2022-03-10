<%-- 
    Document   : header
    Created on : 14/02/2022, 10:50:18 AM
    Author     : DAVID
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="models.daoBean"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"></link>
        <link href="https://cdn.datatables.net/1.11.4/css/dataTables.bootstrap4.min.css"></link>
        <script>
            $(document).ready(function() {
                $('.formularios').DataTable({
                    "lengthMenu": [[5, 10, 20, 50 , -1],[5,10,20,50,"All"]]
                });
            } );
            </script>
    </head>
    <body style="background: #d1d1d1">
        <header style="position: fixed; top: 0 ; width: 100%; z-index: 2">
            <nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #e3f2fd;">
                <div class="container-fluid">
                    <a class="navbar-brand" href="index.htm">Adoptame</a>
                    <a class="navbar-brand" href="#">Acceder</a>
                    <%
                        if(daoBean.conecta()!=null){
                    %>
                    <p class="navbar-brand" style="margin-top: 15px">DB:<img src="<c:url value="public/images/true.png"/>" height="20px" width="20px"/></p> 
                    <%
                        }else{
                    %>
                   <p class="navbar-brand" style="margin-top: 15px">DB:<img src="<c:url value="public/images/false.png"/>" height="20px" width="30px"/></p> 
                    <%}%>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item dropdown" style="display: flex">
                                <a class="nav-link" style="padding-right: 0px" href="personas.htm">Personas</a><a style="padding-left: 0px"class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-bs-toggle="dropdown">:</a>
                                 
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <li><a class="dropdown-item" href="consultarPersonaId.htm">Consultar Personas ID</a></li>
                                    <li><a class="dropdown-item" href="consultarPersonaNombre.htm">Consultar Personas Nombre</a></li>
                                    <li><a class="dropdown-item" href="consultarPersonaApellido.htm">Consultar Personas Apellido</a></li>
                                    <li><a class="dropdown-item" href="consultarPersonaTelefono.htm">Consultar Personas Telefono</a></li>
                                    <li><a class="dropdown-item" href="consultarPersonaCorreo.htm">Consultar Personas Correo</a></li>
                                    <li><a class="dropdown-item" href="consultarPersonaEdad.htm">Consultar Personas Edad</a></li>
                                    <li><a class="dropdown-item" href="consultarPersonaDireccion.htm">Consultar Personas Direccion</a></li>
                                    <li><a class="dropdown-item" href="consultarPersonaCiudad.htm">Consultar Personas Ciudad</a></li>
                                    <li><a class="dropdown-item" href="consultarPersonaGenero.htm">Consultar Personas Genero</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown" style="display: flex">
                                <a class="nav-link" style="padding-right: 0px" href="mascotas.htm">Mascotas</a><a style="padding-left: 0px"class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-bs-toggle="dropdown">:</a>
                                 
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <li><a class="dropdown-item" href="consultarMascotaId.htm">Consultar Mascotas ID</a></li>
                                    <li><a class="dropdown-item" href="consultarMascotaNombre.htm">Consultar Mascotas Nombre</a></li>
                                    <li><a class="dropdown-item" href="consultarMascotaCategoria.htm">Consultar Mascotas Categoria</a></li>
                                    <li><a class="dropdown-item" href="consultarMascotaRaza.htm">Consultar Mascotas Raza</a></li>
                                    <li><a class="dropdown-item" href="consultarMascotaEdad.htm">Consultar Mascotas Edad</a></li>
                                    <li><a class="dropdown-item" href="consultarMascotaDescripcion.htm">Consultar Mascotas Descripcion</a></li>
                                    <li><a class="dropdown-item" href="consultarMascotaGenero.htm">Consultar Mascotas Genero</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown" style="display: flex">
                                <a class="nav-link" style="padding-right: 0px"  href="adopcion.htm">Adopciones</a><a style="padding-left: 0px"class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-bs-toggle="dropdown">:</a>
                                 
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <li><a class="dropdown-item" href="consultarAdopcionId.htm">Consultar Adopcion ID</a></li>
                                    <li><a class="dropdown-item" href="consultarAdopcionFecha.htm">Consultar Adopcion Fecha de Adopcion</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <br>
        <br>
        <br>
        <br>
    
</html>
