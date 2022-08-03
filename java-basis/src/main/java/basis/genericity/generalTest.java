package basis.genericity;

import bean.User;
import org.junit.Test;

public class generalTest {

    @Test
    public void Demo1() {
        GTest<User> gTest = new GTest<>(new User("Alex",12),
                new User("Beth",23));

        System.out.println(gTest.getFirst().toString());
    }

}
