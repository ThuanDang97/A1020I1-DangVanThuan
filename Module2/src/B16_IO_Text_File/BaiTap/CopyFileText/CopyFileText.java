package B16_IO_Text_File.BaiTap.CopyFileText;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src\\B16_IO_Text_File\\BaiTap\\abc.csv")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src\\B16_IO_Text_File\\BaiTap\\xyz.csv"),true));
        String line;
        while ((line = bufferedReader.readLine())!=null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
