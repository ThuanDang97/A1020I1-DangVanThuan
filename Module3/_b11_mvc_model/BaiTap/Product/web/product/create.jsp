<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<h1>Create Product</h1>
<a href="/">Back to home product</a>
<form action="/?action=create" method="post">
    <p>ID: <input type="text" name="id" id="id"></p>
    <p>Name Product: <input type="text" name="nameProduct" id="nameProduct"></p>
    <p>Price: <input type="text" name="priceProduct" id="priceProduct"></p>
    <p>Description Product: <input type="text" name="descriptionProduct" id="descriptionProduct"></p>
    <p>Producer: <input type="text" name="producer" id="producer"></p>
    <input type="submit" value="Create Product">
</form>
</body>
</html>
