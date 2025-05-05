package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoPosa extends AbstractComando {

    @Override
    public void esegui(Partita partita) {
        if (parametro == null) {
            partita.getIO().showMessage("Che cosa vuoi posare?");
            return;
        }

        Attrezzo attrezzo = partita.getGiocatore().getBorsa().removeAttrezzo(parametro);

        if (attrezzo == null) {
            partita.getIO().showMessage("Non hai \"" + parametro + "\" nella borsa.");
            return;
        }

        Stanza stanza = partita.getStanzaCorrente();
        if (stanza.addAttrezzo(attrezzo)) {
            partita.getIO().showMessage("Hai posato: " + attrezzo);
        } else {
            // se (per qualche limite) non entra, rimettilo in borsa
            partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
            partita.getIO().showMessage("Non c'è spazio per posare \"" + parametro + "\" qui.");
        }
    }
}
