package by.netcracker.artemyev.util;

import by.netcracker.artemyev.constant.LoggingName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class describes function for checking different data
 *
 * @autor Artemyev Artoym
 */
public final class DataChecker {
    private static Logger logger = LogManager.getLogger(DataChecker.class);
    private final static String LOGIN_ADMIN = "admin";
    private final static String LOGIN_DISPATCHER = "dispatcher";
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Validates entered user data
     *
     * @param userLogin - entered login
     * @param userPassword - entered password
     * @param userMail - entered mail
     * @return - if data is validate return true, else return false
     */
    public static boolean validateUserData(String userLogin, String userPassword, String userMail) {
        logger.debug(LoggingName.FUNCTION_VALIDATE_USER_DATA);
        boolean isValidateData = false;
        if(userLogin != null && userPassword != null && userMail != null) {
            if (userLogin.length() <= 100 && userPassword.length() <= 100 && userMail.length() <= 100) {
                if(!userLogin.equals(LOGIN_ADMIN) || userLogin.equals(LOGIN_DISPATCHER)) {
                    boolean isUserMailValidate = false;
                    pattern = Pattern.compile(EMAIL_PATTERN);
                    matcher = pattern.matcher(userMail);
                    isUserMailValidate = matcher.matches();
                    if (isUserMailValidate) {
                        isValidateData = true;
                    }
                }
            }
        }
        return isValidateData;
    }

    /**
     * Validates entered user data
     *
     * @param userLogin - entered login
     * @param userPassword - entered password
     * @return - if data is validate return true, else return false
     */
    public static boolean validateUserData(String userLogin, String userPassword) {
        logger.debug(LoggingName.FUNCTION_VALIDATE_USER_DATA);
        boolean isValidateData = false;
        if(userLogin != null && userPassword != null) {
            if(userLogin.length() <= 100 && userPassword.length() <= 100) {
                isValidateData = true;
            }
        }
        return isValidateData;
    }

    /**
     * Checks entered user data
     *
     * @param userData - entered login
     * @return - if data is validate return true, else return false
     */
    public static boolean checkUserData(String userData) {
        logger.debug(LoggingName.FUNCTION_VALIDATE_USER_DATA);
        boolean isValidateData = false;
        if(userData != null) {
            if(userData.length() > 0) {
                isValidateData = true;
            }
        }
        return isValidateData;
    }

}
