package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao{
    private Connection connection;
    public UserDaoJDBCImpl() throws SQLException{
        connection = Util.connection();
    }


    public void createUsersTable() throws SQLException{
        String query = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "name VARCHAR(50) NOT NULL,"
                + "lastName VARCHAR(50) NOT NULL,"
                + "age TINYINT NOT NULL"
                + ")";
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }

    public void dropUsersTable() throws SQLException{
        String query = "DROP TABLE IF EXISTS users";
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String query = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.execute();
        }
    }

    public void removeUserById(long id) throws SQLException{
            String query = "DELETE FROM users WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setLong(1, id);
                statement.execute();
        }

    }

    public List<User> getAllUsers() throws SQLException{
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");
                userList.add(new User(id, name, lastName, age));
            }
        }
        return userList;
    }

    public void cleanUsersTable() throws SQLException{
        String query = "TRUNCATE TABLE users";
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }
    public void close() throws SQLException {
        connection.close();
    }
}
