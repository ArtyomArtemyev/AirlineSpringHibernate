package by.netcracker.artemyev.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DataChecker {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean validateUserData(String userLogin, String userPassword, String userMail) {
        boolean isValidateData = false;
        if(userLogin != null || userPassword != null && userMail != null) {
          boolean isUserMailValidate = false;
          pattern = Pattern.compile(EMAIL_PATTERN);
          matcher = pattern.matcher(userMail);
          isUserMailValidate = matcher.matches();
          if(isUserMailValidate) {
              isValidateData = true;
          }
        }
        return isValidateData;
    }

    public static boolean validateUserData(String userLogin, String userPassword) {
        boolean isValidateData = false;
        if(userLogin != null && userPassword != null) {
            isValidateData = true;
        }
        return isValidateData;
    }

}
