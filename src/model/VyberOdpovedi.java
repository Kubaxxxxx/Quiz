package model;

/**
 * Rozsiruje tridu abstrakni tridu Otazka
 */
public class VyberOdpovedi extends Otazka {

    private String[] moznosti;

    /**
     * Vytvori otazku s vyberem odpovedi
     * @param textOtazky text otazky
     * @param spravnaOdpoved spravna odpoved
     * @param moznosti pole moznych odpovedi
     */
    public VyberOdpovedi(String textOtazky, String spravnaOdpoved, String[] moznosti) {
        super(textOtazky, spravnaOdpoved);
        this.moznosti = moznosti;
    }

    /**
     * Porovnava odpoved uzivatele se spravnou odpovedi
     * @param odpoved odpoved uzivatele
     * @return true pokud spravna moznost
     */
    @Override
    public boolean jeSpravna(String odpoved) {
        return spravnaOdpoved.equalsIgnoreCase(odpoved.trim());
    }

    @Override
    public String[] getMoznosti() {
        return moznosti;
    }
}
