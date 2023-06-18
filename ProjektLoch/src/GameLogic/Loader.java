package GameLogic;

import GameLogic.Enemies.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasa wczytująca i przetrzymująca dane
 */
public class Loader {
    Map<Integer,Item> itemList=new HashMap<>();
    Map<Integer,ArrayList<Enemy>> enemyList=new HashMap<>();
    Map<Integer, Image> enemyImage=new HashMap<>();
    ArrayList<Level> levels=new ArrayList<>();
    public Loader(){
        String currentDirectory = new File("").getAbsolutePath();
        loadItems(Paths.get(currentDirectory+"\\src\\Data\\Items.csv"));
        loadEnemies(Paths.get(currentDirectory+"\\src\\Data\\Enemies.csv"));
        for (int i = 0; i < 3; i++) {
            //levels.add(loadLevels(Paths.get("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\levels\\Level1.csv")));
            levels.add(loadLevels(Paths.get(currentDirectory+"\\src\\levels\\Level"+(i+1)+".csv")));
        }

    }

    /**
     *
     * @param p ścieżka do pliku
     * @return wczytany poziom
     */
    public  Level loadLevels(Path p){
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
                            case "i":map.get(y)[x+1].setTreasure(true); map.get(y)[x+1].setItem(new Item(itemList.get(Integer.parseInt(rooms[2])))); break;
                            case "h":map.get(y)[x+1].setPotion(true); map.get(y)[x+1].setPotion(true); break;
                            case "e":map.get(y)[x+1].setEnemy(true);map.get(y)[x+1].setEnemies(new ArrayList<>(enemyList.get(Integer.parseInt(rooms[2]))),Integer.parseInt(rooms[2]));break;
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

    /**
     * wczytuje stan gry z pliku
     * @param p ścieżka do pliku
     */
    public  void load(Path p){
        try {
            Player player=wczytajGracza(p);
            Level level=new Level(wczytajLevel(p));
            level.setStartY(player.getY());
            level.setStartX(player.getX());
            levels.set(player.getLevel(),level);
            player.setLastLevel(levels.size());
            MainView a=new MainView(levels,player,new Backpack(player),this);
            a.mapRestoration();
            a.setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Wczytywanie stanu poziomu z pliku
     * @param p ścieżka do pliku
     * @return mapa poziomu
     */
    public  ArrayList<Room[]> wczytajLevel(Path p){
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
                            case "i":map.get(y)[x+1].setTreasure(true); map.get(y)[x+1].setItem(new Item(itemList.get(Integer.parseInt(rooms[2]))));break;
                            case "e":map.get(y)[x+1].setEnemy(true);map.get(y)[x+1].setEnemies(new ArrayList<>(enemyList.get(Integer.parseInt(rooms[2]))),Integer.parseInt(rooms[2]));break;
                            case "h":map.get(y)[x+1].setPotion(true); map.get(y)[x+1].setPotion(true); break;
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

    /**
     * Wczytuje zapisany stan gracza
     * @param p ścieżka do pliku
     * @return stan gracza z pliku
     */
    public  Player wczytajGracza(Path p){
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

    /**
     * Wczytuje i tworzy przedmioty na bazie pliku Items.csv
     * @param p ścieżka do pliku
     */
    public void loadItems(Path p){
        try {
            itemList.put(0,new Item("none","none",0,0,0,0,0));
            int i=1;
            CSVParser plik=CSVParser.parse(p, Charset.defaultCharset(), CSVFormat.DEFAULT.withFirstRecordAsHeader());
            for (CSVRecord record : plik) {
                itemList.put(i,new Item(record.get("Name"),record.get("Type"),Integer.parseInt(record.get("Hp")),Integer.parseInt(record.get("Speed")),Integer.parseInt(record.get("Damage")),Integer.parseInt(record.get("Defense")),i));
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Wczytuje grupy przeciwnkiów z pliku Enemies.csv
     * @param p ścieżka do pliku
     */
    public void loadEnemies(Path p){
        try {
            int i=1;
            String currentDirectory = new File("").getAbsolutePath();
            enemyImage.put(1, ImageIO.read(new File(currentDirectory+ "\\src\\images\\enemies\\Sword.png")));
            enemyImage.put(2, ImageIO.read(new File(currentDirectory+ "\\src\\images\\enemies\\Shield.png")));
            enemyImage.put(3, ImageIO.read(new File(currentDirectory+ "\\src\\images\\enemies\\Mace.png")));
            enemyImage.put(4, ImageIO.read(new File(currentDirectory+ "\\src\\images\\enemies\\Necro.png")));
            enemyImage.put(5, ImageIO.read(new File(currentDirectory+ "\\src\\images\\enemies\\Slime.png")));
            enemyImage.put(6, ImageIO.read(new File(currentDirectory+ "\\src\\images\\enemies\\Boom.png")));
            CSVParser plik=CSVParser.parse(p, Charset.defaultCharset(), CSVFormat.DEFAULT.withFirstRecordAsHeader());
            for (CSVRecord record : plik) {
                String temp=record.get("Group");
                String[] temp2=temp.split(":");
                ArrayList<Enemy> temp3=new ArrayList<>();
                for (String x:temp2
                     ) {
                    switch (x){
                        case "1":temp3.add(new SkeletonSword());break;
                        case "2":temp3.add(new SkeletonShield());break;
                        case "3":temp3.add(new SkeletonMace());break;
                        case "4":temp3.add(new Necromancer(temp3));break;
                        case "5":temp3.add(new Slime());break;
                        case "6":temp3.add(new Kaboom());break;
                    }
                }
                enemyList.put(i, temp3);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Map<Integer, Item> getItemList() {
        return itemList;
    }

    public Map<Integer, ArrayList<Enemy>> getEnemyList() {
        return enemyList;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public Map<Integer, Image> getEnemyImage() {
        return enemyImage;
    }
}
