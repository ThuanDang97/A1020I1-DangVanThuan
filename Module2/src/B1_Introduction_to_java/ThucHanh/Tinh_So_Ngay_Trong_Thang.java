package B1_Introduction_to_java.ThucHanh;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Tinh_So_Ngay_Trong_Thang {
    public static void main(String[] args) {
        int month;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Plese Input Month: ");
        month = scanner.nextInt();

        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
                System.out.println("Tháng " + month + " có 31 Ngày!!!");
                break;
            case 4:
            case 6:
            case 9:
            case 12:
                System.out.println("Tháng "+month+" có 30 Ngày!!!");
                break;
            case 2:
                System.out.println("Tháng 2 có 28 hoặc 29 Ngày!!!");
                break;
            default:
                System.out.println("Vui lòng nhập đúng số tháng để kiểm tra!!!");
        }

    }
}
