package tech.leonam.dao;

import java.util.Objects;

public class EnviarBd {
    private boolean isEnviado = false;
    private static final String SQL_CADASTRO = "INSERT INTO dados(recebidos) values (?)";

    public EnviarBd(String texto) {
        new Thread(() -> enviar(texto)).start();
    }

    private void enviar(String texto) {
        while (!isEnviado) {
            try(var conn = ConnectFactory.getConnection(); var stmt = Objects.requireNonNull(conn).prepareStatement(SQL_CADASTRO)) {
                stmt.setString(1,texto);
                stmt.execute();
                isEnviado = true;
            }catch (Exception ignored){}
        }
    }
}
