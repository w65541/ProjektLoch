package GameLogic;
import java.util.Timer;
import java.util.TimerTask;

public class BattleLogic {
    Timer timer = new Timer();
    Player player;
    Enemy enemy;


    public BattleLogic(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            enemyAttack();
            }
        },enemy.getSpeed()*1000, enemy.getSpeed()*1000);
    }

    void enemyAttack(){
        player.getHit(enemy.getDamage());
    }

    void playerAttack(){
        enemy.getHit(player.getDamage());
        player.setActive(false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.setActive(true);
            }
        },player.getSpeed()*1000);
    }
    void playerDefend(){
        player.setDef(player.getDef()*2);
        player.setActive(false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.setActive(true);
                player.setDef(player.getDef()/2);
            }
        },player.getSpeed()*1000/2);
    }

}
