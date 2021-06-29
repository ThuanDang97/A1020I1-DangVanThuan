package Bai_Tap.Manager;

import Bai_Tap.Commons.FileUtils;
import Bai_Tap.Models.Oto;
import Bai_Tap.Models.XeMay;
import Bai_Tap.Models.XeTai;

import java.util.ArrayList;
import java.util.List;

import static Bai_Tap.Commons.StaticFile.*;
import static Bai_Tap.Controllers.MainController.displayMainMenu;
import static Bai_Tap.Manager.XeMayManager.themMoiXeMay;
import static Bai_Tap.Manager.XeOtoManager.themMoiXeOto;
import static Bai_Tap.Manager.XeTaiManager.hienThiXeTai;
import static Bai_Tap.Manager.XeTaiManager.themMoiXeTai;

public class PhuongTienManager {
    public static void themMoiPhuongTien() {
        do {
            check = true;
            System.out.println("------Menu Phương Tiện------");
            System.out.println("1. Thêm Xe Tải\n" +
                    "2. Thêm Oto\n" +
                    "3. Thêm Xe Máy\n" +
                    "4. Quay Lại\n");
            System.out.println("-----------------------");
            System.out.println("Vui lòng chọn một chức năng muốn thực hiện: ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    XeTai xeTai = new XeTai();
                    themMoiXeTai(xeTai);
                    break;
                case 2:
                    Oto oto = new Oto();
                    themMoiXeOto(oto);
                    break;
                case 3:
                    XeMay xeMay = new XeMay();
                    themMoiXeMay(xeMay);
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.err.println("Chức năng vừa chọn không nằm trong menu, vui lòng chọn lại!!!");
                    input.nextLine();
                    themMoiPhuongTien();
                    break;
            }
        } while (check);
    }

    public static void hienThiPhuongTien() {
        do {
            check = true;
            System.out.println("------Menu Phương Tiện------");
            System.out.println("1. Hiển Thị Xe Tải\n" +
                    "2. Hiển Thị Oto\n" +
                    "3. Hiển Thị Xe Máy\n" +
                    "4. Quay Lại\n");
            System.out.println("-----------------------");
            System.out.println("Vui lòng chọn một chức năng muốn thực hiện: ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    hienThiXeTai();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    themMoiPhuongTien();
                    break;
                default:
                    System.err.println("Chức năng vừa chọn không nằm trong menu, vui lòng chọn lại!!!");
                    input.nextLine();
                    hienThiPhuongTien();
                    break;
            }
        } while (check);
    }

    public static void xoaPhuongTien() {
        List<XeTai> xeTaiList = new ArrayList<>();
        List<XeMay> xeMayList = new ArrayList<>();
        List<Oto> xeOtoList = new ArrayList<>();
        listXeTai = FileUtils.getFileCSVToListXeTai();
        listXeMay = FileUtils.getFileCSVToListXeMay();
        listXeOto = FileUtils.getFileCSVToListXeOto();
        System.out.println("Nhập biển kiểm soát cần xóa: ");
        String bks = input.nextLine();
        xeTaiList.addAll(listXeTai);
        xeMayList.addAll(listXeMay);
        xeOtoList.addAll(listXeOto);

        check = true;

        while (check){
            for (XeTai xeTai : xeTaiList){
                if (xeTai.getBienKiemSoat().equals(bks)){
                    xeTaiList.remove(bks);
                }
            }
        }

//        List<XeTai> xeTaiList = FileUtils.getFileCSVToListXeTai();
//        System.out.println("Nhập biển kiểm soát cần xóa: ");
//        String bienkiemsoat = input.nextLine();
//        for (XeTai xeTai : xeTaiList) {
//            if (bienkiemsoat.equals(xeTai.getBienKiemSoat())) {
//                xeTaiList.remove(bienkiemsoat);
//                System.out.println("Đã xóa thành công!!!");
//            }
//        }
//        System.out.println(xeTaiList);
    }
}
