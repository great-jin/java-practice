package json.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import json.Teacher;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class JacksonTest {

    private ObjectMapper objectMapper;

    /**
     * 初始化 jackson 对象，设置相应属性
     */
    @Before
    public void Init() {
        objectMapper = new ObjectMapper();
        // 在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 在序列化时忽略值为 null 的属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 忽略值为默认值的属性
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
    }

    /**
     * Object to json string
     */
    @Test
    public void JsonTran() throws JsonProcessingException {
        Teacher teacher = new Teacher(123, "Alex", "male", new Date());
        String jsStr = objectMapper.writeValueAsString(teacher);
        System.out.println(jsStr);

        Teacher teacher1 = objectMapper.readValue(jsStr, Teacher.class);
        System.out.println(teacher1.toString());
    }

    /**
     * Jackson annotation
     */
    @Test
    public void SellDemo() throws JsonProcessingException {
        Seller seller = new Seller("123", "Alex", "male", new Date(), "China");
        String jsStr = objectMapper.writeValueAsString(seller);
        System.out.println("js result: \n" + jsStr);

        Seller seller1 = objectMapper.readValue(jsStr, Seller.class);
        System.out.println("object result: \n" + seller1);
    }

    /**
     * Json node
     */
    @Test
    public void JsNodeDemo() throws JsonProcessingException {
        Teacher teacher = new Teacher(123, "Alex", "male", new Date());
        String jsStr = objectMapper.writeValueAsString(teacher);

        JsonNode node = objectMapper.readTree(jsStr);
        System.out.println("node name: " + node.get("name"));

        Teacher teacher1 = objectMapper.treeToValue(node, Teacher.class);
        System.out.println(teacher1);
    }
}
