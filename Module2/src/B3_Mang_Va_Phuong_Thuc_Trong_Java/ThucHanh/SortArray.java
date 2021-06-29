package B3_Mang_Va_Phuong_Thuc_Trong_Java.ThucHanh;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập độ dài của mảng: ");
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++){
            System.out.printf("Nhập phần tử Array[%d]",i);
            array[i] = input.nextInt();
        }
        System.out.println("Mảng sau khi nhập là: " + Arrays.toString(array));
        String num = "";
        for (int i = array.length-1; i >=0; i-- ){
            num += array[i] + ", ";
        }
        System.out.println("Mảng sau khi được sắp xếp là: " + num);
    }
}
