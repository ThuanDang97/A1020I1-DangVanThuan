package B11_DSA_Stack_Queue.BaiTap;

import java.util.Scanner;
import java.util.Stack;

public class DaoNguocPhanTuTrongStack {
    public static void main(String[] args) {

        // Stack mảng số nguyên
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử có trong mảng: ");
        int number = input.nextInt();
        input.nextLine();
        Stack<Integer> integerStack = new Stack<>();
        Stack<Integer> integerStack1 = new Stack<>();
        for (int i = 0; i < number; i++){
            System.out.println("Nhập phần thử thứ " + (i+1) + " : " );
            integerStack.push(input.nextInt());
        }
        System.out.println("Before: ");
        System.out.println(integerStack);

        for (int i = 0; i < number; i++){
            integerStack1.push(integerStack.pop());
        }

        System.out.println("After: ");
        System.out.println(integerStack1);

        // Stack chuỗi

//        Stack<String> stringStack = new Stack<>();
//        Stack<String> stringStack1 = new Stack<>();
//
//        for (int i = 0; i < number; i++) {
//            System.out.println("Nhập phần thử thứ " + (i + 1) + " : ");
//            stringStack.push(input.nextLine());
//        }
//        System.out.println("Before: ");
//        System.out.println(stringStack);
//
//        for (int i = 0; i < number; i++) {
//            stringStack1.push(stringStack.pop());
//        }
//
//        System.out.println("After: ");
//        System.out.println(stringStack1);
    }
}
