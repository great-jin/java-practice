package basis.constrct.inter;

public interface InterTest {

    int AddElem(int a, int b);

    /**
     * 默认方法实现类可以选择性实现，可以实现也可以不实现
     */
    default void test() {
    }
}
