<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View List Customer</title>
    <style>

    </style>
</head>
<body>
<h2> Danh Sách Khách Hàng </h2>
<table border="1">
    <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh</th>
    </tr>

    <c:forEach var="customer" items="${customerListServlet}" varStatus="stt">
        <tr>
            <td>${stt.index + 1}</td>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.dayOfBirth}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td><img src="${customer.image}" style="width: 50px; height: 50px"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
