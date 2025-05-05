package it.uniroma3.diadia.IOConsole; // Package in cui risiede IOConsole

import it.uniroma3.diadia.IO;
import java.util.Scanner; // Importa la classe Scanner per leggere l'input da System.in

public class IOConsole implements IO { // Definizione della classe IOConsole, centralizza la gestione dell'input/output

    private Scanner scanner; // Scanner per leggere l'input dall'utente
    // Messaggio di benvenuto mostrato all'avvio del gioco
    public static final String MESSAGGIO_BENVENUTO = "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
            + "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
            + "I locali sono popolati da strani personaggi, alcuni amici, altri... chissa!\n"
            + "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
            + "puoi raccoglierli, usarli, posarli quando ti sembrano inutili o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
            + "Per conoscere le istruzioni usa il comando 'aiuto'.";

    // Costruttore: inizializza lo scanner per la lettura da System.in
    public IOConsole() {
        try {
            scanner = new Scanner(System.in); // Crea uno scanner per leggere dall'input standard
        } catch (Exception e) { // Gestione dell'eventuale errore di inizializzazione
            System.err.println("Errore durante l'inizializzazione dello scanner: " + e.getMessage());
            throw e; // Rilancia l'eccezione
        }
    }

    // Restituisce il messaggio di benvenuto
    public String getMessBenvenuto() {
        return MESSAGGIO_BENVENUTO;
    }

    // Mostra un messaggio sullo standard output
    public void showMessage(String msg) {
        System.out.println(msg);
    }

    // Visualizza il messaggio di fine gioco
    public void fineGioco() {
        System.out.println("Grazie di aver giocato!");
    }
    
    // Legge una riga di input dall'utente
    public String readLine() {
        try {
            return scanner.nextLine(); // Restituisce la riga letta dall'utente
        } catch (Exception e) { // Gestisce eventuali eccezioni durante la lettura
            System.err.println("Errore durante la lettura dell'input: " + e.getMessage());
            throw e;
        }
    }
    
    
}
