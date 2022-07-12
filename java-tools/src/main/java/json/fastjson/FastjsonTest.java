package json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import json.Teacher;
import org.junit.Test;

import java.util.Date;

public class FastjsonTest {

    /**
     * Object to string
     */
    @Test
    public void Demo1() {
        Teacher teacher = new Teacher(123, "Alex", "male", new Date());
        String jsStr = JSON.toJSONString(teacher);
        System.out.println(jsStr);

        JSONObject teacher1 = JSON.parseObject(jsStr);
        System.out.println(teacher1);

        Teacher teacher2 = JSON.parseObject(jsStr, new TypeReference<Teacher>() {
        });
        System.out.println(teacher2);

        Teacher teacher3 = JSON.parseObject(jsStr, Teacher.class);
        System.out.println(teacher3);
    }
}
