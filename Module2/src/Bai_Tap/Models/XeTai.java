package Bai_Tap.Models;

public class XeTai extends PhuongTien {
    private String trongTai;

    public XeTai() {
    }

    public XeTai(String bienKiemSoat, String tenHangSX, String namSX, String chuSoHuu, String trongTai) {
        super(bienKiemSoat, tenHangSX, namSX, chuSoHuu);
        this.trongTai = trongTai;
    }

    public String getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(String trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return super.toString() + "Trọng Tải: " + trongTai + '\n' +
                "---------------------------";
    }

}
