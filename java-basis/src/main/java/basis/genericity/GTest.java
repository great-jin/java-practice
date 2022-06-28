package basis.genericity;

/**
 * <T> can't be use for static method
 */
public class GTest<T> {

    private T first;
    private T last;

    public GTest(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }
}
