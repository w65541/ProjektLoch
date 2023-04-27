package GameLogic;


import lib.BasicBackgroundPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Logic {
    ArrayList<BufferedImage> images=new ArrayList<>();
    public ArrayList<Image> images2=new ArrayList<>();

    public Logic(MainView mainView) {
        try {
            System.out.println(images.size());
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\deadend.png")));//0
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\wall.png")));//1
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\f.png")));//2
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\fr.png")));//3
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\lf.png")));//4
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\lfr.png")));//5
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\lr.png")));//6
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\r.png")));//7
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\l.png")));//8
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\key.png")));//9
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\door.png")));//10
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\enemy.png")));//11
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\key.png")));
            for (int i = 0; i < images.size(); i++) {
                images2.add(images.get(i).getScaledInstance(640, 480, Image.SCALE_SMOOTH));
            }

            System.out.println(images.size());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void roomRender(BasicBackgroundPanel l, Room r, Player p, Level lev,JLabel stuff){

        if (isAccesible(lev.getMap().get(p.getY())[p.getX()],r)){
            ArrayList<Direction> temp=new ArrayList<>(r.getAccess());
            String render="";
            System.out.println("Przed: "+temp.toString()+"\np.dir: "+p.getDir());
            temp.remove(p.getDir());
            for (int i=0;i<temp.size();i++){
                render+=temp.get(i);
            }
            System.out.println("render: "+render);

            if(r.isKey()) {
                stuff.setIcon(new ImageIcon(images2.get(9)));
            }
            else if(r.isEnemy()) {
                stuff.setIcon(new ImageIcon(images2.get(11)));
            }
            else if (r.isDoor()) {
                stuff.setIcon(new ImageIcon(images2.get(10)));
            }else {stuff.setIcon(null);}

            switch (p.getDir()){
                case S: //Patrzy gracz na północ
                    switch (render){
                        case "": l.setIcon( (images2.get(0)));return;
                        case "N": l.setIcon( (images2.get(2)));return;
                        case "W": l.setIcon( (images2.get(8)));return;
                        case "E": l.setIcon( (images2.get(7)));return;
                        case "NW": l.setIcon( (images2.get(4)));return;
                        case "NE": l.setIcon( (images2.get(3)));return;
                        case "NWE": l.setIcon( (images2.get(5)));return;
                        case "WE": l.setIcon( (images2.get(6)));return;
                            }
                    break;

                case N: //Patrzy gracz na południe
                    switch (render){
                        case "": l.setIcon( (images2.get(0)));return;
                        case "S": l.setIcon( (images2.get(2)));return;
                        case "E": l.setIcon( (images2.get(8)));return;
                        case "W": l.setIcon( (images2.get(7)));return;
                        case "ES": l.setIcon( (images2.get(4)));return;
                        case "WS": l.setIcon( (images2.get(3)));return;
                        case "WES": l.setIcon( (images2.get(5)));return;
                        case "WE": l.setIcon( (images2.get(6)));return;
                           }
                    break;

                case W: //Patrzy gracz na północ
                    switch (render){
                        case "": l.setIcon( (images2.get(0)));return;
                        case "E": l.setIcon( (images2.get(2)));return;
                        case "N": l.setIcon( (images2.get(8)));return;
                        case "S": l.setIcon( (images2.get(7)));return;
                        case "NE": l.setIcon( (images2.get(4)));return;
                        case "ES": l.setIcon( (images2.get(3)));return;
                        case "NES": l.setIcon( (images2.get(5)));return;
                        case "NS": l.setIcon( (images2.get(6)));return;
                           }
                    break;
                case E: //Patrzy gracz na północ
                    switch (render){
                        case "": l.setIcon(images2.get(0));return;
                        case "W": l.setIcon(images2.get(2));return;
                        case "S": l.setIcon(images2.get(8));return;
                        case "N": l.setIcon(images2.get(7));return;
                        case "WS": l.setIcon( (images2.get(4)));return;
                        case "NW": l.setIcon( (images2.get(3)));return;
                        case "NWS": l.setIcon( (images2.get(5)));return;
                        case "NS": l.setIcon( (images2.get(6)));return;
                            }
                    break;
            }


        return;
        }
        l.setIcon( (images2.get(1)));
        stuff.setIcon(null);
    }
    public void turnRight(Player p, Level r, BasicBackgroundPanel l,JLabel stuff){
        p.setView((p.getView()+1)%4);
        roomRender(l,viewRoom(p,r),p,r,stuff);
}
    public void turnLeft(Player p, Level r, BasicBackgroundPanel l,JLabel stuff){
        if(p.getView()==0){p.setView(3);
        }else{p.setView((p.getView()-1)%4);}
        roomRender(l,viewRoom(p,r),p,r,stuff);
    }
    boolean isAccesible(Room r1,Room r2){
        //System.out.println(r1.getAccess2().toString()+""+r2.getAccess().toString());
        for (int i = 0; i < r1.getAccess2().size(); i++) {
            if(r2.getAccess().contains(r1.getAccess2().get(i))) return true;
        }
        for (int i = 0; i < r2.getAccess2().size(); i++) {
            if(r1.getAccess().contains(r2.getAccess2().get(i))) return true;
        }
        return false;
    }
    public ArrayList<Room> mappable(Player p,ArrayList<Room[]> rooms){
        ArrayList<Room> tomap=new ArrayList<>();
        if(isAccesible(rooms.get(p.getY())[p.getX()],rooms.get(p.getY()-1)[p.getX()]) && !rooms.get(p.getY()-1)[p.getX()].isMapped()){
            rooms.get(p.getY()-1)[p.getX()].setMapped(true);
            tomap.add(rooms.get(p.getY()-1)[p.getX()]);
        }
        if(isAccesible(rooms.get(p.getY())[p.getX()],rooms.get(p.getY())[p.getX()+1]) && !rooms.get(p.getY())[p.getX()+1].isMapped()){
            rooms.get(p.getY())[p.getX()+1].setMapped(true);
            tomap.add(rooms.get(p.getY())[p.getX()+1]);
        }
        if(isAccesible(rooms.get(p.getY())[p.getX()],rooms.get(p.getY())[p.getX()-1]) && !rooms.get(p.getY())[p.getX()-1].isMapped()){
            rooms.get(p.getY())[p.getX()-1].setMapped(true);
            tomap.add(rooms.get(p.getY())[p.getX()-1]);
        }
        if(isAccesible(rooms.get(p.getY())[p.getX()],rooms.get(p.getY()+1)[p.getX()]) && !rooms.get(p.getY()+1)[p.getX()].isMapped()){
            rooms.get(p.getY()+1)[p.getX()].setMapped(true);
            tomap.add(rooms.get(p.getY()+1)[p.getX()]);
        }
        return tomap;
    }
    public void moveNorth(Player p, Level r, BasicBackgroundPanel l,JLabel stuff){
        try {
            System.out.println(isAccesible(r.getMap().get(p.getY())[p.getX()],r.getMap().get(p.getY()-1)[p.getX()]));
            if(isAccesible(r.getMap().get(p.getY())[p.getX()],r.getMap().get(p.getY()-1)[p.getX()])){
                p.setY(p.getY()-1);
                roomRender(l,viewRoom(p,r),p,r,stuff);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
}

    public void moveEast(Player p, Level r, BasicBackgroundPanel l,JLabel stuff){
        try {
            if(isAccesible(r.getMap().get(p.getY())[p.getX()],r.getMap().get(p.getY())[p.getX()+1])){
                p.setX(p.getX()+1);
                roomRender(l,viewRoom(p,r),p,r,stuff);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void moveWest(Player p, Level r, BasicBackgroundPanel l,JLabel stuff){
        try {
            if(isAccesible(r.getMap().get(p.getY())[p.getX()],r.getMap().get(p.getY())[p.getX()-1])){
                p.setX(p.getX()-1);
                roomRender(l,viewRoom(p,r),p,r,stuff);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void moveSouth(Player p, Level r, BasicBackgroundPanel l,JLabel stuff){
        try {
            if(isAccesible(r.getMap().get(p.getY())[p.getX()],r.getMap().get(p.getY()+1)[p.getX()])){
                p.setY(p.getY()+1);
                roomRender(l,viewRoom(p,r),p,r,stuff);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


Room viewRoom(Player p,Level l){
        //if(p.getY()-1>=0 && p.getX()-1>=0 && p.getY()+1<=l.getMap().size() && p.getX()+1<=l.getMap().get(p.getY()).length){
    try{
        switch (p.getView()){
            case 0:return l.getMap().get(p.getY()-1)[p.getX()];
            case 1:return l.getMap().get(p.getY())[p.getX()+1];
            case 2:return l.getMap().get(p.getY()+1)[p.getX()];
            case 3:return l.getMap().get(p.getY())[p.getX()-1];
        }}catch (Exception e){
return new Room(0,0,0);}
    return null;
}
}
