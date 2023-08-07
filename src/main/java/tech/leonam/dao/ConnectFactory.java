package tech.leonam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectFactory {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://enderecoDoBancoDeDados:3306/info", "user", "senha");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
