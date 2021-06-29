<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Employee - Furama Resort Danang</title>
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
        <div class="col-9 col-md-9 col-xl-9 col-lg-9 col-sm-9">
            <center>
                <form class="needs-validation" method="post" novalidate>
                    <div class="mt-5 mt-lg-5 mt-sm-5 mt-md-5 mt-xl-5">
                        <h1>UPDATE EMPLOYEE</h1>
                    </div>
                    <div class="form-row mt-5 mt-lg-5 mt-sm-5 mt-md-5 mt-xl-5">
                        <div class="col-md-4 mb-3">
                            <label>Employee Name</label>
                            <input type="text" class="form-control" placeholder="Employee name"
                                   name="name" value="${employee.employeeName}" required>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label>Email</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend">@</span>
                                </div>
                                <input type="text" class="form-control" placeholder="Email"
                                       aria-describedby="inputGroupPrepend" name="email" value="${employee.employeeEmail}" required>
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <div class="form-group">
                                <label>Position</label>
                                <select class="custom-select" name="position" required>
                                    <option value="<c:out value="${employee.positionId}"/>">
                                        <c:choose>
                                            <c:when test="${employee.positionId == '1'}">Lễ Tân</c:when>
                                            <c:when test="${employee.positionId == '2'}">Phục Vụ</c:when>
                                            <c:when test="${employee.positionId == '3'}">Chuyên Viên</c:when>
                                            <c:when test="${employee.positionId == '4'}">Giám Sát</c:when>
                                            <c:when test="${employee.positionId == '4'}">Quản Lý</c:when>
                                            <c:when test="${employee.positionId == '4'}">Giám Đốc</c:when>
                                        </c:choose>
                                    </option>
                                    <option value="1">Lễ Tân</option>
                                    <option value="2">Phục Vụ</option>
                                    <option value="3">Chuyên Viên</option>
                                    <option value="4">Giám Sát</option>
                                    <option value="5">Quản Lý</option>
                                    <option value="6">Giám Đốc</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-row mt-5 mt-lg-5 mt-sm-5 mt-md-5 mt-xl-5">
                        <div class="col-md-3 mb-3">
                            <label>Birthday</label>
                            <div class="md-form md-outline input-with-post-icon datepicker" id="accLabels">
                                <input placeholder="Select date" type="date" class="form-control" name="dayOfBirth"
                                value="${employee.employeeBirthday}">
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <div class="form-group">
                                <label>Education Degree</label>
                                <select class="custom-select" name="education" required>
                                    <option value="<c:out value="${employee.educationDegreeName}"/>">
                                        <c:choose>
                                            <c:when test="${employee.educationDegreeId == '1'}">Trung Cấp</c:when>
                                            <c:when test="${employee.educationDegreeId == '2'}">Cao Đẳng</c:when>
                                            <c:when test="${employee.educationDegreeId == '3'}">Đại Học</c:when>
                                            <c:when test="${employee.educationDegreeId == '4'}">Sau Đại Học</c:when>
                                        </c:choose>
                                    </option>
                                    <option value="1">Trung Cấp</option>
                                    <option value="2">Cao Đẳng</option>
                                    <option value="3">Đại Học</option>
                                    <option value="4">Sau Đại Học</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="validationCustom05">Phone Number</label>
                            <input type="text" class="form-control" id="validationCustom05" placeholder="Phone Number"
                                   name="phoneNumber" value="${employee.employeePhone}" required>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label>ID Card</label>
                            <input type="text" class="form-control" placeholder="ID Card"
                                   name="idCard" value="${employee.employeeIdCard}" required>
                        </div>
                    </div>
                    <div class="form-row mt-5 mt-lg-5 mt-sm-5 mt-md-5 mt-xl-5">
                        <div class="col-md-4 mb-3">
                            <label>Address</label>
                            <input type="text" class="form-control" placeholder="Address"
                                   name="address" value="${employee.employeeAddress}" required>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label>Salary</label>
                            <input type="text" class="form-control" placeholder="Salary"
                                   name="salary" value="${employee.employeeSalary}" required>
                        </div>
                        <div class="col-md-4 mb-3">
                            <div class="form-group">
                                <label>Division</label>
                                <select class="custom-select" name="division" required>
                                    <option value="<c:out value="${employee.divisionName}"/>">
                                        <c:choose>
                                            <c:when test="${employee.divisionId == '1'}">Sale – Marketing</c:when>
                                            <c:when test="${employee.divisionId == '2'}">Hành Chính</c:when>
                                            <c:when test="${employee.divisionId == '3'}">Phục Vụ</c:when>
                                            <c:when test="${employee.divisionId == '4'}">Quản Lý</c:when>
                                        </c:choose>
                                    </option>
                                    <option value="1">Sale – Marketing</option>
                                    <option value="2">Hành Chính</option>
                                    <option value="3">Phục Vụ</option>
                                    <option value="4">Quản Lý</option>
                                </select>
                            </div>
                        </div>

                    </div>
                    <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#exampleModal"
                            onclick="employeeSetName('${employee.employeeName}')" style="margin-left: 80%">
                        Update Employee
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Update Employee</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <input type="text" id="empName" size="50" disabled
                                           style="border: none;background: white;">
                                </div>
                                <div class="modal-footer">
                                    <button type="reset" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save</button>
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

<script src="../bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="../bootstrap/js/bootstrap.js"></script>
<script>
    function employeeSetName(name) {
        document.getElementById("empName").value = "Do you want update employee : " + name;
    }
</script>
</body>
</html>
