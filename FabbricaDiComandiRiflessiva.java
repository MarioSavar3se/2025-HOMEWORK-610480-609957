package it.uniroma3.diadia.comandi;

import java.lang.reflect.*;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
    private static final String COMMANDS_PKG = "it.uniroma3.diadia.comandi";
    @Override
    public Comando costruisciComando(String istruzione) {
        String[] parts = istruzione.trim().split("\\s+");
        String name = parts.length>0? parts[0] : null;
        String param = parts.length>1? parts[1] : null;
        String className = (name==null)
            ? "ComandoNonValido"
            : "Comando" + name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        try {
            Class<?> cls = Class.forName(COMMANDS_PKG + "." + className);
            Comando cmd = (Comando) cls.getDeclaredConstructor().newInstance();
            cmd.setParametro(param);
            return cmd;
        } catch (Exception e) {
            Comando cmd = new ComandoNonValido();
            cmd.setParametro(param);
            return cmd;
        }
    }
}