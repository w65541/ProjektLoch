package GameLogic;

import java.util.ArrayList;
import GameLogic.Enemies.*;
public class Level {
    ArrayList<Room[]> map=new ArrayList<Room[]>();
    Double dificulty;
    int enemy_number;
    ArrayList<ArrayList<Enemy>> enemyGroups=new ArrayList<>();
    public Level(ArrayList<Room[]> map) {
        this.map = map;
    }

    public ArrayList<Room[]> getMap() {
        return map;
    }

    public void setMap(ArrayList<Room[]> map) {
        this.map = map;
    }

    public Double getDificulty() {
        return dificulty;
    }

    public void setDificulty(Double dificulty) {
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
