package it.uniroma3.diadia.giocatore; // Package in cui risiede la classe Borsa

import it.uniroma3.diadia.attrezzi.Attrezzo; // Importa la classe Attrezzo per gestire gli oggetti

public class Borsa {
    public final static int DEFAULT_PESO_MAX_BORSA = 10; // Peso massimo di default per la borsa
    private Attrezzo[] attrezzi;    // Array per contenere gli attrezzi presenti nella borsa
    private int numeroAttrezzi;     // Numero corrente di attrezzi presenti nella borsa
    private int pesoMax;            // Peso massimo consentito per la borsa

    // Costruttore senza parametri: utilizza il peso massimo di default
    public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA);
    }

    // Costruttore che permette di specificare un peso massimo diverso
    public Borsa(int pesoMax) {
        this.pesoMax = pesoMax;           // Imposta il peso massimo
        this.attrezzi = new Attrezzo[10];   // Inizializza l'array per contenere fino a 10 attrezzi
        this.numeroAttrezzi = 0;           // Inizializza il contatore degli attrezzi a 0
    }

    // Metodo per aggiungere un attrezzo alla borsa, se non si supera il peso massimo e il numero massimo
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) // Controlla se l'aggiunta supererebbe il peso massimo
            return false;
        if (this.numeroAttrezzi == 10) // Controlla se la borsa è già piena (10 attrezzi)
            return false;
        this.attrezzi[this.numeroAttrezzi] = attrezzo; // Aggiunge l'attrezzo nell'array
        this.numeroAttrezzi++; // Incrementa il contatore degli attrezzi
        return true; // Ritorna true se l'attrezzo è stato aggiunto correttamente
    }

    // Restituisce il peso massimo della borsa
    public int getPesoMax() {
        return pesoMax;
    }

    // Metodo per ottenere un attrezzo specifico in base al nome
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        Attrezzo a = null; // Inizializza la variabile a null
        for (int i = 0; i < this.numeroAttrezzi; i++) { // Scorre tutti gli attrezzi presenti
            if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) // Se il nome corrisponde
                a = attrezzi[i]; // Assegna l'attrezzo trovato
        }
        return a; // Restituisce l'attrezzo o null se non trovato
    }

    // Calcola il peso attuale della borsa sommando i pesi degli attrezzi presenti
    public int getPeso() {
        int peso = 0;
        for (int i = 0; i < this.numeroAttrezzi; i++)
            peso += this.attrezzi[i].getPeso();
        return peso;
    }

    // Verifica se la borsa è vuota (nessun attrezzo presente)
    public boolean isEmpty() {
        return this.numeroAttrezzi == 0;
    }

    // Verifica se un attrezzo con il nome specificato è presente nella borsa
    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.getAttrezzo(nomeAttrezzo) != null;
    }

    // Rimuove un attrezzo dalla borsa in base al nome e restituisce l'attrezzo rimosso
    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
        for (int i = 0; i < this.numeroAttrezzi; i++) { // Cicla su tutti gli attrezzi
            if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) { // Se trova quello con il nome richiesto
                Attrezzo attrezzoRimosso = this.attrezzi[i]; // Memorizza l'attrezzo da rimuovere
                // Sposta tutti gli attrezzi successivi per coprire il buco
                for (int j = i; j < this.numeroAttrezzi - 1; j++) {
                    this.attrezzi[j] = this.attrezzi[j + 1];
                }
                this.attrezzi[this.numeroAttrezzi - 1] = null; // Imposta l'ultima posizione a null
                this.numeroAttrezzi--; // Decrementa il contatore degli attrezzi
                return attrezzoRimosso; // Restituisce l'attrezzo rimosso
            }
        }
        return null; // Se l'attrezzo non è trovato, restituisce null
    }

    // Ritorna una rappresentazione in stringa del contenuto della borsa e del suo peso
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (!this.isEmpty()) { // Se la borsa non è vuota
            s.append("Contenuto borsa (").append(this.getPeso()).append("kg/").append(this.getPesoMax()).append("kg): ");
            for (int i = 0; i < this.numeroAttrezzi; i++) { // Aggiunge ogni attrezzo alla stringa
                s.append(attrezzi[i].toString()).append(" ");
            }
        } else {
            s.append("Borsa vuota"); // Se la borsa è vuota, indica che non ci sono attrezzi
        }
        return s.toString(); // Restituisce la stringa costruita
    }
}
