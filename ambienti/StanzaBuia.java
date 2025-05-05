package it.uniroma3.diadia.ambienti;

/** Se manca l’attrezzo‑chiave, la stanza è completamente buia. */
public class StanzaBuia extends Stanza {

    private final String attrezzoCheIllumina;

    public StanzaBuia(String nome, String attrezzoCheIllumina) {
        super(nome);
        this.attrezzoCheIllumina = attrezzoCheIllumina;
    }

    @Override
    public String getDescrizione() {
        return this.hasAttrezzo(attrezzoCheIllumina)
                ? super.getDescrizione()
                : "qui c'è un buio pesto";
    }
}
