package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoPosa implements Comando {
    private String parametro;

    @Override
    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void esegui(Partita partita) {
        if (parametro == null) {
            partita.getIO().showMessage("Che cosa vuoi posare?");
            return;
        }
        Attrezzo att = partita.getGiocatore().getBorsa().removeAttrezzo(parametro);
        if (att == null) {
            partita.getIO().showMessage("Non hai \"" + parametro + "\" nella borsa.");
            return;
        }
        Stanza stanza = partita.getLabirinto().getStanzaCorrente();
        if (stanza.addAttrezzo(att)) {
            partita.getIO().showMessage("Hai posato: " + att);
        } else {
            partita.getGiocatore().getBorsa().addAttrezzo(att);
            partita.getIO().showMessage("Non c'è spazio per posare \"" + parametro + "\" qui.");
        }
    }
}