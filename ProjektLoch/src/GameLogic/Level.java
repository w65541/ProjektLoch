package GameLogic;

import java.util.ArrayList;
import GameLogic.Enemies.*;
public class Level {
    ArrayList<Room[]> map=new ArrayList<Room[]>();
    int dificulty,startX,startY;
    int enemy_number;
    ArrayList<ArrayList<Enemy>> enemyGroups=new ArrayList<>();
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

    public int getEnemy_number() {
        return enemy_number;
    }

    public void setEnemy_number(int enemy_number) {
        this.enemy_number = enemy_number;
    }

    public ArrayList<ArrayList<Enemy>> getEnemyGroups() {
        return enemyGroups;
    }

    public void setEnemyGroups(ArrayList<ArrayList<Enemy>> enemyGroups) {
        this.enemyGroups = enemyGroups;
    }
}
