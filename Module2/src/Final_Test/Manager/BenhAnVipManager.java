package Final_Test.Manager;

import Final_Test.Commons.FileUtils;
import Final_Test.Commons.validateData;
import Final_Test.Models.BenhAnVip;

import java.util.ArrayList;
import java.util.Scanner;

import static Final_Test.MainController.MainControllers.displayMainMenu;

public class BenhAnVipManager {
    static ArrayList<BenhAnVip> benhAnVipArrayList = new ArrayList<>();

    public static void themBenhAnVip(BenhAnVip benhAnVip){
        Scanner input = new Scanner(System.in);
        String stt;
        String maBenhAn;
        String maBenhNhan;
        String tenBenhNhan;
        String ngayNhapVien;
        String ngayRaVien;
        String lyDoNhapVien;
        String loaiVip;
        String thoiHanVip;

        System.out.println("stt");
        stt = input.nextLine();
        benhAnVip.setSoThuTuBenhAn(stt);
        System.out.println("Nhập mã bênh án theo định dạng BA-XXX ( X là số ): ");
        maBenhAn = input.nextLine();
        while (!validateData.checkMaBenhAn(maBenhAn)) {
            System.err.println("Mã bệnh án sai!!!");
            maBenhAn = input.nextLine();
        }
        benhAnVip.setMaBenhAn(maBenhAn);

        System.out.println("Nhập mã bênh nhân theo định dạng BN-XXX ( X là số ): ");
        maBenhNhan = input.nextLine();
        while (!validateData.checkMaBenhNhan(maBenhNhan)) {
            System.err.println("Mã bệnh án sai!!!");
            maBenhNhan = input.nextLine();
        }
        benhAnVip.setMaBenhNhan(maBenhNhan);
        System.out.println("Nhập tên bệnh nhân: ");
        tenBenhNhan = input.nextLine();
        benhAnVip.setTenBenhNhan(tenBenhNhan);
        System.out.println("Nhập ngày nhập viện: ");
        ngayNhapVien = input.nextLine();
        while (!validateData.checkDayMonthYear(ngayNhapVien)) {
            System.err.println("Ngày nhập viện sai định dạng!!!");
            ngayNhapVien = input.nextLine();
        }
        benhAnVip.setNgayNhapVien(ngayNhapVien);
        System.out.println("Nhập ngày ra viện: ");
        ngayRaVien = input.nextLine();
        while (!validateData.checkDayMonthYear(ngayRaVien)) {
            System.err.println("Ngày nhập viện sai định dạng!!!");
            ngayRaVien = input.nextLine();
        }
        benhAnVip.setNgayRaVien(ngayRaVien);
        System.out.println("Nhập lý do nhập viện: ");
        lyDoNhapVien = input.nextLine();
        benhAnVip.setLyDoNhapVien(lyDoNhapVien);
        System.out.println("Gói VIP I, gói VIP II hoặc gói VIP III: ");
        loaiVip = input.nextLine();
        while (!validateData.checkLoaiVip(loaiVip)){
            System.err.println("Gói VIP bị sai hoặc không có!!!");
            loaiVip = input.nextLine();
        }
        benhAnVip.setGoiVip(loaiVip);
        System.out.println("Nhập thời hạn VIP: ");
        thoiHanVip = input.nextLine();
        while (!validateData.checkDayMonthYear(thoiHanVip)){
            System.err.println("Thời hạn Vip bị sai định dạng!!!");
            thoiHanVip = input.nextLine();
        }
        benhAnVip.setThoiHanVip(thoiHanVip);
        benhAnVipArrayList.add(benhAnVip);
        FileUtils.writeBenhAnVipToFileCSV(benhAnVipArrayList);
        System.out.println("Thêm bệnh án thường thành công, Enter để tiếp tục.");
        input.nextLine();
        displayMainMenu();
    }

    public static void xemBenhAnVip(){
        benhAnVipArrayList = FileUtils.listBenhAnVip();
        for (BenhAnVip benhAnVip : benhAnVipArrayList){
            benhAnVip.showInfor();
        }
    }
}
