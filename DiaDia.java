package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.ambienti.*;

public class DiaDia {
    public static void main(String[] args) throws Exception {
        IOConsole console = new IOConsole();
        FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva();
        Labirinto lab = new LabirintoBuilder().daFile("labirinto.txt").build();
        new Partita(console, lab).gioca(factory);
    }
}