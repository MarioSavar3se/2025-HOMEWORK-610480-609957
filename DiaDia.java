package it.uniroma3.diadia;

import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.comandi.*;

/**
 * Avvia e gestisce una partita a DiaDia.
 * <p>
 * – Costruttore di default → usa IOConsole (interazione reale da tastiera).<br>
 * – Costruttore con parametro IO → consente di passare IOSimulator nei test.
 */
public class DiaDia {

    /* =================== CAMPI =================== */

    private final IO       io;
    private final Partita partita;
    private final FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();

    /* =================== COSTRUTTORI =================== */

    /** Partita “normale” da console. */
    public DiaDia() {
        this(new IOConsole());
    }

    /** Partita con un qualsiasi canale IO (p.es. IOSimulator nei test). */
    public DiaDia(IO io) {
        this.io      = io;
        this.partita = new Partita(io);
    }

    /* =================== LOGICA DI GIOCO =================== */

    public void gioca() {
        io.showMessage(io.getMessBenvenuto());

        while (!partita.isFinita()) {
            String istruzione = io.readLine();

            Comando comando = factory.costruisciComando(istruzione);
            comando.esegui(partita);

            if (partita.vinta())
                io.showMessage("Hai vinto!");
        }
        io.fineGioco();
    }

    /* =================== MAIN =================== */

    public static void main(String[] args) {
        new DiaDia().gioca();
    }
}
