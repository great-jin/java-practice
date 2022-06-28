package basis.exception.log;

import org.junit.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {

    /**
     * The Java basis log
     *
     * Use "getClass()" the child class can also use this log variable
     */
    @Test
    public void LogDemo() {
        Log log1 = LogFactory.getLog(getClass());
        log1.info("1. start...");
        log1.warn("1. end.");

        Log log2 = LogFactory.getLog(Log4jTest.class);
        log2.info("2. start...");
        log2.warn("2. end.");
    }

    /**
     * Log4j plugin
     */
    @Test
    public void Log1Demo() {
        Logger logger = LoggerFactory.getLogger(Log4jTest.class);
        logger.info("info ...");
        logger.warn("warn ...");
        logger.debug("error ...");
        logger.error("error ...");
    }
}
