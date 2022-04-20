package basis;

import org.junit.Test;

import java.util.Properties;

public class PropertiesTest {

    /**
     * extends from "Hashtable", it's a map
     */
    @Test
    public void Demo() {
        Properties properties = new Properties();
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");
        properties.setProperty("key3", "value3");

        System.out.println(properties);
    }
}
