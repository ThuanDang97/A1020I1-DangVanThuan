package B3_Mang_Va_Phuong_Thuc_Trong_Java.ThucHanh;

import java.util.Scanner;

public class SearchInArray {
    public static void main(String[] args) {
        String[] classA10 = {"Thong","Thuan","Dat","Dung","Tien"};
        Scanner input = new Scanner(System.in);
        String name;
        System.out.println("Plese input name search to Class A10: ");
        name = input.nextLine();
        boolean check = false;
        int location = 0;
        for (int i = 0; i < classA10.length; i++){
            if (classA10[i].equals(name)){
                check = true;
                location += i;
                break;
            }
        }
        if (check){
            System.out.println(name + " in " + location + " to Class A10");
        }else {
            System.out.println(name + " not in the Class A10");
        }

    }


}
