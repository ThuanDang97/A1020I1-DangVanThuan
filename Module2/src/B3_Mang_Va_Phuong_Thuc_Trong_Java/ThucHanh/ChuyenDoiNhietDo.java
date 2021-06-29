package B3_Mang_Va_Phuong_Thuc_Trong_Java.ThucHanh;

import java.util.Scanner;

public class ChuyenDoiNhietDo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choose = 0;
        double c = 0, f = 0;

        do {
            System.out.println("Menu: \n"+
                    "1. Fahrenheit to Celsius\n" +
                    "2. Celsius to Fahrenheit\n"+
                    "0. Exit");

            System.out.println("Please choose: ");
            choose = input.nextInt();
            switch (choose){
                case 1:
                    System.out.println("Please input f: ");
                    f = input.nextDouble();
                    c = (5.0 / 9) * (f - 32);
                    System.out.println(f + " oF = " + c + " oC");
                    break;
                case 2:
                    System.out.println("Please input c: ");
                    c = input.nextDouble();
                    f = (9.0 / 5) * c + 32;
                    System.out.println(c + " oC = " + f + " oF");
                    break;
            }
        }while (choose!=0);
    }
}
