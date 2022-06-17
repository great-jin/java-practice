package boost.reflection;

public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException {
        String str = "hello";
        Class cl1 = str.getClass();
        System.out.println(cl1);

        Class cl2 = Class.forName("java.lang.String");
        System.out.println(cl2);

        Class cl3 = String.class;
        System.out.println(cl3);
    }
}
