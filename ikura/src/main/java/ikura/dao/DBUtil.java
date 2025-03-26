package ikura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String DB_PATH = "C:/pleiades-e4.5-java-jre_20160312/pleiades/workspace/ikura/src/main/webapp/db/ikura.db";
    private static final String DB_URL = "jdbc:sqlite:" + DB_PATH;
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
