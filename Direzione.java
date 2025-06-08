package it.uniroma3.diadia.enum;

public enum Direzione {
    NORD, SUD, EST, OVEST;
    public static Direzione fromString(String s) {
        return valueOf(s.trim().toUpperCase());
    }
}