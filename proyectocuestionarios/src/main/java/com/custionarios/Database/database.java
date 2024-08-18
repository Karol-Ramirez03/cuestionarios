package com.custionarios.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    private final static String url = "jdbc:mysql://localhost:3306/encuestas";
    private final static String user = "root";
    private final static String password = "Kr03";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
