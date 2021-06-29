<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Customer - Furama Resort Danang</title>
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
        <div class="col-12 col-md-12 col-xl-12 col-lg-12 col-sm-12">
            <center>
                <form class="needs-validation" method="post" novalidate>
                    <div class="mt-5 mt-lg-5 mt-sm-5 mt-md-5 mt-xl-5">
                        <h1>UPDATE CUSTOMER</h1>
                    </div>
                    <c:if test="${customer != null}">
                        <input type="hidden" name="id" value="<c:out value='${customer.customerId}' />"/>
                    </c:if>
                    <div class="form-row mt-5 mt-lg-5 mt-sm-5 mt-md-5 mt-xl-5">
                        <div class="col-md-4 mb-3">
                            <label for="validationCustom01">Customer Name</label>
                            <input type="text" class="form-control" id="validationCustom01" placeholder="Customer name"
                                   name="name" value="${customer.customerName}" required>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationCustomEmail">Email</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend">@</span>
                                </div>
                                <input type="text" class="form-control" id="validationCustomEmail"
                                       placeholder="Email" aria-describedby="inputGroupPrepend" name="email"
                                       value="${customer.customerEmail}" required>
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <div class="form-group">
                                <label for="validationCustomtype">Customer Type</label>
                                <select class="custom-select" id="validationCustomtype" name="customerType" required>
                                    <option value="<c:out value="${customer.customerType}"/>">
                                        <c:choose>
                                            <c:when test="${customer.customerType == '1'}">Diamond</c:when>
                                            <c:when test="${customer.customerType == '2'}">Platinum</c:when>
                                            <c:when test="${customer.customerType == '3'}">Gold</c:when>
                                            <c:when test="${customer.customerType == '4'}">Silver</c:when>
                                            <c:when test="${customer.customerType == '5'}">Member</c:when>
                                        </c:choose>
                                    </option>
                                    <option value="1">Diamond</option>
                                    <option value="2">Platinum</option>
                                    <option value="3">Gold</option>
                                    <option value="4">Silver</option>
                                    <option value="5">Member</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-row mt-5 mt-lg-5 mt-sm-5 mt-md-5 mt-xl-5">
                        <div class="col-md-3 mb-3">
                            <label for="validationCustom03">Birthday</label>
                            <div class="md-form md-outline input-with-post-icon datepicker" id="accLabels">
                                <input placeholder="Select date" type="date" id="validationCustom03"
                                       class="form-control" name="dayOfBirth" value="${customer.customerBirthday}">
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <div class="form-group">
                                <label for="validationCustom04">Gender</label>
                                <select class="custom-select" id="validationCustom04" name="gender" required>
                                    <option value="${customer.customerGender}">
                                        <c:choose>
                                            <c:when test="${customer.customerGender == 'false'}">
                                                Male
                                            </c:when>
                                            <c:when test="${customer.customerGender == 'true'}">
                                                Female
                                            </c:when>
                                        </c:choose></option>
                                    <option value="false">Male</option>
                                    <option value="true">Female</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="validationCustom05">Phone Number</label>
                            <input type="text" class="form-control" id="validationCustom05" placeholder="Phone Number"
                                   name="phoneNumber" value="${customer.customerPhone}" required>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="validationCustom06">ID Card</label>
                            <input type="text" class="form-control" id="validationCustom06" placeholder="ID Card"
                                   name="idCard" value="${customer.customerIdCard}" required>
                        </div>
                    </div>
                    <div class="form-row mt-5 mt-lg-5 mt-sm-5 mt-md-5 mt-xl-5">
                        <div class="col-md-12 mb-5">
                            <label for="validationCustom07">Address</label>
                            <input type="text" class="form-control" id="validationCustom07" placeholder="Address"
                                   name="address" value="${customer.customerAddress}" required>
                            <div class="invalid-feedback">
                                Please provide a valid address.
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#exampleModal"
                            onclick="customerSetName('${customer.customerName}')" style="margin-left: 80%">
                        Update Customer
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Update Customer</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <input type="text" id="cusName" size="50" disabled
                                           style="border: none;background: white;">
                                </div>
                                <div class="modal-footer">
                                    <button type="reset" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Update</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </center>
        </div>
    </div>
    <div>
        <jsp:include page="../component/footer.jsp"/>
    </div>
</div>

<script src="../bootstrap/js/bootstrap.js"></script>
<script src="../bootstrap/js/jquery-3.6.0.min.js"></script>
<script>
    function customerSetName(name) {
        document.getElementById("cusName").value = "Do you want update customer : " + name;
    }
</script>
</body>
</html>
