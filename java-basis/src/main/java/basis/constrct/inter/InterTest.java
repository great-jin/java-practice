package basis.constrct.inter;

public interface InterTest {

    int AddElem(int a, int b);

    /**
     * "default" method you can choose realized or not
     * If didn't implement the that will execute interface method boy content
     */
    default void defaultMethod() {
        System.out.println("message in interface");
    }
}


class InterTestImpl implements InterTest {

    @Override
    public int AddElem(int a, int b) {
        return a + b;
    }
}
