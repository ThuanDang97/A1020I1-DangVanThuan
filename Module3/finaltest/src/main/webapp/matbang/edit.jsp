<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tòa nhà phức hợp TComplex ở Thành phố Đà Nẵng</title>
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
                        <h1>TẠO MẶT BẰNG</h1>
                    </div>
                    <div class="form-row mt-5 mt-lg-5 mt-sm-5 mt-md-5 mt-xl-5">
                        <div class="col-md-4 mb-3">
                            <label for="validationCustom01">Mã Mặt Bằng</label>
                            <input type="text" class="form-control" id="validationCustom01" placeholder="Mã mặt bằng"
                                   name="mamb" required>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label>Diện Tích</label>
                            <div class="input-group">
                                <input type="text" class="form-control"
                                       placeholder="Diện Tích" aria-describedby="inputGroupPrepend" name="dientich"
                                       required>
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <div class="form-group">
                                <label for="validationCustomtype">Trạng Thái</label>
                                <select class="custom-select" id="validationCustomtype" name="trangthai" required>
                                    <option value="">Chọn một trạng thái</option>
                                    <option value="1">Trống</option>
                                    <option value="2">Hạ Tầng</option>
                                    <option value="3">Đầy Đủ</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-row mt-5 mt-lg-5 mt-sm-5 mt-md-5 mt-xl-5">
                        <div class="col-md-4 mb-3">
                            <label for="validationCustom03">Tầng</label>
                            <div class="md-form md-outline input-with-post-icon datepicker" id="accLabels">
                                <input placeholder="Select date" type="text" id="validationCustom03"
                                       class="form-control" name="tang" value="15">
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <div class="form-group">
                                <label for="validationCustom04">Loại Mặt Bằng</label>
                                <select class="custom-select" id="validationCustom04" name="loaimb" required>
                                    <option value="">Chọn một loại mặt bằng</option>
                                    <option value="1">Văn Phòng Chia Sẻ</option>
                                    <option value="2">Văn Phòng Trọn Gói</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationCustom05">Giá Tiền</label>
                            <input type="text" class="form-control" id="validationCustom05" placeholder="Giá Tiền"
                                   name="giatien" required>
                        </div>
                    </div>
                    <div class="form-row mt-5 mt-lg-5 mt-sm-5 mt-md-5 mt-xl-5">
                        <div class="col-md-6 mb-3">
                            <label>Ngày Bắt Đầu</label>
                            <input type="date" class="form-control" name="ngaybd" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label>Ngày Kết Thúc</label>
                            <input type="date" class="form-control" name="ngaykt" required>
                        </div>
                    </div>
                    <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#exampleModal"
                            style="margin-left: 80%">
                        Tạo Mặt Bằng
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Tạo Mới Mặt Bằng</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Đồng ý tạo mới mặt bằng này không?
                                </div>
                                <div class="modal-footer">
                                    <button type="reset" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                                    <button type="submit" class="btn btn-primary">Tạo</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </center>
        </div>
    </div>
</div>

<script src="../bootstrap/js/bootstrap.js"></script>
<script src="../bootstrap/js/jquery-3.6.0.min.js"></script>
</body>
</html>
