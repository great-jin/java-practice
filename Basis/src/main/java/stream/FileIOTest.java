package stream;

import org.junit.Test;

import java.io.*;

public class FileIOTest {

    private final String sourcePath = "src\\main\\resources\\user.csv";
    private final String targetPath = "src\\main\\resources\\test.txt";

    private final File sourceFile = new File(sourcePath);
    private final File targetFile = new File(targetPath);

    final String message = "This is a message.";

    /**
     * FileInputStream
     */
    @Test
    public void FileInputDemo(){
        if (sourceFile.isFile()) {
            // put io operations in try() than you don't have to carry out "close()" function
            try(InputStream is = new FileInputStream(sourceFile)) {
                int ch;
                // when "read()" visit to the last character return -1
                while ((ch = is.read()) != -1) {
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
     * FileOutputStream
     *
     * Only write byte data.
     */
    @Test
    public void FileOutputDemo(){
        final byte[] bs = message.getBytes();

        try (OutputStream out = new FileOutputStream(targetFile)) {
            out.write(bs);

            System.out.println("write complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * OutputStreamWriter
     *
     * Can write entire string, and you can set charset.
     */
    @Test
    public void FileOutputWriteDemo(){
        try (OutputStream os = new FileOutputStream(targetFile);
             OutputStreamWriter writer = new OutputStreamWriter(os, "UTF-8");) {
            writer.write(message);

            System.out.println("write complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
