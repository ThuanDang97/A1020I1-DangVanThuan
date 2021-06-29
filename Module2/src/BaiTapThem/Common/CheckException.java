//package BaiTapThem.Common;
//
//import CaseStudy.Common.Exception.NameException;
//
//public class CheckException {
//    public static boolean checkBienSoXeTai(String str) throws NameException {
//        String regex = "^[0-9]{2}[C]{1}[-]{1}[0-9]{3}[.]{1}[0-9]{2}$";
//        if (!str.matches(regex)) {
//            throw new NameException();
//        } else {
//            return str.matches(regex);
//        }
//    }
//
//    public static boolean checkBienOto(String str) throws NameException {
//        String regex = "^[0-9]{2}[A-B]{1}[-]{1}[0-9]{3}[.]{1}[0-9]{2}$";
//        if (!str.matches(regex)) {
//            throw new NameException();
//        } else {
//            return str.matches(regex);
//        }
//    }
//
//    public static boolean checkBienXeMay(String str) throws NameException {
//        String regex = "^[0-9]{2}[A-Z]{1}[0-9]{1}[-]{1}[0-9]{3}[.]{1}[0-9]{2}$";
//        if (!str.matches(regex)) {
//            throw new NameException();
//        } else {
//            return str.matches(regex);
//        }
//    }
//}
