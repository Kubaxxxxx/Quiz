package manager;

import model.Otazka;
import model.VyberOdpovedi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpravceKvizu {
    private List<Otazka> otazky;
    private int indexAktualniOtazky;
    private int skore;

    public SpravceKvizu() {
        otazky = new ArrayList<>();
        indexAktualniOtazky = 0;
        skore = 0;
        nactiOtazky();
        Collections.shuffle(otazky);
    }

    private void nactiOtazky() {
        otazky.add(new VyberOdpovedi(
                "Jaké je hlavní město České republiky?",
                "Praha",
                new String[]{"Praha", "Brno", "Ostrava", "Plzeň"}
        ));
        otazky.add(new VyberOdpovedi(
                "Kolik má rok měsíců?",
                "12",
                new String[]{"10", "11", "12", "13"}
        ));
        otazky.add(new VyberOdpovedi(
                "Jaký je výsledek 7 × 8?",
                "56",
                new String[]{"48", "54", "56", "64"}
        ));
        otazky.add(new VyberOdpovedi(
                "Kdo napsal Babičku?",
                "Božena Němcová",
                new String[]{"Karel Čapek", "Božena Němcová", "Jan Neruda", "Alois Jirásek"}
        ));
    }
    public Otazka getAktualniOtazka() {
        return otazky.get(indexAktualniOtazky);
    }

    public boolean zkontrolujOdpoved(String odpoved) {
        boolean spravna = getAktualniOtazka().jeSpravna(odpoved);
        if (spravna) skore++;
        return spravna;
    }

    public boolean masDalsiOtazku() {
        return indexAktualniOtazky + 1 < otazky.size();
    }

    public void dalsiOtazka() {
        if (masDalsiOtazku()) indexAktualniOtazky++;
    }

    public int getSkore() {
        return skore;
    }

    public int getCelkemOtazek() {
        return otazky.size();
    }

    public int getIndexAktualniOtazky() {
        return indexAktualniOtazky;
    }
}
