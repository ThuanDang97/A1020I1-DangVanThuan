package B3_Mang_Va_Phuong_Thuc_Trong_Java.BaiTap;

import java.util.Arrays;
import java.util.Scanner;

public class TimGTNNTrongMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Nhập độ dài mảng: ");
        n = input.nextInt();
        int[] array = new int[n];
        for (int i =0; i<array.length; i++){
            System.out.printf("Nhập phần tử array[%d]", i);
            array[i] = input.nextInt();
        }
        System.out.println("Mảng sau khi nhập là: " + Arrays.toString(array));
        int min = array[0];
        for (int i = 1; i< array.length; i++){
            if (min > array[i]){
                min = array[i];
            }
        }
        System.out.println("GTNN trong mảng là: " + min);
    }
}
