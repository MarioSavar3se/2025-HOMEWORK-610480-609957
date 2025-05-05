package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {

    // Se preferisci, passa l’elenco dall’esterno; qui lo codifichiamo.
    private static final String[] ELENCO = {
        "vai", "prendi", "posa", "guarda", "aiuto", "fine"
    };

    @Override
    public void esegui(Partita partita) {
        StringBuilder sb = new StringBuilder("Comandi disponibili: ");
        for (String c : ELENCO) sb.append(c).append(" ");
        partita.getIO().showMessage(sb.toString());
    }
}
