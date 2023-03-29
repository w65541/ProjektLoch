package GameLogic;

import java.util.ArrayList;

public class Room {
    RoomType type;//zmienić na liczbe
    boolean key=false,enemy=false,treasure=false;
    ArrayList<Direction> access= new ArrayList<>();
    int x,y;

    public Room(RoomType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
        switch (this.type){
            case DEADEND_NORTH: access.add(Direction.N); break;
            case DEADEND_EAST: access.add(Direction.E); break;
            case DEADEND_WEST: access.add(Direction.W); break;
            case DEADEND_SOUTH: access.add(Direction.S); break;
        }
    }

    public ArrayList<Direction> getAccess() {
        return access;
    }

    public void setAccess(ArrayList<Direction> access) {
        this.access = access;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
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
}
