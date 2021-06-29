<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Service - Furama Resort Danang</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="../bootstrap/css/style.css">

</head>
<body>
<div class="container-fluid">
    <div>
        <jsp:include page="../component/header.jsp"/>
    </div>
    <div class="row col-12 col-md-12 col-xl-12 col-lg-12 col-sm-12">
        <div class="col-3 col-md-3 col-xl-3 col-lg-3 col-sm-3 text-center bg-info min-vh-100">
            <div class="cn mt-5 mt-xl-5 mt-md-5 mt-sm-5 mt-lg-5">
                <a href="/service?action=list">
                    Show All Service
                </a>
            </div>
            <div class="cn">
                <a href="/service?action=create">
                    Create Service
                </a>
            </div>
            <div class="cn">
                <a href="/service?action=edit" >
                    Edit Service
                </a>
            </div>
            <div class="cn">
                <a href="/service?action=delete">
                    Delete Service
                </a>
            </div>
        </div>
        <div class="col-9 col-md-9 col-xl-9 col-lg-9 col-sm-9">

        </div>
    </div>
    <div>
        <jsp:include page="../component/footer.jsp"/>
    </div>
</div>

<script src="../bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="../bootstrap/js/bootstrap.js"></script>
</body>
</html>
