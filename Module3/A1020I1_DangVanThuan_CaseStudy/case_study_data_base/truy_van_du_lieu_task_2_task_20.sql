-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.

select *
from nhan_vien
where ho_ten like "H%" or ho_ten like "T%" or ho_ten like "K%" and length(ho_ten) <= 15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select *
from khach_hang
where (year(current_date()) - year(ngay_sinh)) > 18 and (year(current_date()) - year(ngay_sinh)) < 50
and (dia_chi = 'Đà Nẵng' or dia_chi = 'Quảng Trị');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select kh.id_khach_hang, kh.ho_ten, lk.ten_loai_khach, count(*) as so_lan_dat
from khach_hang kh
	inner join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
    left join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
where lk.ten_loai_khach = 'Diamond'
group by id_khach_hang
order by so_lan_dat;

-- 5. Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra)

select kh.id_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.id_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc,
		sum(dv.chi_phi_thue + (dvdk.don_vi * dvdk.gia)) as tong_tien
from khach_hang kh
	left join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach 
    left join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
	left join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
    left join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
    left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by hd.id_hop_dong;

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select dv.id_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, hd.ngay_lam_hop_dong
from dich_vu dv
	left join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
where dv.id_dich_vu not in (
	select id_dich_vu
    from hop_dong
    where year(ngay_lam_hop_dong) > 2019
);

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue,TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

select dv.id_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue
from dich_vu dv
	inner join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
where dv.id_dich_vu not in (
	select distinct id_dich_vu
    from hop_dong
    where year(ngay_lam_hop_dong) = 2019
);

-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

-- 1
select distinct ho_ten
from khach_hang;

-- 2

select ho_ten
from khach_hang
group by ho_ten;

-- 3

select ho_ten
from khach_hang
union
select ho_ten
from khach_hang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select month(ngay_lam_hop_dong) as thang, count(id_khach_hang) as tong_so_khach_hang
from hop_dong
where year(ngay_lam_hop_dong) = '2019'
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong);

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).

select hd.id_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, count(hdct.id_hop_dong_chi_tiet) as so_luong_dich_vu_di_kem
from hop_dong hd
	left join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
group by hd.id_hop_dong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi 
-- những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”. 

select kh.ho_ten, kh.dia_chi, ten_loai_khach, hd.id_hop_dong, dvdk.ten_dich_vu_di_kem, so_luong
from khach_hang kh
	inner join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
    inner join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
    inner join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
    inner join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
where lk.ten_loai_khach = 'Diamond' and (kh.dia_chi in ('Huế', 'Quảng Ngãi'))
order by kh.ho_ten;

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

select hd.id_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu, sum(hdct.id_hop_dong_chi_tiet) as so_luong_dich_vu_di_kem
from hop_dong hd
	inner join nhan_vien nv on hd.id_nhan_vien = nv.id_nhan_vien
    inner join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
    inner join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
    left join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
where year(ngay_lam_hop_dong) = 2021 and month(ngay_lam_hop_dong) in (1,2,3,4) and month(ngay_lam_hop_dong) not in (10,11,12)
group by hd.id_hop_dong
order by hd.id_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
--  (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select dvdk.id_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem,count(hdct.id_dich_vu_di_kem) as so_lan_su_dung
from hop_dong_chi_tiet hdct
	inner join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by hdct.id_dich_vu_di_kem
having count(hdct.id_dich_vu_di_kem) = (
	select max(so_lan_su_dung) 
    from (
		select count(id_dich_vu_di_kem) as so_lan_su_dung
        from hop_dong_chi_tiet 
        group by id_dich_vu_di_kem) as so_lan_su_dung_dich_vu );

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select hd.id_hop_dong, ten_dich_vu_di_kem, count(hdct.id_dich_vu_di_kem) as so_lan_su_dung
from hop_dong hd
	inner join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
    inner join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
    inner join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by hdct.id_dich_vu_di_kem
having count(hdct.id_dich_vu_di_kem) = 1
order by hd.id_hop_dong;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm :
-- IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select nv.id_nhan_vien, ho_ten, td.trinh_do, bp.bo_phan, nv.sdt, nv.dia_chi, count(id_hop_dong) as so_hop_dong
from nhan_vien nv
	inner join trinh_do td on nv.id_trinh_do = td.id_trinh_do
    inner join bo_phan bp on nv.id_bo_phan = bp.id_bo_phan
	inner join vi_tri vt on nv.id_vi_tri = vt.id_vi_tri
    left join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien
where year(ngay_lam_hop_dong) > 2020
group by nv.id_nhan_vien
having count(id_hop_dong) <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
select * from nhan_vien;
delete from nhan_vien
where id_nhan_vien not in (
	select id_nhan_vien
    from hop_dong
    where hop_dong.ngay_lam_hop_dong between'2017-01-30' and '2019-12-30' 
		and hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien and id_nhan_vien is not null);
-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
    
update khach_hang, (select hop_dong.id_khach_hang as id, sum(hop_dong.tong_tien) as tong_tien 
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = 2019
group by hop_dong.id_khach_hang
having tong_tien > 10000000) as temp set khach_hang.id_loai_khach= (select loai_khach.id_loai_khach from loai_khach where loai_khach.ten_loai_khach = 'Diamond')
	where khach_hang.id_loai_khach= (select loai_khach.id_loai_khach from loai_khach where loai_khach.ten_loai_khach = 'Platinium') 
	and temp.id = khach_hang.id_khach_hang;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).

delete khach_hang
from khach_hang 
	inner join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
	inner join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
where year(ngay_lam_hop_dong) not in (
	select ngay_lam_hop_dong
    from hop_dong
    where year(ngay_lam_hop_dong) < '2016' and ngay_lam_hop_dong is not null);
    
	select *
    from hop_dong
    where year(ngay_lam_hop_dong) > '2016';
    

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

update dich_vu_di_kem 
	inner join (select dich_vu_di_kem.ten_dich_vu_di_kem as ten_dich_vu_di_kem 
				from hop_dong_chi_tiet inner join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
                group by dich_vu_di_kem.id_dich_vu_di_kem
                having count(hop_dong_chi_tiet.id_dich_vu_di_kem) > 10) as temp set dich_vu_di_kem.gia = dich_vu_di_kem.gia*2
where dich_vu_di_kem.ten_dich_vu_di_kem = temp.ten_dich_vu_di_kem;

-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống,
--  thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

select id_nhan_vien, ho_ten, email, sdt, ngay_sinh, dia_chi, 'nhan vien' as form_table
from nhan_vien
union all
select id_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi, 'khach hang' as form_table
from khach_hang;

