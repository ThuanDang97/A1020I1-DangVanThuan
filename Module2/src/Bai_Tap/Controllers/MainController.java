package Bai_Tap.Controllers;

import static Bai_Tap.Commons.StaticFile.*;
import static Bai_Tap.Manager.PhuongTienManager.*;

public class MainController {
    public static void displayMainMenu() {
        do {
            check = true;
            System.out.println("------Menu Quản Lý Phương Tiện------");
            System.out.println("1. Thêm mới phương tiện.\n" +
                    "2. Hiển thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát\n");
            System.out.println("-----------------------");
            System.out.println("Vui lòng chọn một chức năng muốn thực hiện: ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    themMoiPhuongTien();
                    displayMainMenu();
                    break;
                case 2:
                    hienThiPhuongTien();
                    displayMainMenu();
                    break;
                case 3:
                    xoaPhuongTien();
                    displayMainMenu();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Chức năng vừa chọn không nằm trong menu, vui lòng chọn lại!!!");
                    input.nextLine();
                    displayMainMenu();
                    break;
            }
        } while (check);


    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
