package tools.jackson;

import bean.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonTest {

    private ObjectMapper objectMapper;

    @Before
    public void Init() {
        objectMapper = new ObjectMapper();
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
     * Json node
     */
    @Test
    public void JsNodeDemo() throws JsonProcessingException {
        Teacher teacher = new Teacher(123, "Alex", "male", new Date());
        String jsStr = objectMapper.writeValueAsString(teacher);

        JsonNode node = objectMapper.readTree(jsStr);
        System.out.println("node: " + node);
        System.out.println("node name: " + node.get("name"));
    }
}
