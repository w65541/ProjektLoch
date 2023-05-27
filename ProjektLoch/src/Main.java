import GameLogic.*;
import GameLogic.Menu;
import GameLogic.Player;
import jdk.jfr.StackTrace;
import lib.NativeOpenDialogDemo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //JFrame a=new Battle();
        //JFrame a=new Szlam();
        Player p=new Player();
        p.setHelmet(new Item(0,0,0,2,"Hełm","helmet"));
        p.setArmor(new Item(0,0,0,2,"a","armor"));
        p.setBoots(new Item(0,0,0,2,"b","boots"));
        p.setWeapon(new Item(0,0,1,0,"v","weapon"));
        p.setShield(new Item(0,0,0,2,"c","shield"));
        p.getInv().add(new Item(0,0,0,3,"Hełm żelazny","helmet"));

        p.setHelmet(new Item(0, 0, 0, 2, "Hełm", "helmet"));
        p.setArmor(new Item(0, 0, 0, 2, "a", "armor"));
        p.setBoots(new Item(0, 0, 0, 2, "b", "boots"));
        p.setWeapon(new Item(0, 0, 1, 0, "v", "weapon"));
        p.setShield(new Item(0, 0, 0, 2, "c", "shield"));
        p.getInv().add(new Item(0, 0, 0, 3, "Hełm żelazny", "helmet"));


        ArrayList<Room[]> m = new ArrayList<>();
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
        ArrayList<Room[]> m2 = new ArrayList<>();
        {
            m2.add(new Room[3]);
            m2.get(0)[0] = new Room(0, 0, 0);
            m2.get(0)[1] = new Room(0, 1, 0);
            m2.get(0)[2] = new Room(0, 2, 0);
            m2.add(new Room[3]);
            m2.get(1)[0] = new Room(0, 0, 1);
            m2.get(1)[1] = new Room(4, 1, 1);
            m2.get(1)[2] = new Room(0, 4, 1);
            m2.add(new Room[3]);
            m2.get(2)[0] = new Room(0, 0, 2);
            m2.get(2)[1] = new Room(12, 1, 2);
            m2.get(2)[2] = new Room(0, 4, 2);
            m2.add(new Room[3]);
            m2.get(3)[0] = new Room(0, 0, 3);
            m2.get(3)[1] = new Room(1, 1, 3);
            m2.get(3)[2] = new Room(0, 2, 3);
            m2.add(new Room[3]);
            m2.get(4)[0] = new Room(0, 0, 0);
            m2.get(4)[1] = new Room(0, 1, 0);
            m2.get(4)[2] = new Room(0, 2, 0);
        }
        m2.get(1)[1].setKey(true);
        m2.get(3)[1].setDoor(true);
        ArrayList<Level> levels=new ArrayList<>();
        levels.add(loadLevels(Paths.get("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\levels\\Level1.csv")));
