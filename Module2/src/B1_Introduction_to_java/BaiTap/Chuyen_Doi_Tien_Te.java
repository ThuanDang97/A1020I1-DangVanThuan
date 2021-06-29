package B1_Introduction_to_java.BaiTap;

import java.util.Scanner;

public class Chuyen_Doi_Tien_Te {
    public static void main(String[] args) {
        final int rate = 23000;
        int usd;
        int vnd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng USD cần chuyển sang VND: ");
        usd = scanner.nextInt();
        vnd = usd*rate;
        System.out.println(usd + " USD = " + vnd + " VND");
    }
}
