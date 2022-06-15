package basis.collection;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    /**
     * Extends from "Hashtable"
     */
    @Test
    public void Demo() {
        Properties prop = new Properties();
        prop.put("key1", "value1");
        prop.put("key2", "value2");

        prop.setProperty("key3", "value3");
        prop.setProperty("key4", "value4");
        prop.setProperty("key5", "value5");

        System.out.println(prop);
    }

    @Test
    public void PropUtils() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("key3", "value3");
        prop.setProperty("key4", "value4");
        prop.setProperty("key5", "value5");

        prop.storeToXML(new FileOutputStream("src\\main\\resources\\test.xml"),
                "数据库配置文件",
                "GBK");
    }
}
