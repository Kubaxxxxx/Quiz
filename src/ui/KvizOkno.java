package ui;

import manager.SpravceKvizu;

import javax.swing.*;
import java.awt.*;


public class KvizOkno extends  JFrame {
    private SpravceKvizu spravce;
    private String jmenoHrace;
    private JLabel Otazka;
    private JButton[] tlacitka;

    public KvizOkno(String jmenoHrace, SpravceKvizu spravce) {
        this.jmenoHrace = jmenoHrace;
        this.spravce = spravce;

        setTitle("Quiz App");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1, 5, 5));

        Otazka = new JLabel("", SwingConstants.CENTER);
        Otazka.setFont(new Font("Arial", Font.BOLD, 14));
        add(Otazka);
    }

    private void zobrazOtazku() {
        Otazka.setText(spravce.getAktualniOtazka().getTextOtazky());
        String[] moznosti = spravce.getAktualniOtazka().getMoznosti();
        for (int i = 0; i < 4; i++) {
            tlacitka[i].setText(moznosti[i]);
            tlacitka[i].setEnabled(true);
            tlacitka[i].setBackground(null);
        }
    }


}
