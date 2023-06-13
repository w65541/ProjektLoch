package GameLogic;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

public class Menu extends JFrame{
    private JButton newGameButton;
    private JButton loadGameButton;
    private JButton exitButton;
    private JPanel panel;
    Loader loader=new Loader();
    Menu menu;
    public Menu() {
        menu=this;
        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 700);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            menu.dispose();
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Player player=new Player();
            Item none=new Item("none","none",0,0,0,0,0);
                player.setHelmet(new Item(none));
                player.setArmor(new Item(none));
                player.setBoots(new Item(none));
                player.setWeapon(new Item(none));
                player.setShield(new Item(none));
                JFrame a=new MainView(loader.getLevels(),player,new Backpack(player),new Loader());
                a.setVisible(true);
                menu.dispose();
            }
        });
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\levels");
                FileNameExtensionFilter restrict = new FileNameExtensionFilter("", "csv");
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.addChoosableFileFilter(restrict);
                if (chooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
                    loader.load(Paths.get(chooser.getSelectedFile().getPath()));
                    menu.dispose();
                }
            }
        });
    }
}
