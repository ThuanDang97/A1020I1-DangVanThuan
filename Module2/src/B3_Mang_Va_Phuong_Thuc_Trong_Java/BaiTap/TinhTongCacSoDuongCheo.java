package B3_Mang_Va_Phuong_Thuc_Trong_Java.BaiTap;

import java.util.Arrays;
import java.util.Scanner;

public class TinhTongCacSoDuongCheo {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
        int[][] array = {{4,7,2}, {6,4,8}, {2,4,6}};
        int sum1 = 0;
        for (int i = 0; i < array.length; i++) {
            sum1 += array[i][i];
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]);
            }
            System.out.println("");
        }
        System.out.println("Tổng hàng chéo là: " + sum1);
    }
}
