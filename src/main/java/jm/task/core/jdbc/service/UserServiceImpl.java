package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoJDBCImpl userDaoJDBCImpl;

    {
        try {
            userDaoJDBCImpl = new UserDaoJDBCImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void createUsersTable() throws SQLException {
    }

    @Override
    public void dropUsersTable() throws SQLException {
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        User user = new User(name, lastName, age);
        userDaoJDBCImpl.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        userDaoJDBCImpl.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDaoJDBCImpl.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        userDaoJDBCImpl.cleanUsersTable();
    }
}