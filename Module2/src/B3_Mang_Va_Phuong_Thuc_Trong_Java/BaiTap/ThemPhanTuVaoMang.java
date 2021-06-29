package B3_Mang_Va_Phuong_Thuc_Trong_Java.BaiTap;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = {1,2,4,5,6};
        int number, index, temp;
        System.out.println("Nhap so can chen: ");
        number = input.nextInt();
        System.out.println("Nhap vi tri can chen trong mang: ");
        index = input.nextInt();
        int[] arr2 = Arrays.copyOf(arr, arr.length +1);
        System.out.println("Mang truoc khi them phan tu: ");
        System.out.println(Arrays.toString(arr2));
        for (int i = arr2.length -1 ; i > index; i--){
            arr2[i] = arr2[i-1];
        }
        arr2[index] = number;
        System.out.println("Mang sau khi da them phan tu: ");
        System.out.println(Arrays.toString(arr2));
//    i = 5; arr2[5] = arr2[4]
    }
}