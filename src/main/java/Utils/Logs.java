package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
    private static Logger logger;

    public static void logInfo(String info){
        logger = LogManager.getLogger();
        logger.info(info);
    }
}
