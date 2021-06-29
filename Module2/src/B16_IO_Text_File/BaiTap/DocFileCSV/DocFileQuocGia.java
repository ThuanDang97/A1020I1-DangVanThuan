package B16_IO_Text_File.BaiTap.DocFileCSV;

import java.io.*;

public class DocFileQuocGia {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(new File("src\\B16_IO_Text_File\\BaiTap\\DocFileCSV\\QuocGia.csv")));
            String[] arrayQuocGia;
            String line;
            while ((line = bufferedReader.readLine()) != null){
                line.split(",");
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
