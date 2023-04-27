package GameLogic;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import lib.BackgroundPanel;
import GameLogic.Enemies.Enemy;
import GameLogic.Enemies.SkeletonSword;
import lib.BackgroundPanel;
import lib.BasicBackgroundPanel;

public class MainView extends JFrame{
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
    private JPanel view;
    private BackgroundPanel backgroundPanel1;
    private BasicBackgroundPanel basicBackgroundPanel1;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    int n;
    public MainView() {
        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300,700);
        Logic logic=new Logic(this);
        ArrayList<Room[]> m=new ArrayList<>();
        {
            m.add(new Room[5]);
            m.get(0)[0] = new Room(0, 0, 0);
            m.get(0)[1] = new Room(0, 1, 0);
            m.get(0)[2] = new Room(0, 2, 0);
            m.get(0)[3] = new Room(0, 3, 0);
            m.get(0)[4] = new Room(0, 4, 0);

            m.add(new Room[5]);
            m.get(1)[0] = new Room(0, 0, 1);
            m.get(1)[1] = new Room(10, 1, 1);
            m.get(1)[2] = new Room(11, 2, 1);
            m.get(1)[3] = new Room(9, 3, 1);
            m.get(1)[4] = new Room(0, 4, 1);

            m.add(new Room[5]);
            m.get(2)[0] = new Room(0, 0, 2);
            m.get(2)[1] = new Room(14, 1, 2);
            m.get(2)[2] = new Room(8, 2, 2);
            m.get(2)[3] = new Room(15, 3, 2);
            m.get(2)[4] = new Room(0, 4, 2);
            m.add(new Room[5]);
            m.get(3)[0] = new Room(0, 0, 3);
            m.get(3)[1] = new Room(6, 1, 3);
            m.get(3)[2] = new Room(7, 2, 3);
            m.get(3)[3] = new Room(5, 3, 3);
            m.get(3)[4] = new Room(0, 4, 3);
            m.add(new Room[5]);
            m.get(4)[0] = new Room(0, 0, 4);
            m.get(4)[1] = new Room(0, 1, 4);
            m.get(4)[2] = new Room(0, 2, 4);
            m.get(4)[3] = new Room(0, 3, 4);
            m.get(4)[4] = new Room(0, 4, 4);
        }
        m.get(1)[2].setKey(true);
        m.get(1)[3].setDoor(true);
        m.get(1)[1].setEnemy(true);
        Level lev=new Level(m);
        Player p=new Player();



        p.setY(2);
        p.setX(2);
        p.setView(0);

        JLabel stuff=new JLabel();
        //stuff.setIcon(new ImageIcon(logic.images2.get(12)));
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        roomView.add(stuff,gbc);
        roomView.revalidate();
        roomView.repaint();
        mapa.setLayout(new GridBagLayout());
panel.revalidate();
        panel.repaint();
        logic.roomRender(roomView,m.get(1)[2],p,lev,stuff);

        p.setHelmet(new Item(0,0,0,2,"Hełm","helmet"));
        p.setArmor(new Item(0,0,0,2,"a","armor"));
        p.setBoots(new Item(0,0,0,2,"b","boots"));
        p.setWeapon(new Item(0,0,1,0,"v","weapon"));
        p.setShield(new Item(0,0,0,2,"c","shield"));
        p.getInv().add(new Item(0,0,0,3,"Hełm żelazny","helmet"));
        Backpack backpack=new Backpack(p);p.setHp(5);
        updateHp(p);
        nortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (p.getView()){
                    case 0:logic.moveNorth(p,lev,roomView,stuff);break;
                    case 1:logic.moveEast(p,lev,roomView,stuff);break;
                    case 2:logic.moveSouth(p,lev,roomView,stuff);break;
                    case 3:logic.moveWest(p,lev,roomView,stuff);break;
                }
                mapping(mapa,p,lev);
            }
        });
        eastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (p.getView()){
                    case 3:logic.moveNorth(p,lev,roomView,stuff);break;
                    case 0:logic.moveEast(p,lev,roomView,stuff);break;
                    case 1:logic.moveSouth(p,lev,roomView,stuff);break;
                    case 2:logic.moveWest(p,lev,roomView,stuff);break;
                }
            }
        });
        westButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (p.getView()){
                    case 1:logic.moveNorth(p,lev,roomView,stuff);break;
                    case 2:logic.moveEast(p,lev,roomView,stuff);break;
                    case 3:logic.moveSouth(p,lev,roomView,stuff);break;
                    case 0:logic.moveWest(p,lev,roomView,stuff);break;
                }
            }
        });
        southButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (p.getView()){
                    case 2:logic.moveNorth(p,lev,roomView,stuff);break;
                    case 3:logic.moveEast(p,lev,roomView,stuff);break;
                    case 0:logic.moveSouth(p,lev,roomView,stuff);break;
                    case 1:logic.moveWest(p,lev,roomView,stuff);break;
                }mapping(mapa,p,lev);
            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.turnLeft(p,lev,roomView,stuff);
            }
        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.turnRight(p,lev,roomView,stuff);
                System.out.println("view: "+p.getView()+p.getDir());
                mapa.remove(getMapCell(mapa,1,1));
                //System.out.println(getMapCell(mapa,1,1).getParent());
                JLabel mapRoom=new JLabel();
                mapRoom.setText("lol");
                GridBagConstraints ggg=new GridBagConstraints();
                ggg.gridx=1;ggg.gridy=1;
                mapa.add(mapRoom,ggg);
                mapa.revalidate();
                mapa.repaint();
            }

        });
        waitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Enemy> en=new ArrayList<Enemy>();
                en.add(new SkeletonSword(1));
                //en.add(new SkeletonSword(1));
                startBattle(en,p,lev.getMap().get(p.getY())[p.getX()]);
            }
        });
        heal3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.getPotion().heal(p);
                heal3Button.setText("Heal("+p.getPotion().getCount()+")");
                if(p.getPotion().getCount()==0) heal3Button.setEnabled(false);
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

    void startBattle(ArrayList<Enemy> enemies,Player player,Room r){
        System.out.println(enemies.size());
        n=enemies.size();
        for (int i = 0; i < enemies.size(); i++) {
            JFrame a=new Battle(player,enemies.get(i),this,r);
            a.setVisible(true);
        }
        setVisible(false);
    }
    void updateHp(Player p){
        info.setMaximum(p.getMaxHP());
        info.setValue(p.getHp());
        System.out.println(""+p.getHp()+"/"+p.getMaxHP());
        info.setString(""+p.getHp()+"/"+p.getMaxHP());
    }

    void mapping(JPanel panel,Player p,Level l){
        try {
            ArrayList<Room> tomap=new Logic(this).mappable(p,l.getMap());
            GridBagConstraints gbc=new GridBagConstraints();
            for (int i = 0; i < tomap.size(); i++) {
                gbc.gridx=tomap.get(i).getX()-1;
                gbc.gridy=tomap.get(i).getY()-1;
                JLabel mapRoom=new JLabel();
                mapRoom.setIcon(new ImageIcon( ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\map\\"+tomap.get(i).map+".png"))));
                panel.add(mapRoom,gbc);
            }
            panel.revalidate();
            panel.repaint();
        }catch (Exception e){
            e.printStackTrace();
        }
        }
        Component getMapCell(JPanel p,int x,int y){
            GridBagLayout layout = (GridBagLayout) p.getLayout();
            for (Component comp : p.getComponents()) {
                GridBagConstraints gbc = layout.getConstraints(comp);
                if (gbc.gridx == x && gbc.gridy == y) {
                    return comp;
                }
            }return null;}
    }

