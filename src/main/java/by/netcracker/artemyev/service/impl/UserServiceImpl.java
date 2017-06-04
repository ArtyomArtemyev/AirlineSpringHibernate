package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.dao.UserDao;
import by.netcracker.artemyev.entity.impl.Role;
import by.netcracker.artemyev.entity.impl.User;
import by.netcracker.artemyev.enumeration.RoleType;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.GenericService;
import by.netcracker.artemyev.service.MailService;
import by.netcracker.artemyev.service.RoleService;
import by.netcracker.artemyev.service.UserService;
import by.netcracker.artemyev.util.Definer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @autor Artemyev Artoym
 */
@Service
public class UserServiceImpl extends GenericService<User> implements UserService {
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MailService mailService;

    @Transactional
    @Override
    public String checkUser(String userLogin, String userPassword, HttpSession httpSession) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_CHECK_USER);
        String namePage = Page.ERROR_AUTHORIZATION;
        List<User> userList;
        try {
           userList = userDao.getByLoginAndPassword(userLogin,String.valueOf(userPassword.hashCode()));
        }  catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
        if(userList.size() != 0) {
            httpSession.setAttribute("user", userList.get(0));
            return Definer.defineUserPage(userList.get(0));
        }
        return namePage;
    }

    @Transactional
    @Override
    public void createUser(String userLogin, String userPassword, String userMail) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_ADD_USER);
        Role role = getUserRole();
        User user = new User(userLogin, String.valueOf(userPassword.hashCode()), userMail, role);
        this.add(user);
        mailService.sendMail(userMail);
    }

    @Override
    public Long getByLoginAndPassword(String userLogin, String userPassword) throws ServiceException {
        Long idUser = 0L;
        List<User> userList;
        try {
            userList = userDao.getByLoginAndPassword(userLogin, String.valueOf(userPassword.hashCode()));
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
        if(userList.size() != 0) {
            idUser = userList.get(0).getId();
        }
        return idUser;
    }

    private Role getUserRole() throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_GET_USER_ROLE);
        Role userRole = null;
        Long idRoleUser = 0L;
        List<Role> roleList = roleService.getAll();
        idRoleUser = getRoleUserId(roleList);
        if(idRoleUser == 0L) {
            Role role = new Role(RoleType.USER);
            roleService.add(role);
            List<Role> roleList2 = roleService.getAll();
            idRoleUser = getRoleUserId(roleList2);
        }
        userRole = roleService.getById(idRoleUser);
        return userRole;
    }

    private Long getRoleUserId(List<Role> roleList) {
        logger.debug(LoggingName.SERVICE_FUNCTION_GET_USER_ROLE_ID);
        Long idRoleUser = 0L;
        for(int i = 0; i < roleList.size(); i++) {
            if(roleList.get(i).getRoleType() == RoleType.USER) {
                idRoleUser = roleList.get(i).getId();
                break;
            }
        }
        return idRoleUser;
    }

}
