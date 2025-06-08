package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.*;
import it.uniroma3.diadia.enum.Direzione;

public class Stanza {
    private String nome;
    private Map<Direzione, Stanza> stanzeAdiacenti = new EnumMap<>(Direzione.class);
    private List<Attrezzo> attrezzi = new ArrayList<>();

    public Stanza(String nome) { this.nome = nome; }
    public void impostaStanzaAdiacente(Direzione dir, Stanza s) {
        stanzeAdiacenti.put(dir, s);
    }
    public Stanza getStanzaAdiacente(Direzione dir) {
        return stanzeAdiacenti.get(dir);
    }
    public Set<Direzione> getDirezioni() {
        return Collections.unmodifiableSet(stanzeAdiacenti.keySet());
    }
    public boolean addAttrezzo(Attrezzo a) { return attrezzi.add(a); }
    public boolean removeAttrezzo(Attrezzo a) { return attrezzi.remove(a); }
    public Attrezzo getAttrezzo(String nome) {
        return attrezzi.stream().filter(a->a.getNome().equals(nome)).findFirst().orElse(null);
    }
    public boolean hasAttrezzo(String nome) {
        return getAttrezzo(nome)!=null;
    }
    public String getDescrizione() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome)
          .append("\nUscite: ")
          .append(stanzeAdiacenti.keySet())
          .append("\nAttrezzi: ")
          .append(attrezzi);
        return sb.toString();
    }
    public String getNome() { return nome; }
}