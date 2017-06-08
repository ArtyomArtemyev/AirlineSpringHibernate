package by.netcracker.artemyev.util;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.entity.impl.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class describes different function for define something data
 *
 * @autor Artemyev Artoym
 */
public final class Definer {
    private static Logger logger = LogManager.getLogger(Definer.class);

    /**
     * Defines user page depends on user role
     *
     * @param user - user for define his page
     * @return - name of page depends on user role
     */
    public static String defineUserPage(User user) {
        logger.debug(LoggingName.FUNCTION_DEFINE_USER_PAGE);
        String namePage = Page.ERROR_AUTHORIZATION;
        switch (user.getRole().getRoleType()) {
            case USER:
                namePage = Page.USER_INDEX;
                break;
            case DISPATCHER:
                namePage = Page.DISPATCHER_INDEX;
                break;
            case ADMINISTRATOR:
                namePage = Page.ADMIN_INDEX;
                break;
        }
        return namePage;
    }

}
