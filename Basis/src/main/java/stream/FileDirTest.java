package stream;

import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class FileDirTest {

    private final String sourcePath = "src\\main\\resources\\user.csv";

    private final File sourceFile = new File(sourcePath);

    /**
     * File Operations
     */
    @Test
    public void FileDemo() throws IOException {
        // get file relative path
        String filePath = sourceFile.getPath();
        System.out.println("File relative path：" + filePath);

        // get file absolute path
        String absolutePath = sourceFile.getAbsolutePath();
        System.out.println("File absolute path：" + absolutePath);

        // if file doesn't exist, then create it
        if (!sourceFile.exists()){
            sourceFile.createNewFile();
            System.out.println("You're get into new file");
        }

        if (sourceFile.isFile()){
            System.out.println("This is a file.");
        }
    }

    /**
     * Directory Operations
     */
    @Test
    public void DirDemo(){
        // get file parent path
        File parentPath = sourceFile.getParentFile();
        System.out.println("Parent Path：" + parentPath);

        // if path doesn't exist, then create it
        if (!parentPath.exists()){
            parentPath.mkdirs();
            System.out.println("You're get into mkdirs");
        }

        if (parentPath.isDirectory()){
            System.out.println("This is a directory.");
        }
    }
}
