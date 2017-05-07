package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.UserDao;
import by.netcracker.artemyev.entity.User;
import by.netcracker.artemyev.util.UserRoleChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserService extends GenericService<User> {

    @Autowired
    private UserDao userDAO;

    public String checkUser(String userLogin, String userPassword) {
        String namePage = "errorAuthorization";
        List<User> userList = userDAO.getByLoginAndPassword(userLogin, userPassword);
        if(userList.size() != 0) {
            return UserRoleChecker.defineUserPage(userList.get(0));
        }
        return namePage;
    }

}
