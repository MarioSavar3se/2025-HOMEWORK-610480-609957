package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
    @Override
    public void setParametro(String parametro) {
        // nessun parametro
    }

    @Override
    public void esegui(Partita partita) {
        partita.setFinita();
        partita.getIO().showMessage("Grazie per aver giocato!");
    }
}