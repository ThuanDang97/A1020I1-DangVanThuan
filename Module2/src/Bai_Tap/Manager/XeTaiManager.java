package Bai_Tap.Manager;

import Bai_Tap.Commons.Exception.BKSException;
import Bai_Tap.Commons.Exception.CSHException;
import Bai_Tap.Commons.Exception.NSXException;
import Bai_Tap.Commons.Exception.TTException;
import Bai_Tap.Commons.FileUtils;
import Bai_Tap.Commons.Validate;
import Bai_Tap.Models.XeTai;

import java.util.ArrayList;
import java.util.List;

import static Bai_Tap.Commons.StaticFile.*;
import static Bai_Tap.Controllers.MainController.displayMainMenu;
import static Bai_Tap.Manager.HangSanXuatManager.hangSX;

public class XeTaiManager {
    public static void themMoiXeTai(XeTai xeTai) {
        String bienkiemsoat;
        String namsanxuat;
        String chusohuu;
        String trongtai;

        do {
            check = true;
            try {
                System.out.println("Nhập biển kiểm soát theo định dạng XXC-XXX.XX (X : 0-9)");
                bienkiemsoat = input.nextLine();
                Validate.checkBKSXeTai(bienkiemsoat);
                xeTai.setBienKiemSoat(bienkiemsoat);
            } catch (BKSException e) {
                System.err.println(e);
                check = false;
            }
        } while (!check);

        hangSX(xeTai);

        do {
            check = true;
            try {
                System.out.println("Nhập năm sản xuất: ");
                namsanxuat = input.nextLine();
                Validate.checkNamSX(namsanxuat);
                xeTai.setNamSX(namsanxuat);
            } catch (NSXException e) {
                System.err.println(e);
                check = false;
            }
        } while (!check);

        do {
            check = true;
            try {
                System.out.println("Nhập chủ sở hữu: ");
                chusohuu = input.nextLine();
                Validate.checkCSH(chusohuu);
                xeTai.setChuSoHuu(chusohuu);
            } catch (CSHException e) {
                System.err.println(e);
                check = false;
            }
        } while (!check);

        do {
            check = true;
            try {
                System.out.println("Nhập trọng tải: ");
                trongtai = input.nextLine();
                Validate.checkTT(trongtai);
                xeTai.setTrongTai(trongtai);
            } catch (TTException e) {
                System.err.println(e);
                check = false;
            }
        } while (!check);

        listXeTai.add(xeTai);
        String line;
        line = xeTai.getBienKiemSoat() + COMMA + xeTai.getTenHangSX() + COMMA + xeTai.getNamSX() + COMMA + xeTai.getChuSoHuu()
                + COMMA + xeTai.getTrongTai();
        FileUtils.writeFile(FILE_XE_TAI, line);
        System.out.println("Thêm thành công xe tải, Enter để tiếp tục chương trình!!!");
        displayMainMenu();
    }

    public static void hienThiXeTai() {
        listXeTai = FileUtils.getFileCSVToListXeTai();
        for (XeTai xeTai : listXeTai) {
            System.out.println(xeTai.toString());
        }
    }

    public static void checkBKSXeTai(String str) {
        List<String> bienKiemSoat = new ArrayList<>();
        List<XeTai> xeTaiList = FileUtils.getFileCSVToListXeTai();
        for (int i = 0; i < xeTaiList.size(); i++) {
            bienKiemSoat.add(xeTaiList.get(i).getBienKiemSoat());
        }
        System.out.println(bienKiemSoat);
        System.out.println("Nhập biển kiểm soát cần xóa");
        str = input.nextLine();
        for (int i = 0; i < bienKiemSoat.size(); i++) {
            if (str.equals(bienKiemSoat.get(i))) {
                bienKiemSoat.remove(i);
                break;
            }
        }
        System.out.println(bienKiemSoat);
    }
}
