package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoGuarda extends AbstractComando {

    @Override
    public void esegui(Partita partita) {
        Stanza stanza = partita.getStanzaCorrente();
        Giocatore g   = partita.getGiocatore();

        partita.getIO().showMessage(stanza.getDescrizione());
        partita.getIO().showMessage("CFU: " + g.getCfu());
        partita.getIO().showMessage(g.getBorsa().toString());
    }
}
