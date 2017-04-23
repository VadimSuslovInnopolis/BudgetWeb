package main.model.dao;

import main.model.pojo.User;

/**
 * Created by admin on 21.04.2017.
 */
public interface UserDAO {

        User findUser(String login, String password);

}
