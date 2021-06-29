package B1_Introduction_to_java.BaiTap;

import java.util.Scanner;

public class Hello_Name {
    public static void main(String[] args) {

        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Name: ");
        name = scanner.nextLine();
        System.out.println("Hello " + name);
    }
}
