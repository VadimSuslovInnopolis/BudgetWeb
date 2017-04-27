package main.services;

import main.model.dao.UserDAO;
import main.model.dao.UserDAOImpl;
import main.model.pojo.User;
import org.apache.log4j.Logger;

/**
 * Created by admin on 21.04.2017.
 */
public class UserServiceImpl implements UserService  {
 //private static final Logger Logger = Logger.getLogger(UserServiceImpl.class);

    private static UserDAO userDAO = new UserDAOImpl();

    @Override
    public User auth(String login, String password) {
        User user = userDAO.findUser(login, password);
//    logger.debug("user: " + user);

        if (user != null && user.isBlocked()) {
            return null;
        }
//       logger.debug("user not blocked");

        return user;
    }


    public User addUser(User user) {
        return userDAO.insert(user);
    }
}
