package basis.constrct.inter;

public class MainTest {

    public static void main(String[] args) {
        // instance the object
        InterTestImpl interTest = new InterTestImpl();

        int sum = interTest.AddElem(10, 20);
        System.out.println(sum);

        // will execute default method body
        interTest.defaultMethod();
    }
}
