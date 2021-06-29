<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
    <style>
        body{
            text-align: center;
            padding: 2% 0;
        }
    </style>
</head>
<body >
<form action="/display-discount" method="post">
    <h3 style="font-weight: bold">Product Discount Calculator</h3>
    <h4>
        Product Description:
        <input type="text" name="product_decription" style="margin-left: 1%">
    </h4>
    <h4>
        List Price:
        <input type="text" name="list_price" style="margin-left: 6.3%">
    </h4>
    <h4>
        Discount Percent:
        <input type="text" name="discount" style="margin-left: 2.6%">
    </h4>
    <input type="submit" value="Calculate Discount" style="background-color: cornflowerblue;margin-top: 2%;margin-left: 7%"
           class="submit">

</form>
</body>
</html>
