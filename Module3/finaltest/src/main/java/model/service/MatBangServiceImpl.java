package model.service;

import model.bean.MatBang;
import model.repository.MatBangRepository;
import model.repository.MatBangRepositoryImpl;

import java.sql.Date;
import java.util.List;

public class MatBangServiceImpl implements MatBangService {
    private MatBangRepository matBangRepository = new MatBangRepositoryImpl();

    @Override
    public List<MatBang> findAll() {
        return this.matBangRepository.findAll();
    }

    @Override
    public MatBang findById(int id) {
        return this.matBangRepository.findById(id);
    }

    @Override
    public void chonMatBang(MatBang matBang) {
        this.matBangRepository.chonMatBang(matBang);
    }

    @Override
    public void xoaMatBang(int id) {
        this.matBangRepository.xoaMatBang(id);
    }

    @Override
    public void capNhatMatBang(int id, MatBang matBang) {
        this.matBangRepository.capNhatMatBang(id, matBang);
    }

    @Override
    public List<MatBang> timMatBang(int id_loai_mat_bang, int tang, Date ngay_bat_dau, Date ngay_ket_thuc) {
        return this.matBangRepository.timMatBang(id_loai_mat_bang, tang, ngay_bat_dau, ngay_ket_thuc);
    }
}
