package main.model.dao;

import main.model.ConnectionPool;
import main.model.pojo.User;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by admin on 21.04.2017.
 */
public class UserDAOImpl implements UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    public Collection<User> getAll() {
        throw new NotImplementedException();
    }

    public User getById(Long id) {
        throw new NotImplementedException();
    }

    public Long insert(User entity) {
        throw new NotImplementedException();
    }

    public void update(User entity) {
        throw new NotImplementedException();
    }

    public void delete(User entity) {
        throw new NotImplementedException();
    }


    public User findUser(String login, String password) {
        User user = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?")) {

            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getLong("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("admin"));
            }

            logger.debug("user " + user);
        } catch (SQLException e) {
            logger.error(e);
            e.printStackTrace();
        }

        return user;
    }
}
