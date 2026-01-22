package com.cashfinance.cashfinancesf.util.Connect;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static final String url = "jdbc:mysql://localhost:3306/cashfinance";
    private static final String username= "root";
    private static final String password = "";

    public static java.sql.Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
