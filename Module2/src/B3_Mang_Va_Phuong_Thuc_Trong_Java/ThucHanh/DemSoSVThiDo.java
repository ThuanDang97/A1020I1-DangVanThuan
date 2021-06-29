package B3_Mang_Va_Phuong_Thuc_Trong_Java.ThucHanh;

import java.util.Arrays;
import java.util.Scanner;

public class DemSoSVThiDo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0, n;
        System.out.print("Nhập số lượng sinh viên cần nhập điểm: ");
        n = input.nextInt();
        int[] arraySV = new int[n];
        while (n <= 30) {
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập điểm sinh viên thứ " + (i+1) + " :");
                arraySV[i] = input.nextInt();
            }
            for (int i = 0; i < arraySV.length; i++){
                if (arraySV[i] > 5 && arraySV[i] < 10){
                    count++;
                }
            }
            System.out.println("Số lượng sinh viên đỗ là: " + count);
            break;
        }
    }
}
