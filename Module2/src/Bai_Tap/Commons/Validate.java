package Bai_Tap.Commons;

import Bai_Tap.Commons.Exception.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static Bai_Tap.Commons.StaticFile.FILE_XE_TAI;
import static Bai_Tap.Commons.StaticFile.regex;

public class Validate {
//    private static boolean checkBKS(String str){
//            try {
//                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(FILE_XE_TAI)));
//                String line;
//                List<String> stringList = new ArrayList<>();
//                while ((line = bufferedReader.readLine()) == null){
//                    line.split(",");
//                    stringList.add(line);
//                }
//                for (int i = 0; i < stringList.size(); i++){
//                    String[] name = stringList.get(i).split(",");
//                    if (str.equals(name[1])){
//                        return true;
//                    }else {
//                        throw new BKSException();
//                    }
//                }
//            } catch (IOException | BKSException e) {
//                e.printStackTrace();
//            }
//            return true;
//    }
    public static boolean checkBKSXeTai(String str) throws BKSException {
        regex = "^[\\d]{2}C-[\\d]{3}.[\\d]{2}$";

        if (!str.matches(regex)) {
            throw new BKSException();
        } else {
            return str.matches(regex);
        }
    }

    public static boolean checkBKSOto(String str) throws BKSException {
        regex = "^[\\d]{2}[A-B]-[\\d]{3}.[\\d]{2}$";
        if (!str.matches(regex)) {
            throw new BKSException();
        } else {
            return str.matches(regex);
        }
    }

    public static boolean checkBKSXeMay(String str) throws BKSException {
        regex = "^[\\d]{2}-[A-Z][A-Z0-9]-[\\d]{3}.[\\d]{2}$";
        if (!str.matches(regex)) {
            throw new BKSException();
        } else {
            return str.matches(regex);
        }
    }

    public static boolean checkNamSX(String str) throws NSXException {
        regex = "^(19|20)[\\d]{2}$";
        if (!str.matches(regex)) {
            throw new NSXException();
        } else {
            return str.matches(regex);
        }
    }

    public static boolean checkCSH(String str) throws CSHException {
        regex = "^([A-Z][a-z ]+)+$";
        if (!str.matches(regex)) {
            throw new CSHException();
        } else {
            return str.matches(regex);
        }
    }

    public static boolean checkSCN(String str) throws SCNException {
        regex = "^[4-9]|[1-9][\\d]$";
        if (!str.matches(regex)) {
            throw new SCNException();
        } else {
            return str.matches(regex);
        }
    }

    public static boolean checkKieuXe(String str) throws KXException {
        regex = "^(du lich|xe khach)$";
        if (!str.matches(regex)) {
            throw new KXException();
        } else {
            return str.matches(regex);
        }
    }

    public static boolean checkTT(String str) throws TTException {
        regex = "^[1-9]|[1-9][\\d]$";
        if (!str.matches(regex)) {
            throw new TTException();
        } else {
            return str.matches(regex);
        }
    }

    public static boolean checkCS(String str) throws CSException {
        regex = "^(50|100|150)$";
        if (!str.matches(regex)) {
            throw new CSException();
        } else {
            return str.matches(regex);
        }
    }
}
