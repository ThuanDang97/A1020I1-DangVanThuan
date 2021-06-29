package B3_Mang_Va_Phuong_Thuc_Trong_Java.BaiTap;

import java.util.Arrays;
import java.util.Scanner;

public class DemSoLanKyTuXuatHien {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String array = "CodeGym";
        System.out.print("Nhập ký tự cần đếm trong chuỗi: ");
        char c = input.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < array.length();i++){
            if (array.charAt(i) == c){
                count++;
            }
        }
        System.out.println(count);
    }
}
