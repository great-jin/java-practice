package basis.constrct.inter;

import basis.constrct.inter.impl.InterTestImpl;

public class MainTest {

    public static void main(String[] args) {
        InterTest interTest = new InterTestImpl();
        int sum = interTest.AddElem(10, 20);
        System.out.println(sum);
    }
}
