package GameLogic;

import java.util.ArrayList;
import GameLogic.Enemies.*;
public class Level {
    ArrayList<Room[]> map=new ArrayList<Room[]>();
    int dificulty;
    int enemy_number;
    ArrayList<ArrayList<Enemy>> enemyGroups=new ArrayList<>();
    public Level(ArrayList<Room[]> map) {
        this.map = map;
    }
    public Level(ArrayList<Room[]> map,int[][] enemy) {
        this.map = map;
        for (int i = 0; i < enemy.length; i++) {
            enemyGroups.add(new ArrayList<Enemy>());
            for (int j = 0; j < enemy[i].length; j++) {
                switch (enemy[i][j]){
                    case 0:
                        enemyGroups.get(i).add(new SkeletonSword(dificulty));
                        break;
                    case 1:
                        enemyGroups.get(i).add(new SkeletonShield(dificulty));
                        break;
                        case 2:
                        enemyGroups.get(i).add(new SkeletonMace(dificulty));
                        break; case 3:
                        enemyGroups.get(i).add(new Necromancer(dificulty,enemyGroups.get(i)));
                        break;
                }
            }
        }
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
