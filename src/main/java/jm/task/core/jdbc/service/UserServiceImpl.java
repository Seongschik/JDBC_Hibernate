package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {


    private UserDaoHibernateImpl UserDaoHibernateImpl = new UserDaoHibernateImpl();


    @Override
    public void createUsersTable() throws SQLException {
        UserDaoHibernateImpl.createUsersTable();
    }

    @Override
    public void dropUsersTable() throws SQLException {
        UserDaoHibernateImpl.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        UserDaoHibernateImpl.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        UserDaoHibernateImpl.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return UserDaoHibernateImpl.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        UserDaoHibernateImpl.cleanUsersTable();
    }
}