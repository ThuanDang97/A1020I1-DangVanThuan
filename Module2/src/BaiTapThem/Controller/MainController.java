//package BaiTapThem.Controller;
//
//import BaiTapThem.Common.CheckException;
//import BaiTapThem.Common.ReadWriteCSV;
//import BaiTapThem.Model.Oto;
//import BaiTapThem.Model.Xe;
//import BaiTapThem.Model.XeMay;
//import BaiTapThem.Model.XeTai;
//
//import java.util.*;
//
//public class MainController {
//
//    private static ArrayList<XeTai> listXeTai = new ArrayList<>();
//    private static ArrayList<Oto> listOto = new ArrayList<>();
//    private static ArrayList<XeMay> listXeMay = new ArrayList<>();
//
//    public static void displayMainMenu(){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("1. Them moi phuong tien" + "\n" +
//                "2. Hien thi phuong tien \n" +
//                "3. Xoa phuong tien \n" +
//                "4. Edit phuong tien \n" +
//                "5. Exit \n"
//        );
//
//        System.out.println("vui long chon chuc nang");
//        int chooseMenu = scan.nextInt();
//
//        switch (chooseMenu){
//            case 1:
//                themMoiPhuongTien();
//                break;
//            case 2:
//                hienThiPhuongTien();
//                break;
//            case 3:
//                xoaPhuongTien();
//                break;
//            case 4:
//                Edit();
//            case 5:
//                System.exit(0);
//                break;
//        }
//    }
//
//    private static void Edit() {
//
//    }
//
//
//    private static void xoaPhuongTien() {
//        Scanner scan = new Scanner(System.in);
//        List<XeTai> xeTaiList = new ArrayList<>();
//        List<XeMay>xeMayList = new ArrayList<>();
//        List<Oto>otoList = new ArrayList<>();
//        listXeTai = ReadWriteCSV.getFileXeTaiCSV();
//        listXeMay = ReadWriteCSV.getFileXeMayCSV();
//        listOto = ReadWriteCSV.getFileOtoCSV();
//
//        System.out.println("Nhap bien so xe can xoa");
//        String bienCanXoa = scan.nextLine();
//
//        for (XeTai xeTai : listXeTai){
//            xeTaiList.add(xeTai);
//        }
//        for (Oto oto : listOto){
//            otoList.add(oto);
//        }
//        for (XeMay xeMay : listXeMay){
//            xeMayList.add(xeMay);
//        }
//
//        boolean check = true;
//        while (true){
//            for (XeMay xeMay : xeMayList){
//                if (xeMay.getBienSo().equals(bienCanXoa)){
//                    xeMayList.remove(xeMay);
//                    ReadWriteCSV.writeXeMayToFileCSV((ArrayList<XeMay>)xeMayList, false);
//                    check = false;
//                    break;
//                }
//            }
//
//            for (Oto oto : otoList){
//                if (oto.getBienSo().equals(bienCanXoa)){
//                    xeMayList.remove(oto);
//                    ReadWriteCSV.writeOtoToFileCSV((ArrayList<Oto>)otoList, false);
//                    check = false;
//                    break;
//                }
//            }
//
//            for (XeTai xeTai : xeTaiList){
//                if (xeTai.getBienSo().equals(bienCanXoa)){
//                    xeMayList.remove(xeTai);
//                    ReadWriteCSV.writeXeTaiToFileCSV((ArrayList<XeTai>)xeTaiList, false);
//                    check = false;
//                    break;
//                }
//            }
//            if (check){
//                System.out.println("bien so khong co, vui long nhap lai");
//                bienCanXoa = scan.nextLine();
//            }else {
//                System.out.println("da xoa bien so " +bienCanXoa);
//                break;
//            }
//        }
//
//
//
//
//
//
//
//
//
//
////        for (XeTai xeTai : listXeTai){
////            list1.add(xeTai);
////        }
////
////
////        System.out.println("Nhap bien kiem soat can xoa");
////        String bienCanXoa = scan.nextLine();
////
////        for (int i=0; i<list1.size(); i++){
////            if (list1.get(i).getBienSo().equals(bienCanXoa)) {
////                list1.remove(i);
////            }
////        }
////
////        ReadWriteCSV.writeXeTaiToFileCSV((ArrayList<XeTai>)list1, false);
//
//
//
////        boolean check = true;
////        while (true){
////            for (XeTai xeTai : listXeTai){
////                if (xeTai.getBienSo().equals(bienCanXoa)){
////                    listXeTai.remove(xeTai);
////                    System.out.println("da xoa");
////                    check = false;
////                    displayMainMenu();
////                }
////            }
////            if (check){
////                System.out.println("khong co bien so nay");
////            }else {
////                break;
////            }
////        }
//    }
//
//    private static void hienThiPhuongTien() {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("1. Hien thi xe tai" + "\n" +
//                "2. Hien thi xe oto \n" +
//                "3. Hien thi xe may \n"+
//                "4. Back to menu \n" +
//                "5. Exit"
//        );
//        int chooseHienthi = scan.nextInt();
//        switch (chooseHienthi){
//            case 1:
//                listXeTai= ReadWriteCSV.getFileXeTaiCSV();
//                for (XeTai xeTai : listXeTai){
//                    xeTai.showInfor();
//                    System.out.println("---------------");
//                }
//                hienThiPhuongTien();
//                break;
//            case 2:
//                listOto= ReadWriteCSV.getFileOtoCSV();
//                for (Oto oto : listOto){
//                    oto.showInfor();
//                    System.out.println("---------------");
//                }
//                hienThiPhuongTien();
//                break;
//            case 3:
//                listXeMay= ReadWriteCSV.getFileXeMayCSV();
//                for (XeMay xeMay : listXeMay){
//                    xeMay.showInfor();
//                    System.out.println("---------------");
//                }
//                hienThiPhuongTien();
//                break;
//            case 4:
//                displayMainMenu();
//                break;
//            case 5:
//                System.exit(0);
//                break;
//        }
//    }
//
//    private static void themMoiPhuongTien() {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("1. Them xe tai" + "\n" +
//                "2. Them xe oto \n" +
//                "3. Them xe may \n"+
//                "4. Back to menu \n" +
//                "5. Exit"
//        );
//
//        int chooseXe = scan.nextInt();
//        switch (chooseXe){
//            case 1:
//                listXeTai = ReadWriteCSV.getFileXeTaiCSV();
//                XeTai xeTai = new XeTai();
//
//                System.out.println("Nhap bien kiem soat");
//                scan.nextLine();
//                String bienSo = scan.nextLine();
//                while (true) {
//                    boolean flag = true;
//                    for (XeTai xeTai1 : listXeTai) {
//                        if (xeTai1.getBienSo().equals(bienSo)) {
//                            System.out.println("Bien so da co, vui long nhap lai");
//                            bienSo = scan.nextLine();
//                            flag = false;
//                        }
//                    }
//                    if (flag){
//                        break;
//                    }
//                }
//
//                while (true){
//                    try {
//                        CheckException.checkBienSoXeTai(bienSo);
//                        xeTai.setBienSo(bienSo);
//                        break;
//                    }catch (Exception e){
//                        System.err.println("Sai dinh dang, vui long nhap lai bien kiem soat");
//                        bienSo = scan.nextLine();
//                    }
//                }
//
//                System.out.println("nhap hang san xuat");
//                String hangSanXuat = scan.nextLine();
//                xeTai.setTenHangSanXuat(hangSanXuat);
//                System.out.println("Nhap nam san xuat");
//                String namSanXuat = scan.nextLine();
//                xeTai.setNamSanXuat(namSanXuat);
//                System.out.println("Nhap chu so huu");
//                String chuSoHuu = scan.nextLine();
//                xeTai.setChuSoHuu(chuSoHuu);
//                System.out.println("Nhap trong tai");
//                String trongTai = scan.nextLine();
//                xeTai.setTrongTai(trongTai);
//
//                listXeTai.add(xeTai);
//                ReadWriteCSV.writeXeTaiToFileCSV(listXeTai);
//                System.out.println("Them xe tai thanh cong, enter de tiep tuc...");
//                scan.nextLine();
//                themMoiPhuongTien();
//                break;
//            case 2:
//                listOto = ReadWriteCSV.getFileOtoCSV();
//                Oto oto = new Oto();
//
//                System.out.println("Nhap bien kiem soat");
//                scan.nextLine();
//                String bienSoOto = scan.nextLine();
//                while (true) {
//                    boolean flag = true;
//                    for (Oto oto1 : listOto) {
//                        if (oto1.getBienSo().equals(bienSoOto)) {
//                            System.out.println("Bien so da co, vui long nhap lai");
//                            bienSoOto = scan.nextLine();
//                            flag = false;
//                        }
//                    }
//                    if (flag){
//                        break;
//                    }
//                }
//
//                while (true){
//                    try {
//                        CheckException.checkBienOto(bienSoOto);
//                        oto.setBienSo(bienSoOto);
//                        break;
//                    }catch (Exception e){
//                        System.err.println("Sai dinh dang, vui long nhap lai bien kiem soat");
//                        bienSoOto = scan.nextLine();
//                    }
//                }
//                System.out.println("nhap hang san xuat");
//                String hangSanXuatOto = scan.nextLine();
//                oto.setTenHangSanXuat(hangSanXuatOto);
//                System.out.println("Nhap nam san xuat");
//                String namSanXuatOto = scan.nextLine();
//                oto.setNamSanXuat(namSanXuatOto);
//                System.out.println("Nhap chu so huu");
//                String chuSoHuuOto = scan.nextLine();
//                oto.setChuSoHuu(chuSoHuuOto);
//                System.out.println("Nhap so cho ngoi");
//                String soChoNgoi = scan.nextLine();
//                oto.setSoChoNgoi(soChoNgoi);
//                System.out.println("Nhap kieu xe");
//                String kieuXe = scan.nextLine();
//                oto.setKieuXe(kieuXe);
//
//                listOto.add(oto);
//                ReadWriteCSV.writeOtoToFileCSV(listOto);
//                System.out.println("Them xe oto thanh cong, enter de tiep tuc...");
//                scan.nextLine();
//                themMoiPhuongTien();
//                break;
//            case 3:
//                listXeMay = ReadWriteCSV.getFileXeMayCSV();
//                XeMay xeMay = new XeMay();
//
//                System.out.println("Nhap bien kiem soat");
//                scan.nextLine();
//                String bienSoXeMay = scan.nextLine();
//                while (true) {
//                    boolean flag = true;
//                    for (XeMay xeMay1 : listXeMay) {
//                        if (xeMay1.getBienSo().equals(bienSoXeMay)) {
//                            System.out.println("Bien so da co, vui long nhap lai");
//                            bienSoXeMay = scan.nextLine();
//                            flag = false;
//                        }
//                    }
//                    if (flag){
//                        break;
//                    }
//                }
//
//                while (true){
//                    try {
//                        CheckException.checkBienXeMay(bienSoXeMay);
//                        xeMay.setBienSo(bienSoXeMay);
//                        break;
//                    }catch (Exception e){
//                        System.err.println("Sai dinh dang, vui long nhap lai bien kiem soat");
//                        bienSoXeMay = scan.nextLine();
//                    }
//                }
//                System.out.println("nhap hang san xuat");
//                String hangSanXuatXeMay = scan.nextLine();
//                xeMay.setTenHangSanXuat(hangSanXuatXeMay);
//                System.out.println("Nhap nam san xuat");
//                String namSanXuatXeMay = scan.nextLine();
//                xeMay.setNamSanXuat(namSanXuatXeMay);
//                System.out.println("Nhap chu so huu");
//                String chuSoHuuXeMay = scan.nextLine();
//                xeMay.setChuSoHuu(chuSoHuuXeMay);
//                System.out.println("Nhap cong suat xe");
//                String congSuat = scan.nextLine();
//                xeMay.setCongSuat(congSuat);
//
//                listXeMay.add(xeMay);
//                ReadWriteCSV.writeXeMayToFileCSV(listXeMay);
//                System.out.println("Them xe may thanh cong, enter de tiep tuc...");
//                scan.nextLine();
//                themMoiPhuongTien();
//                break;
//            case 4:
//                displayMainMenu();
//                break;
//            case 5:
//                System.exit(0);
//                break;
//        }
//    }
//
//}
