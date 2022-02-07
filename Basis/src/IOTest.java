import java.io.*;

public class IOTest {
    public static void main(String[] args){
//        FileDemo();

        WriteFileDemo();

    }

    private static void FileDemo(){
        // The file path: ./Files/test.csv
        File file = new File(".\\Files\\test.csv");
        if (file.isFile()) {
            // put io operations in try() than you don't have to carry out "close()" function
            // the FileInputStream or FileOutputStream only can read the byte stream, it can't read the normal date.
            try(FileInputStream fis = new FileInputStream(file)) {
                int ch;
                // visit to the last char return -1
                // read(): read a byte than return it
                while ((ch = fis.read()) != -1) {
                    // output one byte
                    System.out.write(ch);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File don't exist！");
        }
    }

    private static void WriteFileDemo(){
        //要写入的数据
        String jsonStr = "This is a test";
        //存放位置，已存在则覆盖
        File f = new File(".\\Files\\test.json");
        //将数据写入.json文件
        try (BufferedWriter writer =
                     new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(f,false), "UTF-8")) ) {
            writer.write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
