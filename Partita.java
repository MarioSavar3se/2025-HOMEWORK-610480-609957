package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Partita {

    /* ========= CAMPI ========= */
    private final Labirinto labirinto;
    private final Giocatore giocatore;
    private final IO        io;          // adesso è l’interfaccia IO, non più IOConsole

    private boolean finita;

    /* ========= COSTRUTTORI ========= */

    /** ♦ Costruttore che accetta un qualsiasi canale IO (IOConsole o IOSimulator). */
    public Partita(IO io) {              // <‑‑ cambia il tipo del parametro
        this.io        = io;
        this.labirinto = new Labirinto();
        this.labirinto.creaStanze();

        this.giocatore = new Giocatore();
        this.giocatore.setCfuIniziali();

        this.finita = false;
    }

    /* volendo, puoi lasciare ANCHE il vecchio costruttore per retro‑compatibilità:
    public Partita(IOConsole io) { this((IO) io); }
    */

    /* ========= METODI RESTANTI (invariati) ========= */

    public Stanza getStanzaCorrente()          { return labirinto.getStanzaCorrente(); }
    public void   setStanzaCorrente(Stanza s)  { labirinto.setStanzaCorrente(s);       }

    public Stanza getStanzaVincente()          { return labirinto.getStanzaVincente(); }

    public Giocatore getGiocatore()            { return giocatore; }

    /** Canale I/O condiviso con i comandi. */
    public IO getIO()                          { return io; }

    public boolean vinta()          { return getStanzaCorrente() == getStanzaVincente(); }
    public boolean isFinita()       { return finita || vinta() || !giocatoreIsVivo(); }
    public void    setFinita()      { this.finita = true; }

    public int     getCfu()         { return giocatore.getCfu(); }
    public void    setCfu(int cfu)  { giocatore.setCfu(cfu);     }
    public boolean giocatoreIsVivo(){ return giocatore.getCfu() > 0; }
}
