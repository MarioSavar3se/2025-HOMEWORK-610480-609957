package it.uniroma3.diadia.ambienti;

public class Labirinto {
    private Stanza stanzaCorrente;
    private Stanza stanzaVincente;
    public Labirinto(LabirintoBuilder builder) {
        this.stanzaCorrente = builder.getEntrata();
        this.stanzaVincente = builder.getUscita();
    }
    public Stanza getStanzaCorrente() { return stanzaCorrente; }
    public void setStanzaCorrente(Stanza s) { stanzaCorrente = s; }
    public Stanza getStanzaVincente()       { return stanzaVincente; }
}