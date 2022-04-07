package basis.io;

import org.junit.Test;

import java.io.*;

public class FileIOTest {

    private final String sourcePath = "src\\main\\resources\\user.csv";
    private final String targetPath = "src\\main\\resources\\test.txt";

    /**
     * FileInputStream
     */
    @Test
    public void FileInputDemo() throws IOException {
        // put io declare in try() then it will automatically close when code finished.
        try (InputStream in = new FileInputStream(sourcePath)) {
            int ch;
            // when "read()" visit to the last character return -1
            while ((ch = in.read()) != -1) {
                System.out.write(ch);
            }
        }
    }

    /**
     * FileOutputStream
     * <p>
     * Only write byte.
     */
    @Test
    public void FileOutputDemo() throws IOException {
        final String message = "This is a message from FileOutputStream.";
        final byte[] bytes = message.getBytes();

        try (OutputStream out = new FileOutputStream(targetPath)) {
            out.write(bytes);

            System.out.println("write complete");
        }
    }

    /**
     * OutputStreamWriter
     * <p>
     * Can write entire string, and you can choose charset.
     */
    @Test
    public void FileOutputWriteDemo() {
        final String message = "This is a message from OutputStreamWriter.";

        try (OutputStream out = new FileOutputStream(targetPath);
             OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");) {
            writer.write(message);

            System.out.println("write complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private final File sourceFile = new File("src\\main\\resources\\user.csv");
    private final File targetFile = new File("src\\main\\resources\\test.txt");

    /**
     * BufferedReader
     */
    @Test
    public void BufferReadDemo() {
        if (sourceFile.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
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
     * <p>
     * Writer with caching
     */
    @Test
    public void BufferWriteDemo() {
        final String message = "This is a test.";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {
            writer.append(message);

            System.out.println("write complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
