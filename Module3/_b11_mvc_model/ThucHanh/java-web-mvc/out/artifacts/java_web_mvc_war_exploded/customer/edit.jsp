<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>
<h1>Edit Customer</h1>
    <p>
        <c:if test='${requestScope["msg"] != null}'>
            <span class="message">${requestScope["msg"]}</span>
        </c:if>
    </p>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<form method="post">
    <table border="1">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" id="name" value="${requestScope["customer"].getName()}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" id="email" value="${requestScope["customer"].getEmail()}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" id="address" value="${requestScope["customer"].getAddress()}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="update customer"></td>
        </tr>
    </table>
</form>

</body>
</html>
