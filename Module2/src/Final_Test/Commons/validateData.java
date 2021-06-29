package Final_Test.Commons;

public class validateData {
    static String regex = "";

    public static boolean checkMaBenhAn(String str) {
        regex = "BA-[\\d]{3}";
        return str.matches(regex);
    }

    public static boolean checkMaBenhNhan(String str) {
        regex = "BN-[\\d]{3}";
        return str.matches(regex);
    }

    public static boolean checkDayMonthYear(String str) {
        regex = "\\b(0?[1-9]|[12]\\d|3[01])[\\/\\-.](0?[1-9]|[12]\\d|3[01])[\\/\\-.](\\d{2}|\\d{4})\\b";
        return str.matches(regex);
    }

    public static boolean checkChiPhi(String str) {
        regex = "[1-9][\\d]+";
        return str.matches(regex);
    }
    public static boolean checkLoaiVip(String str){
        regex = "^(VIP I | VIP II | VIP III)$";
        return str.matches(regex);
    }
}
