package stream;

import org.junit.Test;
import java.io.*;

public class BufferIOTest {

    private final String sourcePath = "src\\main\\resources\\user.csv";
    private final String targetPath = "src\\main\\resources\\test.txt";

    private final File sourceFile = new File(sourcePath);
    private final File targetFile = new File(targetPath);

    /**
     * BufferedReader
     */
    @Test
    public void BufferReadDemo(){
        if (sourceFile.isFile()) {
            try(BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
                int ch;
                while ((ch = reader.read()) != -1) {
                    System.out.write(ch);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File don't exist！");
        }
    }

    /**
     * BufferedWriter
     */
    @Test
    public void BufferWriteDemo() {
        final String message = "This is a test.";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile)) ) {
            writer.write(message);
            System.out.println("write complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
