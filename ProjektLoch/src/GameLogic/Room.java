package GameLogic;

import GameLogic.Enemies.Enemy;

import java.util.ArrayList;

public class Room {
    //RoomType type;//zmienić na liczbe

    boolean key=false,enemy=false,treasure=false,door=false,mapped=false;
    ArrayList<Direction> access= new ArrayList<>();
    ArrayList<Direction> access2= new ArrayList<>();
    String map="";
    int x,y,type, contentId;
    Item item;
    ArrayList<Enemy> enemies;
    public Room(int type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
        switch (this.type){
            case 0: mapped=true; break;
            case 1: access.add(Direction.N); break;
            case 2: access.add(Direction.E); break;
            case 3: access.add(Direction.W); break;
            case 4: access.add(Direction.S); break;
            case 5: access.add(Direction.N); access.add(Direction.W); break;
            case 6: access.add(Direction.N); access.add(Direction.E); break;
            case 7: access.add(Direction.N); access.add(Direction.W); access.add(Direction.E); break;
            case 8: access.add(Direction.N); access.add(Direction.W); access.add(Direction.E); access.add(Direction.S); break;
            case 9: access.add(Direction.W); access.add(Direction.S); break;
            case 10: access.add(Direction.E);access.add(Direction.S); break;
            case 11: access.add(Direction.W); access.add(Direction.E); access.add(Direction.S); break;
            case 12: access.add(Direction.N); access.add(Direction.S); break;
            case 13: access.add(Direction.W); access.add(Direction.E); break;
            case 14: access.add(Direction.N); access.add(Direction.E); access.add(Direction.S); break;
            case 15: access.add(Direction.N); access.add(Direction.W); access.add(Direction.S); break;
        }
        for (int i = 0; i < access.size(); i++) {
            map+=access.get(i);
            switch (access.get(i)){
                case E: access2.add(Direction.W);break;
                case W: access2.add(Direction.E);break;
                case N: access2.add(Direction.S);break;
                case S: access2.add(Direction.N);break;
            }
        }
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies, int i) {
        this.enemies = enemies;
        contentId=i;
    }

    public ArrayList<Direction> getAccess2() {
        return access2;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
        contentId=item.getId();
    }

    public void setAccess2(ArrayList<Direction> access2) {
        this.access2 = access2;
    }

    public ArrayList<Direction> getAccess() {
        return access;
    }

    public void setAccess(ArrayList<Direction> access) {
        this.access = access;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public boolean isEnemy() {
        return enemy;
    }

    public void setEnemy(boolean enemy) {
        this.enemy = enemy;
    }

    public boolean isTreasure() {
        return treasure;
    }

    public void setTreasure(boolean treasure) {
        this.treasure = treasure;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    public boolean isMapped() {
        return mapped;
    }

    public void setMapped(boolean mapped) {
        this.mapped = mapped;
    }

    @Override
    public String toString() {
        return "Room{" +
                "type=" + type +
                '}';
    }
}
