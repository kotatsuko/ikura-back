package ikura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ikura.common.CommonEnums.Database;

public class DBUtil {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(Database.URL.getValue());
    }
}
