package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {

    @Override
    public void esegui(Partita partita) {
        if (parametro == null) {
            partita.getIO().showMessage("Dove vuoi andare? Devi specificare una direzione.");
            return;
        }

        Stanza prossima = partita.getStanzaCorrente().getStanzaAdiacente(parametro);

        if (prossima == null) {
            partita.getIO().showMessage("Direzione inesistente");
            return;
        }

        partita.setStanzaCorrente(prossima);
        partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
        partita.getIO().showMessage("Sei in: " + prossima.getNome());
    }
}
