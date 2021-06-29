package B19_String_and_Regex.BaiTap.ValidatePhoneNumber;

import B19_String_and_Regex.BaiTap.ValidateNameClass.NameClassExample;

import java.util.Scanner;

public class PhoneNumberExampleTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input Phone Number check: ");
        String phoneNumberInput = input.nextLine();
        System.err.println(phoneNumberInput + " : " + PhoneNumberExample.checkPhoneNumber(phoneNumberInput));
    }
}
