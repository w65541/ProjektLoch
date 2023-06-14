package GameLogic;

import java.util.ArrayList;

/**
 * Klasa reprezentująca poziom i przechowuje jego atrybuty
 */
public class Level {

    ArrayList<Room[]> map=new ArrayList<Room[]>();
    int dificulty,startX,startY;

    public Level(ArrayList<Room[]> map) {
        this.map = map;
    }


    public Level() {

    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public ArrayList<Room[]> getMap() {
        return map;
    }

    public void setMap(ArrayList<Room[]> map) {
        this.map = map;
    }

    public int getDificulty() {
        return dificulty;
    }

    public void setDificulty(int dificulty) {
        this.dificulty = dificulty;
    }
}
