drop database if exists ham_thong_dung;

create database ham_thong_dung;

use ham_thong_dung;

create table hoc_vien (
	id int primary key auto_increment,
    ten varchar(35),
    tuoi int,
    khoa_hoc varchar(30),
    so_tien int(6)
);

insert into hoc_vien (ten, tuoi, khoa_hoc, so_tien)
values
('Hoang', 21, 'CNTT', 400000),
('Viet', 19, 'DTVT', 320000),
('Thanh', 18, 'KTDN', 400000),
('Nhan', 19, 'CK', 450000),
('Huong', 20, 'TCNH', 500000),
('Huong', 20, 'TCNH', 200000);


-- Viết câu lệnh hiện thị tất cả các dòng có tên là Huong

select *
from hoc_vien
where ten = 'Huong';

-- Viết câu lệnh lấy ra tổng số tiền của Huong

select ten, sum(so_tien) as tong_tien
from hoc_vien
where ten = 'Huong';

-- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp
select distinct ten
from hoc_vien;