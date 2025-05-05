package it.uniroma3.diadia;

/** Interfaccia di I/O comune a console e simulatori. */
public interface IO {
    String getMessBenvenuto();
    void   showMessage(String msg);
    void   fineGioco();
    String readLine();
}
