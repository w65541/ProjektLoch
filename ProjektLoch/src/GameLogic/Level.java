package GameLogic;

import java.util.ArrayList;

public class Level {
    ArrayList<Room[]> map=new ArrayList<Room[]>();
    Double dificulty;
    int enemy_number;

    public Level(ArrayList<Room[]> map) {
        this.map = map;
    }

    public ArrayList<Room[]> getMap() {
        return map;
    }

    public void setMap(ArrayList<Room[]> map) {
        this.map = map;
    }
}
