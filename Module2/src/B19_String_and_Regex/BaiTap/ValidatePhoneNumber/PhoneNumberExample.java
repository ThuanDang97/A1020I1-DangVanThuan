package B19_String_and_Regex.BaiTap.ValidatePhoneNumber;

public class PhoneNumberExample {

    public static boolean checkPhoneNumber ( String str){
        String regex = "[(][84][)]-[(][0][\\d]{9}[)]";
        return str.matches(regex);
    }
}