package it.uniroma3.diadia.attrezzi;

public class Attrezzo {
    private String nome;
    private int peso;
    public Attrezzo(String nome, int peso) { this.nome = nome; this.peso = peso; }
    public String getNome() { return nome; }
    public int getPeso() { return peso; }
    @Override public String toString() { return nome + "(" + peso + "kg)"; }
}