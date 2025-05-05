package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {

    @Override
    public void esegui(Partita partita) {
        if (parametro == null) {
            partita.getIO().showMessage("Che cosa vuoi prendere?");
            return;
        }

        Stanza stanza = partita.getStanzaCorrente();
        Attrezzo attrezzo = stanza.getAttrezzo(parametro);

        if (attrezzo == null) {
            partita.getIO().showMessage("Attrezzo \"" + parametro + "\" non presente nella stanza.");
            return;
        }

        if (partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
            stanza.removeAttrezzo(attrezzo);
            partita.getIO().showMessage("Hai preso: " + attrezzo);
        } else {
            partita.getIO().showMessage("Non riesci a prendere \"" + parametro + "\" (borsa piena o troppo pesante).");
        }
    }
}
