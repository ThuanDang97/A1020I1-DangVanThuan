package Final_Test.Manager;

import Final_Test.Models.BenhAnThuong;
import Final_Test.Models.BenhAnVip;

import static Bai_Tap.Commons.StaticFile.*;
import static Final_Test.MainController.MainControllers.displayMainMenu;
import static Final_Test.Manager.BenhAnThuongManager.themBenhAnThuong;
import static Final_Test.Manager.BenhAnThuongManager.xemBenhAnThuong;
import static Final_Test.Manager.BenhAnVipManager.themBenhAnVip;
import static Final_Test.Manager.BenhAnVipManager.xemBenhAnVip;

public class BenhAnManager {
    public static void themMoi() {
        do {
            check = true;
            System.out.println("-----Menu Thêm Bệnh Án------");
            System.out.println("1. Thêm bệnh án thường\n" +
                    "2. Thêm bệnh án VIP\n" +
                    "3. Quay Lại\n");
            System.out.println("-----------------------");
            System.out.println("Vui lòng chọn một chức năng muốn thực hiện: ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    BenhAnThuong benhAnThuong = new BenhAnThuong();
                    themBenhAnThuong(benhAnThuong);
                    break;
                case 2:
                    BenhAnVip benhAnVip = new BenhAnVip();
                    themBenhAnVip(benhAnVip);
                    break;
                case 3:
                    displayMainMenu();
                    break;
                default:
                    System.err.println("Chức năng vừa chọn không nằm trong menu, vui lòng chọn lại!!!");
                    input.nextLine();
                    themMoi();
                    break;
            }
        } while (check);
    }

    public static void xemBenhAn(){
        do {
            check = true;
            System.out.println("------Menu Xem Bệnh Án------");
            System.out.println("1. Xem bệnh án thường\n" +
                    "2. Xem bệnh án VIP\n" +
                    "3. Quay Lại\n");
            System.out.println("-----------------------");
            System.out.println("Vui lòng chọn một chức năng muốn thực hiện: ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    xemBenhAnThuong();
                    break;
                case 2:
                    xemBenhAnVip();
                    break;
                case 3:
                    displayMainMenu();
                    break;
                default:
                    System.err.println("Chức năng vừa chọn không nằm trong menu, vui lòng chọn lại!!!");
                    input.nextLine();
                    xemBenhAn();
                    break;
            }
        } while (check);
    }

    public static void xoaBenhAn(){

    }
}

