package B3_Mang_Va_Phuong_Thuc_Trong_Java.BaiTap;

import java.util.Scanner;

public class TinhTongCacSoTrongMotCot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] array = {{1,2,3,4},{5,6,7,8},{3,1,5,6}};
        System.out.println("Nhap thu tu cot can tinh tong: ");
        int number = input.nextInt();
        int sum =0;
        for(int i = number; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                sum += array[number][j];
            }
            break;
        }
        System.out.println("Tong la: " + sum);
    }
}
