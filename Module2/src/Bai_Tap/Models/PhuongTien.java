package Bai_Tap.Models;

public abstract class PhuongTien {
    private String bienKiemSoat;
    private String tenHangSX;
    private String namSX;
    private String chuSoHuu;

    public PhuongTien() {
    }

    public PhuongTien(String bienKiemSoat, String tenHangSX, String namSX, String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.tenHangSX = tenHangSX;
        this.namSX = namSX;
        this.chuSoHuu = chuSoHuu;
    }

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public String getTenHangSX() {
        return tenHangSX;
    }

    public void setTenHangSX(String tenHangSX) {
        this.tenHangSX = tenHangSX;
    }

    public String getNamSX() {
        return namSX;
    }

    public void setNamSX(String namSX) {
        this.namSX = namSX;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return "--------------------------- \n" +
                "Biển kiểm soát: " + bienKiemSoat + '\n' +
                "Tên hãng sản xuất: " + tenHangSX + '\n' +
                "Năm sản xuất: " + namSX + '\n' +
                "Chủ sở hữu: " + chuSoHuu + '\n';
    }
}