levels.add(new Level(m2));
        //JFrame a=new Backpack(p);
        levels.get(0).setStartX(2);levels.get(0).setStartY(2);
        levels.get(1).setStartX(1);levels.get(1).setStartY(2);
        p.setLastLevel(levels.size());
        Map<Integer,Item> itemList=new HashMap<>();
        loadItems(Paths.get("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\Data\\Items.csv"),itemList);
        System.out.println(itemList.get(1).toString());
        //load(Paths.get("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\levels\\test.csv"),levels,itemList);
      /*  for (int i = 0; i < levels.get(0).getMap().size(); i++) {
            for (int j = 0; j < levels.get(0).getMap().get(i).length; j++) {
                System.out.println(levels.get(0).getMap().get(i)[j].getType());
            }

        }*/
       // JFrame a=new MainView(levels,p,new Backpack(p),new Loader());
        JFrame a=new Menu();
        a.setVisible(true);
       // dodajZCSV(Paths.get("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\levels\\Level1.csv"));
    }

    public static Level loadLevels(Path p){
        try {
            int y=1;
            Level level=new Level();
            ArrayList<Room[]> map = new ArrayList<>();
            CSVParser plik=CSVParser.parse(p, Charset.defaultCharset(), CSVFormat.DEFAULT.withFirstRecordAsHeader());
            int n=plik.getHeaderMap().size();
            map.add(new Room[n+2]);
            for (int i = 0; i < n+2; i++) {
                map.get(0)[i]=new Room(0,i,0);
            }

           for (CSVRecord record : plik) {
               map.add(new Room[n+2]);
               map.get(y)[0]=new Room(0,0,y);
               map.get(y)[0]=new Room(0,n,y);
               for (int x = 0; x < n; x++) {
                   String room = record.get(""+(x+1));
                   String[] rooms=room.split(":");System.out.println(rooms.length);
                   map.get(y)[x+1]=new Room(Integer.parseInt(rooms[0]),x+1,y);
                   if(rooms.length>1)
                       switch (rooms[1]){
                       case "k":map.get(y)[x+1].setKey(true);break;
                       case "d":map.get(y)[x+1].setDoor(true);break;
                       case "i":break;
                       case "e":break;
                       case "p":level.setStartX(x+1);level.setStartY(y);break;
                   }
               }
               map.get(y)[n+1]=new Room(0,n+1,y);
                y++;
            }
            map.add(new Room[n+2]);
            for (int i = 0; i < n+2; i++) {
                map.get(y)[i]=new Room(0,i,y);
            }
            level.setMap(map);
return level;
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }
    public static void load(Path p,ArrayList<Level> levels,Map<Integer,Item> itemList){
        try {
        Player player=wczytajGracza(p,itemList);
        Level level=new Level(wczytajLevel(p));
        level.setStartY(player.getY());
        level.setStartX(player.getX());
        levels.set(player.getLevel(),level);
            player.setLastLevel(levels.size());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Room[]> wczytajLevel(Path p){
        try {
            int y=1;
            ArrayList<Room[]> map = new ArrayList<>();
            CSVParser plik=CSVParser.parse(p, Charset.defaultCharset(), CSVFormat.DEFAULT.withFirstRecordAsHeader());
            int n=plik.getHeaderMap().size()-2;
            map.add(new Room[n+2]);
            for (int i = 0; i < n+2; i++) {
                map.get(0)[i]=new Room(0,i,0);
            }

            for (CSVRecord record : plik) {
                map.add(new Room[n+2]);
                map.get(y)[0]=new Room(0,0,y);
                map.get(y)[0]=new Room(0,n,y);
                for (int x = 0; x < n; x++) {
                    String room = record.get(""+(x+1));
                    String[] rooms=room.split(":");System.out.println(rooms.length);
                    map.get(y)[x+1]=new Room(Integer.parseInt(rooms[0]),x+1,y);
                    if(rooms[1].equals("m"))map.get(y)[x+1].setMapped(true);
                    if(rooms.length>2)
                        switch (rooms[2]){
                            case "k":map.get(y)[x+1].setKey(true);break;
                            case "d":map.get(y)[x+1].setDoor(true);break;
                            case "i":break;
                            case "e":break;
                        }
                }
                map.get(y)[n+1]=new Room(0,n+1,y);
                y++;
            }
            map.add(new Room[n+2]);
            for (int i = 0; i < n+2; i++) {
                map.get(y)[i]=new Room(0,i,y);
            }
            return map;
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }

    public static Player wczytajGracza(Path p,Map<Integer,Item> itemList){
        try {
            Player player=new Player();
            CSVParser plik=CSVParser.parse(p, Charset.defaultCharset(), CSVFormat.DEFAULT.withFirstRecordAsHeader());
            for (CSVRecord record : plik) {
                    String temp1 = record.get("Player");
                String temp2 = record.get("Inv");
                String[] pStats=temp1.split(":");
                String[] pInv=temp2.split(":");
                player.setX(Integer.parseInt(pStats[0]));
                player.setY(Integer.parseInt(pStats[1]));
                player.setLevel(Integer.parseInt(pStats[2]));
                player.setHp(Integer.parseInt(pStats[3]));
                player.getPotion().setCount(Integer.parseInt(pStats[4]));
                player.setKey(Boolean.parseBoolean(pStats[5]));
                player.setHelmet(new Item(itemList.get(Integer.parseInt(pStats[6]))));
                player.setArmor(new Item(itemList.get(Integer.parseInt(pStats[7]))));
                player.setBoots(new Item(itemList.get(Integer.parseInt(pStats[8]))));
                player.setWeapon(new Item(itemList.get(Integer.parseInt(pStats[9]))));
                player.setShield(new Item(itemList.get(Integer.parseInt(pStats[10]))));

                for (String item: pInv) {
                    player.getInv().add(new Item(itemList.get(Integer.parseInt(item))));
                }
                return player;

                }
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }
    static void loadItems(Path p, Map<Integer,Item> itemList){
        try {
            int i=0;
            CSVParser plik=CSVParser.parse(p, Charset.defaultCharset(), CSVFormat.DEFAULT.withFirstRecordAsHeader());
            for (CSVRecord record : plik) {
                itemList.put(i,new Item(record.get("Name"),record.get("Type"),Integer.parseInt(record.get("Hp")),Integer.parseInt(record.get("Speed")),Integer.parseInt(record.get("Damage")),Integer.parseInt(record.get("Defense")),i));
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}