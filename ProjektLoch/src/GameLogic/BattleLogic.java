package GameLogic;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import GameLogic.Enemies.*;
public class BattleLogic {
    Timer timer = new Timer();
    Player player;
    Enemy enemy;
    ArrayList<Enemy> team;
    boolean playerActive=true;
    public BattleLogic(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        int temp=enemy.getDamage();
                enemy.setDamage(0);
                enemy.attack(player,timer);
                enemy.setDamage(temp);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(enemy.getHp()<=0) {timer.cancel();}
                if(enemy.isActive()){System.out.println("atak "+enemy.isActive());enemyAttack();}


            }
        },enemy.getSpeed()*1000, 1);
    }

    void enemyAttack(){
        enemy.attack(player, timer);
    }

    void playerAttack(){
        enemy.getHit(player.getDamage());
        player.setSpeed(5);
        player.setActive(false);
        playerActive=false;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                playerActive=true;
                player.setActive(true);
            }
        },player.getSpeed()*1000);
    }
    void playerDefend(){
        player.setDef(player.getDef()*2);
        player.setSpeed(player.getSpeed()/2);
        player.setActive(false);
        playerActive=false;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.setActive(true);
                playerActive=true;
                player.setDef(player.getDef()/2);
            }
        },player.getSpeed()*1000);
    }

    public boolean isPlayerActive() {
        return playerActive;
    }

    public void setPlayerActive(boolean playerActive) {
        this.playerActive = playerActive;
    }
}
