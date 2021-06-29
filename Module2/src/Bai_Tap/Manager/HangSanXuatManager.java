package Bai_Tap.Manager;

import Bai_Tap.Models.PhuongTien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static Bai_Tap.Commons.StaticFile.*;

public class HangSanXuatManager {

    // ----------------- Read & Get Data File HSX ---------------- //
    public static void hangSX(PhuongTien phuongtien){
        try {
            List<String> listHSX = new ArrayList<>();
            BufferedReader bufferedReader= new BufferedReader(new FileReader(new File(FILE_NAME_HANG_SAN_XUAT)));
            String line;
            System.out.println("Vui lòng chọn 1 nhà sản xuất: ");
            while ((line = bufferedReader.readLine()) != null){
                line.split(",");
                System.out.println(line);
                listHSX.add(line);
            }
            choose = input.nextInt();
            input.nextLine();
            for (int i =0; i <listHSX.size();){
                String[] name = listHSX.get(choose - 1).split(",");
                phuongtien.setTenHangSX(name[1]);
                break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
