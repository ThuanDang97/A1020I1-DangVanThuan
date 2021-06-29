package B3_Mang_Va_Phuong_Thuc_Trong_Java.BaiTap;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuCuaMang1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("mang co bao nhieu phan tu");
        int a = scanner.nextInt();
        int[] arr = new int[a];

        for (int i = 0; i < a; i++) {
            System.out.println("nhap phan tu thu " + i);
            arr[i] = scanner.nextInt();
        }
        System.out.println("mang cua ban la: " + Arrays.toString(arr));

        System.out.println("nhap so can xoa");
        int num = scanner.nextInt();
        int doDaiMang = arr.length;
        for (int i = 0; i < doDaiMang; i++) {
            if (arr[i] == num) {
                for (int j = i; j < doDaiMang - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                doDaiMang--;
            }
        }
        for (int i = 0; i < doDaiMang; i++) {
            System.out.println("Mang sau khi xoa: " + arr[i]);
        }
        arr[arr.length - 1] = 0;
        System.out.println(Arrays.toString(arr));
    }
}

