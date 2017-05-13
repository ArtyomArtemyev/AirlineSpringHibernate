package by.netcracker.artemyev.util;

import by.netcracker.artemyev.constant.Page;
import org.apache.log4j.Logger;

/**
 * @autor Artemyev Artoym
 */
public class ErrorHandler {

    private static Logger logger = Logger.getLogger(ErrorHandler.class.getName());

    public static String returnErrorPage(String error, String className) {
        logger.error(className + ": " + error);
        return Page.ERROR;
    }
}
