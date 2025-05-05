package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/** Fornisce l’implementazione “di default” del campo parametro. */
public abstract class AbstractComando implements Comando {
    protected String parametro;

    @Override
    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    /** Le sottoclassi devono implementare esegui(). */
    @Override
    public abstract void esegui(Partita partita);
}
