package B1_Introduction_to_java.ThucHanh;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        double bmi,weight,height;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều cao: ");
        height = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Nhập cân nặng: ");
        weight = scanner.nextFloat();
        bmi = weight/Math.pow(height,2);
        System.out.println("Chỉ số BMI của bạn là: " + bmi);
        if (bmi<18.5){
            System.out.println("Underweight");
        }else if (bmi < 25.0){
            System.out.println("Normal");
        }else if (bmi < 30.0){
            System.out.println("Overweight");
        }else {
            System.out.println("Obese");
        }
    }
}
