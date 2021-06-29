<%--
  Created by IntelliJ IDEA.
  User: duytr
  Date: 5/10/2021
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/?action=create">Create Product</a>
<h1>Product management</h1>
<table border="solid 1px">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
    <tr>
        <td><c:out value="${product.id}"/></td>
        <td><c:out value="${product.name}"/></td>
        <td><c:out value="${product.price}"/></td>
        <td>
            <a href="?action=delete&id=<c:out value='${product.id}'/>">Delete |</a>
            <a href="#">Edit</a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
