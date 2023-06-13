package GameLogic;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import GameLogic.Enemies.Necromancer;
import lib.BackgroundPanel;
import GameLogic.Enemies.Enemy;
import GameLogic.Enemies.SkeletonSword;
import lib.BasicBackgroundPanel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

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
    private JLabel key;
    private JPanel view;
    private BackgroundPanel backgroundPanel1;
    private BasicBackgroundPanel basicBackgroundPanel1;
    private ArrayList<JLabel[]> mapCells = new ArrayList<>();
private Loader loader;
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
MainView mainView;
    int n;
Player p;
    ArrayList<Level> levels;
    Backpack backpack;Level lev;
    public MainView(ArrayList<Level> levels,Player player,Backpack backpack,Loader loader) {
        p=player;
        this.mainView=this;
        this.levels=levels;
        this.backpack=backpack;
        this.loader=loader;
        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 700);
        Logic logic = new Logic(this);
        lev=levels.get(p.getLevel());
        if(p.isKey()) invkey(this);
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
                    case 3 -> logic.moveNorth(p, lev, roomView, stuff);
                    case 0 -> logic.moveEast(p, lev, roomView, stuff);
                    case 1 -> logic.moveSouth(p, lev, roomView, stuff);
                    case 2 -> logic.moveWest(p, lev, roomView, stuff);
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

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\levels");
                FileNameExtensionFilter restrict = new FileNameExtensionFilter("", "csv");
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.addChoosableFileFilter(restrict);
                if (chooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
                    loader.load(Paths.get(chooser.getSelectedFile().getPath()));
                    mainView.dispose();
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\levels");
                FileNameExtensionFilter restrict = new FileNameExtensionFilter("", "csv");
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.addChoosableFileFilter(restrict);
                chooser.setApproveButtonText("Save");
                if (chooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
                    save(Paths.get(chooser.getSelectedFile().getPath()+".csv"),lev,player);
                }
            }
        });
    }

    void startBattle(ArrayList<Enemy> enemies, Player player, Room r) {
        System.out.println(enemies.size());
        n = enemies.size();
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).setTeam(enemies);
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
    public void mapRestoration(){
        restoreMap(mapa,p,lev);
    }
    void restoreMap(JPanel panel,Player p,Level l){
        try {

                for (int i = 1; i < l.getMap().size()-1; i++) {
                    for (int j = 1; j < l.getMap().get(i).length-1; j++) {
                        if(l.getMap().get(i)[j].isMapped())mapCells.get(i-1)[j-1].setIcon((new ImageIcon(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\map\\" + l.getMap().get(i)[j].map + ".png")))));
                    }
                }
            l.getMap().get(p.getY())[p.getX()].setMapped(false);
            mapCells.get(p.getY() - 1)[p.getX() - 1]
                    .setIcon(new ImageIcon(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\map\\player\\" + p.getDir() + ".png"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    void invkey(MainView mainView){
        try {
            mainView.key.setIcon(new ImageIcon(ImageIO.read(new File((new File("").getAbsolutePath())+"\\src\\images\\keyinv.png"))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    void moveCheck(MainView mainView,Player player,Level level,Backpack backpack) {
        mapping(mapa, player, level);
        Room room=level.getMap().get(player.getY())[player.getX()];
        mainView.updateHp(p);
        if(room.isKey()){
            room.setKey(false);
            player.setKey(true);
            invkey(mainView);
            return;
        }
        if(room.isDoor() && player.isKey()){
            //czy ma przejść do następnego poziomu
            p.setKey(false);nextLevel(mainView);return;
        }
        if(room.isTreasure()){
            room.setTreasure(false);
            //dodanie rzeczy do ekwipunku
            player.getInv().add(room.item);
            backpack.update(player);return;
        }
        if(room.isEnemy()){
            startBattle(room.getEnemies(),player,room);return;
        }
        if(room.isPotion()){
            player.getPotion().add();
            room.setPotion(false);
            mainView.heal3Button.setText("Heal("+player.potion.getCount()+")");return;
        }
    }

    void nextLevel(MainView mainView){
        p.nextLevel();
        if(p.getLevel()!=p.getLastLevel()){
        MainView next=new MainView(levels,p,backpack,loader);
        next.setVisible(true);
        mainView.dispose();
        }else{
        WinScreen next=new WinScreen();
        next.setVisible(true);
        mainView.dispose();
        }
    }
    MainView getMain(){return this;}

    public void save( Path p,Level level,Player player){
        try{
            BufferedWriter writer = Files.newBufferedWriter(p, StandardCharsets.UTF_8 ) ;
            CSVFormat csvFileFormat = CSVFormat.DEFAULT;
            CSVPrinter plik=new CSVPrinter(writer,csvFileFormat);
           // ResultSetMetaData rsmd = r.getMetaData();
            for (int i=1;i<=level.getMap().get(0).length-2;i++){
                plik.print(i);
            }
            plik.print("Player");
            plik.print("Inv");
            plik.println();
            String temp="";
            for (int j=1;j<=level.getMap().get(0).length-2;j++){
                temp="";
                temp+=level.getMap().get(1)[j].getType();
                if(level.getMap().get(1)[j].isMapped()){temp+=":m";}else{temp+=":n";}
                if(level.getMap().get(1)[j].isKey()) temp+=":k";
                if(level.getMap().get(1)[j].isDoor()) temp+=":d";
                if(level.getMap().get(1)[j].isTreasure())temp+=(":i:"+level.getMap().get(1)[j].getContentId());
                if(level.getMap().get(1)[j].isEnemy())temp+=(":e:"+level.getMap().get(1)[j].getContentId());
                plik.print(temp);
            }
            temp=""+player.getX()+":"+player.getY()+":"+player.getLevel()+":"+player.getHp()+":"+player.getPotion().getCount()+":"+
                    player.isKey()+":"+player.getHelmet().getId()+":"+player.getArmor().getId()+":"+player.getBoots().getId()+":"+player.getWeapon().getId()+":"+player.getShield().getId();
            plik.print(temp);
            temp="";
            for (int i = 0; i < player.getInv().size(); i++) {
                temp+=player.getInv().get(i).getId()+":";
            }
            plik.print(temp);
            plik.println();
            for (int i=2;i<=level.getMap().get(0).length-2;i++){
                for (int j=1;j<=level.getMap().get(0).length-2;j++){
                    temp="";
                    temp+=level.getMap().get(i)[j].getType();
                    if(level.getMap().get(i)[j].isMapped()){temp+=":m";}else{temp+=":n";}
                    if(level.getMap().get(i)[j].isKey()) temp+=":k";
                    if(level.getMap().get(i)[j].isDoor()) temp+=":d";
                    if(level.getMap().get(i)[j].isTreasure())temp+=(":i:"+level.getMap().get(i)[j].getContentId());
                    if(level.getMap().get(i)[j].isEnemy())temp+=(":e:"+level.getMap().get(i)[j].getContentId());
                    plik.print(temp);
                }
                plik.println();
            }
            plik.close();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
