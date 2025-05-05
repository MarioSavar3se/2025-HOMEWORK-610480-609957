package it.uniroma3.diadia.comandi;

import java.util.Scanner;

/** Versione “a fisarmonica” mostrata a lezione. */
public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {

    @Override
    public Comando costruisciComando(String istruzione) {
        Scanner scanner = new Scanner(istruzione);
        String nome = (scanner.hasNext()) ? scanner.next() : null;
        String parametro = (scanner.hasNext()) ? scanner.next() : null;
        scanner.close();

        Comando comando;
        if (nome == null) {
            comando = new ComandoNonValido();
        } else {
            switch (nome) {
                case "vai"    -> comando = new ComandoVai();
                case "prendi" -> comando = new ComandoPrendi();
                case "posa"   -> comando = new ComandoPosa();
                case "aiuto"  -> comando = new ComandoAiuto();
                case "fine"   -> comando = new ComandoFine();
                case "guarda" -> comando = new ComandoGuarda();
                default       -> comando = new ComandoNonValido();
            }
        }
        comando.setParametro(parametro);
        return comando;
    }
}
