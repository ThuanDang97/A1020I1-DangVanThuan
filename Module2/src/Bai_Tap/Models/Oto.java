package Bai_Tap.Models;

public class Oto extends PhuongTien {
    private String soChoNgoi;
    private String kieuXe;

    public Oto() {
    }

    public Oto(String bienKiemSoat, String tenHangSX, String namSX, String chuSoHuu, String soChoNgoi, String kieuXe) {
        super(bienKiemSoat, tenHangSX, namSX, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public String getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(String soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return "Số chỗ ngồi: " + soChoNgoi + '\n' +
                "Kiểu Xe: " + kieuXe + '\n' +
                "---------------------------";
    }

}
