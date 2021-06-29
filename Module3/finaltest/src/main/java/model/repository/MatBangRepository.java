package model.repository;

import model.bean.MatBang;

import java.sql.Date;
import java.util.List;

public interface MatBangRepository {
    List<MatBang> findAll();

    MatBang findById(int id);

    void chonMatBang(MatBang matBang);

    void xoaMatBang(int id);

    void capNhatMatBang(int id, MatBang matBang);

    List<MatBang> timMatBang(int id_loai_mat_bang, int tang, Date ngay_bat_dau, Date ngay_ket_thuc);
}
