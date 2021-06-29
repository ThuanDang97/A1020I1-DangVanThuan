package B2_Vong_Lap_Java.BaiTap;

import java.util.Scanner;

public class Hien_Thi_Cac_Hinh {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles rectangle");
        System.out.println("4. Exit");
        System.out.println("You choice: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                for (int i = 0; i < 3; i++) {
                    System.out.println("* * * * * *");
                }
                break;
            case 2:
                for (int i = 1; i <= 5; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
                System.out.println("");
                for (int i = 5; i >= 1; i--){
                    for (int j = 1; j <= i; j++){
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
                break;
            case 3:
                for(int i=1;i<=5;i++)
                {
                    for(int j=i;j<=5;j++)
                    {
                        System.out.print(" ");
                    }
                    for(int j=1;j<=i;j++)
                    {
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
                break;
            default:
                break;
        }
    }
}
