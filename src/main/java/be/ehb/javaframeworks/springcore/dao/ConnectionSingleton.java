package be.ehb.javaframeworks.springcore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static be.ehb.javaframeworks.springcore.dao.DatabaseProperties.*;

class ConnectionSingleton {

    private static Connection connection;

    private ConnectionSingleton() {

    }

    static synchronized Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        }

        connection = DriverManager.getConnection(URL + '/' + USERNAME, USERNAME, PASSWORD);
        return connection;
    }
}
