package boost.general;

import org.junit.Test;

public class Test1 {

    @Test
    public void Demo1() {
        GTest<User> gTest = new GTest<>(new User("Alex","123"),
                new User("Beth","123"));

        System.out.println(gTest.getFirst().toString());
    }

}

class User {
    String name;
    String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
