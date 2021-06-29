package model.repository;

import model.bean.MatBang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepositoryImpl implements MatBangRepository {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<MatBang> findAll() {
        List<MatBang> matBangList = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select id_mat_bang, ma_mat_bang, trang_thai.ten_trang_thai as trang_thai, dien_tich, tang, loai_mat_bang.ten_loai_mat_bang as loai_mat_bang, gia_tien, ngay_bat_dau, ngay_ket_thuc\n" +
                            "from mat_bang\n" +
                            "left join trang_thai on trang_thai.ma_trang_thai = mat_bang.ma_trang_thai\n" +
                            "left join loai_mat_bang on loai_mat_bang.ma_loai_mat_bang = mat_bang.ma_loai_mat_bang;"
            );
            MatBang matBang = null;
            while (resultSet.next()){
                matBang = new MatBang();
                matBang.setId_mat_bang(resultSet.getInt("id_mat_bang"));
                matBang.setMa_mat_bang(resultSet.getString("ma_mat_bang"));
                matBang.setTen_trang_thai(resultSet.getString("trang_thai"));
                matBang.setDien_tich(resultSet.getDouble("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setTen_loai_mat_bang(resultSet.getString("loai_mat_bang"));
                matBang.setGia_tien(resultSet.getDouble("gia_tien"));
                matBang.setNgay_bat_dau(resultSet.getDate("ngay_bat_dau"));
                matBang.setNgay_ket_thuc(resultSet.getDate("ngay_ket_thuc"));

                matBangList.add(matBang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public MatBang findById(int id) {
        return null;
    }

    @Override
    public void chonMatBang(MatBang matBang) {

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "insert into mat_bang (ma_mat_bang, ma_trang_thai, dien_tich, tang, ma_loai_mat_bang, gia_tien, ngay_bat_dau, ngay_ket_thuc)\n" +
                            "values\n" +
                            "(?,?,?,?,?,?,?,?);"
            );
            preparedStatement.setString(1, matBang.getMa_mat_bang());
            preparedStatement.setInt(2, matBang.getMa_trang_thai());
            preparedStatement.setDouble(3, matBang.getDien_tich());
            preparedStatement.setInt(4, matBang.getTang());
            preparedStatement.setInt(5, matBang.getMa_loai_mat_bang());
            preparedStatement.setDouble(6, matBang.getGia_tien());
            preparedStatement.setDate(7, matBang.getNgay_bat_dau());
            preparedStatement.setDate(8, matBang.getNgay_ket_thuc());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaMatBang(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "delete from mat_bang where id_mat_bang = ?;"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void capNhatMatBang(int id, MatBang matBang) {

    }

    @Override
    public List<MatBang> timMatBang(int id_loai_mat_bang, int tang, Date ngay_bat_dau, Date ngay_ket_thuc) {
        return null;
    }
}
