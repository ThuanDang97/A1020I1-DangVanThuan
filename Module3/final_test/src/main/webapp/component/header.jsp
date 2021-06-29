<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="../bootstrap/css/style.css">
    <script src="../bootstrap/js/bootstrap.js"></script>
    <script src="../bootstrap/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row col-12 bg-info">
        <div class="col-2 col-md-2 col-xl-2 col-sm-2 col-lg-2">
            <img src="../img/logo.jpg" alt="logo" class="logo img-fluid">
        </div>
        <div class="col-8 col-md-8 col-xl-8 col-sm-8 col-lg-8" style="padding: 0">
        </div>
        <div class="col-2 col-md-2 col-xl-2 col-sm-2 col-lg-2 text-center text-white" style="padding: 0">
            <p class="mt-3">Đặng Văn Thuận</p>
            <a href="#" style="color: white">15i1dangvanthuan@gmail.com</a>
        </div>
    </div>
</div>
<div class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto" style="margin-left: 30%">
                <li id="nav-menu-item-2197"
                    class="nav-item  menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page">
                    <a href="/" class="nav-link main-menu-link active">Home</a></li>
                <li id="nav-menu-item-1445"
                    class="nav-item  menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page">
                    <a href="#" class="nav-link main-menu-link">Employee</a></li>
                <li id="nav-menu-item-1519"
                    class="nav-item  menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page">
                    <a href="customer" class="nav-link main-menu-link">Customer</a></li>
                <li id="nav-menu-item-1564"
                    class="nav-item  menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page">
                    <a href="#" class="nav-link main-menu-link">Service</a></li>
                <li id="nav-menu-item-1855"
                    class="nav-item  menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page">
                    <a href="#" class="nav-link main-menu-link">Contract</a></li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input type="hidden" name="action" value="search">
                <input class="form-control mr-sm-2" name="name" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

</div>
</body>
</html>
