<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Furama Resort Danang</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="bootstrap/css/style.css">
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="bootstrap/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container-fluid bg-light">
    <div>
        <jsp:include page="component/header.jsp"/>
    </div>
    <div>
        <div id="furama" class="carousel slide" data-ride="carousel">

            <!-- Indicators -->
            <ul class="carousel-indicators">
                <li data-target="#furama" data-slide-to="0" class="active"></li>
                <li data-target="#furama" data-slide-to="1"></li>
                <li data-target="#furama" data-slide-to="2"></li>
                <li data-target="#furama" data-slide-to="3"></li>
            </ul>

            <!-- The slideshow -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="img/furama-1.jpg" alt="furama 1" class="mx-auto d-block">
                </div>
                <div class="carousel-item">
                    <img src="img/furama-2.jpg" alt="furama 2" class="mx-auto d-block">
                </div>
                <div class="carousel-item">
                    <img src="img/furama-3.jpg" alt="furama 3" class="mx-auto d-block">
                </div>
                <div class="carousel-item">
                    <img src="img/furama-4.jpg" alt="furama 4" class="mx-auto d-block">
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="carousel-control-prev" href="#furama" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#furama" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>

        </div>
    </div>
    <div>
        <jsp:include page="component/footer.jsp"/>
    </div>
</div>

<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>
