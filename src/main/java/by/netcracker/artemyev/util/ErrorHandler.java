package by.netcracker.artemyev.util;

import by.netcracker.artemyev.constant.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @autor Artemyev Artoym
 */
public class ErrorHandler {
    private static final Logger logger = LogManager.getLogger(ErrorHandler.class.getName());

    public static String returnErrorPage(String error, String className) {
        logger.error(className + ": " + error);
        return Page.ERROR;
    }

}
