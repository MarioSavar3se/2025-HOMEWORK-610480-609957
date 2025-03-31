package it.uniroma3.diadia; // Package principale del gioco

import it.uniroma3.diadia.IOConsole.IOConsole; // Importa IOConsole per gestire I/O centralizzato
import it.uniroma3.diadia.attrezzi.Attrezzo; // Importa la classe Attrezzo per gestire gli oggetti nel gioco
import it.uniroma3.diadia.ambienti.Stanza; // Importa la classe Stanza per rappresentare le stanze del labirinto

public class DiaDia { // Inizio della classe principale DiaDia

    private IOConsole ioconsole;      // Istanza di IOConsole per gestire input/output in modo centralizzato
    private Partita partita;          // Istanza di Partita che gestisce lo stato del gioco (stanze, CFU, ecc.)
    // Array dei comandi validi che l'utente può utilizzare
    private final String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

    // Costruttore di DiaDia
    public DiaDia() {
        this.ioconsole = new IOConsole(); // Inizializza IOConsole
        this.partita = new Partita();     // Crea una nuova partita (labirinto, giocatore, ecc.)
    }

    // Metodo principale per avviare il gioco
    public void gioca() {
        // Mostra il messaggio di benvenuto prelevato da IOConsole
        ioconsole.showMessage(ioconsole.getMessBenvenuto());
        try {
            // Ciclo di gioco: continua finché processa un'istruzione che non termina il gioco
            while (!processaIstruzione()) {
                // Il ciclo si ripete finché processaIstruzione() restituisce false
            }
        } catch (Exception e) { // Gestione di eventuali eccezioni nel ciclo di gioco
            ioconsole.showMessage("Errore durante il gioco: " + e.getMessage());
            e.printStackTrace(); // Stampa lo stack trace per facilitare il debug
        }
    }

    // Metodo che legge e processa l'istruzione dell'utente
    private boolean processaIstruzione() {
        // Crea un nuovo oggetto Comando utilizzando IOConsole per leggere l'input
        Comando comandoDaEseguire = new Comando(ioconsole);
        String nome = comandoDaEseguire.getNome();         // Estrae il nome del comando
        String parametro = comandoDaEseguire.getParametro(); // Estrae il parametro del comando, se presente

        try {
            // Gestione dei diversi comandi in base al nome
            if (nome.equals("fine")) { // Se l'utente ha digitato "fine"
                fine();              // Chiama il metodo per terminare il gioco
                return true;         // Restituisce true per uscire dal ciclo di gioco
            } else if (nome.equals("vai")) { // Se il comando è "vai"
                vai(parametro);      // Chiama il metodo vai passando il parametro (direzione)
            } else if (nome.equals("aiuto")) { // Se il comando è "aiuto"
                aiuto();             // Mostra l'elenco dei comandi disponibili
            } else if (nome.equals("prendi")) { // Se il comando è "prendi"
                prendi(parametro);   // Prova a prendere l'attrezzo specificato
            } else if (nome.equals("posa")) { // Se il comando è "posa"
                posa(parametro);     // Prova a posare l'attrezzo specificato
            } else {
                // Se il comando non corrisponde a nessuno dei validi
                ioconsole.showMessage("Comando sconosciuto");
            }
            // Controlla se la partita è stata vinta (stanza corrente è quella vincente)
            if (partita.vinta()) {
                ioconsole.showMessage("Hai vinto!");
                return true; // Termina il gioco
            } else if (partita.isFinita()) { // Oppure se la partita è finita (es. CFU esauriti)
                ioconsole.showMessage("Partita finita!");
                return true; // Termina il gioco
            }
        } catch (Exception e) { // Gestione delle eccezioni durante l'elaborazione del comando
            ioconsole.showMessage("Errore durante l'elaborazione del comando: " + e.getMessage());
            e.printStackTrace();
        }
        return false; // Se nessun comando termina il gioco, continua il ciclo
    }

    // Metodo che mostra l'aiuto, ovvero l'elenco dei comandi validi
    private void aiuto() {
        StringBuilder sb = new StringBuilder(); // Utilizzato per costruire la stringa dei comandi
        for (String cmd : elencoComandi) {      // Per ogni comando nell'array
            sb.append(cmd).append(" ");           // Aggiunge il comando seguito da uno spazio
        }
        ioconsole.showMessage(sb.toString());     // Visualizza il messaggio di aiuto
    }

