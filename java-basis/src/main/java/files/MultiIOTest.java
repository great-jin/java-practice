package files;

import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MultiIOTest {

    private final String sourcePath = "src\\main\\resources\\user.csv";

    private final File sourceFile = new File(sourcePath);

    private final String targetPath = "src\\main\\resources\\";

    /**
     * MultipartFile 是 SpringMVC 提供简化上传操作的工具类
     */
    @Test
    public void MultiFileDemo() throws IOException {
        MultipartFile multipartFile = (MultipartFile) sourceFile;
        String fileName = multipartFile.getOriginalFilename();
        String filePath = targetPath + fileName;

        File dest = new File(filePath);
        Files.copy(multipartFile.getInputStream(), dest.toPath());
    }

}
