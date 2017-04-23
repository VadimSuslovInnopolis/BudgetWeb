package main.services;

import main.model.dao.UserDAO;
import main.model.dao.UserDAOImpl;
import main.model.pojo.User;

/**
 * Created by admin on 21.04.2017.
 */
public class UserServiceImpl implements UserService  {
//    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    private static UserDAO userDAO = new UserDAOImpl();

    @Override
    public User auth(String login, String password) {
        User user = userDAO.findUser(login, password);
//        logger.debug("user: " + user);

        if (user != null && user.isBlocked()) {
            return null;
        }
//        logger.debug("user not blocked");

        return user;
    }
}
