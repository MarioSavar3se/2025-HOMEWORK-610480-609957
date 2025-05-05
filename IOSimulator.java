package it.uniroma3.diadia;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import it.uniroma3.diadia.IOConsole.IOConsole;

/** Implementazione “silenziosa” di IO per i test automatici. */
public class IOSimulator implements IO {

    private final Deque<String>  input;   // comandi da “digitare”
    private final List<String>   output;  // messaggi prodotti dal gioco

    public IOSimulator(List<String> righeDiInput) {
        this.input  = new ArrayDeque<>(righeDiInput);
        this.output = new ArrayList<>();
    }

    /* ===== API IO ===== */

    @Override public String getMessBenvenuto() { return IOConsole.MESSAGGIO_BENVENUTO; }

    @Override public void showMessage(String msg) { output.add(msg); }

    @Override public void fineGioco() { output.add("Grazie di aver giocato!"); }

    @Override public String readLine() { return input.isEmpty() ? "" : input.pop(); }

    /* ===== utilità per i test ===== */

    public List<String> getMessaggiProdotti() { return output; }
}
