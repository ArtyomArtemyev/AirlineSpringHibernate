package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.UserDao;
import by.netcracker.artemyev.entity.Role;
import by.netcracker.artemyev.entity.User;
import by.netcracker.artemyev.enumeration.RoleType;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.util.UserRoleChecker;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService extends GenericService<User> {

    private static Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

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

    public void addUser(String userLogin, String userPassword, String userMail) throws ServiceException{
        Role role = new Role(0, RoleType.USER);
        User user = new User(0, userLogin, userPassword, userMail, role);
        add(user);
    }

}
