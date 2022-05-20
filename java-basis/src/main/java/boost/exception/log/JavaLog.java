package boost.exception.log;

import org.junit.Test;
import java.util.logging.Logger;

public class JavaLog {

    /**
     * Level high to low:
     *
     * SEVERE, WARNING, INFO,
     * CONFIG, FINE, FINER, FINEST
     */
    @Test
    public void LogDemo() {
        Logger logger = Logger.getGlobal();

        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");
    }
}
