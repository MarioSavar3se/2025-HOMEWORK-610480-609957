package it.uniroma3.diadia; // Package principale del gioco

import it.uniroma3.diadia.ambienti.Stanza;   // Importa la classe Stanza per gestire le stanze del labirinto
import it.uniroma3.diadia.ambienti.Labirinto;  // Importa la classe Labirinto per la creazione e gestione delle stanze
import it.uniroma3.diadia.giocatore.Giocatore; // Importa la classe Giocatore che contiene CFU e la borsa

public class Partita { // Definizione della classe Partita che gestisce lo stato del gioco

    private Labirinto labirinto; // Riferimento all'oggetto Labirinto che contiene le stanze e il labirinto
    private Giocatore giocatore; // Riferimento all'oggetto Giocatore che gestisce i CFU e la borsa
    private boolean finita;      // Flag che indica se la partita è terminata

    // Costruttore della Partita
    public Partita() {
        this.labirinto = new Labirinto(); // Crea un nuovo labirinto
        this.giocatore = new Giocatore(); // Crea un nuovo giocatore
        this.labirinto.creaStanze();      // Inizializza il labirinto creando le stanze e impostando le adiacenze
        this.finita = false;              // Imposta la partita come non terminata
        this.giocatore.setCfuIniziali();  // Imposta i CFU iniziali del giocatore
    }

    // Metodo per ottenere la stanza corrente in cui si trova il giocatore
    public Stanza getStanzaCorrente() {
        return labirinto.getStanzaCorrente();
    }

    // Metodo per impostare la stanza corrente
    public void setStanzaCorrente(Stanza stanza) {
        labirinto.setStanzaCorrente(stanza);
    }

    // Verifica se la partita è stata vinta (ovvero se la stanza corrente è quella vincente)
    public boolean vinta() {
        return labirinto.getStanzaCorrente() == labirinto.getStanzaVincente();
    }

    // Verifica se la partita è finita (vinta, CFU esauriti o flag 'finita' impostato)
    public boolean isFinita() {
        return finita || vinta() || (giocatore.getCfu() == 0);
    }

    // Metodo per impostare la partita come terminata
    public void setFinita() {
        this.finita = true;
    }

    // Metodo per ottenere i CFU attuali del giocatore
    public int getCfu() {
        return giocatore.getCfu();
    }

    // Metodo per aggiornare i CFU del giocatore
    public void setCfu(int cfu) {
        giocatore.setCfu(cfu);
    }

    // Metodo per ottenere l'oggetto Giocatore
    public Giocatore getGiocatore() {
        return this.giocatore;
    }
    
    // Metodo per ottenere la stanza vincente, quella necessaria per vincere la partita
    public Stanza getStanzaVincente() {
        return labirinto.getStanzaVincente();
    }
}
