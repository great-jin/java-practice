package boost.annotation;

import java.lang.reflect.Field;

public class AnnotationTest {

    static class Person {
        @MyAnnotation(min = 1, max = 20)
        public String name;

        @MyAnnotation(max = 10)
        public String city;

        public Person() {
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        for (Field field : person.getClass().getFields()) {
            // 获取Field定义的@Range:
            MyAnnotation range = field.getAnnotation(MyAnnotation.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                Object value = field.get(person);
                // 如果值是String:
                if (value instanceof String) {
                    String s = (String) value;
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }
}
