package model;

public class VyberOdpovedi extends Otazka {

    private String[] moznosti;

    public VyberOdpovedi(String textOtazky, String spravnaOdpoved, String[] moznosti) {
        super(textOtazky, spravnaOdpoved);
        this.moznosti = moznosti;
    }

    @Override
    public boolean jeSpravna(String odpoved) {
        return spravnaOdpoved.equalsIgnoreCase(odpoved.trim());
    }

    @Override
    public String[] getMoznosti() {
        return moznosti;
    }
}
