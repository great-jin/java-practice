import org.junit.Test;

import java.io.*;

public class IOTest {

    @Test
    public void ReadDemo(){
        // The file path: ./Files/test.csv
        File file = new File("src/main/resources/user.csv");
        if (file.isFile()) {
            // put io operations in try() than you don't have to carry out "close()" function
            try(FileInputStream fis = new FileInputStream(file)) {
                int ch;
                // when visit to the last character return -1
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

    @Test
    public void WriteDemo(){
        // source data
        String jsonStr = "{\"message\": \"This is a test\"}";

        // the target file path, exists than replace
        File f = new File("src/main/resources/test.js");

        // write date
        try (BufferedWriter writer =
                     new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(f,false), "UTF-8")) ) {
            writer.write(jsonStr);
            System.out.println("write complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
