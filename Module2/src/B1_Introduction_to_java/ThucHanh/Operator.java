package B1_Introduction_to_java.ThucHanh;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
//        Viết một ứng dụng để tính diện tích của hình chữ nhật dựa vào chiều rộng và chiều cao được nhập vào.

        float width;
        float height;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Width: ");
        width = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter Height: ");
        height = scanner.nextFloat();

        float area = width * height;
        System.out.println("Area is: " + area);
    }
}
