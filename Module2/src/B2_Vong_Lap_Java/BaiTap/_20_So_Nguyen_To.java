package B2_Vong_Lap_Java.BaiTap;

import java.util.Scanner;

public class _20_So_Nguyen_To {
    public static void main(String[] args) {
        int count = 0;
        int num = 2;
        String ketqua = "";
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần hiển thị: ");
        number = scanner.nextInt();
        while (count < number) {
            boolean check = true;
            for (int i = 2; i < num; i++) {
                if (num%i==0){
                    check = false;
                    break;
                }
            }
            if (check){
                ketqua += num + ", ";
                count++;
            }
            num++;
        }
        System.out.println(ketqua);
    }
}
