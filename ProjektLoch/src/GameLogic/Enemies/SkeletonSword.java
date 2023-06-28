package GameLogic.Enemies;

import GameLogic.*;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Standardowy przeciwnik
 */
public class SkeletonSword extends Enemy{
    public SkeletonSword() {
        setHp(9+random.nextInt(dif)+(dif/2));setMaxHP(getHp());
        setSpeed(7);
        setDef(dif);
        setDamage(4+random.nextInt(dif)+(dif/2));
        name="Skeleton";
        enemyId=1;
    }

    @Override
    public void attack(Player player, Timer timer) {
        if(getHp()>0) player.getHit(getDamage());setActive(false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setActive(true);
            }
        },(getSpeed()-1)*1000);
    }
}
