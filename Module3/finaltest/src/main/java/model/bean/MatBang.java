package model.bean;

import java.sql.Date;

public class MatBang {
    private int id_mat_bang;
    private String ma_mat_bang;
    private int ma_trang_thai;
    private String ten_trang_thai;
    private double dien_tich;
    private int tang;
    private int ma_loai_mat_bang;
    private String ten_loai_mat_bang;
    private double gia_tien;
    private Date ngay_bat_dau;
    private Date ngay_ket_thuc;

    public MatBang() {
    }

    public MatBang(int id_mat_bang, String ma_mat_bang, int ma_trang_thai, double dien_tich, int tang, int ma_loai_mat_bang, double gia_tien, Date ngay_bat_dau, Date ngay_ket_thuc) {
        this.id_mat_bang = id_mat_bang;
        this.ma_mat_bang = ma_mat_bang;
        this.ma_trang_thai = ma_trang_thai;
        this.dien_tich = dien_tich;
        this.tang = tang;
        this.ma_loai_mat_bang = ma_loai_mat_bang;
        this.gia_tien = gia_tien;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public MatBang(int id_mat_bang, String ma_mat_bang, String ten_trang_thai, double dien_tich, int tang, String ten_loai_mat_bang, double gia_tien, Date ngay_bat_dau, Date ngay_ket_thuc) {
        this.id_mat_bang = id_mat_bang;
        this.ma_mat_bang = ma_mat_bang;
        this.ten_trang_thai = ten_trang_thai;
        this.dien_tich = dien_tich;
        this.tang = tang;
        this.ten_loai_mat_bang = ten_loai_mat_bang;
        this.gia_tien = gia_tien;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public MatBang(String ma_mat_bang, int ma_trang_thai, double dien_tich, int tang, int ma_loai_mat_bang, double gia_tien, Date ngay_bat_dau, Date ngay_ket_thuc) {
        this.ma_mat_bang = ma_mat_bang;
        this.ma_trang_thai = ma_trang_thai;
        this.dien_tich = dien_tich;
        this.tang = tang;
        this.ma_loai_mat_bang = ma_loai_mat_bang;
        this.gia_tien = gia_tien;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public int getId_mat_bang() {
        return id_mat_bang;
    }

    public void setId_mat_bang(int id_mat_bang) {
        this.id_mat_bang = id_mat_bang;
    }

    public String getMa_mat_bang() {
        return ma_mat_bang;
    }

    public void setMa_mat_bang(String ma_mat_bang) {
        this.ma_mat_bang = ma_mat_bang;
    }

    public int getMa_trang_thai() {
        return ma_trang_thai;
    }

    public void setMa_trang_thai(int ma_trang_thai) {
        this.ma_trang_thai = ma_trang_thai;
    }

    public String getTen_trang_thai() {
        return ten_trang_thai;
    }

    public void setTen_trang_thai(String ten_trang_thai) {
        this.ten_trang_thai = ten_trang_thai;
    }

    public double getDien_tich() {
        return dien_tich;
    }

    public void setDien_tich(double dien_tich) {
        this.dien_tich = dien_tich;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public int getMa_loai_mat_bang() {
        return ma_loai_mat_bang;
    }

    public void setMa_loai_mat_bang(int ma_loai_mat_bang) {
        this.ma_loai_mat_bang = ma_loai_mat_bang;
    }

    public String getTen_loai_mat_bang() {
        return ten_loai_mat_bang;
    }

    public void setTen_loai_mat_bang(String ten_loai_mat_bang) {
        this.ten_loai_mat_bang = ten_loai_mat_bang;
    }

    public double getGia_tien() {
        return gia_tien;
    }

    public void setGia_tien(double gia_tien) {
        this.gia_tien = gia_tien;
    }

    public Date getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(Date ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public Date getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(Date ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }
}
