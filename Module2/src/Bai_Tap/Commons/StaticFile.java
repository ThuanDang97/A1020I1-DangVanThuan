package Bai_Tap.Commons;

import Bai_Tap.Models.Oto;
import Bai_Tap.Models.XeMay;
import Bai_Tap.Models.XeTai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaticFile {
    public static final Scanner input = new Scanner(System.in);
    public static boolean check;
    public static final String COMMA = ",";
    public static int choose;
    public static String regex = "";
    public static final String FILE_NAME_HANG_SAN_XUAT = "src/Bai_Tap/Data/hangSanXuat.csv";
    public static final String FILE_XE_OTO = "src/Bai_Tap/Data/oto.csv";
    public static final String FILE_XE_MAY = "src/Bai_Tap/Data/xeMay.csv";
    public static final String FILE_XE_TAI = "src/Bai_Tap/Data/xeTai.csv";
    public static List<XeTai> listXeTai = new ArrayList<>();
    public static List<Oto> listXeOto = new ArrayList<>();
    public static List<XeMay> listXeMay = new ArrayList<>();
}
