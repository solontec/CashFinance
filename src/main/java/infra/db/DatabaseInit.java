package infra.db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseInit {
    public static void init() {

        String sqlStatements =  """
            CREATE TABLE IF NOT EXISTS tb_users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                email TEXT NOT NULL UNIQUE,
                phone TEXT,
                password TEXT,
                profileType TEXT CHECK (
                profileType IN ('Conservative', 'Moderate', 'Dangerous')
                )
            );
            """
        ;
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            // here i doing a select query to view the users
            try (ResultSet rs = stmt.executeQuery("SELECT id, name, email, profileType FROM tb_users")) {
                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + rs.getString("name") + " | " + rs.getString("email") + " | " + rs.getString("profileType")
                    );
                }
            }
        } catch (Exception e) {
            System.err.println("error for init database");
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        init();
    }
}