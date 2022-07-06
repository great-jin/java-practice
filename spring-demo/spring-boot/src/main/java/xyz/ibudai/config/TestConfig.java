package xyz.ibudai.config;

import xyz.ibudai.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestConfig {

    /**
     * @Bean 未指定 name 时默认 bean 的值为方法名(首字母小写)
     * @Scope 指定 bean 作用域，默认单例模式 singleton
     * singleton	在 spring IoC 容器仅存在一个 Bean 实例，Bean 以单例方式存在，bean 作用域范围的默认值。
     * prototype	每次从容器中调用 Bean 时，都返回一个新的实例，即每次调用 getBean() 时，相当于执行 newXxxBean()。
     * request	    每次 HTTP 请求都会创建一个新的 Bean，该作用域仅适用于 web 的 Spring WebApplicationContext 环境。
     * session	    同一个 HTTP Session 共享一个 Bean，不同 Session 使用不同的 Bean。该作用域仅适用于 web 的 Spring WebApplicationContext 环境。
     * application	限定一个 Bean 的作用域为 ServletContext 的生命周期。该作用域仅适用于 web 的 Spring WebApplicationContext 环境。
     */
    @Bean(name = "user")
    @Scope("prototype")
    public User TestBean() {
        return new User();
    }
}
