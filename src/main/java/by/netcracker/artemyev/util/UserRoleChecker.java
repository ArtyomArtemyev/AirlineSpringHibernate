package by.netcracker.artemyev.util;

import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.entity.impl.User;

/**
 * @autor Artemyev Artoym
 */
public final class UserRoleChecker {

    public static String defineUserPage(User user) {
        String namePage = "errorAuthorization";
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
