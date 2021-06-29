package B1_Introduction_to_java.ThucHanh;

import java.util.Scanner;

public class Kiem_Tra_Nam_Nhuan {
    public static void main(String[] args) {
//        Những năm chia hết cho 4 mà không chia hết cho 100 là năm nhuận
//        Những năm chia hết cho 100 mà không chia hết cho 400 thì KHÔNG PHẢI là năm nhuận
//        Những năm chia hết đồng thời cho 100 và 400 là năm nhuận

        int year;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập năm để kiểm tra: ");
        year = scanner.nextInt();

        if(year%4==0){
            if(year%100==0&&year%400==0){
                System.out.println("Năm " + year + " là năm nhuận!!!");
            }else if (year%100==0&&year%400!=0){
                System.out.println("Năm " + year + " không phải làm năm nhuận!!!");
            }
        } else {
            System.out.println( "Năm "+ year +" không phải làm năm nhuận!!!");
        }

    }
}
