package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoGuarda implements Comando {
    @Override
    public void setParametro(String parametro) {
        // nessun parametro
    }

    @Override
    public void esegui(Partita partita) {
        Stanza stanza = partita.getLabirinto().getStanzaCorrente();
        partita.getIO().showMessage(stanza.getDescrizione());
        partita.getIO().showMessage("CFU: " + partita.getGiocatore().getCfu());
        partita.getIO().showMessage(partita.getGiocatore().getBorsa().toString());
    }
}