package it.uniroma3.diadia.ambienti; // Package per le classi relative agli ambienti del gioco

import it.uniroma3.diadia.attrezzi.Attrezzo; // Importa la classe Attrezzo

public class Labirinto {

    private Stanza stanzaCorrente;  // La stanza corrente in cui si trova il giocatore
    private Stanza stanzaVincente;  // La stanza che rappresenta l'obiettivo per vincere il gioco

    // Metodo per creare le stanze del labirinto e collegarle tra loro
    public void creaStanze() {
        // Creazione attrezzi
        Attrezzo lanterna = new Attrezzo("lanterna", 3); // Crea un attrezzo "lanterna" con peso 3
        Attrezzo osso = new Attrezzo("osso", 1);           // Crea un attrezzo "osso" con peso 1
        Attrezzo pietra_filosofale = new Attrezzo("PietraFilosofale", 10);		//Crea un attrezzo "Pietra Filosofale" con peso 10

        // Creazione delle stanze
        Stanza atrio = new Stanza("Atrio");               // Crea la stanza "Atrio"
        Stanza aulaN11 = new Stanza("Aula N11");           // Crea la stanza "Aula N11"
        Stanza aulaN10 = new Stanza("Aula N10");           // Crea la stanza "Aula N10"
        Stanza laboratorio = new Stanza("Laboratorio Campus"); // Crea la stanza "Laboratorio Campus"
        Stanza biblioteca = new Stanza("Biblioteca");      // Crea la stanza "Biblioteca"

        // Collegamento delle stanze: impostazione delle uscite
        atrio.impostaStanzaAdiacente("nord", biblioteca); // L'atrio ha come uscita a nord la biblioteca
        atrio.impostaStanzaAdiacente("est", aulaN11);       // L'atrio ha come uscita a est Aula N11
        atrio.impostaStanzaAdiacente("sud", aulaN10);       // L'atrio ha come uscita a sud Aula N10
        atrio.impostaStanzaAdiacente("ovest", laboratorio); // L'atrio ha come uscita a ovest il laboratorio

        aulaN11.impostaStanzaAdiacente("ovest", atrio);     // Aula N11 collega all'atrio a ovest
        aulaN11.impostaStanzaAdiacente("est", laboratorio); // Aula N11 collega al laboratorio a est

        aulaN10.impostaStanzaAdiacente("nord", atrio);       // Aula N10 collega all'atrio a nord
        aulaN10.impostaStanzaAdiacente("est", aulaN11);       // Aula N10 collega ad Aula N11 a est
        aulaN10.impostaStanzaAdiacente("ovest", laboratorio); // Aula N10 collega al laboratorio a ovest

        laboratorio.impostaStanzaAdiacente("est", atrio);     // Il laboratorio collega all'atrio a est
        laboratorio.impostaStanzaAdiacente("ovest", aulaN11);   // Il laboratorio collega ad Aula N11 a ovest

        biblioteca.impostaStanzaAdiacente("sud", atrio);      // La biblioteca collega all'atrio a sud

        // Posizionamento degli attrezzi nelle stanze
        aulaN10.addAttrezzo(lanterna); // Aggiunge la lanterna ad Aula N10
        atrio.addAttrezzo(osso);       // Aggiunge l'osso nell'atrio
        laboratorio.addAttrezzo(pietra_filosofale);		//Aggiunge pietra filosofale al laboratorio campus 

        // Impostazione della stanza iniziale e della stanza vincente
        this.stanzaCorrente = atrio;     // Il gioco inizia nell'atrio
        this.stanzaVincente = biblioteca; // La biblioteca è la stanza vincente
    }

    // Restituisce la stanza corrente
    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }

    // Imposta la stanza corrente
    public void setStanzaCorrente(Stanza stanza) {
        this.stanzaCorrente = stanza;
    }

    // Restituisce la stanza vincente
    public Stanza getStanzaVincente() {
        return this.stanzaVincente;
    }
}
