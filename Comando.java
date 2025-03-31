package it.uniroma3.diadia; // Definisce il package in cui risiede la classe Comando

import it.uniroma3.diadia.IOConsole.IOConsole; // Importa la classe IOConsole per gestire l'input centralizzato
import java.util.Scanner; // Importa la classe Scanner per il parsing della stringa letta

public class Comando { // Inizio della definizione della classe Comando

    private String nome;       // Variabile per memorizzare il nome del comando (la prima parola)
    private String parametro;  // Variabile per memorizzare il parametro del comando (la seconda parola, se presente)

    // Costruttore che utilizza IOConsole per leggere l'input e separarlo in nome e parametro
    public Comando(IOConsole ioconsole) {
        try {
            String istruzione = ioconsole.readLine(); // Legge una riga di input tramite IOConsole
            // Utilizza un oggetto Scanner per analizzare la riga letta
            Scanner scanner = new Scanner(istruzione);
            if (scanner.hasNext()) // Se la riga contiene almeno una parola
                this.nome = scanner.next(); // La prima parola viene salvata come nome del comando
            if (scanner.hasNext()) // Se esiste una seconda parola
                this.parametro = scanner.next(); // La seconda parola viene salvata come parametro del comando
            scanner.close(); // Chiude lo scanner per liberare le risorse
        } catch (Exception e) { // Gestione dell'eventuale eccezione
            System.err.println("Errore nella lettura del comando: " + e.getMessage());
            throw e; // Rilancia l'eccezione dopo aver stampato il messaggio di errore
        }
    }

    // Restituisce il nome del comando
    public String getNome() {
        return this.nome;
    }

    // Restituisce il parametro del comando (se presente)
    public String getParametro() {
        return this.parametro;
    }

    // Verifica se il comando è sconosciuto (ovvero se il nome non è stato definito)
    public boolean sconosciuto() {
        return (this.nome == null);
    }
}
