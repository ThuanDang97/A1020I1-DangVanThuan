<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>View Product</h1>
<a href="/?action=create">Create Product</a>
<form>
    <p>
        Find Product by Name:
        <input type="hidden" name="action" value="find">
        <input type="text" name="keyword" placeholder="input name product" width="50px" >
        <input type="submit" value="Find" >
    </p>
</form>
<table border="1" style="text-align: center">
    <tr>
        <th>ID</th>
        <th>Name Product</th>
        <th>Price Product</th>
        <th>Description Product</th>
        <th>Producer</th>
        <th>Action</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><a href="/?action=info&id=${product.getId()}"><c:out value="${product.nameProduct}"/></a></td>
            </td>
            <td><c:out value="${product.priceProduct}"/></td>
            <td><c:out value="${product.descriptionProduct}"/></td>
            <td><c:out value="${product.producer}"/></td>
            <td>
                <a href="/?action=update&id=${product.getId()}">Edit | </a>
                <a href="/?action=delete&id=${product.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
