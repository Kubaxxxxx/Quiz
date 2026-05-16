package ui;

import manager.SpravceKvizu;
import model.VysledekQuizu;

import javax.swing.*;
import java.awt.*;

/**
 * Okno ve kterem probiha samotny kviz
 */
public class KvizOkno extends  JFrame {
    private SpravceKvizu spravce;
    private String jmenoHrace;
    private JLabel Otazka;
    private JButton[] tlacitka;

    /**
     * Vytvori kvizove okno a zobrazi prvni otazku
     * @param jmenoHrace jméno hráče zadané v hlavním menu
     * @param spravce spravce kvizu, ktery ridi otazky a skore
     */
    public KvizOkno(String jmenoHrace, SpravceKvizu spravce) {
        this.jmenoHrace = jmenoHrace;
        this.spravce = spravce;

        setTitle("Quiz App");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 5, 5));

        Otazka = new JLabel("", JLabel.CENTER);
        Otazka.setFont(new Font("Arial", Font.BOLD, 14));
        add(Otazka);

        //Vytvoreni 4 tlacitek pro odpovedi
        tlacitka = new JButton[4];
        for (int i = 0; i < 4; i++) {
            tlacitka[i] = new JButton();
            final int index = i;
            tlacitka[i].addActionListener(e -> zpracujOdpoved(tlacitka[index].getText()));
            add(tlacitka[i]);
        }
        // Zobrazí první otázku
        zobrazOtazku();
    }

    /**
     * Zobrazi aktualni otazku a moznosti odpovedi
     */
    private void zobrazOtazku() {
        Otazka.setText(spravce.getAktualniOtazka().getTextOtazky());
        String[] moznosti = spravce.getAktualniOtazka().getMoznosti();
        for (int i = 0; i < 4; i++) {
            tlacitka[i].setText(moznosti[i]);
            tlacitka[i].setEnabled(true);
            tlacitka[i].setBackground(null);
        }
    }

    /**
     * Zpracuje odpoved, oznaci spravnost a prejde na dalsi otazku
     * @param odpoved odpoved kterou uzivatel vybral
     */
    private void zpracujOdpoved(String odpoved) {
        boolean spravna = spravce.zkontrolujOdpoved(odpoved);

        // Zakáže tlačítka a označí správnou/špatnou odpověď barvou
        for (JButton t : tlacitka) {
            t.setEnabled(false);
            if (t.getText().equals(spravce.getAktualniOtazka().getSpravnaOdpoved())) {
                t.setBackground(Color.GREEN);
            } else if (t.getText().equals(odpoved) && !spravna) {
                t.setBackground(Color.RED);
            }
        }

        // Po 1 sekundě přejde na další otázku nebo zobrazí výsledky
        Timer casovac = new Timer(1000, e -> {
            if (spravce.masDalsiOtazku()) {
                spravce.dalsiOtazka();
                zobrazOtazku();
            } else {
                dispose();
                new VysledkyOkno(new VysledekQuizu(jmenoHrace, spravce.getSkore(), spravce.getCelkemOtazek())).setVisible(true);
            }
        });
        casovac.setRepeats(false);
        casovac.start();
    }
}
