<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<h1>Update Product</h1>
<a href="/">Back to home product</a>
<form method="post">
    <p>Name Product: <input type="text" name="nameProduct" value="${product.nameProduct}"></p>
    <p>Price: <input type="text" name="priceProduct" value="${product.priceProduct}"></p>
    <p>Description Product: <input type="text" name="descriptionProduct"
                                   value="${product.descriptionProduct}"></p>
    <p>Producer: <input type="text" name="producer" value="${product.producer}"></p>
    <input type="submit" value="Update Product">
</form>
</body>
</html>
