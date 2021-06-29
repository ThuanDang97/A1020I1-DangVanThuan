//package BaiTapThem.Common;
//
//import BaiTapThem.Model.Oto;
//import BaiTapThem.Model.Xe;
//import BaiTapThem.Model.XeMay;
//import BaiTapThem.Model.XeTai;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//
//public class ReadWriteCSV {
//public static final ReadWriteCSV readwrite = new ReadWriteCSV();
//    //-------------Xe tai------------------
//    private static final String COMMA = ",";
//    private static final String NEW_LINE = "\n";
//    private static final String fileNameXeTai = "BaiTapThem\\Data\\XeTai.csv";
//    private static final String FILE_HEAD_XETAI = "Bien Kiem Soat, Ten Hang San Xuat, " +
//            "Nam San Xuat, Chu So Huu, Trong Tai";
//
//    //xoa xe tai bang cach gi de
//    public static void writeXeTaiToFileCSV(ArrayList<XeTai> listXeTai, boolean append) {
//        FileWriter fileWrite = null;
//        StringBuilder dataInput = new StringBuilder();
//        for (XeTai xeTai : listXeTai){
//            dataInput.append(xeTai.dataWriteFile()).append("\n");
//        }
//        try {
//             fileWrite = new FileWriter(fileNameXeTai, false);
//             if (!append){
//                 fileWrite.write(FILE_HEAD_XETAI);
//                 fileWrite.append(NEW_LINE);
//             }
//             fileWrite.append(dataInput);
//        } catch (Exception ex) {
//            System.out.println("erro in csv file write");
//        } finally {
//            try {
//                fileWrite.flush();
//                fileWrite.close();
//            } catch (Exception ex) {
//                System.out.println("erro when flush or close");
//            }
//        }
//    }
//
//    //them moi xe tai
//    public static void writeXeTaiToFileCSV(ArrayList<XeTai> listXeTai) {
//        FileWriter fileWrite = null;
//        try {
//            fileWrite = new FileWriter(fileNameXeTai);
//            fileWrite.append(FILE_HEAD_XETAI);
//            fileWrite.append(NEW_LINE);
//            for (XeTai xeTai : listXeTai) {
//                fileWrite.append(xeTai.getBienSo());
//                fileWrite.append(COMMA);
//                fileWrite.append(xeTai.getTenHangSanXuat());
//                fileWrite.append(COMMA);
//                fileWrite.append(xeTai.getNamSanXuat());
//                fileWrite.append(COMMA);
//                fileWrite.append(xeTai.getChuSoHuu());
//                fileWrite.append(COMMA);
//                fileWrite.append(xeTai.getTrongTai());
//                fileWrite.append(NEW_LINE);
//            }
//        } catch (Exception ex) {
//            System.out.println("erro in csv file write");
//        } finally {
//            try {
//                fileWrite.flush();
//                fileWrite.close();
//            } catch (Exception ex) {
//                System.out.println("erro when flush or close");
//            }
//        }
//    }
//
//    //hien thi xe tai
//
//    public static ArrayList<XeTai> getFileXeTaiCSV() {
//        BufferedReader br = null;
//        ArrayList<XeTai> listXeTai = new ArrayList<>();
//        Path path = Paths.get(fileNameXeTai);
//        if (!Files.exists(path)) {
//            try {
//                Writer writer = new FileWriter(fileNameXeTai);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        try {
//            String line;
//            br = new BufferedReader(new FileReader(fileNameXeTai));
//
//            while ((line = br.readLine()) != null) {
//                String[] splitData = line.split(",");
//                if (splitData[0].equals("Bien Kiem Soat")) {
//                    continue;
//                }
//                XeTai xeTai = new XeTai();
//                xeTai.setBienSo(splitData[0]);
//                xeTai.setTenHangSanXuat(splitData[1]);
//                xeTai.setNamSanXuat(splitData[2]);
//                xeTai.setChuSoHuu(splitData[3]);
//                xeTai.setTrongTai(splitData[4]);
//
//                listXeTai.add(xeTai);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                br.close();
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return listXeTai;
//    }
//    // ------------- end xe tai -------------------
//
//
//    // ------------- Oto -------------------
//    private static final String fileNameOto = "BaiTapThem\\Data\\Oto.csv";
//    private static final String FILE_HEAD_OTO = "Bien Kiem Soat, Ten Hang San Xuat, " +
//            "Nam San Xuat, Chu So Huu, So Cho Ngoi, Kieu Xe";
//
//    //xoa o to bang cach ghi de
//
//    public static void writeOtoToFileCSV(ArrayList<Oto> listOto, boolean append) {
//        FileWriter fileWrite = null;
//        StringBuilder dataInput = new StringBuilder();
//        for (Oto oto : listOto){
//            dataInput.append(oto.dataWriteFile()).append("\n");
//        }
//        try {
//            fileWrite = new FileWriter(fileNameOto, false);
//            if (!append){
//                fileWrite.write(FILE_HEAD_OTO);
//                fileWrite.append(NEW_LINE);
//            }
//            fileWrite.append(dataInput);
//        } catch (Exception ex) {
//            System.out.println("erro in csv file write");
//        } finally {
//            try {
//                fileWrite.flush();
//                fileWrite.close();
//            } catch (Exception ex) {
//                System.out.println("erro when flush or close");
//            }
//        }
//    }
//
//    //them moi o to
//    public static void writeOtoToFileCSV(ArrayList<Oto> listOto) {
//        FileWriter fileWrite = null;
//        try {
//            fileWrite = new FileWriter(fileNameOto);
//            fileWrite.append(FILE_HEAD_OTO);
//            fileWrite.append(NEW_LINE);
//            for (Oto oto : listOto) {
//                fileWrite.append(oto.getBienSo());
//                fileWrite.append(COMMA);
//                fileWrite.append(oto.getTenHangSanXuat());
//                fileWrite.append(COMMA);
//                fileWrite.append(oto.getNamSanXuat());
//                fileWrite.append(COMMA);
//                fileWrite.append(oto.getChuSoHuu());
//                fileWrite.append(COMMA);
//                fileWrite.append(oto.getSoChoNgoi());
//                fileWrite.append(COMMA);
//                fileWrite.append(oto.getKieuXe());
//                fileWrite.append(NEW_LINE);
//            }
//        } catch (Exception ex) {
//            System.out.println("erro in csv file write");
//        } finally {
//            try {
//                fileWrite.flush();
//                fileWrite.close();
//            } catch (Exception ex) {
//                System.out.println("erro when flush or close");
//            }
//        }
//    }
//
//    // hien thi o to
//    public static ArrayList<Oto> getFileOtoCSV() {
//        BufferedReader br = null;
//        ArrayList<Oto> listOto = new ArrayList<>();
//        Path path = Paths.get(fileNameOto);
//        if (!Files.exists(path)) {
//            try {
//                Writer writer = new FileWriter(fileNameOto);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        try {
//            String line;
//            br = new BufferedReader(new FileReader(fileNameOto));
//
//            while ((line = br.readLine()) != null) {
//                String[] splitData = line.split(",");
//                if (splitData[0].equals("Bien Kiem Soat")) {
//                    continue;
//                }
//                Oto oto = new Oto();
//                oto.setBienSo(splitData[0]);
//                oto.setTenHangSanXuat(splitData[1]);
//                oto.setNamSanXuat(splitData[2]);
//                oto.setChuSoHuu(splitData[3]);
//                oto.setSoChoNgoi(splitData[4]);
//                oto.setKieuXe(splitData[5]);
//
//                listOto.add(oto);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                br.close();
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return listOto;
//    }
//    // ------------- end oto -------------------
//
//    // ------------- Xe May -------------------
//    private static final String fileNameXeMay = "BaiTapThem\\Data\\XeMay.csv";
//    private static final String FILE_HEAD_XEMAY = "Bien Kiem Soat, Ten Hang San Xuat, " +
//            "Nam San Xuat, Chu So Huu, Cong Suat";
//    //them moi xe may
//
//    public static void writeXeMayToFileCSV(ArrayList<XeMay> listXeMay) {
//        FileWriter fileWrite = null;
//        try {
//            fileWrite = new FileWriter(fileNameXeMay);
//            fileWrite.append(FILE_HEAD_XEMAY);
//            fileWrite.append(NEW_LINE);
//            for (XeMay xeMay : listXeMay) {
//                fileWrite.append(xeMay.getBienSo());
//                fileWrite.append(COMMA);
//                fileWrite.append(xeMay.getTenHangSanXuat());
//                fileWrite.append(COMMA);
//                fileWrite.append(xeMay.getNamSanXuat());
//                fileWrite.append(COMMA);
//                fileWrite.append(xeMay.getChuSoHuu());
//                fileWrite.append(COMMA);
//                fileWrite.append(xeMay.getCongSuat());
//                fileWrite.append(NEW_LINE);
//            }
//        } catch (Exception ex) {
//            System.out.println("erro in csv file write");
//        } finally {
//            try {
//                fileWrite.flush();
//                fileWrite.close();
//            } catch (Exception ex) {
//                System.out.println("erro when flush or close");
//            }
//        }
//    }
//
//// xoa xe may bang cach ghi de
//    public static void writeXeMayToFileCSV(ArrayList<XeMay> listXeMay, boolean append) {
//        FileWriter fileWrite = null;
//        StringBuilder dataInput = new StringBuilder();
//        for (XeMay xeMay : listXeMay){
//            dataInput.append(xeMay.dataWriteFile()).append("\n");
//        }
//        try {
//            fileWrite = new FileWriter(fileNameXeMay);
//            fileWrite = new FileWriter(fileNameXeTai, false);
//            if (!append){
//                fileWrite.write(FILE_HEAD_XETAI);
//                fileWrite.append(NEW_LINE);
//            }
//            fileWrite.append(dataInput);
//        } catch (Exception ex) {
//            System.out.println("erro in csv file write");
//        } finally {
//            try {
//                fileWrite.flush();
//                fileWrite.close();
//            } catch (Exception ex) {
//                System.out.println("erro when flush or close");
//            }
//        }
//    }
//
//    public static ArrayList<XeMay> getFileXeMayCSV() {
//        BufferedReader br = null;
//        ArrayList<XeMay> listXeMay = new ArrayList<>();
//        Path path = Paths.get(fileNameXeMay);
//        if (!Files.exists(path)) {
//            try {
//                Writer writer = new FileWriter(fileNameXeMay);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        try {
//            String line;
//            br = new BufferedReader(new FileReader(fileNameXeMay));
//
//            while ((line = br.readLine()) != null) {
//                String[] splitData = line.split(",");
//                if (splitData[0].equals("Bien Kiem Soat")) {
//                    continue;
//                }
//                XeMay xeMay = new XeMay();
//                xeMay.setBienSo(splitData[0]);
//                xeMay.setTenHangSanXuat(splitData[1]);
//                xeMay.setNamSanXuat(splitData[2]);
//                xeMay.setChuSoHuu(splitData[3]);
//                xeMay.setCongSuat(splitData[4]);
//
//                listXeMay.add(xeMay);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                br.close();
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return listXeMay;
//    }
//
//
//
//    // ------------- end xe may -------------------
//}
