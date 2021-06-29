package B19_String_and_Regex.BaiTap.ValidateNameClass;

import java.util.Scanner;

public class NameClassExampleTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input name class check: ");
        String nameClassInput = input.nextLine();
        System.err.println(nameClassInput + " : " + NameClassExample.checkNameClass(nameClassInput));
    }
}
