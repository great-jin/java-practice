import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args){
        // the local file path: E:\TEMP\CSV\1.csv
        File file = new File("E:\\TEMP\\CSV\\1.csv");
        if (file.isFile()) {
            try(FileInputStream fis = new FileInputStream(file)) {
                int ch;
                while ((ch = fis.read()) != -1) {
                    System.out.write(ch);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件不存在！");
        }
    }
}