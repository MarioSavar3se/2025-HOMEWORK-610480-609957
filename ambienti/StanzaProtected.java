package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {

    protected static final int NUMERO_MASSIMO_DIREZIONI = 4;
    protected static final int NUMERO_MASSIMO_ATTREZZI  = 10;

    protected String nome;
    protected Attrezzo[] attrezzi;
    protected int numeroAttrezzi;
    protected StanzaProtected[] stanzeAdiacenti;
    protected int numeroStanzeAdiacenti;
    protected String[] direzioni;

    /* ---------- costruttore ---------- */
    public StanzaProtected(String nome) {
        this.nome               = nome;
        this.attrezzi           = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
        this.stanzeAdiacenti    = new StanzaProtected[NUMERO_MASSIMO_DIREZIONI];
        this.direzioni          = new String[NUMERO_MASSIMO_DIREZIONI];
        this.numeroAttrezzi     = 0;
        this.numeroStanzeAdiacenti = 0;
    }

    /* ---------- METODI (copiati da Stanza) ---------- */

    public boolean addAttrezzo(Attrezzo a) {
        if (this.numeroAttrezzi >= NUMERO_MASSIMO_ATTREZZI) return false;
        this.attrezzi[this.numeroAttrezzi++] = a;
        return true;
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        for (int i = 0; i < numeroAttrezzi; i++)
            if (attrezzi[i].getNome().equals(nomeAttrezzo)) return true;
        return false;
    }

    /* …(gli altri metodi che ti servono: getStanzaAdiacente, getDescrizione, ecc.)… */
}
