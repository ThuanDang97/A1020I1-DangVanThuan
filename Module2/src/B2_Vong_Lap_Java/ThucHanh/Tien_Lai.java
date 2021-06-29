package B2_Vong_Lap_Java.ThucHanh;

import java.util.Scanner;

public class Tien_Lai {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double rate = 1.0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số tiền muốn gửi: ");
        money = scanner.nextDouble();

        System.out.println("Nhập số tháng muốn gửi: ");
        month = scanner.nextInt();

        System.out.println("Nhập lãi suất: ");
        rate = scanner.nextDouble();

        double total = 0;
        for(int i = 0; i < month; i++){
            total += money * (rate/100)/12 * month;
        }
        System.out.println("Số tiền lãi: " + total);
    }
}
