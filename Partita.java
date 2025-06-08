package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Partita {
    private Labirinto lab;
    private Giocatore giocatore;
    private IO io;
    private boolean finita = false;

    public Partita(IO io, Labirinto labirinto) {
        this.io = io;
        this.lab = labirinto;
        this.giocatore = new Giocatore();
        this.giocatore.setCfuIniziali();
        // pattern Observer: il giocatore notificherà i cambi di CFU tramite io.showMessage
        this.giocatore.addObserver(io::showMessage);
    }

    /** Restituisce il canale di I/O in uso */
    public IO getIO() {
        return io;
    }

    /** Restituisce il labirinto associato a questa partita */
    public Labirinto getLabirinto() {
        return lab;
    }

    /** Restituisce la stanza in cui si trova attualmente il giocatore */
    public Stanza getStanzaCorrente() {
        return lab.getStanzaCorrente();
    }

    /** Imposta la stanza corrente (usata dal comando 'vai') */
    public void setStanzaCorrente(Stanza stanza) {
        lab.setStanzaCorrente(stanza);
    }

    /** Restituisce la stanza vincente del labirinto */
    public Stanza getStanzaVincente() {
        return lab.getStanzaVincente();
    }

    /** Restituisce il giocatore che sta giocando */
    public Giocatore getGiocatore() {
        return giocatore;
    }

    /** Controlla se la partita è finita (giocatore fuori CFU, vittoria o comando fine) */
    public boolean isFinita() {
        return finita
            || giocatore.getCfu() <= 0
            || lab.getStanzaCorrente() == lab.getStanzaVincente();
    }

    /** Restituisce true se il giocatore ha raggiunto la stanza vincente */
    public boolean vinta() {
        return lab.getStanzaCorrente() == lab.getStanzaVincente();
    }

    /** Segna la partita come terminata (usato da ComandoFine) */
    public void setFinita() {
        finita = true;
    }

    /**
     * Ciclo di gioco: legge istruzioni, costruisce ed esegue comandi,
     * controlla vittoria e fine partita.
     */
    public void gioca(FabbricaDiComandi factory) {
        io.showMessage(io.getMessBenvenuto());
        while (!isFinita()) {
            String istruzione = io.readLine();
            Comando comando = factory.costruisciComando(istruzione);
            comando.esegui(this);
            if (vinta()) {
                io.showMessage("Hai vinto!");
            }
        }
        io.fineGioco();
    }
}
