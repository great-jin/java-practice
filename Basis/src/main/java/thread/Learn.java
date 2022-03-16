package thread;

import org.junit.Test;

public class Learn {

    /**
     * 并行(parallel)：指在同一时刻，有多条指令在多个处理器上同时执行。所以无论从微观还是从宏观来看，二者都是一起执行的。
     *
     * 串行(serial)：与并行(parallel)相对应，是指的我们从事某项工作时一个步骤一个步骤的去实施。
     *
     * 并发(concurrency)：指在同一时刻只能有一条指令执行，但多个进程指令被快速的轮换执行，
     * 使得在宏观上具有多个进程同时执行的效果，但在微观上并不是同时执行的，只是把时间分成若干段，使多个进程快速交替的执行。
     */
    @Test
    public void demo(){
        System.out.println("main start...");
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("thread run...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("thread end.");
            }
        };

        thread.start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}

        System.out.println("main end...");
    }
}
