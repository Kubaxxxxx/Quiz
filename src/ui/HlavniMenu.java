package ui;

import javax.swing.*;
import java.awt.*;

public class HlavniMenu extends JFrame {

    private JTextField poleJmeno;
    private JLabel chyba;

    public HlavniMenu() {
        setTitle("Quiz App");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(4,1,10,10));

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

    public void  spustitQuiz() {
        String jmeno = poleJmeno.getText().trim();
        if(jmeno.isEmpty()){
            chyba.setText("Prosim zadej sve jmeno!");
            return;
        }
    }

    public String getJmeno(){
        return poleJmeno.getText().trim();
    }
}
