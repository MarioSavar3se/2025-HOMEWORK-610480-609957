package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Una stanza “magica”: dopo il N‑esimo attrezzo inserito
 * gli attrezzi successivi vengono “trasformati”
 * (nome invertito e peso raddoppiato).
 */
public class StanzaMagica extends Stanza {

    private static final int SOGLIA_MAGICA_DEFAULT = 3;

    private final int sogliaMagica;
    private int contatoreAttrezzi;

    public StanzaMagica(String nome) { this(nome, SOGLIA_MAGICA_DEFAULT); }

    public StanzaMagica(String nome, int soglia) {
        super(nome);
        this.sogliaMagica = soglia;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        contatoreAttrezzi++;
        if (contatoreAttrezzi > sogliaMagica)
            attrezzo = trasforma(attrezzo);
        return super.addAttrezzo(attrezzo);
    }

    private Attrezzo trasforma(Attrezzo a) {
        String nomeInvertito = new StringBuilder(a.getNome()).reverse().toString();
        return new Attrezzo(nomeInvertito, a.getPeso() * 2);
    }
}
