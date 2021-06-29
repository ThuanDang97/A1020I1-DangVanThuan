<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tòa nhà phức hợp TComplex ở Thành phố Đà Nẵng</title>
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
                <h1 class="mt-5 mt-md-5 mt-xl-5 mt-lg-5">DANH SÁCH MẶT BẰNG</h1>
                <a class="btn btn-primary" href="/matbang?action=create" style="margin-left: 88%;">Tạo Mặt Bằng</a>
            </center>
            <table id="tablematbang" class="table table-striped table-bordered mt-5" style="width: 100%">
                <thead align="center">
                <tr>
                    <th>Mã Mặt Bằng</th>
                    <th>Trạng Thái</th>
                    <th>Diện Tích</th>
                    <th>Tầng</th>
                    <th>Loại Mặt Bằng</th>
                    <th>Giá Tiền</th>
                    <th>Ngày Bắt Đầu</th>
                    <th>Ngày Kết Thúc</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody align="center">
                <c:forEach var="matbang" items="${matBangList}">
                    <tr>
                        <td><c:out value="${matbang.ma_mat_bang}"/></td>
                        <td><c:out value="${matbang.ten_trang_thai}"/></td>
                        <td><c:out value="${matbang.dien_tich}"/></td>
                        <td><c:out value="${matbang.tang}"/></td>
                        <td><c:out value="${matbang.ten_loai_mat_bang}"/></td>
                        <td><c:out value="${matbang.gia_tien}"/></td>
                        <td><c:out value="${matbang.ngay_bat_dau}"/></td>
                        <td><c:out value="${matbang.ngay_ket_thuc}"/></td>
                        <td><a class="btn btn-outline-primary" href="/matbang?action=edit&id=${matbang.id_mat_bang}">Edit</a>
                        </td>
                        <td>
                            <form>
                                <a class="btn btn-outline-danger" type="button" data-toggle="modal"
                                   data-target="#exampleModal"
                                   onclick="matBangSetName('${matbang.ten_loai_mat_bang}','${matbang.id_mat_bang}')">Delete</a>
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
                                                <input type="text" id="name" size="50" disabled
                                                       style="border: none;background: white;">
                                            </div>
                                            <div class="modal-footer">
                                                <button type="reset" class="btn btn-secondary" data-dismiss="modal">
                                                    Close
                                                </button>
                                                <input type="hidden" name="action" value="delete">
                                                <input type="hidden" name="id" id="id">
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
</div>
<script src="../bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="../bootstrap/js/bootstrap.js"></script>
<script src="../bootstrap/datatables/js/jquery.dataTables.min.js"></script>
<script src="../bootstrap/datatables/js/dataTables.bootstrap4.min.js"></script>

<script>
    $(document).ready(function () {
        $('#tablematbang').DataTable(
            {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            }
        );
    });
</script>
<script>
    function matBangSetName(name, id) {
        document.getElementById("name").value = "Bạn muốn xóa mặt bằng : " + name + " ?";
        document.getElementById("id").value = id;
    }
</script>
</body>
</html>
