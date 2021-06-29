package B11_DSA_Stack_Queue.BaiTap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KiemTraChuoiPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Character> stringQueue = new LinkedList<>();
        System.out.println("Nhập chuỗi cần kiểm tra Palindrome: ");
        String string = input.nextLine();

        for (int i = string.length()-1; i >= 0; i--) {
            stringQueue.add(string.charAt(i));
        }
        String a = "";
        int length = stringQueue.size();
        for (int i = 0; i < length; i++){
            a += stringQueue.poll();
        }
        if (string.equals(a)){
            System.out.println("Palindrome");
        }else {
            System.out.println("not Palindrome");
        }
    }
}
