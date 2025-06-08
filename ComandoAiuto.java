package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
    private static final String[] ELENCO = {
        "vai", "prendi", "posa", "guarda", "aiuto", "fine"
    };

    @Override
    public void setParametro(String parametro) {
        // nessun parametro per aiuto
    }

    @Override
    public void esegui(Partita partita) {
        StringBuilder sb = new StringBuilder("Comandi disponibili: ");
        for (String c : ELENCO) {
            sb.append(c).append(" ");
        }
        partita.getIO().showMessage(sb.toString());
    }
}