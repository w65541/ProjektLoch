package GameLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Szlam extends JFrame{
    private JButton button1;
    private JPanel panel;
    int i=0;
    public Szlam() {
        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1300,700);
        setLocationRelativeTo(null);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                if(i==8) dispose();
            }
        });
    }
}
