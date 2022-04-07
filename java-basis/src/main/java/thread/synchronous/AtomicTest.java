package thread.synchronous;

import org.junit.Test;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    @Test
    public void AtomicDemo() {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.set(2);
        System.out.println("atomicInteger: " + atomicInteger);
        System.out.println("atomicInteger.get: " + atomicInteger.get());
        System.out.println("atomicInteger.get == 2: " + (atomicInteger.get() == 2));
        System.out.println("atomicInteger.incrementAndGet: " + atomicInteger.incrementAndGet());
        System.out.println("atomicInteger.decrementAndGet: " + atomicInteger.decrementAndGet());

        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        System.out.println("\natomicBoolean.origin: " + atomicBoolean);
        atomicBoolean.set(true);
        System.out.println("atomicBoolean.afterSet: " + atomicBoolean);
    }

}
