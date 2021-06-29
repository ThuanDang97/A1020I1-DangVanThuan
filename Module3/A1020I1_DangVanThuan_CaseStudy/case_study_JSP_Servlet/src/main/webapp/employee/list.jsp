<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show List Employee - Furama Resort Danang</title>
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
        <div class="col-3 col-md-3 col-xl-3 col-lg-3 col-sm-3 text-center bg-info min-vh-100">
            <div class="cn mt-5 mt-xl-5 mt-md-5 mt-sm-5 mt-lg-5">
                <a href="/employee?action=list">
                    Show All Employee
                </a>
            </div>
            <div class="cn">
                <a href="/employee?action=create">
                    Create Employee
                </a>
            </div>
            <div class="cn">
                <a href="/employee?action=edit">
                    Edit Employee
                </a>
            </div>
            <div class="cn">
                <a href="/employee?action=delete">
                    Delete Employee
                </a>
            </div>
        </div>
        <div class="col-9 col-md-9 col-xl-9 col-lg-9 col-sm-9" style="padding: 1% 0">
            <center>
                <h1>LIST EMPLOYEE</h1>
            </center>
            <table id="tableEmployee" class="table table-striped table-bordered mt-5" style="width: 100%">
                <thead align="center">
                <tr>
                    <th>ID Employee</th>
                    <th>Name Employee</th>
                    <th>Birthday</th>
                    <th>Id Card</th>
                    <th>Salary</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Position</th>
                    <th>Education Degree</th>
                    <th>Division</th>
                </tr>
                </thead>
                <tbody align="center">
                <c:forEach var="employee" items="${employeeList}">
                    <tr>
                        <td><c:out value="${employee.employeeId}"/></td>
                        <td><c:out value="${employee.employeeName}"/></td>
                        <td><c:out value="${employee.employeeBirthday}"/></td>
                        <td><c:out value="${employee.employeeIdCard}"/></td>
                        <td><c:out value="${employee.employeeSalary}"/></td>
                        <td><c:out value="${employee.employeePhone}"/></td>
                        <td><c:out value="${employee.employeeEmail}"/></td>
                        <td><c:out value="${employee.employeeAddress}"/></td>
                        <td><c:out value="${employee.positionName}"/></td>
                        <td><c:out value="${employee.educationDegreeName}"/></td>
                        <td><c:out value="${employee.divisionName}"/></td>
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
        $('#tableEmployee').DataTable(
            {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            }
        );
    });
</script>
</body>
</html>
