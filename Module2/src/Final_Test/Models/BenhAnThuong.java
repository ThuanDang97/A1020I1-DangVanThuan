package Final_Test.Models;

public class BenhAnThuong extends BenhAn {
    private String phiNamVien;

    public BenhAnThuong() {
    }

    public BenhAnThuong(String soThuTuBenhAn, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, String phiNamVien) {
        super(soThuTuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public String getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(String phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public void showInfor() {
        System.out.println( super.toString() + "Phí Nằm Viện: " + phiNamVien);
    }
}
