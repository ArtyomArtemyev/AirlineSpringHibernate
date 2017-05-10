package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.dao.UserDao;
import by.netcracker.artemyev.entity.impl.Role;
import by.netcracker.artemyev.entity.impl.User;
import by.netcracker.artemyev.enumeration.RoleType;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.GenericService;
import by.netcracker.artemyev.service.UserService;
import by.netcracker.artemyev.util.UserRoleChecker;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl extends GenericService<User> implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public String checkUser(String userLogin, String userPassword) throws ServiceException {
        String namePage = "errorAuthorization";
        List<User> userList;
        try {
           userList = userDao.getByLoginAndPassword(userLogin, userPassword);
        }  catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
        if(userList.size() != 0) {
            return UserRoleChecker.defineUserPage(userList.get(0));
        }
        return namePage;
    }

    @Override
    public void addUser(String userLogin, String userPassword, String userMail) throws ServiceException {
        Role role = new Role(0, RoleType.USER);
        User user = new User(0, userLogin, userPassword, userMail, role);
        add(user);
    }

}
