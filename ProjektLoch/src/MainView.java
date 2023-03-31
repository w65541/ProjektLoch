import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import GameLogic.*;
public class MainView extends JFrame{
    private JButton westButton;
    private JButton waitButton;
    private JButton eastButton;
    private JButton nortButton;
    private JButton southButton;
    private JPanel panel;
    private JLabel roomView;
    private JButton leftButton;
    private JButton rightButton;
    private JLabel info;
    int j=0;
    public MainView() {
        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300,700);
        Logic logic=new Logic();
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
        Level lev=new Level(m);
        Player p=new Player();
        p.setY(2);
        p.setX(2);
        p.setView(0);
        logic.roomRender(roomView,m.get(1)[2],p,lev);
        nortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (p.getView()){
                    case 0:logic.moveNorth(p,lev,roomView);break;
                    case 1:logic.moveEast(p,lev,roomView);break;
                    case 2:logic.moveSouth(p,lev,roomView);break;
                    case 3:logic.moveWest(p,lev,roomView);break;
                }


            }
        });
        eastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (p.getView()){
                    case 3:logic.moveNorth(p,lev,roomView);break;
                    case 0:logic.moveEast(p,lev,roomView);break;
                    case 1:logic.moveSouth(p,lev,roomView);break;
                    case 2:logic.moveWest(p,lev,roomView);break;
                }
            }
        });
        westButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (p.getView()){
                    case 1:logic.moveNorth(p,lev,roomView);break;
                    case 2:logic.moveEast(p,lev,roomView);break;
                    case 3:logic.moveSouth(p,lev,roomView);break;
                    case 0:logic.moveWest(p,lev,roomView);break;
                }
            }
        });
        southButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (p.getView()){
                    case 2:logic.moveNorth(p,lev,roomView);break;
                    case 3:logic.moveEast(p,lev,roomView);break;
                    case 0:logic.moveSouth(p,lev,roomView);break;
                    case 1:logic.moveWest(p,lev,roomView);break;
                }
            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.turnLeft(p,lev,roomView);info.setText("X: "+p.getX()+" Y: "+p.getY()+" Dir:"+p.getDir());
            }
        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.turnRight(p,lev,roomView);
                System.out.println("view: "+p.getView()+p.getDir());info.setText("X: "+p.getX()+" Y: "+p.getY()+" Dir:"+p.getDir());
            }
        });
    }
}
