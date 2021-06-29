package Final_Test.Manager;

import Final_Test.Commons.FileUtils;
import Final_Test.Commons.validateData;
import Final_Test.Models.BenhAnThuong;

import java.util.ArrayList;
import java.util.Scanner;

import static Final_Test.MainController.MainControllers.displayMainMenu;

public class BenhAnThuongManager {
    static Scanner input = new Scanner(System.in);
    static ArrayList<BenhAnThuong> benhAnThuongList = new ArrayList<>();

    public static void themBenhAnThuong(BenhAnThuong benhAnThuong) {
        String stt;
        String maBenhAn;
        String maBenhNhan;
        String tenBenhNhan;
        String ngayNhapVien;
        String ngayRaVien;
        String lyDoNhapVien;
        String phiNamVien;
        System.out.println("stt");
        stt = input.nextLine();
        benhAnThuong.setSoThuTuBenhAn(stt);
        System.out.println("Nhập mã bênh án theo định dạng BA-XXX ( X là số ): ");
        maBenhAn = input.nextLine();
        while (!validateData.checkMaBenhAn(maBenhAn)) {
            System.err.println("Mã bệnh án sai!!!");
            maBenhAn = input.nextLine();
        }
        benhAnThuong.setMaBenhAn(maBenhAn);

        System.out.println("Nhập mã bênh nhân theo định dạng BN-XXX ( X là số ): ");
        maBenhNhan = input.nextLine();
        while (!validateData.checkMaBenhNhan(maBenhNhan)) {
            System.err.println("Mã bệnh án sai!!!");
            maBenhNhan = input.nextLine();
        }
        benhAnThuong.setMaBenhNhan(maBenhNhan);
        System.out.println("Nhập tên bệnh nhân: ");
        tenBenhNhan = input.nextLine();
        benhAnThuong.setTenBenhNhan(tenBenhNhan);
        System.out.println("Nhập ngày nhập viện: ");
        ngayNhapVien = input.nextLine();
        while (!validateData.checkDayMonthYear(ngayNhapVien)) {
            System.err.println("Ngày nhập viện sai định dạng!!!");
            ngayNhapVien = input.nextLine();
        }
        benhAnThuong.setNgayNhapVien(ngayNhapVien);
        System.out.println("Nhập ngày ra viện: ");
        ngayRaVien = input.nextLine();
        while (!validateData.checkDayMonthYear(ngayRaVien)) {
            System.err.println("Ngày nhập viện sai định dạng!!!");
            ngayRaVien = input.nextLine();
        }
        benhAnThuong.setNgayRaVien(ngayRaVien);
        System.out.println("Nhập lý do nhập viện: ");
        lyDoNhapVien = input.nextLine();
        benhAnThuong.setLyDoNhapVien(lyDoNhapVien);
        System.out.println("Nhập chi phí nằm viện: ");
        phiNamVien = input.nextLine();
        while (!validateData.checkChiPhi(phiNamVien)){
            System.err.println("Chi phí nhập viện sai định dạng!!!");
            phiNamVien = input.nextLine();
        }
        benhAnThuong.setPhiNamVien(phiNamVien);
        benhAnThuongList.add(benhAnThuong);
        FileUtils.writeBenhAnThuongToFileCSV(benhAnThuongList);
        System.out.println("Thêm bệnh án thường thành công, Enter để tiếp tục.");
        input.nextLine();
        displayMainMenu();
    }

    public static void xemBenhAnThuong(){
        benhAnThuongList = FileUtils.listBenhAnThuong();
        for (BenhAnThuong benhAnThuong : benhAnThuongList){
            benhAnThuong.showInfor();
        }
    }
}
