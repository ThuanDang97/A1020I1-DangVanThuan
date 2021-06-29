package Final_Test.MainController;

import static Bai_Tap.Commons.StaticFile.*;
import static Final_Test.Manager.BenhAnManager.*;

public class MainControllers {
    public static void displayMainMenu() {
        do {
            check = true;
            System.out.println("------Menu Quản Lý Bệnh Án------");
            System.out.println("1. Thêm mới\n" +
                    "2. Xóa\n" +
                    "3. Xem danh sách các bệnh án\n" +
                    "4. Thoát\n");
            System.out.println("-----------------------");
            System.out.println("Vui lòng chọn một chức năng muốn thực hiện: ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    themMoi();
                    displayMainMenu();
                    break;
                case 2:
                    xoaBenhAn();
                    displayMainMenu();
                    break;
                case 3:
                    xemBenhAn();
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
