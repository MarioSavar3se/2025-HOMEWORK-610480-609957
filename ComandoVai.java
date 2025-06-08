package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.enum.Direzione;

public class ComandoVai implements Comando {
    private String parametro;

    @Override
    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void esegui(Partita partita) {
        if (parametro == null) {
            partita.getIO().showMessage("Dove vuoi andare? Devi specificare una direzione.");
            return;
        }
        Direzione dir;
        try {
            dir = Direzione.fromString(parametro);
        } catch (IllegalArgumentException e) {
            partita.getIO().showMessage("Direzione sconosciuta.");
            return;
        }
        Stanza prossima = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(dir);
        if (prossima == null) {
            partita.getIO().showMessage("Direzione inesistente");
            return;
        }
        partita.getLabirinto().setStanzaCorrente(prossima);
        partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
        partita.getIO().showMessage("Sei in: " + prossima.getNome());
    }
}