package GameLogic;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import GameLogic.Enemies.*;

/**
 * Zestaw funkcji do obsługi bitwy
 */
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
        /**
         * Timer odpowiada za atakowanie przeciwnika
         */
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(enemy.getHp()<=0) {timer.cancel();}
                if(enemy.isActive()){enemyAttack();}


            }
        },enemy.getSpeed()*1000, 1);
    }

    void enemyAttack(){
        enemy.attack(player, timer);
    }

    /**
     * Atak gracza
     */
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

    /**
     * Obrona gracza, podwaja się jego obrona, czas na kolejna akcję jest równy połowy
     */
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
