package GameLogic;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Logic {
    ArrayList<BufferedImage> images=new ArrayList<>();
    ArrayList<Image> images2=new ArrayList<>();
    public Logic() {
        try {
            System.out.println(images.size());
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\ProjektLoch\\src\\images\\deadend.png")));//0
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\ProjektLoch\\src\\images\\wall.png")));//1
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\ProjektLoch\\src\\images\\f.png")));//2
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\ProjektLoch\\src\\images\\fr.png")));//3
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\ProjektLoch\\src\\images\\lf.png")));//4
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\ProjektLoch\\src\\images\\lfr.png")));//5
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\ProjektLoch\\src\\images\\lr.png")));//6
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\ProjektLoch\\src\\images\\r.png")));//7
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\ProjektLoch\\src\\images\\l.png")));//8
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\ProjektLoch\\src\\images\\key.png")));//9
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\ProjektLoch\\src\\images\\door.png")));//10
            images.add(ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\ProjektLoch\\src\\images\\enemy.png")));//11

            images2.add(images.get(0).getScaledInstance(640, 480, Image.SCALE_SMOOTH));
            images2.add(images.get(1).getScaledInstance(640, 480, Image.SCALE_SMOOTH));
            System.out.println(images.size());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void roomRender(JLabel l, Room r,Player p){

        if (isAccesible(p,r)){
            ArrayList<Direction> temp=r.getAccess();
            String render="";
            temp.remove(p.getDir());
            for (int i=0;i<temp.size();i++){
                render+=temp.get(i);
            }
            switch (p.getDir()){
                case S: //Patrzy gracz na północ
                    switch (render){
                        case "": l.setIcon(new ImageIcon(images2.get(0)));
                        case "N": l.setIcon(new ImageIcon(images2.get(2)));
                        case "W": l.setIcon(new ImageIcon(images2.get(8)));
                        case "E": l.setIcon(new ImageIcon(images2.get(7)));
                        case "NW": l.setIcon(new ImageIcon(images2.get(4)));
                        case "NE": l.setIcon(new ImageIcon(images2.get(3)));
                        case "NWE": l.setIcon(new ImageIcon(images2.get(5)));
                        case "WE": l.setIcon(new ImageIcon(images2.get(6)));
                            break;}
                    break;

                case N: //Patrzy gracz na południe
                    switch (render){
                        case "": l.setIcon(new ImageIcon(images2.get(0)));
                        case "S": l.setIcon(new ImageIcon(images2.get(2)));
                        case "E": l.setIcon(new ImageIcon(images2.get(8)));
                        case "W": l.setIcon(new ImageIcon(images2.get(7)));
                        case "ES": l.setIcon(new ImageIcon(images2.get(4)));
                        case "WS": l.setIcon(new ImageIcon(images2.get(3)));
                        case "WES": l.setIcon(new ImageIcon(images2.get(5)));
                        case "WE": l.setIcon(new ImageIcon(images2.get(6)));
                            break;}
                    break;

                case W: //Patrzy gracz na północ
                    switch (render){
                        case "": l.setIcon(new ImageIcon(images2.get(0)));
                        case "E": l.setIcon(new ImageIcon(images2.get(2)));
                        case "N": l.setIcon(new ImageIcon(images2.get(8)));
                        case "S": l.setIcon(new ImageIcon(images2.get(7)));
                        case "NE": l.setIcon(new ImageIcon(images2.get(4)));
                        case "ES": l.setIcon(new ImageIcon(images2.get(3)));
                        case "NES": l.setIcon(new ImageIcon(images2.get(5)));
                        case "NS": l.setIcon(new ImageIcon(images2.get(6)));
                            break;}
                    break;
                case E: //Patrzy gracz na północ
                    switch (render){
                        case "": l.setIcon(new ImageIcon(images2.get(0)));
                        case "W": l.setIcon(new ImageIcon(images2.get(2)));
                        case "S": l.setIcon(new ImageIcon(images2.get(8)));
                        case "N": l.setIcon(new ImageIcon(images2.get(7)));
                        case "WS": l.setIcon(new ImageIcon(images2.get(4)));
                        case "NW": l.setIcon(new ImageIcon(images2.get(3)));
                        case "NWS": l.setIcon(new ImageIcon(images2.get(5)));
                        case "NS": l.setIcon(new ImageIcon(images2.get(6)));
                            break;}
                    break;
            }
        switch (render){
            case "": l.setIcon(new ImageIcon(images2.get(0)));
            case "N": l.setIcon(new ImageIcon(images2.get(2)));
            case "W": l.setIcon(new ImageIcon(images2.get(2)));
            case "E": l.setIcon(new ImageIcon(images2.get(2)));
            case "S": l.setIcon(new ImageIcon(images2.get(2)));
            case "NW": l.setIcon(new ImageIcon(images2.get(0)));
            case "NE": l.setIcon(new ImageIcon(images2.get(0)));
            case "NWE": l.setIcon(new ImageIcon(images2.get(0)));
            case "WE": l.setIcon(new ImageIcon(images2.get(0)));
            case "WS": l.setIcon(new ImageIcon(images2.get(0)));
            case "ES": l.setIcon(new ImageIcon(images2.get(0)));
            case "WES": l.setIcon(new ImageIcon(images2.get(0)));
            break;
        }
        return;
        }
        l.setIcon(new ImageIcon(images2.get(1)));
    }
void turnRight(Player p){
        p.setView((p.getView()+1)%4);
}
    void turnLeft(Player p){
        p.setView((p.getView()-1)%4);
    }
    boolean isAccesible(Player p,Room r){
        if(r.getAccess().contains(p.getDir())) return true;
        return false;
    }



}
