package Final_Test.Commons;

import Final_Test.Models.BenhAnThuong;
import Final_Test.Models.BenhAnVip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class FileUtils {
    private static final String COMMA = ",";
    private static final String FILE_NAME_BENH_AN = "src/Final_Test/Data/medical_records.csv";

    public static void writeBenhAnThuongToFileCSV(ArrayList<BenhAnThuong> listBenhAnThuong) {
        FileWriter fileWrite = null;
        try {
            fileWrite = new FileWriter(FILE_NAME_BENH_AN);
            for (BenhAnThuong benhAnThuong : listBenhAnThuong) {
                fileWrite.append(benhAnThuong.getSoThuTuBenhAn());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnThuong.getMaBenhAn());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnThuong.getMaBenhNhan());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnThuong.getTenBenhNhan());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnThuong.getNgayNhapVien());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnThuong.getNgayRaVien());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnThuong.getLyDoNhapVien());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnThuong.getPhiNamVien());
                fileWrite.append(COMMA);
            }
        } catch (Exception ex) {
            System.out.println("erro in csv file write");
        } finally {
            try {
                fileWrite.flush();
                fileWrite.close();
            } catch (Exception ex) {
                System.out.println("erro when flush or close");
            }
        }
    }

    public static void writeBenhAnVipToFileCSV(ArrayList<BenhAnVip> listBenhAnVip) {
        FileWriter fileWrite = null;
        try {
            fileWrite = new FileWriter(FILE_NAME_BENH_AN);
            for (BenhAnVip benhAnVip : listBenhAnVip) {
                fileWrite.append(benhAnVip.getSoThuTuBenhAn());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnVip.getMaBenhAn());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnVip.getMaBenhNhan());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnVip.getTenBenhNhan());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnVip.getNgayNhapVien());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnVip.getNgayRaVien());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnVip.getLyDoNhapVien());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnVip.getGoiVip());
                fileWrite.append(COMMA);
                fileWrite.append(benhAnVip.getThoiHanVip());
                fileWrite.append(COMMA);
            }
        } catch (Exception ex) {
            System.out.println("erro in csv file write");
        } finally {
            try {
                fileWrite.flush();
                fileWrite.close();
            } catch (Exception ex) {
                System.out.println("erro when flush or close");
            }
        }
    }

    public static ArrayList<BenhAnThuong> listBenhAnThuong() {
        BufferedReader br = null;
        ArrayList<BenhAnThuong> benhAnThuongArrayList = new ArrayList<>();
        try {
            String line;
            br = new BufferedReader
                    (new FileReader(FILE_NAME_BENH_AN));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[7].equals("VIP I") | splitData[7].equals("VIP II") | splitData[7].equals("VIP III")) {
                    continue;
                }
                BenhAnThuong benhAnThuong = new BenhAnThuong();
                benhAnThuong.setSoThuTuBenhAn(splitData[0]);
                benhAnThuong.setMaBenhAn(splitData[1]);
                benhAnThuong.setMaBenhNhan(splitData[2]);
                benhAnThuong.setTenBenhNhan(splitData[3]);
                benhAnThuong.setNgayNhapVien(splitData[4]);
                benhAnThuong.setNgayRaVien(splitData[5]);
                benhAnThuong.setLyDoNhapVien(splitData[6]);
                benhAnThuong.setPhiNamVien(splitData[7]);
                benhAnThuongArrayList.add(benhAnThuong);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
        return benhAnThuongArrayList;
    }

    public static ArrayList<BenhAnVip> listBenhAnVip() {
        BufferedReader br = null;
        ArrayList<BenhAnVip> benhAnVipArrayList = new ArrayList<>();
        try {
            String line;
            br = new BufferedReader
                    (new FileReader(FILE_NAME_BENH_AN));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");

                BenhAnVip benhAnVip = new BenhAnVip();
                benhAnVip.setSoThuTuBenhAn(splitData[0]);
                benhAnVip.setMaBenhAn(splitData[1]);
                benhAnVip.setMaBenhNhan(splitData[2]);
                benhAnVip.setTenBenhNhan(splitData[3]);
                benhAnVip.setNgayNhapVien(splitData[4]);
                benhAnVip.setNgayRaVien(splitData[5]);
                benhAnVip.setLyDoNhapVien(splitData[6]);
                benhAnVip.setGoiVip(splitData[7]);
                benhAnVip.setThoiHanVip(splitData[8]);
                benhAnVipArrayList.add(benhAnVip);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
        return benhAnVipArrayList;
    }

//    public static void xoaBenhAnCSV(ArrayList<BenhAnThuong> benhAnThuongArrayList, boolean append)
}
