package model;

public abstract class Otazka {
    protected String textOtazky;
    protected String spravnaOdpoved;

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

    public abstract boolean jeSpravna(String odpoved);

    public abstract String[] getMoznosti();
}
