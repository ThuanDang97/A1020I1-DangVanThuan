package B11_DSA_Stack_Queue.BaiTap;

import java.util.Scanner;
import java.util.Stack;

public class ChuyenDoiThapPhanSangNhiPhan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so can chuyen tu thap phan sang nhi phan: ");
        int number = input.nextInt();
        Stack <Integer> integerStack = new Stack<>();
        while (number!=0){
            int n = number%2;
            integerStack.push(n);
            number/=2;
        }

        System.out.println("Result: ");
        while (!(integerStack.isEmpty())){
            System.out.print(integerStack.pop());
        }
    }


}
