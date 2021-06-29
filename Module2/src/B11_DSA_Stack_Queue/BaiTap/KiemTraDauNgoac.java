package B11_DSA_Stack_Queue.BaiTap;

import java.util.Scanner;
import java.util.Stack;

public class KiemTraDauNgoac {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập biểu thức: ");
        String bieuThuc = input.nextLine();
        Stack<String> bStack = new Stack<>();
        Stack<String> left = new Stack<>();
        boolean check = true;
        String string = "";
        for (int i = 0; i < bieuThuc.length(); i++) {
            String sym = bieuThuc.substring(i, (i + 1));
            if (sym.equals("(")) {
                bStack.push(sym);
            }
            if (sym.equals(")")) {
                if (bStack.isEmpty() || string.equals(")")) {
                    System.out.println("Ngoặc không đúng.");
                    check = false;
                    break;
                } else {
                    left.push(sym);
                }
            }
            string = sym;
        }
        if (check) {
            if (bStack.size() == left.size()) {
                System.out.println("Ngoặc trong biểu thức đúng!!!");
            } else {
                System.out.println("Ngoặc trong biểu thức sai!!!");
            }
        }
    }
}
