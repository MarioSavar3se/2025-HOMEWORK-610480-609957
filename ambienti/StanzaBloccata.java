package it.uniroma3.diadia.ambienti;

/**
 * Una direzione è bloccata finché non compare l’attrezzo sbloccante
 * nella stanza stessa.
 */
public class StanzaBloccata extends Stanza {

    private final String direzioneBloccata;
    private final String attrezzoSbloccante;

    public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
        super(nome);
        this.direzioneBloccata  = direzioneBloccata;
        this.attrezzoSbloccante = attrezzoSbloccante;
    }

    @Override
    public Stanza getStanzaAdiacente(String dir) {
        if (dir.equals(direzioneBloccata) && !this.hasAttrezzo(attrezzoSbloccante))
            return this;                    // resta fermo
        return super.getStanzaAdiacente(dir);
    }

    @Override
    public String getDescrizione() {
        if (this.hasAttrezzo(attrezzoSbloccante))
            return super.getDescrizione();
        return "La direzione \"" + direzioneBloccata +
               "\" è bloccata. Ti serve \"" + attrezzoSbloccante + "\".";
    }
}
