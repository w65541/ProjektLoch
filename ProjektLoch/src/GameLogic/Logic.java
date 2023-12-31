package GameLogic;


import lib.BasicBackgroundPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * klasa posiadająca zbiór funkcji obsługujących klasę MainView
 * i wczytująca grafikę
 */
public class Logic {
    ArrayList<BufferedImage> images=new ArrayList<>();
    public ArrayList<Image> images2=new ArrayList<>();

    public Logic(MainView mainView) {
        try {
            String currentDirectory = new File("").getAbsolutePath();
            images.add(ImageIO.read(new File(currentDirectory+ "\\src\\images\\deadend.png")));//0
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\wall.png")));//1
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\f.png")));//2
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\fr.png")));//3
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\lf.png")));//4
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\lfr.png")));//5
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\lr.png")));//6
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\r.png")));//7
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\l.png")));//8
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\key.png")));//9
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\door.png")));//10
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\enemy.png")));//11
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\treasure.png")));//12
            images.add(ImageIO.read(new File(currentDirectory+"\\src\\images\\potion.png")));//13
            for (int i = 0; i < images.size(); i++) {
                images2.add(images.get(i).getScaledInstance(640, 480, Image.SCALE_SMOOTH));
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Funkcja wybiera który widok korytarza ma być widoczny
     * @param l panel na którym bedzie grafika
     * @param r pokój na który gracz patrzy
     * @param p gracz
     * @param lev poziom
     * @param stuff miejce gdzie będzie grafika obiektu jeśli jakiś sie znajduje w pokoju
     */
    public void roomRender(BasicBackgroundPanel l, Room r, Player p, Level lev,JLabel stuff){

        if (isAccesible(lev.getMap().get(p.getY())[p.getX()],r)){
            ArrayList<Direction> temp=new ArrayList<>(r.getAccess());
            String render="";
            temp.remove(p.getDir());
            for (int i=0;i<temp.size();i++){
                render+=temp.get(i);
            }

            if(r.isKey()) {
                stuff.setIcon(new ImageIcon(images2.get(9)));
            }
            else if(r.isEnemy()) {
                stuff.setIcon(new ImageIcon(images2.get(11)));
            }
            else if (r.isDoor()) {
                stuff.setIcon(new ImageIcon(images2.get(10)));
            }else if (r.isPotion()) {
                stuff.setIcon(new ImageIcon(images2.get(13)));
            }else if (r.isTreasure()) {
                stuff.setIcon(new ImageIcon(images2.get(12)));
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

    /**
     * obrót w prawo
     * parametry są przekazywane do roomRender
     * @param p
     * @param r
     * @param l
     * @param stuff
     */
    public void turnRight(Player p, Level r, BasicBackgroundPanel l,JLabel stuff){
        p.setView((p.getView()+1)%4);
        roomRender(l,viewRoom(p,r),p,r,stuff);
}
    /**
     * obrót w lewo
     * parametry są przekazywane do roomRender
     * @param p
     * @param r
     * @param l
     * @param stuff
     */
    public void turnLeft(Player p, Level r, BasicBackgroundPanel l,JLabel stuff){
        if(p.getView()==0){p.setView(3);
        }else{p.setView((p.getView()-1)%4);}
        roomRender(l,viewRoom(p,r),p,r,stuff);
    }

    /**
     * Sprawdza czy między danymi 2 pokojami jest przejście
     * @param r1 pokój 1
     * @param r2 pokój 2
     * @return
     */
    boolean isAccesible(Room r1,Room r2){
        if(r1.getType()==0 || r2.getType()==0) return false;
        int x,y;
        x=r1.getX()-r2.getX();
        y=r1.getY()-r2.getY();
        if(x>0 && r1.getAccess().contains(Direction.W) && r2.getAccess().contains(Direction.E)) return true;
        if(x<0 && r1.getAccess().contains(Direction.E) && r2.getAccess().contains(Direction.W)) return true;
        if(y>0 && r1.getAccess().contains(Direction.N) && r2.getAccess().contains(Direction.S)) return true;
        if(y<0 && r1.getAccess().contains(Direction.S) && r2.getAccess().contains(Direction.N)) return true;
        return false;
    }

    /**
     *
     * @param p gracz
     * @param rooms pokoje sąsiadujące z graczem
     * @return Lista pokoji które należy dodać do mapy
     */
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

    /**
     * Zmienia pozycje gracza o 1 na północ
     * parametry są przekazywane do roomRender
     * @param p
     * @param r
     * @param l
     * @param stuff
     */
    public void moveNorth(Player p, Level r, BasicBackgroundPanel l,JLabel stuff){
        try {
            if(isAccesible(r.getMap().get(p.getY())[p.getX()],r.getMap().get(p.getY()-1)[p.getX()])){
                p.setY(p.getY()-1);
                roomRender(l,viewRoom(p,r),p,r,stuff);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
}
    /**
     * Zmienia pozycje gracza o 1 na wschód
     * parametry są przekazywane do roomRender
     * @param p
     * @param r
     * @param l
     * @param stuff
     */
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
    /**
     * Zmienia pozycje gracza o 1 na zachód
     * parametry są przekazywane do roomRender
     * @param p
     * @param r
     * @param l
     * @param stuff
     */
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
    /**
     * Zmienia pozycje gracza o 1 na południe
     * parametry są przekazywane do roomRender
     * @param p
     * @param r
     * @param l
     * @param stuff
     */
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

    /**
     *
     * @param p gracz
     * @param l poziom
     * @return pokój na który gracz się patrzy
     */
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
