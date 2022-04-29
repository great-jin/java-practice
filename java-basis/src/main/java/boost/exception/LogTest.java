package boost.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

//import java.util.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

    /**
     * Level high to low:
     *
     *      SEVERE
     *      WARNING
     *      INFO
     *      CONFIG
     *      FINE
     *      FINER
     *      FINEST
     */
   /* @Test
    public void LogDemo() {
        Logger logger = Logger.getGlobal();

        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");
    }*/


    /**
     * import org.apache.commons.logging.Log;
     * import org.apache.commons.logging.LogFactory;
     *
     *      FATAL
     *      ERROR
     *      WARNING
     *      INFO
     *      DEBUG
     *      TRACE
     */

    // Use "getClass()" the child class can also use this log variable
    protected final Log log1 = LogFactory.getLog(getClass());

    @Test
    public void Log1Demo() {
        log1.info("1. start...");
        log1.warn("1. end.");

        Log log2 = LogFactory.getLog(LogTest.class);
        log2.info("2. start...");
        log2.warn("2. end.");
    }


    /**
     *
     */
    @Test
    public void Log2Demo() {
        Logger logger = LoggerFactory.getLogger(LogTest.class);

        logger.info("info ...");
        logger.warn("warn ...");
        logger.debug("error ...");
        logger.error("error ...");
    }

}
