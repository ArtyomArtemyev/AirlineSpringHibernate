package by.netcracker.artemyev.util;

import by.netcracker.artemyev.constant.LoggingName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class describes checker function for different data
 * @autor Artemyev Artoym
 */
public final class DataChecker {
    private static Logger logger = LogManager.getLogger(DataChecker.class.getName());
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean validateUserData(String userLogin, String userPassword, String userMail) {
        logger.debug(LoggingName.FUNCTION_VALIDATE_USER_DATA);
        boolean isValidateData = false;
        if(userLogin != null && userPassword != null && userMail != null) {
            if (userLogin.length() <= 100 && userPassword.length() <= 100 && userMail.length() <= 100) {
                boolean isUserMailValidate = false;
                pattern = Pattern.compile(EMAIL_PATTERN);
                matcher = pattern.matcher(userMail);
                isUserMailValidate = matcher.matches();
                if (isUserMailValidate) {
                    isValidateData = true;
                }
            }
        }
        return isValidateData;
    }

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

}
