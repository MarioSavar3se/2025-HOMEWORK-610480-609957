package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PartitaTest {

    @Test
    public void testGetStanzaCorrente() {
        Partita partita = new Partita();
        // Dopo la creazione del labirinto, la stanza iniziale è "Atrio"
        Stanza corrente = partita.getStanzaCorrente();
        assertNotNull(corrente, "La stanza corrente non deve essere null");
        assertEquals("Atrio", corrente.getNome(), "La stanza corrente dovrebbe essere 'Atrio'");
    }

    @Test
    public void testVinta() {
        Partita partita = new Partita();
        // Imposta la stanza corrente uguale a quella vincente
        Stanza vincente = partita.getStanzaVincente();
        partita.setStanzaCorrente(vincente);
        assertTrue(partita.vinta(), "La partita deve essere vinta quando la stanza corrente è quella vincente");
    }

    @Test
    public void testIsFinita() {
        Partita partita = new Partita();
        // Inizialmente la partita non è finita
        assertFalse(partita.isFinita(), "La partita non deve essere finita all'inizio");
        // Imposta i CFU a 0 per simulare una partita finita
        partita.setCfu(0);
        assertTrue(partita.isFinita(), "La partita deve essere finita se i CFU sono 0");
    }
}
