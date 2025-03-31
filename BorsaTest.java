package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BorsaTest {

    @Test
    public void testAddAttrezzo() {
        Borsa borsa = new Borsa();
        Attrezzo attrezzo = new Attrezzo("chiave", 1);
        assertTrue(borsa.addAttrezzo(attrezzo), "L'aggiunta dell'attrezzo dovrebbe avere successo");
        assertNotNull(borsa.getAttrezzo("chiave"), "La borsa deve contenere l'attrezzo 'chiave'");
    }

    @Test
    public void testRemoveAttrezzo() {
        Borsa borsa = new Borsa();
        Attrezzo attrezzo = new Attrezzo("martello", 2);
        borsa.addAttrezzo(attrezzo);
        Attrezzo removed = borsa.removeAttrezzo("martello");
        assertEquals(attrezzo, removed, "L'attrezzo rimosso deve essere quello aggiunto");
        assertNull(borsa.getAttrezzo("martello"), "La borsa non deve più contenere l'attrezzo 'martello'");
    }

    @Test
    public void testGetPeso() {
        Borsa borsa = new Borsa();
        Attrezzo attrezzo1 = new Attrezzo("libro", 2);
        Attrezzo attrezzo2 = new Attrezzo("penna", 1);
        borsa.addAttrezzo(attrezzo1);
        borsa.addAttrezzo(attrezzo2);
        // Il peso totale deve essere 3 (2 + 1)
        assertEquals(3, borsa.getPeso(), "Il peso totale della borsa deve essere 3kg");
    }
}
