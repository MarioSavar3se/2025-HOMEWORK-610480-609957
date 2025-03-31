package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StanzaTest {

    @Test
    public void testAddAttrezzo() {
        // Crea una nuova stanza
        Stanza stanza = new Stanza("TestStanza");
        // Crea un attrezzo da aggiungere
        Attrezzo attrezzo = new Attrezzo("chiave", 1);
        // Aggiunge l'attrezzo e controlla che l'operazione vada a buon fine
        assertTrue(stanza.addAttrezzo(attrezzo), "L'aggiunta dell'attrezzo dovrebbe avere successo");
        // Verifica che la stanza contenga l'attrezzo aggiunto
        assertTrue(stanza.hasAttrezzo("chiave"), "La stanza dovrebbe contenere l'attrezzo 'chiave'");
        // Verifica che il metodo getAttrezzo restituisca l'attrezzo corretto
        assertEquals(attrezzo, stanza.getAttrezzo("chiave"), "getAttrezzo deve restituire l'attrezzo 'chiave'");
    }

    @Test
    public void testRemoveAttrezzo() {
        Stanza stanza = new Stanza("TestStanza");
        Attrezzo attrezzo = new Attrezzo("martello", 2);
        stanza.addAttrezzo(attrezzo);
        // Rimuove l'attrezzo e controlla il risultato
        assertTrue(stanza.removeAttrezzo(attrezzo), "La rimozione dell'attrezzo deve restituire true");
        // Dopo la rimozione, la stanza non deve più contenere l'attrezzo
        assertFalse(stanza.hasAttrezzo("martello"), "La stanza non deve contenere l'attrezzo 'martello'");
    }

    @Test
    public void testImpostaStanzaAdiacente() {
        Stanza stanza1 = new Stanza("Stanza1");
        Stanza stanza2 = new Stanza("Stanza2");
        // Imposta stanza2 come adiacente in direzione "nord" di stanza1
        stanza1.impostaStanzaAdiacente("nord", stanza2);
        // Verifica che getStanzaAdiacente("nord") restituisca stanza2
        assertEquals(stanza2, stanza1.getStanzaAdiacente("nord"), "La stanza adiacente in 'nord' deve essere Stanza2");
    }
}
