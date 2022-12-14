package Database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static String MYSQL_URL = "jdbc:mysql://18.217.214.158:3306/splitwise";
    private static String MYSQL_USER_NAME = "root";
    private static String MYSQL_PASSWORD = "wm9qm75Q1@0b";

    private static Connection connection;

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnection.class);

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to register mysql driver", e);
        }
    }
    public static Connection getConnectionInSingleTon() {
        if(connection == null) {
            connection = createConnection(MYSQL_URL, MYSQL_USER_NAME, MYSQL_PASSWORD);
        }
        return connection;
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DatabaseConnection.class) {
                if(connection == null) {
                    connection = createConnection(MYSQL_URL, MYSQL_USER_NAME, MYSQL_PASSWORD);
                }
            }
        }
        return connection;
    }

    public static Connection getConnectionNonSingleTon() {
        Connection mySQLConnection = createConnection(MYSQL_URL, MYSQL_USER_NAME, MYSQL_PASSWORD);
        return mySQLConnection;
    }

    private static Connection createConnection(String mysqlUrl, String mysqlUserName, String mysqlPassword) {
        try {
            LOGGER.info("Creating database connection to {} and username {}", mysqlUrl, mysqlUserName);
            return DriverManager.getConnection(mysqlUrl, mysqlUserName, mysqlPassword);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create connection", e);
        }
    }

    public static void closeConnection(Connection connection){
        try{
            connection.close();
        } catch (SQLException e) {
            LOGGER.warn("SQL Exception while closing Mysql Connection {} With User {}", MYSQL_URL, MYSQL_USER_NAME, e);
        }
    }
}


