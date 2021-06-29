package B3_Mang_Va_Phuong_Thuc_Trong_Java.BaiTap;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("Please input Array1[%d]", i + 1);
            arr1[i] = input.nextInt();
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("Please input Array2[%d]", i + 1);
            arr2[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = Arrays.copyOf(arr1, arr1.length + arr2.length);
        int n = arr2.length;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = n; j < arr3.length; j++){
                arr3[n] = arr2[i];
            }
            n++;
        }

        System.out.println(Arrays.toString(arr3));
    }
}
