package stream;

import org.junit.Test;

import java.io.*;

public class FileIOTest {

    @Test
    public void FileInputDemo(){
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
    public void FileOutputDemo(){
        String jsonStr = "{\"message\": \"This is a test\"}";

        // the target file path, exists than replace
        File file = new File("src/main/resources/test.js");

        // write date
        try (BufferedWriter writer =
                     new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(file,false), "UTF-8")) ) {
            writer.write(jsonStr);
            System.out.println("write complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
    flowFile = session.write(flowFile, out -> {
        int ch;
        while ((ch = is.read()) != -1) {
            out.write(ch);
        }
    });

    session.read(flowFile, in -> {
        try {
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .stream(in, in.available(), -1)
                    .build());
        } catch (Exception e) {
            throw new ProcessException(e);
        }
    });
    */

}
