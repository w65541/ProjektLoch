package GameLogic;

import javax.swing.*;

public class WinScreen extends JFrame{
    private JPanel panel1;
    public WinScreen(){
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 700);
    }
}
