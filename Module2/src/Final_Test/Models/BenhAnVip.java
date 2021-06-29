package Final_Test.Models;

public class BenhAnVip extends BenhAn {
    private String goiVip;
    private String thoiHanVip;

    public BenhAnVip() {
    }

    public BenhAnVip(String soThuTuBenhAn, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, String goiVip, String thoiHanVip) {
        super(soThuTuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.goiVip = goiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public String getGoiVip() {
        return goiVip;
    }

    public void setGoiVip(String goiVip) {
        this.goiVip = goiVip;
    }

    public String getThoiHanVip() {
        return thoiHanVip;
    }

    public void setThoiHanVip(String thoiHanVip) {
        this.thoiHanVip = thoiHanVip;
    }

    @Override
    public void showInfor() {
        System.out.println(super.toString() + "Gói Víp: " + goiVip + "\n"
        + "Thời hạn VIP: " + thoiHanVip);
    }
}
