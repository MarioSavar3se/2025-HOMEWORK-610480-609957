package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/** Un qualunque comando del gioco. */
public interface Comando {
    /** Esegue la logica del comando. */
    void esegui(Partita partita);

    /** Imposta l’eventuale parametro del comando (può essere null). */
    void setParametro(String parametro);
}
