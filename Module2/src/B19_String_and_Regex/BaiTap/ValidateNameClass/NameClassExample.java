package B19_String_and_Regex.BaiTap.ValidateNameClass;

public class NameClassExample {
    private static String regex;

    public static boolean checkNameClass (String str){
        regex = "[CAP][\\d]{4}[GHIKLM]";
        return str.matches(regex);
    }
}
