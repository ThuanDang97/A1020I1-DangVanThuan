package B14_Thuat_Toan_Sap_Xep.BaiTap;

import java.util.Arrays;

public class MinhHoaThuatToanSapXepChen {
    public static void main(String[] args) {
        int[] a = {5, 9, 1, 3, 2, 6, 7};

        for (int i = 1; i < a.length; i++) {

            int curElement = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (curElement < a[j]) {
                    a[j + 1] = a[j];
                    System.out.println(Arrays.toString(a));
                } else {
                    break;
                }
            }

            a[j + 1] = curElement;
        }

        System.out.println(Arrays.toString(a));
    }
}
