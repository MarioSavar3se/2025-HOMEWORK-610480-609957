package it.uniroma3.diadia;

import java.util.Scanner;

public class IOConsole implements IO {
    private Scanner scanner = new Scanner(System.in);
    public static final String MESSAGGIO_BENVENUTO = "Ti trovi nell'Universita'...";

    @Override public String getMessBenvenuto() { return MESSAGGIO_BENVENUTO; }
    @Override public void showMessage(String msg) { System.out.println(msg); }
    @Override public void fineGioco()       { System.out.println("Grazie di aver giocato!"); }
    @Override public String readLine()       { return scanner.nextLine(); }
}