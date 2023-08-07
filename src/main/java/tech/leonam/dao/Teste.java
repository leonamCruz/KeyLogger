package tech.leonam.dao;

import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) throws SQLException {
        var conn = ConnectFactory.getConnection();
        if (conn != null) {
            System.out.println("Conectado");
            conn.close();
        }
    }
}
