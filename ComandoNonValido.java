package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
    @Override
    public void setParametro(String parametro) {
        // nessun parametro
    }

    @Override
    public void esegui(Partita partita) {
        partita.getIO().showMessage("Comando non valido.");
    }
}