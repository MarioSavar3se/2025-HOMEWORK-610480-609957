package it.uniroma3.diadia;

import java.util.*;

public class IOSimulator implements IO {
    private Deque<String> input;
    private List<String> output;
    public IOSimulator(List<String> righeDiInput) {
        this.input = new ArrayDeque<>(righeDiInput);
        this.output = new ArrayList<>();
    }
    @Override public String getMessBenvenuto() { return IOConsole.MESSAGGIO_BENVENUTO; }
    @Override public void showMessage(String msg) { output.add(msg); }
    @Override public void fineGioco() { output.add("Grazie di aver giocato!"); }
    @Override public String readLine() { return input.isEmpty() ? "" : input.pop(); }
    public List<String> getMessaggiProdotti() { return output; }
}