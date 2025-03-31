package it.uniroma3.diadia.attrezzi; // Package in cui risiede la classe Attrezzo

public class Attrezzo {

    private String nome; // Nome identificativo dell'attrezzo
    private int peso;    // Peso dell'attrezzo

    // Costruttore che inizializza nome e peso
    public Attrezzo(String nome, int peso) {
        this.nome = nome;
        this.peso = peso;
    }

    // Restituisce il nome dell'attrezzo
    public String getNome() {
        return this.nome;
    }

    // Restituisce il peso dell'attrezzo
    public int getPeso() {
        return this.peso;
    }

    // Restituisce una rappresentazione in stringa dell'attrezzo (nome e peso)
    @Override
    public String toString() {
        return this.nome + " (" + this.peso + "kg)";
    }
}
