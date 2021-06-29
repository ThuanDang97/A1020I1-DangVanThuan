package Bai_Tap.Commons;

import Bai_Tap.Models.Oto;
import Bai_Tap.Models.XeMay;
import Bai_Tap.Models.XeTai;

import java.io.*;
import java.util.ArrayList;

import static Bai_Tap.Commons.StaticFile.FILE_XE_MAY;
import static Bai_Tap.Commons.StaticFile.FILE_XE_TAI;

public class FileUtils {

    // ----------------- Read Data File Xe Tai CSV ---------------- //

    public static void writeFile(String pathFile, String line) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ----------------- Read Data File Xe Tai CSV ---------------- //

    public static ArrayList<XeTai> getFileCSVToListXeTai() {
        BufferedReader br = null;
        ArrayList<XeTai> listXeTai = new ArrayList<>();
        try {
            String line;
            br = new BufferedReader
                    (new FileReader(FILE_XE_TAI));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                XeTai xeTai = new XeTai();
                xeTai.setBienKiemSoat(splitData[0]);
                xeTai.setTenHangSX(splitData[1]);
                xeTai.setNamSX(splitData[2]);
                xeTai.setChuSoHuu(splitData[3]);
                xeTai.setTrongTai(splitData[4]);
                listXeTai.add(xeTai);
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
        return listXeTai;
    }

    // ----------------- Read Data File Xe May CSV ---------------- //

    public static ArrayList<XeMay> getFileCSVToListXeMay() {
        BufferedReader br = null;
        ArrayList<XeMay> listXeMay = new ArrayList<>();
        try {
            String line;
            br = new BufferedReader
                    (new FileReader(FILE_XE_MAY));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                XeMay xeMay = new XeMay();
                xeMay.setBienKiemSoat(splitData[0]);
                xeMay.setTenHangSX(splitData[1]);
                xeMay.setNamSX(splitData[2]);
                xeMay.setChuSoHuu(splitData[3]);
                xeMay.setCongSuat(splitData[4]);
                listXeMay.add(xeMay);
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
        return listXeMay;
    }

    // ----------------- Read Data File Xe Oto CSV ---------------- //

    public static ArrayList<Oto> getFileCSVToListXeOto() {
        BufferedReader br = null;
        ArrayList<Oto> listXeOto = new ArrayList<>();
        try {
            String line;
            br = new BufferedReader
                    (new FileReader(FILE_XE_TAI));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                Oto xeOto = new Oto();
                xeOto.setBienKiemSoat(splitData[0]);
                xeOto.setTenHangSX(splitData[1]);
                xeOto.setNamSX(splitData[2]);
                xeOto.setChuSoHuu(splitData[3]);
                xeOto.setSoChoNgoi(splitData[4]);
                xeOto.setKieuXe(splitData[4]);
                listXeOto.add(xeOto);
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
        return listXeOto;
    }

    // ----------------- Delete and Writer Data File CSV ---------------- //

    public static void deleteFile(String pathFile, String line) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile, false  );
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateFileCSVXeTai(ArrayList<XeTai> xeTaiArrayList, boolean append){

    }
}
