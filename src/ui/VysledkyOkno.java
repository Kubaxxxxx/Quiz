package ui;

import model.VysledekQuizu;

import javax.swing.*;
import java.awt.*;

public class VysledkyOkno extends JFrame {

    public VysledkyOkno(VysledekQuizu vysledek) {
        setTitle("Quiz App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 5, 5));

        add(new JLabel("Hráč: " + vysledek.getJmenoHrace(), JLabel.CENTER));
        add(new JLabel("Skóre: " + vysledek.getSkore() + " / " + vysledek.getCelkemOtazek(), JLabel.CENTER));
        add(new JLabel(vysledek.getHodnoceni(), JLabel.CENTER));

        JButton tlacitkoZnovu = new JButton("Hrát znovu");
        tlacitkoZnovu.addActionListener(e -> {
            dispose();
            new HlavniMenu().setVisible(true);
        });
        add(tlacitkoZnovu);
    }
}
