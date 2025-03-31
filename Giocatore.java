package it.uniroma3.diadia.giocatore; // Package in cui risiede la classe Giocatore

public class Giocatore {

    static final private int CFU_INIZIALI = 20; // Costante per i CFU iniziali del giocatore
    private int cfu;       // Variabile per memorizzare i CFU attuali
    private Borsa borsa;   // Oggetto Borsa associato al giocatore, per contenere gli attrezzi

    // Costruttore della classe Giocatore
    public Giocatore() {
        this.borsa = new Borsa(); // Inizializza la borsa con il costruttore di default
    }

    // Imposta i CFU iniziali utilizzando la costante CFU_INIZIALI
    public void setCfuIniziali() {
        this.cfu = CFU_INIZIALI;
    }

    // Restituisce i CFU attuali del giocatore
    public int getCfu() {
        return this.cfu;
    }

    // Aggiorna i CFU del giocatore
    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    // Restituisce l'oggetto Borsa del giocatore
    public Borsa getBorsa() {
        return this.borsa;
    }
}
