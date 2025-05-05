package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/** Variante che sfrutta i CAMPI PROTETTI della superclasse. */
public class StanzaMagicaProtected extends StanzaProtected {

    private static final int SOGLIA_MAGICA_DEFAULT = 3;

    private final int sogliaMagica;
    private int contatoreAttrezzi;

    public StanzaMagicaProtected(String nome) { this(nome, SOGLIA_MAGICA_DEFAULT); }

    public StanzaMagicaProtected(String nome, int soglia) {
        super(nome);
        this.sogliaMagica = soglia;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        contatoreAttrezzi++;
        if (contatoreAttrezzi > sogliaMagica)
            attrezzo = trasforma(attrezzo);

        if (this.numeroAttrezzi >= NUMERO_MASSIMO_ATTREZZI) return false;
        this.attrezzi[this.numeroAttrezzi++] = attrezzo;
        return true;
    }

    private Attrezzo trasforma(Attrezzo a) {
        String nomeInvertito = new StringBuilder(a.getNome()).reverse().toString();
        return new Attrezzo(nomeInvertito, a.getPeso() * 2);
    }
}
