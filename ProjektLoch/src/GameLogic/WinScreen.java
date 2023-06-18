package GameLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinScreen extends JFrame{
    private JPanel panel1;
    private JButton menuButton;

    public WinScreen(){
        this.setContentPane(this.panel1);
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
