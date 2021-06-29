package B2_Vong_Lap_Java.ThucHanh;

import java.util.Scanner;

public class Kiem_Tra_So_Nguyen_To {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập số để kiểm tra: ");
        int num = scanner.nextInt();
        if (num < 2) {
            System.out.println("Số " + num + " không phải là số nguyên tố!!!");

        } else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(num)) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                System.out.println(num + " is a prime");
            } else {
                System.out.println(num + " is not a prime");
            }
        }
    }

}

