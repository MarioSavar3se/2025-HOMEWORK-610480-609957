package it.uniroma3.diadia.ambienti; // Package per le classi relative agli ambienti (stanze)

import it.uniroma3.diadia.attrezzi.Attrezzo; // Importa la classe Attrezzo per gestire gli oggetti presenti nelle stanze

public class Stanza {

    static final private int NUMERO_MASSIMO_DIREZIONI = 4;  // Numero massimo di uscite (direzioni) che la stanza può avere
    static final private int NUMERO_MASSIMO_ATTREZZI = 10;   // Numero massimo di attrezzi che la stanza può contenere

    private String nome;          // Nome della stanza
    private Attrezzo[] attrezzi;   // Array per memorizzare gli attrezzi presenti nella stanza
    private int numeroAttrezzi;   // Numero attuale di attrezzi nella stanza
    private Stanza[] stanzeAdiacenti; // Array per memorizzare le stanze adiacenti (uscite)
    private int numeroStanzeAdiacenti; // Numero attuale di stanze adiacenti
    private String[] direzioni;        // Array per memorizzare le direzioni associate alle uscite

    // Costruttore che inizializza la stanza con un nome e prepara gli array per attrezzi e uscite
    public Stanza(String nome) {
        this.nome = nome;                           // Imposta il nome della stanza
        this.numeroStanzeAdiacenti = 0;             // Inizializza il contatore delle uscite a 0
        this.numeroAttrezzi = 0;                     // Inizializza il contatore degli attrezzi a 0
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI]; // Crea l'array per le direzioni con dimensione massima
        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI]; // Crea l'array per le stanze adiacenti
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI]; // Crea l'array per contenere gli attrezzi
    }

    // Imposta una stanza adiacente in una data direzione
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        boolean aggiornato = false; // Flag per verificare se la direzione esiste già
        // Scorre l'array delle direzioni già impostate
        for (int i = 0; i < this.direzioni.length; i++) {
            if (direzione.equals(this.direzioni[i])) { // Se la direzione è già presente
                this.stanzeAdiacenti[i] = stanza; // Aggiorna la stanza adiacente in quella posizione
                aggiornato = true; // Segna che la direzione era già presente
            }
        }
        if (!aggiornato) // Se la direzione non esiste ancora
            if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) { // Verifica che non si superi il numero massimo di uscite
                this.direzioni[numeroStanzeAdiacenti] = direzione; // Imposta la nuova direzione
                this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza; // Imposta la stanza adiacente corrispondente
                this.numeroStanzeAdiacenti++; // Incrementa il contatore delle uscite
            }
    }

    // Restituisce la stanza adiacente per una data direzione
    public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null; // Inizializza la variabile a null
        // Scorre le direzioni impostate
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++) {
            if (this.direzioni[i].equals(direzione)) // Se la direzione corrisponde
                stanza = this.stanzeAdiacenti[i]; // Assegna la stanza corrispondente
        }
        return stanza; // Ritorna la stanza trovata, oppure null se non esiste
    }

    // Restituisce il nome della stanza
    public String getNome() {
        return this.nome;
    }

    // Restituisce la descrizione della stanza (utilizzando il metodo toString)
    public String getDescrizione() {
        return this.toString();
    }

    // Restituisce l'array di attrezzi presenti nella stanza
    public Attrezzo[] getAttrezzi() {
        return this.attrezzi;
    }

    // Aggiunge un attrezzo alla stanza se c'è spazio disponibile
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) { // Se c'è spazio per un nuovo attrezzo
            this.attrezzi[numeroAttrezzi] = attrezzo; // Aggiunge l'attrezzo all'array
            this.numeroAttrezzi++; // Incrementa il contatore degli attrezzi
            return true; // Restituisce true indicando successo
        } else {
            return false; // Restituisce false se non c'è spazio
        }
    }

    // Restituisce una rappresentazione in stringa della stanza, comprensiva di nome, uscite e attrezzi presenti
    @Override
    public String toString() {
        StringBuilder risultato = new StringBuilder();
        risultato.append(this.nome); // Aggiunge il nome della stanza
        risultato.append("\nUscite: ");
        for (String direzione : this.direzioni) { // Per ogni uscita impostata
            if (direzione != null)
                risultato.append(" " + direzione); // Aggiunge la direzione alla stringa
        }
        risultato.append("\nAttrezzi nella stanza: ");
        for (int i = 0; i < this.numeroAttrezzi; i++) { // Per ogni attrezzo presente
            risultato.append(this.attrezzi[i].toString()).append(" "); // Aggiunge la rappresentazione dell'attrezzo
        }
        return risultato.toString(); // Ritorna la stringa finale
    }

    // Verifica se nella stanza è presente un attrezzo con il nome specificato
    public boolean hasAttrezzo(String nomeAttrezzo) {
        for (int i = 0; i < this.numeroAttrezzi; i++) { // Scorre tutti gli attrezzi
            if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
                return true; // Restituisce true se trova una corrispondenza
        }
        return false; // Restituisce false se nessun attrezzo corrisponde
    }

    // Restituisce un attrezzo specifico dalla stanza in base al nome
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        for (int i = 0; i < this.numeroAttrezzi; i++) { // Scorre l'array degli attrezzi
            if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
                return this.attrezzi[i]; // Ritorna l'attrezzo se il nome corrisponde
        }
        return null; // Ritorna null se non trova l'attrezzo
    }

    // Rimuove un attrezzo dalla stanza; restituisce true se l'attrezzo è stato rimosso, false altrimenti
    public boolean removeAttrezzo(Attrezzo attrezzo) {
        for (int i = 0; i < this.numeroAttrezzi; i++) { // Itera su tutti gli attrezzi presenti
            if (this.attrezzi[i].equals(attrezzo)) { // Se trova l'attrezzo da rimuovere
                // Sposta gli attrezzi successivi per colmare il vuoto
                for (int j = i; j < this.numeroAttrezzi - 1; j++) {
                    this.attrezzi[j] = this.attrezzi[j + 1];
                }
                this.attrezzi[this.numeroAttrezzi - 1] = null; // Imposta l'ultima posizione a null
                this.numeroAttrezzi--; // Decrementa il contatore degli attrezzi
                return true; // Ritorna true per indicare che l'attrezzo è stato rimosso
            }
        }
        return false; // Ritorna false se l'attrezzo non è stato trovato
    }

    // Restituisce un array contenente tutte le direzioni (uscite) impostate per la stanza
    public String[] getDirezioni() {
        String[] direzioniOut = new String[this.numeroStanzeAdiacenti];
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++)
            direzioniOut[i] = this.direzioni[i];
        return direzioniOut;
    }
}
