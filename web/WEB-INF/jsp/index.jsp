<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adoptame</title>
    </head>

    <body style="background: #d1d1d1">
        
        <%@include file="views/header.jsp" %>
        
        <main>
            <div class="container-lg">
                <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner" style="border-radius: 10px">
                        <div class="carousel-item active">
                            <img src="<c:url value="./public/images/1_image.jpg"/>" class="d-block w-100" alt="..." height="500px">
                        </div>
                        <div class="carousel-item">
                            <img src="<c:url value="./public/images/2_image.jpg"/>" class="d-block w-100" alt="..." height="500px">
                        </div>
                        <div class="carousel-item">
                            <img src="<c:url value="./public/images/3_image.jpg"/>" class="d-block w-100" alt="..." height="500px">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                       <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                       <span class="visually-hidden">Next</span>
                    </button>
                </div>
                <div style=" display: flex">
                    <div style="width: 60% ;">
                        <br>
                    <h3 style="margin-left: 30px">¿Quiénes Somos?</h3>
                    <br>
                    <p>ADÓPTAME es una fundación sin ánimo de lucro creada en febrero de 2015 por una pareja de voluntarios con amplia experiencia en el rescate y adopción animal que deciden unir sus fuerzas, entusiasmo y pasión para luchar por los más indefensos y realizar una labor por un bien social. Damos en adopción perritos y gatitos rescatados en situación de calle, abandonados, atropellados, maltratados, moribundos, etcétera, a los que se les cura, rehabilita, esteriliza, desparasita y vacuna para darlos en adopción responsable.</p>
                    <br>
                    <p>Buscamos familias que los acepten y respeten como a un miembro más. Promovemos la esterilización de todas las mascotas para evitar la sobreproblación, sufrimiento y muerte de tanto indefenso en la calle.</p>
                    <br>
                    <p>Un gran parte de nuestros peques están en nuestras casas en hogar temporal y, otros tantos, en un pequeño albergue. Contamos con un total de 5 hogares temporales fijos repartidos entre la Ciudad de Bogota. De esta manera podemos dar atención especializada y única a nuestros rescatados. Nos reunimos en el Parque nacional, en el norte, un sábado cada 15 días, sobre la autopista norte, frente al movistar arena de 12 p.m. a 4 p.m. ¡Llevamos una carpa blanca y camisetas con nuestro logotipo! Visita nuestro calendario de eventos.</p>
                    </div>
                    <div style="width: 40%; padding: 20px">
                    <img src="<c:url value="./public/images/4_image.jpg"/>" class="d-block w-100" alt="..." >
                    </div>
                </div>
                
            </div>
        </main>
        <%@include file="views/footer.jsp" %>
    </body>
</html>
