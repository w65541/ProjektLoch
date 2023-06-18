package GameLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoseScreen extends  JFrame{
    private JPanel panel;
    private JButton menuButton;

    public LoseScreen() {
        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 700);


        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame a=new Menu();
                a.setLocationRelativeTo(null);
                a.setVisible(true);
                dispose();
            }
        });
    }
}