    // Metodo per gestire il comando "vai" che sposta il giocatore in una direzione specificata
    private void vai(String direzione) {
        try {
            if (direzione == null) { // Se non è stata specificata una direzione
                ioconsole.showMessage("Dove vuoi andare?");
                return;
            }
            // Ottiene la stanza adiacente nella direzione indicata
            Stanza prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
            if (prossimaStanza == null) { // Se non esiste una stanza in quella direzione
                ioconsole.showMessage("Direzione inesistente");
            } else {
                // Imposta la nuova stanza come stanza corrente della partita
                partita.setStanzaCorrente(prossimaStanza);
                int cfu = partita.getCfu();    // Ottiene i CFU attuali del giocatore
                partita.setCfu(cfu - 1);         // Decrementa i CFU di 1
                ioconsole.showMessage("Sei in: " + partita.getStanzaCorrente().getNome());
            }
        } catch (Exception e) { // Gestione delle eccezioni nel comando "vai"
            ioconsole.showMessage("Errore durante il comando 'vai': " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Metodo per gestire il comando "prendi" che permette di prendere un attrezzo dalla stanza
    private void prendi(String nomeAttrezzo) {
        try {
            if (nomeAttrezzo == null) { // Se l'utente non specifica l'attrezzo da prendere
                ioconsole.showMessage("Specifica l'attrezzo da prendere");
                return;
            }
            // Cerca l'attrezzo nella stanza corrente
            Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
            if (attrezzo == null) { // Se l'attrezzo non è presente nella stanza
                ioconsole.showMessage("Attrezzo non presente nella stanza");
            } else {
                // Tenta di aggiungere l'attrezzo alla borsa del giocatore
                if (partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
                    // Se l'aggiunta ha successo, rimuove l'attrezzo dalla stanza
                    partita.getStanzaCorrente().removeAttrezzo(attrezzo);
                    ioconsole.showMessage("Hai preso: " + attrezzo.toString());
                    // Se l'attrezzo è la Pietra Filosofale, mostra il messaggio speciale
                    if (attrezzo.getNome().equals("PietraFilosofale")) {
                        ioconsole.showMessage("Se vai in biblioteca vinci ;-)");
                    }
                } else {
                    ioconsole.showMessage("Borsa piena o peso massimo superato");
                }
            }
        } catch (Exception e) { // Gestione delle eccezioni nel comando "prendi"
            ioconsole.showMessage("Errore durante il comando 'prendi': " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Metodo per gestire il comando "posa" che permette di posare un attrezzo dalla borsa nella stanza corrente
    private void posa(String nomeAttrezzo) {
        try {
            if (nomeAttrezzo == null) { // Se l'utente non specifica l'attrezzo da posare
                ioconsole.showMessage("Specifica l'attrezzo da posare");
                return;
            }
            // Tenta di rimuovere l'attrezzo dalla borsa del giocatore
            Attrezzo attrezzo = partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
            if (attrezzo == null) { // Se l'attrezzo non è presente nella borsa
                ioconsole.showMessage("Attrezzo non presente nella borsa");
            } else {
                // Aggiunge l'attrezzo alla stanza corrente
                partita.getStanzaCorrente().addAttrezzo(attrezzo);
                ioconsole.showMessage("Hai posato: " + attrezzo.toString());
            }
        } catch (Exception e) { // Gestione delle eccezioni nel comando "posa"
            ioconsole.showMessage("Errore durante il comando 'posa': " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Metodo per gestire il comando "fine" che termina il gioco
    private void fine() {
        try {
            ioconsole.fineGioco(); // Chiama il metodo di IOConsole per mostrare il messaggio di fine gioco
        } catch (Exception e) { // Gestione delle eccezioni nella chiusura del gioco
            ioconsole.showMessage("Errore durante la chiusura del gioco: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void showMessage(String msg) {
    	ioconsole.showMessage(msg);
    }

    // Metodo main: punto di ingresso del programma
    public static void main(String[] args) {
        DiaDia gioco = new DiaDia(); // Crea un'istanza del gioco
        gioco.gioca();               // Avvia il ciclo di gioco
    }
}
