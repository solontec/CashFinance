package infra.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String db = System.getProperty("user.home") + "/cashfinance.db";
    private static final String url = "jdbc:sqlite:" + db;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver SQLite não encontrado", e);
        }
    }

    public static Connection getConnection() throws SQLException {

        Connection conn = DriverManager.getConnection(url);
        return conn;
    }
}