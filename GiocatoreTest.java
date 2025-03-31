package it.uniroma3.diadia.giocatore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GiocatoreTest {

    @Test
    public void testSetCfuIniziali() {
        Giocatore giocatore = new Giocatore();
        giocatore.setCfuIniziali();
        assertEquals(20, giocatore.getCfu(), "I CFU iniziali devono essere 20");
    }

    @Test
    public void testSetAndGetCfu() {
        Giocatore giocatore = new Giocatore();
        giocatore.setCfu(15);
        assertEquals(15, giocatore.getCfu(), "I CFU devono essere impostati a 15");
    }

    @Test
    public void testGetBorsaNotNull() {
        Giocatore giocatore = new Giocatore();
        assertNotNull(giocatore.getBorsa(), "La borsa del giocatore non deve essere null");
    }
}
