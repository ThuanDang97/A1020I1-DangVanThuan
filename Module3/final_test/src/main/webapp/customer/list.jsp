<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List - Furama Resort Danang</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../bootstrap/css/style.css">
    <link rel="stylesheet" href="../bootstrap/datatables/css/dataTables.bootstrap4.min.css">

</head>
<body>
<div class="container-fluid">
    <div>
        <jsp:include page="../component/header.jsp"/>
    </div>
    <div class="row col-12 col-md-12 col-xl-12 col-lg-12 col-sm-12">
        <div class="container-fluid align-content-center">
            <center>
                <h1>LIST CUSTOMER</h1>
                <a class="btn btn-primary" href="/customer?action=create" style="margin-left: 88%;">Create Customer</a>
            </center>
            <table id="tableCustomer" class="table table-striped table-bordered mt-5" style="width: 100%">
                <thead align="center">
                <tr>
                    <th>ID Customer</th>
                    <th>Type Customer</th>
                    <th>Name Customer</th>
                    <th>Birthday</th>
                    <th>Gender</th>
                    <th>Id Card</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody align="center">
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <td><c:out value="${customer.customerId}"/></td>
                        <td><c:out value="${customer.customerTypeName}"/></td>
                        <td><c:out value="${customer.customerName}"/></td>
                        <td><c:out value="${customer.customerBirthday}"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${customer.customerGender == 'false'}">
                                    Male
                                </c:when>
                                <c:when test="${customer.customerGender == 'true'}">
                                    Female
                                </c:when>
                            </c:choose>
                        </td>

                        <td><c:out value="${customer.customerIdCard}"/></td>
                        <td><c:out value="${customer.customerPhone}"/></td>
                        <td><c:out value="${customer.customerEmail}"/></td>
                        <td><c:out value="${customer.customerAddress}"/></td>
                        <td><a class="btn btn-outline-primary" href="/customer?action=edit&id=${customer.customerId}">Edit</a>
                            <form>
                                <a class="btn btn-outline-danger" type="button" data-toggle="modal"
                                   data-target="#exampleModal"
                                   onclick="customerSetName('${customer.customerName}','${customer.customerId}')">Delete</a>
                                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Delete Customer</h5>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <input type="text" id="cusName" size="50" disabled
                                                       style="border: none;background: white;">
                                            </div>
                                            <div class="modal-footer">
                                                <button type="reset" class="btn btn-secondary" data-dismiss="modal">
                                                    Close
                                                </button>
                                                <input type="hidden" name="action" value="delete">
                                                <input type="hidden" name="id" id="cusID">
                                                <button type="submit" class="btn btn-primary">Delete</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div>
        <jsp:include page="../component/footer.jsp"/>
    </div>
</div>
<script src="../bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="../bootstrap/js/bootstrap.js"></script>
<script src="../bootstrap/datatables/js/jquery.dataTables.min.js"></script>
<script src="../bootstrap/datatables/js/dataTables.bootstrap4.min.js"></script>

<script>
    $(document).ready(function () {
        $('#tableCustomer').DataTable(
            {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            }
        );
    });
</script>
<script>
    function customerSetName(name, id) {
        document.getElementById("cusName").value = "Do you want delete customer : " + name;
        document.getElementById("cusID").value = id;
    }
</script>
</body>
</html>
