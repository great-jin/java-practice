package thread.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    @Test
    public void AtomicDemo() {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger);
        atomicInteger.set(2);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.get() == 2);

        System.out.println("-----------------------");

        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        System.out.println(atomicInteger);
        atomicBoolean.set(true);
        System.out.println(atomicInteger);
    }

}
