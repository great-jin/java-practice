package files.source;

import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DireLoopTest {

    private final String path = "src\\main\\resources\\loop";
    private final List<String> directoryList = new ArrayList<>();

    @Test
    public void LoopDemo() {
        LoopDirectory(path);
        System.out.println(directoryList);
    }

    public List<String> LoopDirectory(String name) {
        File file = new File(name);
        // 获取路径下所有文件对象
        File files[] = file.listFiles();

        String directoryName = null;

        for (File f : files) {
            if (f.isDirectory()) {
                if ("/".equals(name)) {
                    directoryName = name + f.getName();
                } else {
                    directoryName = name + "/" + f.getName();
                }

                // 递归遍历文件夹
                LoopDirectory(directoryName);
                directoryList.add(directoryName);
            }
        }

        return directoryList;
    }

}
