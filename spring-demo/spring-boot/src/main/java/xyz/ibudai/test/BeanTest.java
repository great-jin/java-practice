package xyz.ibudai.test;

import xyz.ibudai.model.User;
import xyz.ibudai.config.TestConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {
    public static void main(String[] args) {
        /**
         * 若加载 spring-context.xml 文件：
         *
         * ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        // 获取 bean
        User user = (User) context.getBean("user");
        user.setName("Alex");
        System.out.println(user);
    }
}
