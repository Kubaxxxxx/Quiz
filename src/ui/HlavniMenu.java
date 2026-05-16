package ui;

import manager.SpravceKvizu;

import javax.swing.*;
import java.awt.*;

/**
 * Hlavni menu kde hrac zada jmeno a spusti kviz
 */
public class HlavniMenu extends JFrame {

    private JTextField poleJmeno;
    private JLabel chyba;

    /**
     * Vytvori a nastavi hlavni menu
     */
    public HlavniMenu() {
        setTitle("Quiz App");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(5,1,10,10));

        JLabel nadpis = new JLabel("Vytej v Quiz App",JLabel.CENTER);
        nadpis.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel Stitek = new JLabel("Zadej sve jmeno: ",JLabel.CENTER);

        chyba = new JLabel("",JLabel.CENTER);
        chyba.setForeground(Color.RED);

        poleJmeno = new JTextField();

        JButton start = new JButton("Spustit Quiz");
        start.addActionListener(e -> spustitQuiz());

        add(nadpis);
        add(Stitek);
        add(poleJmeno);
        add(chyba);
        add(start);
    }

    /**
     * Zkontroluje jmeno a spusti kviz nebo hodi chybu
     */
    public void  spustitQuiz() {
        String jmeno = poleJmeno.getText().trim();
        if(jmeno.isEmpty()){
            chyba.setText("Prosim zadej sve jmeno!");
            return;
        }
        dispose();
        new KvizOkno(jmeno, new SpravceKvizu()).setVisible(true);
    }
}
