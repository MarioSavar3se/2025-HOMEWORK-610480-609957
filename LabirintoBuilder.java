package it.uniroma3.diadia.ambienti;

import java.io.*;
import java.util.*;
import it.uniroma3.diadia.enum.Direzione;

public class LabirintoBuilder {
    private Map<String,Stanza> stanze = new HashMap<>();
    private Stanza entrata, uscita;

    public LabirintoBuilder daFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine())!=null) {
                line = line.trim();
                if (line.isEmpty()|| line.startsWith("#")) continue;
                String[] parts = line.split(" ");
                switch(parts[0]) {
                    case "Stanza": stanze.put(parts[1], new Stanza(parts[1])); break;
                    case "Attrezzo": stanze.get(parts[1]).addAttrezzo(new Attrezzo(parts[2], Integer.parseInt(parts[3]))); break;
                    case "Adiacente":
                        Stanza s1 = stanze.get(parts[1]);
                        Stanza s2 = stanze.get(parts[2]);
                        s1.impostaStanzaAdiacente(Direzione.fromString(parts[3]), s2);
                        break;
                    case "Inizio": entrata = stanze.get(parts[1]); break;
                    case "Vincente": uscita = stanze.get(parts[1]); break;
                }
            }
        }
        return this;
    }
    public Labirinto build() { return new Labirinto(this); }
    public Stanza getEntrata() { return entrata; }
    public Stanza getUscita()  { return uscita; }
}
