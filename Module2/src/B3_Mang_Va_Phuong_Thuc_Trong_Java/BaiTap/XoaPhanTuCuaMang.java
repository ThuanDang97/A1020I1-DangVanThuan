package B3_Mang_Va_Phuong_Thuc_Trong_Java.BaiTap;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuCuaMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Please input number: ");
        int num = input.nextInt();
        int c;
        for (int i = c = 0; i < arr.length; i++) {
            if (num != arr[i]) {
                arr[c] = arr[i];
                c++;
            } else {
                System.out.println(num + " on location " + i);
            }
        }
        arr[arr.length - 1] = 0;
        System.out.println("New Array: ");
        System.out.println(Arrays.toString(arr));
    }
}

