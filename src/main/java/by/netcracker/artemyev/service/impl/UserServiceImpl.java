package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.dao.RoleDao;
import by.netcracker.artemyev.dao.UserDao;
import by.netcracker.artemyev.entity.impl.Role;
import by.netcracker.artemyev.entity.impl.User;
import by.netcracker.artemyev.enumeration.RoleType;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.GenericService;
import by.netcracker.artemyev.service.MailService;
import by.netcracker.artemyev.service.UserService;
import by.netcracker.artemyev.util.UserRoleChecker;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
@Service
public class UserServiceImpl extends GenericService<User> implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    public static final String TOPIC_REGISTRATION = "REGISTRATION";
    public static final String NOTIFICATION_MESSAGE = "Thank you for registration";

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private MailService mailService;

    @Transactional
    @Override
    public String checkUser(String userLogin, String userPassword) throws ServiceException {
        String namePage = "errorAuthorization";
        List<User> userList;
        try {
           userList = userDao.getByLoginAndPassword(userLogin,String.valueOf(userPassword.hashCode()));
        }  catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
        if(userList.size() != 0) {
            return UserRoleChecker.defineUserPage(userList.get(0));
        }
        return namePage;
    }

    @Transactional
    @Override
    public void addUser(String userLogin, String userPassword, String userMail) throws ServiceException {
        Role role = new Role(RoleType.USER);
        roleDao.add(role);
        User user = new User(userLogin, String.valueOf(userPassword.hashCode()), userMail, role);
        System.out.println(user.toString());
        this.add(user);
        mailService.sendMail(userMail,TOPIC_REGISTRATION,NOTIFICATION_MESSAGE);
    }

}
