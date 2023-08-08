package tech.leonam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectFactory {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://enderecoDoBd:3306/info", "user", "senha");
        } catch (SQLException ignored) {}
        return null;
    }
}
