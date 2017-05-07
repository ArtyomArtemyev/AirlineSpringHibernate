package by.netcracker.artemyev.util;

import by.netcracker.artemyev.entity.User;

public final class UserRoleChecker {
    private static final String USER_PAGE = "userIndex";
    private static final String ADMIN_PAGE = "administratorIndex";
    private static final String DISPATCHER_PAGE = "dispatcherIndex";

    public static String defineUserPage(User user) {
        String namePage = "errorAuthorization";
        switch (user.getRole().getRoleType()) {
            case USER:
                namePage = USER_PAGE;
                break;
            case DISPATCHER:
                namePage = ADMIN_PAGE;
                break;
            case ADMINISTRATOR:
                namePage = DISPATCHER_PAGE;
                break;
        }
        return namePage;
    }
}
