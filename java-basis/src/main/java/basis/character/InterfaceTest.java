package basis.character;

public class InterfaceTest {
    public static void main(String[] args) {
        // instance the object
        InterTestImpl interTest = new InterTestImpl();

        int sum = interTest.AddElem(10, 20);
        System.out.println(sum);

        // will execute default method body
        interTest.defaultMethod();
    }
}

interface InterTest {

    int AddElem(int a, int b);

    /**
     * "default" method you can choose to override or not
     * If implement class didn't  override default method,
     * then it will cary out original content.
     */
    default void defaultMethod() {
        System.out.println("message in interface");
    }
}


/**
 * the implement class can choose not to override "default" method.
 */
class InterTestImpl implements InterTest {

    @Override
    public int AddElem(int a, int b) {
        return a + b;
    }
}
