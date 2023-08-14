package tech.leonam.dao;

import org.junit.Assert;
import org.junit.Test;

public class ConnectFactoryTest {

    @Test
    public void getConnection() {
        var conexao = ConnectFactory.getConnection();
        Assert.assertNotNull(conexao);
    }
}