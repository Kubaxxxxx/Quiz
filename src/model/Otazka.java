package model;

/**
 * Abstraktni trida ktera predstavuje otazku
 */
public abstract class Otazka {
    protected String textOtazky;
    protected String spravnaOdpoved;

    /**
     * Vytvori otazku s textem a spravnou odpovedi
     * @param textOtazky text otazky
     * @param spravnaOdpoved spravnou odpoved
     */
    public Otazka(String textOtazky, String spravnaOdpoved) {
        this.textOtazky = textOtazky;
        this.spravnaOdpoved = spravnaOdpoved;
    }

    public String getTextOtazky() {
        return textOtazky;
    }

    public String getSpravnaOdpoved() {
        return spravnaOdpoved;
    }

    /**
     * Zkontroluje zda je odpoved spravna
     * @param odpoved odpoved uzivatele
     * @return true pokud je spravna
     */
    public abstract boolean jeSpravna(String odpoved);

    public abstract String[] getMoznosti();
}
