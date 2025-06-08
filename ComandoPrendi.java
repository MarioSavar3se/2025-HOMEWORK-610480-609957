package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoPrendi implements Comando {
    private String parametro;

    @Override
    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void esegui(Partita partita) {
        if (parametro == null) {
            partita.getIO().showMessage("Che cosa vuoi prendere?");
            return;
        }
        Stanza stanza = partita.getLabirinto().getStanzaCorrente();
        Attrezzo att = stanza.getAttrezzo(parametro);
        if (att == null) {
            partita.getIO().showMessage("Attrezzo \"" + parametro + "\" non presente nella stanza.");
            return;
        }
        if (partita.getGiocatore().getBorsa().addAttrezzo(att)) {
            stanza.removeAttrezzo(att);
            partita.getIO().showMessage("Hai preso: " + att);
        } else {
            partita.getIO().showMessage("Non riesci a prendere \"" + parametro + "\" (borsa piena o troppo pesante). ");
        }
    }
}