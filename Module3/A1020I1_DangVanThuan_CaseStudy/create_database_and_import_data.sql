drop database if exists a1020i1_dangvanthuan_casestudy;

create database a1020i1_dangvanthuan_casestudy;

use a1020i1_dangvanthuan_casestudy;

create  table vi_tri (
	id_vi_tri int primary key not null,
    ten_vi_tri varchar(45)
    
);


create table kieu_thue (
	id_kieu_thue int primary key not null,
    ten_kieu_thue varchar (45)
    
);

create table trinh_do(
	id_trinh_do int primary key not null,
    trinh_do varchar(45)
    
);

create table bo_phan(
	id_bo_phan int primary key not null,
    bo_phan varchar(45)
    
);
 
create table loai_khach (
	id_loai_khach int primary key not null,
    ten_loai_khach varchar(45) 
    
);
 
create table nhan_vien (
	id_nhan_vien int primary key not null,
    ho_ten varchar(45) not null,
    id_vi_tri int not null,
    id_trinh_do int not null,
    id_bo_phan int not null,
    ngay_sinh date not null,
    so_cmnd varchar(45) not null,
    luong varchar(45) not null,
    sdt varchar(45) not null,
    email varchar(45) not null,
    dia_chi varchar(45) not null,
    
    foreign key(id_vi_tri) references vi_tri(id_vi_tri),
    foreign key(id_trinh_do) references trinh_do(id_trinh_do),
    foreign key(id_bo_phan) references bo_phan(id_bo_phan)
 );

create table dich_vu_di_kem (
	id_dich_vu_di_kem int primary key not null,
	ten_dich_vu_di_kem varchar(45) not null,
    gia int not null,
    don_vi int not null,
	trang_thai_kha_dung varchar(45) not null
);

create table khach_hang (
	id_khach_hang int primary key not null,
    id_loai_khach int not null,
    ho_ten varchar(45),
    ngay_sinh date not null,
    so_cmnd varchar(45) not null,
    so_dien_thoai varchar(45) not null,
    email varchar(45) not null,
    dia_chi varchar(45) not null,
    
    foreign key(id_loai_khach) references loai_khach(id_loai_khach)
);

create table dich_vu (
	id_dich_vu int primary key not null,
    ten_dich_vu varchar(45) not null,
    dien_tich int not null,
    so_tang int not null,
    so_nguoi_toi_da varchar(50) not null,
    chi_phi_thue varchar(50) not null,
    id_kieu_thue int not null,
    trang_thai varchar(45),
    
    foreign key(id_kieu_thue) references kieu_thue(id_kieu_thue)
);

create table hop_dong (
	id_hop_dong int primary key not null,
    id_nhan_vien int not null,
    id_khach_hang int not null,
    id_dich_vu int not null,
    ngay_lam_hop_dong date not null,
    ngay_ket_thuc date not null,
    tien_dat_coc int,
    tong_tien int,
    
    foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien) ,
    foreign key(id_khach_hang) references khach_hang(id_khach_hang) on delete cascade on update cascade ,
    foreign key(id_dich_vu) references dich_vu(id_dich_vu)
    
);

create table hop_dong_chi_tiet (
	id_hop_dong_chi_tiet int primary key not null,
    id_hop_dong int not null,
    id_dich_vu_di_kem int not null,
    so_luong int not null,
    
    foreign key(id_hop_dong) references hop_dong(id_hop_dong) on delete cascade on update cascade,
    foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);

-- nh????p d???? li????u cho ba??ng

-- b???? ph????n
insert into bo_phan 
values
(1, 'Sale ??? Marketing'),
(2, 'H??nh Ch??nh'),
(3, 'Phu??c Vu??'),
(4, 'Qua??n Ly??');

-- tri??nh ??????
insert into trinh_do
values
(1,'Trung C????p'),
(2,'Cao ??????ng'),
(3,'??a??i Ho??c va?? sau ??a??i ho??c');

-- vi?? tri??
insert into vi_tri
values
(1,'L???? T??n'),
(2,'Phu??c Vu??'),
(3,'Chuy??n Vi??n'),
(4,'Gia??m Sa??t'),
(5,'Qua??n Ly??'),
(6,'Gia??m ??????c');

