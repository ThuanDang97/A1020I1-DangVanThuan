<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Info Product</title>
</head>
<body>
<h1>View Info Product</h1>
<table border="1" style="text-align: center">
    <tr>
        <th>ID:</th>
        <td><c:out value="${product.id}"/></td>
    </tr>
    <tr>
        <th>Name:</th>
        <td><c:out value="${product.nameProduct}"/></td>
    </tr>
    <tr>
        <th>Price:</th>
        <td><c:out value="${product.priceProduct}"/></td>
    </tr>
    <tr>
        <th>Description:</th>
        <td><c:out value="${product.descriptionProduct}"/></td>
    </tr>
    <tr>
        <th>Producer:</th>
        <td><c:out value="${product.producer}"/></td>
    </tr>
</table>
<a href="/">Back to home product</a>
</body>
</html>
