package GameLogic;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import lib.BackgroundPanel;
import GameLogic.Enemies.Enemy;
import GameLogic.Enemies.SkeletonSword;
import lib.BasicBackgroundPanel;

public class MainView extends JFrame {
    private JButton westButton;
    private JButton waitButton;
    private JButton eastButton;
    private JButton nortButton;
    private JButton southButton;
    private JPanel panel;
    private BasicBackgroundPanel roomView;
    private JButton leftButton;
    private JButton rightButton;
    private JProgressBar info;
    private JButton heal3Button;
    private JButton inventoryButton;
    private JPanel mapa;
    private JButton saveButton;
    private JButton loadButton;
    private JPanel view;
    private BackgroundPanel backgroundPanel1;
    private BasicBackgroundPanel basicBackgroundPanel1;
    private ArrayList<JLabel[]> mapCells = new ArrayList<>();

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    int n;
Player p;
    ArrayList<Level> levels;
    Backpack backpack;
    public MainView(ArrayList<Level> levels,Player player,Backpack backpack) {
        p=player;
        this.levels=levels;
        this.backpack=backpack;
        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 700);
        Logic logic = new Logic(this);
        Level lev=levels.get(p.getLevel());

        mapa.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int i = 0; i < lev.getMap().size() - 2; i++) {
            mapCells.add(new JLabel[lev.getMap().get(i).length - 2]);
            for (int j = 0; j < lev.getMap().get(i).length - 2; j++) {
                gbc.gridx = j;
                gbc.gridy = i;
                mapCells.get(i)[j] = new JLabel();
                mapa.add(mapCells.get(i)[j], gbc);
                mapa.revalidate();
                System.out.println(lev.getMap().get(i).length - 2);
            }
        }
        mapa.repaint();

        p.setY(lev.getStartY());
        p.setX(lev.getStartX());
        p.setView(0);

        JLabel stuff = new JLabel();
        //stuff.setIcon(new ImageIcon(logic.images2.get(12)));
        gbc.gridx = 0;
        gbc.gridy = 0;
        roomView.add(stuff, gbc);
        roomView.revalidate();
        roomView.repaint();

        panel.revalidate();
        panel.repaint();
        logic.roomRender(roomView, lev.getMap().get(p.getY()-1)[p.getX()], p, lev, stuff);

        p.setHp(5);
        updateHp(p);
        try {
            mapping(mapa, p, lev);
            mapCells.get(p.getY() - 1)[p.getX() - 1]
                    .setIcon(new ImageIcon(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\map\\player\\" + p.getDir() + ".png"))));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        nortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (p.getView()) {
                    case 0:
                        logic.moveNorth(p, lev, roomView, stuff);
                        break;
                    case 1:
                        logic.moveEast(p, lev, roomView, stuff);
                        break;
                    case 2:
                        logic.moveSouth(p, lev, roomView, stuff);
                        break;
                    case 3:
                        logic.moveWest(p, lev, roomView, stuff);
                        break;
                }
                moveCheck(getMain(), p, lev,backpack);
            }
        });
        eastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (p.getView()) {
                    case 3:
                        logic.moveNorth(p, lev, roomView, stuff);
                        break;
                    case 0:
                        logic.moveEast(p, lev, roomView, stuff);
                        break;
                    case 1:
                        logic.moveSouth(p, lev, roomView, stuff);
                        break;
                    case 2:
                        logic.moveWest(p, lev, roomView, stuff);
                        break;
                }
                moveCheck(getMain(), p, lev,backpack);
            }
        });
        westButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (p.getView()) {
                    case 1:
                        logic.moveNorth(p, lev, roomView, stuff);
                        break;
                    case 2:
                        logic.moveEast(p, lev, roomView, stuff);
                        break;
                    case 3:
                        logic.moveSouth(p, lev, roomView, stuff);
                        break;
                    case 0:
                        logic.moveWest(p, lev, roomView, stuff);
                        break;
                }
                moveCheck(getMain(), p, lev,backpack);
            }
        });
        southButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (p.getView()) {
                    case 2:
                        logic.moveNorth(p, lev, roomView, stuff);
                        break;
                    case 3:
                        logic.moveEast(p, lev, roomView, stuff);
                        break;
                    case 0:
                        logic.moveSouth(p, lev, roomView, stuff);
                        break;
                    case 1:
                        logic.moveWest(p, lev, roomView, stuff);
                        break;
                }
                moveCheck(getMain(), p, lev,backpack);
            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.turnLeft(p, lev, roomView, stuff);
                try {
                    mapCells.get(p.getY() - 1)[p.getX() - 1]
                            .setIcon(new ImageIcon(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\map\\player\\" + p.getDir() + ".png"))));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.turnRight(p, lev, roomView, stuff);
                System.out.println("view: " + p.getView() + p.getDir());
                try {
                    mapCells.get(p.getY() - 1)[p.getX() - 1]
                            .setIcon(new ImageIcon(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\map\\player\\" + p.getDir() + ".png"))));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
        waitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Enemy> en = new ArrayList<Enemy>();
                en.add(new SkeletonSword(1));
                //en.add(new SkeletonSword(1));
                startBattle(en, p, lev.getMap().get(p.getY())[p.getX()]);
            }
        });
        heal3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.getPotion().heal(p);
                heal3Button.setText("Heal(" + p.getPotion().getCount() + ")");
                if (p.getPotion().getCount() == 0) heal3Button.setEnabled(false);
                updateHp(p);
            }
        });
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backpack.setVisible(true);
            }
        });
    }

    void startBattle(ArrayList<Enemy> enemies, Player player, Room r) {
        System.out.println(enemies.size());
        n = enemies.size();
        for (int i = 0; i < enemies.size(); i++) {
            JFrame a = new Battle(player, enemies.get(i), this, r);
            a.setVisible(true);
        }
        setVisible(false);
    }

    void updateHp(Player p) {
        info.setMaximum(p.getMaxHP());
        info.setValue(p.getHp());
        System.out.println("" + p.getHp() + "/" + p.getMaxHP());
        info.setString("" + p.getHp() + "/" + p.getMaxHP());
    }

    void mapping(JPanel panel, Player p, Level l) {
        try {
            ArrayList<Room> tomap = new Logic(this).mappable(p, l.getMap());
            if (tomap != null) {
                for (int i = 0; i < tomap.size(); i++) {
                    mapCells.get(tomap.get(i).getY() - 1)[tomap.get(i).getX() - 1].setIcon(new ImageIcon(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\map\\" + tomap.get(i).map + ".png"))));
                }
            }
            l.getMap().get(p.getY())[p.getX()].setMapped(false);
            mapCells.get(p.getY() - 1)[p.getX() - 1]
                    .setIcon(new ImageIcon(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\map\\player\\" + p.getDir() + ".png"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void moveCheck(MainView mainView,Player player,Level level,Backpack backpack) {
        mapping(mapa, player, level);
        Room room=level.getMap().get(player.getY())[player.getX()];
        if(room.isKey()){
            room.setKey(false);
            player.setKey(true);
        }
        if(room.isDoor() && player.isKey()){
            //czy ma przejść do następnego poziomu
            nextLevel(mainView);
        }
        if(room.isTreasure()){
            room.setTreasure(false);
            //dodanie rzeczy do ekwipunku
            backpack.update(player);
        }
        if(room.getEnemies()!=null){
            startBattle(room.getEnemies(),player,room);
        }
    }

    void nextLevel(MainView mainView){
        p.nextLevel();
        if(p.getLevel()!=p.getLastLevel()){
        MainView next=new MainView(levels,p,backpack);
        next.setVisible(true);
        mainView.dispose();
        }else{
        WinScreen next=new WinScreen();
        next.setVisible(true);
        mainView.dispose();
        }
    }
    MainView getMain(){return this;}
}