-- nh??n vi??n
insert into nhan_vien
values
-- id, ten, vitri, trinhdo, bophan, namsinh, cmt, luong, sdt, diachi
(1, 'Thu????n', 3, 3, 2, '1997-10-25', '123123123', '3500000', '123123123', 'abc@gmail.com', '??a?? N????ng'),
(2, 'Toa??n', 1, 3, 2, '1997-10-25', '123321123', '3500000', '123123123', 'abc@gmail.com', '??a?? N????ng'),
(3, 'Trang', 1, 3, 2, '1997-10-25', '123321123', '3500000', '123123123', 'abc@gmail.com', '??a?? N????ng'),
(4, 'Kha??nh', 1, 3, 2, '1997-10-25', '123321123', '3500000', '123123123', 'abc@gmail.com', '??a?? N????ng'),
(5, 'Ki??n', 1, 3, 2, '1997-10-25', '123321123', '3500000', '123123123', 'abc@gmail.com', '??a?? N????ng'),
(6, 'Hu??ng', 4, 3, 2, '1997-10-25', '111222333', '4000000', '123123123', 'abc@gmail.com', '??a?? N????ng'),
(7, 'Xu??n', 6, 3, 2, '1997-10-25', '333222111', '5000000', '123123123', 'abc@gmail.com', '??a?? N????ng'),
(8, 'Kh????ng', 2, 3, 2, '1997-10-25', '222111333', '3500000', '123123123', 'abc@gmail.com', '??a?? N????ng');

-- loa??i kha??ch
insert into loai_khach
values
(1, 'Diamond'),
(2, 'Platinium'),
(3, 'Gold'),
(4, 'Silver'),
(5, 'Member');

-- kha??ch ha??ng
insert into khach_hang
values 
-- id, loaikhach, 
(1, 3, 'Nguy????n V??n A', '1940-12-12', '123123123', '123123123', 'abc@abc.com', '??a?? N????ng'),
(2, 1, 'Nguy????n V??n B', '1992-12-12', '123123123', '123123123', 'abc@abc.com', 'Hu????'),
(3, 5, 'Nguy????n V??n C', '2003-12-12', '123123123', '123123123', 'abc@abc.com', '??a?? N????ng'),
(4, 2, 'Nguy????n V??n D', '1980-12-12', '123123123', '123123123', 'abc@abc.com', 'Qua??ng Tri??'),
(5, 4, 'Nguy????n V??n E', '2010-12-12', '123123123', '123123123', 'abc@abc.com', 'Qua??ng Nam');

-- ki????u thu??
insert into kieu_thue
values
(1, 'n??m'),
(2, 'tha??ng'),
(3, 'nga??y'),
(4, 'gi????');

-- di??ch vu??
insert into dich_vu
values
(1, 'Villa 1', 100, 2, 20, 500, 3, 'tr????ng'),
(2, 'Villa 2', 150, 2, 25, 600, 3, 'tr????ng'),
(3, 'Villa 3', 50, 1, 10, 350, 4, 'tr????ng'),
(4, 'Villa 4', 300, 3, 50, 1000, 2, 'tr????ng'),
(5, 'House 1', 100, 2, 10, 200, 2, 'tr????ng'),
(6, 'House 2', 150, 2, 15, 250, 2, 'tr????ng'),
(7, 'House 3', 50, 1, 5, 100, 2, 'tr????ng'),
(8, 'House 4', 300, 3, 25, 350, 2, 'tr????ng'),
(9, 'Room 1', 100, 3, 25, 100, 2, 'tr????ng'),
(10, 'Room 2', 50, 3, 25, 50, 2, 'tr????ng'),
(11, 'Room 3', 150, 3, 25, 150, 2, 'tr????ng'),
(12, 'Room 4', 30, 1, 25, 30, 2, 'tr????ng');

-- di??ch vu?? ??i ke??m
insert into dich_vu_di_kem
values
(1, 'massage' , 50, 5, 'tr????ng'),
(2, 'karaoke' , 80, 5, 'tr????ng'),
(3, 'th????c ??n' , 20, 500, 'tr????ng'),
(4, 'n??????c u????ng' , 5, 2000, 'tr????ng'),
(5, 'thu?? xe' , 100, 15, 'tr????ng');

-- h????p ??????ng
insert into hop_dong 
values
(1, 2, 1, 5, '2021-04-17', '2021-04-30', 500000, 15000000),
(2, 2, 4, 1, '2021-03-15', '2021-03-30', 500000, 10000000),
(3, 3, 3, 3, '2021-02-17', '2021-03-01', 500000, 7000000),
(4, 4, 2, 10, '2021-01-01', '2021-01-10', 500000, 25000000),
(5, 5, 5, 12, '2021-03-01', '2021-03-10', 500000, 5000000);

-- h????p ??????ng chi ti????t
insert into hop_dong_chi_tiet
values
(1, 1, 4, 5),
(2, 2, 4, 2),
(3, 4, 2, 1),
(4, 3, 5, 1),
(5, 3, 3, 3),
(6, 2, 1, 1),
(7, 4, 3, 5),
(8, 1, 3, 5),
(9, 3, 3, 3),
(10, 4, 5, 1);