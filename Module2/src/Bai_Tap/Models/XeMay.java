package Bai_Tap.Models;

public class XeMay extends PhuongTien {
    private String congSuat;

    public XeMay() {
    }

    public XeMay(String bienKiemSoat, String tenHangSX, String namSX, String chuSoHuu, String congSuat) {
        super(bienKiemSoat, tenHangSX, namSX, chuSoHuu);
        this.congSuat = congSuat;
    }

    public String getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return super.toString() + "Công Suất: " + congSuat + '\n' +
                "---------------------------";
    }
}
