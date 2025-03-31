package it.uniroma3.diadia.ambienti;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LabirintoTest {

    @Test
    public void testCreaStanzeNotNull() {
        Labirinto labirinto = new Labirinto();
        labirinto.creaStanze();
        // Verifica che dopo la creazione le stanze corrente e vincente non siano null
        assertNotNull(labirinto.getStanzaCorrente(), "La stanza corrente non deve essere null");
        assertNotNull(labirinto.getStanzaVincente(), "La stanza vincente non deve essere null");
    }

    @Test
    public void testStanzaCorrente() {
        Labirinto labirinto = new Labirinto();
        labirinto.creaStanze();
        // Controlla che la stanza corrente sia "Atrio" come previsto dalla logica
        assertEquals("Atrio", labirinto.getStanzaCorrente().getNome(), "La stanza corrente dovrebbe essere 'Atrio'");
    }

    @Test
    public void testStanzaVincente() {
        Labirinto labirinto = new Labirinto();
        labirinto.creaStanze();
        // Controlla che la stanza vincente sia "Biblioteca"
        assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome(), "La stanza vincente dovrebbe essere 'Biblioteca'");
    }
}
