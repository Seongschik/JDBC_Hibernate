package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;
import java.util.Set;

import static jm.task.core.jdbc.util.Util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoHibernateImpl connection = new UserDaoHibernateImpl();

        connection.createUsersTable();
        connection.saveUser("Phrodo", "Kan", (byte) 27);
        connection.saveUser("Kimnick", "Kim", (byte) 31);
        connection.saveUser("Seka", "Se", (byte) 25);
        connection.saveUser("Seongschik", "Jeon", (byte) 30);
        connection.getAllUsers();
        System.out.println(connection.getAllUsers().toString());
/*        connection.cleanUsersTable();
        connection.dropUsersTable();*/

    }
}